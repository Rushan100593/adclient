/*
 * TODO Copyright
 */

package com.company.adclient.gui.screens.user;

import com.company.adclient.entity.activedirectory.User;
import com.company.adclient.gui.datasource.ActiveDirectoryCollectionDs;
import com.company.adclient.service.ReportingService;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.gui.AppConfig;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.components.actions.EditAction;
import com.haulmont.cuba.gui.export.ByteArrayDataProvider;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.yarg.reporting.ReportOutputDocument;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.Map;

public class UserBrowse extends AbstractLookup {
    private ReportingService reportingService = AppBeans.get(ReportingService.class);
    @Inject
    private ActiveDirectoryCollectionDs<User> usersDs;
    @Named("usersTable.edit")
    private EditAction usersTableEdit;
    @Named("usersTable.create")
    private CreateAction usersTableCreate;
    @Inject
    private Table<User> usersTable;


    @Override
    public void init(Map<String, Object> params) {
        usersDs.setFrame(getFrame());
        initActions();
    }

    private void initActions() {
        usersTableCreate.setAfterCommitHandler(entity -> usersDs.refresh());
        usersTableEdit.setAfterCommitHandler(entity -> usersDs.refresh());

        BaseAction reportAction = new BaseAction("report") {
            @Override
            public void actionPerform(Component component) {
                try {
                    ReportOutputDocument document = reportingService.runGroupsMembershipReport();
                    byte[] byteArr = document.getContent();
                    ExportFormat exportFormat = ExportFormat.getByExtension(document.getReportOutputType().getId());
                    ExportDisplay exportDisplay = AppConfig.createExportDisplay(UserBrowse.this);
                    String documentName = document.getDocumentName();
                    exportDisplay.show(new ByteArrayDataProvider(byteArr), documentName, exportFormat);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        usersTable.addAction(reportAction);
    }

    /*private void initActions() {
        EditAction usersTableEdit = new EditAction(usersTable, WindowManager.OpenType.DIALOG){
            @Override
            public String getWindowId() {
                if(target.getSingleSelected() != null) {
                    MetaClass metaClass = target.getSingleSelected().getMetaClass();
                    WindowConfig windowConfig = AppBeans.get(WindowConfig.NAME);
                    return windowConfig.getEditorScreenId(metaClass);
                } else {
                    return super.getWindowId();
                }
            }
        };
        usersTableEdit.addEnabledRule(() -> usersDs.getItem() instanceof User);
        usersTable.addAction(usersTableEdit);
    }*/
}