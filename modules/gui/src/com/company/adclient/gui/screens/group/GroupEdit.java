/*
 * TODO Copyright
 */

package com.company.adclient.gui.screens.group;

import com.company.adclient.entity.activedirectory.Group;
import com.company.adclient.gui.datasource.ActiveDirectoryDs;
import com.haulmont.cuba.gui.components.AbstractEditor;

import javax.inject.Inject;

public class GroupEdit extends AbstractEditor<Group> {
    @Inject
    private ActiveDirectoryDs<Group> groupDs;

    @Override
    public boolean commit() {
        return commit(true);
    }

    @Override
    public boolean commit(boolean validate) {
        if (validate && !validateAll())
            return false;
        groupDs.commit();
        return super.commit(validate);
    }

    @Override
    public void commitAndClose() {
        if (!validateAll())
            return;
        groupDs.commit();
        super.commitAndClose();
    }
}