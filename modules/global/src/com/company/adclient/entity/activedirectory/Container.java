/*
 * TODO Copyright
 */

package com.company.adclient.entity.activedirectory;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

/**
 * @author rushan
 * @since 13.12.2016
 */
@NamePattern("%s|name")
@MetaClass(name = "adclient$Container")
@Entry(objectClasses = {"container", "top"})
public class Container extends ADEntity {

    //Не изменяемое
    @Id
    private Name distinguishedName;

    //Не изменяемое
    @MetaProperty
    protected String objectGUID;

    //Не изменяемое
    @MetaProperty
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

    @Override
    public Name getDistinguishedName() {
        return distinguishedName;
    }

    @Override
    public void setDistinguishedName(Name distinguishedName) {
        this.distinguishedName = distinguishedName;
    }

    @Override
    public String getObjectGUID() {
        return objectGUID;
    }

    @Override
    public void setObjectGUID(String objectGUID) {
        this.objectGUID = objectGUID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getNameAttr() {
        return "CN";
    }
}
