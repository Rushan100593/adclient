/*
 * TODO Copyright
 */

package com.company.adclient.entity.activedirectory;

import com.haulmont.cuba.core.entity.AbstractNotPersistentEntity;

import javax.naming.Name;

/**
 * @author rushan
 * @since 12.12.2016
 */

public abstract class ADEntity extends AbstractNotPersistentEntity {
    public abstract Name getDistinguishedName();

    public abstract void setDistinguishedName(Name distinguishedName);

    public abstract String getObjectGUID();

    public abstract void setObjectGUID(String objectGUID);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract String getDisplayName();

    public abstract void setDisplayName(String displayName);

    public abstract String getDescription();

    public abstract void setDescription(String description);

    public abstract String getNameAttr();
}
