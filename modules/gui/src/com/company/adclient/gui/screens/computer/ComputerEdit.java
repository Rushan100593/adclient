/*
 * TODO Copyright
 */

package com.company.adclient.gui.screens.computer;

import com.company.adclient.entity.activedirectory.Computer;
import com.company.adclient.gui.datasource.ActiveDirectoryDs;
import com.haulmont.cuba.gui.components.AbstractEditor;

import javax.inject.Inject;

public class ComputerEdit extends AbstractEditor<Computer> {
    @Inject
    private ActiveDirectoryDs<Computer> computerDs;

    @Override
    public boolean commit() {
        return commit(true);
    }

    @Override
    public boolean commit(boolean validate) {
        if (validate && !validateAll())
            return false;
        computerDs.commit();
        return super.commit(validate);
    }

    @Override
    public void commitAndClose() {
        if (!validateAll())
            return;
        computerDs.commit();
        super.commitAndClose();
    }
}