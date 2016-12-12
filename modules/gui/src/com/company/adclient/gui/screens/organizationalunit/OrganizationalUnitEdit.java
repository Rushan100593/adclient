/*
 * TODO Copyright
 */

package com.company.adclient.gui.screens.organizationalunit;

import com.company.adclient.entity.activedirectory.OrganizationalUnit;
import com.company.adclient.gui.datasource.ActiveDirectoryDs;
import com.haulmont.cuba.gui.components.AbstractEditor;

import javax.inject.Inject;

public class OrganizationalUnitEdit extends AbstractEditor<OrganizationalUnit> {
    @Inject
    private ActiveDirectoryDs<OrganizationalUnit> organizationalUnitDs;

    @Override
    public boolean commit() {
        return commit(true);
    }

    @Override
    public boolean commit(boolean validate) {
        if (validate && !validateAll())
            return false;
        organizationalUnitDs.commit();
        return super.commit(validate);
    }

    @Override
    public void commitAndClose() {
        if (!validateAll())
            return;
        organizationalUnitDs.commit();
        super.commitAndClose();
    }
}