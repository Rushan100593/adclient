/*
 * TODO Copyright
 */

package com.company.adclient.entity.activedirectory;

import com.company.adclient.service.ActiveDirectoryService;
import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.global.AppBeans;
import org.springframework.ldap.core.support.BaseLdapNameAware;
import org.springframework.ldap.odm.annotations.*;
import org.springframework.ldap.support.LdapNameBuilder;

import javax.naming.Name;
import javax.naming.ldap.LdapName;

/**
 * @author rushan
 * @since 05.12.2016
 */
@NamePattern("%s|name")
@MetaClass(name = "adclient$Computer")
@Entry(objectClasses = {"computer", "user", "organizationalPerson", "person", "top"})
public final class Computer extends ADEntity {

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

    public Name getDistinguishedName() {
        return distinguishedName;
    }

    public void setDistinguishedName(Name distinguishedName) {
        this.distinguishedName = distinguishedName;
    }

    public Name getFullDistinguishedName() {
        return LdapNameBuilder.newInstance(AppBeans.get(ActiveDirectoryService.class).getBaseLdapPath())
                .add(getDistinguishedName())
                .build();
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

    @Override
    public String getNameAttr() {
        return "CN";
    }
}