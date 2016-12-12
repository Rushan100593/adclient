/*
 * TODO Copyright
 */

package com.company.adclient.entity.activedirectory;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

/**
 * @author rushan
 * @since 05.12.2016
 */
@MetaClass(name = "adclient$Computer")
public final class Computer extends ADEntity {
    //Не изменяемое
    @Id
    private Name distinguishedName;

    //Не изменяемое
    @MetaProperty
    protected String objectGUID;

    //Не изменяемое
    @MetaProperty
    @Attribute(name = "cn")
    @DnAttribute("cn")
    protected String name;

    /**
     * Выводимое имя
     */
    @MetaProperty
    protected String displayName;

    /**
     * Описание
     */
    @MetaProperty
    protected String description;

    public Name getDistinguishedName() {
        return distinguishedName;
    }

    public void setDistinguishedName(Name distinguishedName) {
        this.distinguishedName = distinguishedName;
    }

    public String getObjectGUID() {
        return objectGUID;
    }

    public void setObjectGUID(String objectGUID) {
        this.objectGUID = objectGUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}