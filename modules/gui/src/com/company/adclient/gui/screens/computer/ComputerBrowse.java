/*
 * TODO Copyright
 */

package com.company.adclient.gui.screens.computer;

import com.company.adclient.gui.datasource.ActiveDirectoryCollectionDs;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.components.actions.EditAction;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

public class ComputerBrowse extends AbstractLookup {
    @Inject
    private ActiveDirectoryCollectionDs computersDs;
    @Named("computersTable.create")
    private CreateAction computersTableCreate;
    @Named("computersTable.edit")
    private EditAction computersTableEdit;

    @Override
    public void init(Map<String, Object> params) {
        computersDs.setFrame(getFrame());
        initActions();
    }

    private void initActions() {
        computersTableCreate.setAfterCommitHandler(entity -> computersDs.refresh());
        computersTableEdit.setAfterCommitHandler(entity -> computersDs.refresh());
    }
}