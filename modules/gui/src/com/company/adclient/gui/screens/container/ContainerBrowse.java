/*
 * TODO Copyright
 */

package com.company.adclient.gui.screens.container;

import com.company.adclient.gui.datasource.ActiveDirectoryCollectionDs;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.actions.EditAction;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

public class ContainerBrowse extends AbstractLookup {
    @Inject
    private ActiveDirectoryCollectionDs containersDs;
    @Named("containersTable.edit")
    private EditAction containersTableEdit;

    @Override
    public void init(Map<String, Object> params) {
        containersDs.setFrame(getFrame());
        containersTableEdit.setAfterCommitHandler(entity -> containersDs.refresh());
    }
}