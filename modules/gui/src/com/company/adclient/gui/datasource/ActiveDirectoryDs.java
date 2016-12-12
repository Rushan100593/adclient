/*
 * TODO Copyright
 */

package com.company.adclient.gui.datasource;

import com.company.adclient.entity.activedirectory.ADEntity;
import com.company.adclient.service.ActiveDirectoryService;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.impl.DatasourceImpl;

/**
 * @author rushan
 * @since 10.12.2016
 */
public class ActiveDirectoryDs<T extends ADEntity> extends DatasourceImpl<T> {
    private ActiveDirectoryService activeDirectoryService = AppBeans.get(ActiveDirectoryService.class);

    @Override
    public void commit() {

        backgroundWorker.checkUIAccess();

        if (!allowCommit) {
            return;
        }

        if (getCommitMode() == CommitMode.DATASTORE) {
            if(item.getDistinguishedName() == null) {
                activeDirectoryService.create(item);
            } else {
                activeDirectoryService.update(item);
            }

            clearCommitLists();
            modified = false;

        } else if (getCommitMode() == CommitMode.PARENT) {
            if (parentDs == null) {
                throw new IllegalStateException("parentDs is null while commitMode=PARENT");
            }

            if (parentDs instanceof CollectionDatasource) {
                CollectionDatasource ds = (CollectionDatasource) parentDs;
                if (ds.containsItem(item.getId())) {
                    ds.modifyItem(item);
                } else {
                    ds.addItem(item);
                    ds.setItem(item); // This is necessary for nested property datasources to work correctly
                }
            } else {
                parentDs.setItem(item);
            }
            clearCommitLists();
            modified = false;

        } else {
            throw new UnsupportedOperationException("Unsupported commitMode: " + getCommitMode());
        }
    }
}
