/*
 * TODO Copyright
 */

package com.company.adclient.gui.datasource;

import com.company.adclient.entity.activedirectory.ADEntity;
import com.company.adclient.service.ActiveDirectoryService;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.RemoteException;
import com.haulmont.cuba.core.global.Security;
import com.haulmont.cuba.gui.components.Frame;
import com.haulmont.cuba.gui.data.impl.CollectionDatasourceImpl;
import com.haulmont.cuba.gui.logging.UIPerformanceLogger;
import com.haulmont.cuba.security.entity.EntityOp;
import org.apache.log4j.Logger;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import javax.inject.Inject;
import javax.naming.CommunicationException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

/**
 * @author rushan
 * @since 04.12.2016
 */
public class ActiveDirectoryCollectionDs<T extends ADEntity> extends CollectionDatasourceImpl<T, UUID> {
    @Inject
    private ActiveDirectoryService activeDirectoryService;

    private Frame frame;

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    @Override
    protected void loadData(Map<String, Object> params) {
        Security security = AppBeans.get(Security.NAME);
        if (!security.isEntityOpPermitted(metaClass, EntityOp.READ)) {
            return;
        }

        String tag = getLoggingTag("CDS");
        StopWatch sw = new Log4JStopWatch(tag, Logger.getLogger(UIPerformanceLogger.class));

        if (needLoading()) {
            try {
                final Collection<T> entities = activeDirectoryService.findAll(getMetaClass().getJavaClass());
                detachListener(data.values());
                data.clear();

                for (T entity : entities) {
                    data.put(entity.getId(), entity);
                    attachListener(entity);
                }

            } catch (Throwable e) {
                dataLoadError = e;
            }
        }

        sw.stop();
    }

    @Override
    public void commit() {
        backgroundWorker.checkUIAccess();

        if (!allowCommit) {
            return;
        }

        if (getCommitMode() == CommitMode.DATASTORE) {

            for (Entity entity : itemsToCreate) {
                activeDirectoryService.create((T) entity);
            }
            for (Entity entity : itemsToUpdate) {
                activeDirectoryService.update((T) entity);
            }
            for (Entity entity : itemsToDelete) {
                activeDirectoryService.delete((T) entity);
            }

        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public void removeItem(T item) {
        backgroundWorker.checkUIAccess();

        checkState();

        if (this.item != null && this.item.equals(item)) {
            setItem(null);
        }

        data.remove(item.getId());
        detachListener(item);

        itemsToCreate.remove(item);
        itemsToDelete.add(item);
        modified = true;

        fireCollectionChanged(Operation.REMOVE, Collections.singletonList(item));
    }

    @Override
    protected void checkDataLoadError() {
        if (dataLoadError != null) {
            if(frame != null && dataLoadError instanceof RemoteException &&
                    ((RemoteException) dataLoadError).contains(CommunicationException.class)) {
                Messages messages = AppBeans.get(Messages.class);
                frame.showNotification(messages.getMainMessage("DataLoadError.CommunicationException.caption"));
            } else if (dataLoadError instanceof RuntimeException)
                throw (RuntimeException) dataLoadError;
            else
                throw new RuntimeException("Data load error", dataLoadError);
        }
    }
}
