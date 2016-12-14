/*
 * TODO Copyright
 */

package com.company.adclient.entity.activedirectory;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.AbstractNotPersistentEntity;

import javax.naming.Name;

/**
 * @author rushan
 * @since 12.12.2016
 */

@MetaClass(name = "adclient$ADEntity")
public abstract class ADEntity extends AbstractNotPersistentEntity {

    //Не изменяемое
    @MetaProperty
    private String name;

    /**
     * Выводимое имя
     */
    @MetaProperty
    private String displayName;

    /**
     * Описание
     */
    @MetaProperty
    private String description;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ADEntity that = (ADEntity) o;

        return !(getObjectGUID() != null ? !getObjectGUID().equals(that.getObjectGUID()) : that.getObjectGUID() != null);
    }

    @Override
    public int hashCode() {
        return getObjectGUID() != null ? getObjectGUID().hashCode() : 0;
    }
}
