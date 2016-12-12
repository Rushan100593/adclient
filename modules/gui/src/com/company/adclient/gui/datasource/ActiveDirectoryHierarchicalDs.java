/*
 * TODO Copyright
 */

package com.company.adclient.gui.datasource;

import com.company.adclient.entity.activedirectory.ADEntity;
import com.company.adclient.service.ActiveDirectoryService;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Security;
import com.haulmont.cuba.gui.data.impl.HierarchicalDatasourceImpl;
import com.haulmont.cuba.gui.logging.UIPerformanceLogger;
import com.haulmont.cuba.security.entity.EntityOp;
import org.apache.log4j.Logger;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

/**
 * @author rushan
 * @since 04.12.2016
 */
public class ActiveDirectoryHierarchicalDs<T extends ADEntity> extends HierarchicalDatasourceImpl<T, UUID> {
    private ActiveDirectoryService activeDirectoryService = AppBeans.get(ActiveDirectoryService.class);

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

                repairParents(entities);

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

    private void repairParents(Collection<? extends ADEntity> topObjects) {
        /*topObjects.stream()
                .filter(top -> top.getParentName() != null)
                .forEach(top -> {
                    String parentName = top.getParentName();
                    Top parent = topObjects.stream()
                            .filter(parentCandidate -> parentName.equals(parentCandidate.getName()))
                            .findAny().orElse(null);
                    top.setParent(parent);
                });*/
    }
}
