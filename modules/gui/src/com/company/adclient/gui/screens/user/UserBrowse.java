/*
 * TODO Copyright
 */

package com.company.adclient.gui.screens.user;

import com.company.adclient.entity.activedirectory.User;
import com.company.adclient.gui.datasource.ActiveDirectoryCollectionDs;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.components.actions.EditAction;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

public class UserBrowse extends AbstractLookup {
    @Inject
    private ActiveDirectoryCollectionDs<User> usersDs;
    @Named("usersTable.edit")
    private EditAction usersTableEdit;
    @Named("usersTable.create")
    private CreateAction usersTableCreate;

    @Override
    public void init(Map<String, Object> params) {
        usersDs.setFrame(getFrame());
        initActions();
    }

    private void initActions() {
        usersTableCreate.setAfterCommitHandler(entity -> usersDs.refresh());
        usersTableEdit.setAfterCommitHandler(entity -> usersDs.refresh());
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