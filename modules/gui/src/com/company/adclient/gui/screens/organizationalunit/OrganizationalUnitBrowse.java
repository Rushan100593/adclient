/*
 * TODO Copyright
 */

package com.company.adclient.gui.screens.organizationalunit;

import com.company.adclient.entity.activedirectory.OrganizationalUnit;
import com.company.adclient.gui.datasource.ActiveDirectoryCollectionDs;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.components.actions.EditAction;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

public class OrganizationalUnitBrowse extends AbstractLookup {
    @Inject
    private ActiveDirectoryCollectionDs<OrganizationalUnit> organizationalUnitsDs;
    @Named("organizationalUnitsTable.edit")
    private EditAction organizationalUnitsTableEdit;
    @Named("organizationalUnitsTable.create")
    private CreateAction organizationalUnitsTableCreate;

    @Override
    public void init(Map<String, Object> params) {
        organizationalUnitsDs.setFrame(getFrame());
        initActions();
    }

    private void initActions() {
        organizationalUnitsTableCreate.setAfterCommitHandler(entity -> organizationalUnitsDs.refresh());
        organizationalUnitsTableEdit.setAfterCommitHandler(entity -> organizationalUnitsDs.refresh());
    }
}