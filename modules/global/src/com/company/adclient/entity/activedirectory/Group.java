/*
 * TODO Copyright
 */

package com.company.adclient.entity.activedirectory;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;
import java.util.Set;

/**
 * @author rushan
 * @since 05.12.2016
 */
@MetaClass(name = "adclient$Group")
@Entry(objectClasses = {"group", "top"})
public final class Group extends ADEntity {

    //Не изменяемое
    @Id
    private Name distinguishedName;

    //Не изменяемое
    @MetaProperty
    private String objectGUID;

    //Не изменяемое
    @MetaProperty
    @Attribute(name="cn")
    @DnAttribute("cn")
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

    @Attribute(name="uniqueMember")
    private Set<Name> members;

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

    public Set<Name> getMembers() {
        return members;
    }

    public void setMembers(Set<Name> members) {
        this.members = members;
    }
}
