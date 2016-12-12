/*
 * TODO Copyright
 */

package com.company.adclient.gui.screens.user;

import com.company.adclient.entity.activedirectory.User;
import com.company.adclient.gui.datasource.ActiveDirectoryDs;
import com.haulmont.cuba.gui.components.AbstractEditor;

import javax.inject.Inject;

public class UserEdit extends AbstractEditor<User> {
    @Inject
    private ActiveDirectoryDs<User> userDs;

    @Override
    public boolean commit() {
        return commit(true);
    }

    @Override
    public boolean commit(boolean validate) {
        if (validate && !validateAll())
            return false;
        userDs.commit();
        return super.commit(validate);
    }

    @Override
    public void commitAndClose() {
        if (!validateAll())
            return;
        userDs.commit();
        super.commitAndClose();
    }
}