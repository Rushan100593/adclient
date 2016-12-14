/*
 * TODO Copyright
 */

package com.company.adclient.gui.screens.user;

import com.company.adclient.entity.activedirectory.Group;
import com.company.adclient.entity.activedirectory.User;
import com.company.adclient.gui.datasource.ActiveDirectoryDs;
import com.google.common.collect.Sets;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.DateField;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.components.actions.AddAction;
import com.haulmont.cuba.gui.components.actions.ExcludeAction;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.Name;
import java.util.*;

public class UserEdit extends AbstractEditor<User> {
    @Inject
    private ActiveDirectoryDs<User> userDs;
    @Inject
    private CollectionDatasource<Group, UUID> groupsDs;
    @Inject
    private DateField accountExpiresDateField;
    @Inject
    private PickerField managerPickerField;
    @Inject
    private Table<Group> groupsTable;
    @Named("groupsTable.add")
    private AddAction groupsTableAdd;

    @Override
    public void init(Map<String, Object> params) {
        userDs.addItemChangeListener(e -> {
            if(e.getItem() != null) {
                accountExpiresDateField.setVisible(!e.getItem().getAccountNeverExpires());
            }
        });
        userDs.addItemPropertyChangeListener(e -> {
            if("accountExpires".equals(e.getProperty())) {
                accountExpiresDateField.setVisible(!e.getItem().getAccountNeverExpires());
            }
        });
        groupsTableAdd.setAfterAddHandler(items -> {
            Set<Name> groupNames = new HashSet<>();
            getItem().getGroups().stream().map(Group::getFullDistinguishedName).forEach(groupNames::add);
            getItem().setMemberOf(groupNames);
        });
        ExcludeAction groupsTableExclude = new ExcludeAction(groupsTable) {
            @Override
            protected void doRemove(Set selected, boolean autocommit) {
                //noinspection unchecked
                Set<Group> selectedGroups = Sets.newHashSet(selected);
                selectedGroups.stream().map(Group::getFullDistinguishedName).forEach(getItem().getMemberOf()::remove);
                selectedGroups.forEach(groupsDs::excludeItem);
            }
        };
        groupsTable.addAction(groupsTableExclude);
    }

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