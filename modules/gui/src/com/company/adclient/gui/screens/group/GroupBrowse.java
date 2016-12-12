/*
 * TODO Copyright
 */

package com.company.adclient.gui.screens.group;

import com.company.adclient.gui.datasource.ActiveDirectoryCollectionDs;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.components.actions.EditAction;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

public class GroupBrowse extends AbstractLookup {
    @Inject
    private ActiveDirectoryCollectionDs groupsDs;
    @Named("groupsTable.edit")
    private EditAction groupsTableEdit;
    @Named("groupsTable.create")
    private CreateAction groupsTableCreate;

    @Override
    public void init(Map<String, Object> params) {
        groupsDs.setFrame(getFrame());
        initActions();
    }

    private void initActions() {
        groupsTableCreate.setAfterCommitHandler(entity -> groupsDs.refresh());
        groupsTableEdit.setAfterCommitHandler(entity -> groupsDs.refresh());
    }
}