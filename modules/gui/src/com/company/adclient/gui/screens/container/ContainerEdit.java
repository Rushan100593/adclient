/*
 * TODO Copyright
 */

package com.company.adclient.gui.screens.container;

import com.company.adclient.entity.activedirectory.Container;
import com.company.adclient.gui.datasource.ActiveDirectoryDs;
import com.haulmont.cuba.gui.components.AbstractEditor;

import javax.inject.Inject;

public class ContainerEdit extends AbstractEditor<Container> {
    @Inject
    private ActiveDirectoryDs containerDs;

    @Override
    public boolean commit() {
        return commit(true);
    }

    @Override
    public boolean commit(boolean validate) {
        if (validate && !validateAll())
            return false;
        containerDs.commit();
        return super.commit(validate);
    }

    @Override
    public void commitAndClose() {
        if (!validateAll())
            return;
        containerDs.commit();
        super.commitAndClose();
    }
}