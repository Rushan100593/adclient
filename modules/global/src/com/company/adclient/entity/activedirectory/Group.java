/*
 * TODO Copyright
 */

package com.company.adclient.entity.activedirectory;

import com.company.adclient.service.ActiveDirectoryService;
import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.global.AppBeans;
import org.springframework.ldap.odm.annotations.*;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.util.CollectionUtils;

import javax.naming.Name;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author rushan
 * @since 05.12.2016
 */
@NamePattern("%s|name")
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

    /**
     * Электронная почта
     */
    @MetaProperty
    private String mail;

    /**
     * Участники
     */
    private Set<Name> member;

    @MetaProperty
    @Transient
    private Set<ADEntity> members;

    private Set<Name> memberOf;

    @MetaProperty
    @Transient
    private Set<Group> groups;

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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String getNameAttr() {
        return "CN";
    }

    public Set<Name> getMember() {
        return member;
    }

    public void setMember(Set<Name> member) {
        this.member = member;
    }

    public Set<ADEntity> getMembers() {
        if (!CollectionUtils.isEmpty(member) && CollectionUtils.isEmpty(members)) {
            members = new HashSet<>();
            ActiveDirectoryService activeDirectoryService = AppBeans.get(ActiveDirectoryService.class);
            member.stream()
                    .map(memberDn -> activeDirectoryService.findByDn(memberDn, Group.class))
                    .filter(Objects::nonNull)
                    .forEach(members::add);
            member.stream()
                    .map(memberDn -> activeDirectoryService.findByDn(memberDn, User.class))
                    .filter(Objects::nonNull)
                    .forEach(members::add);
        }
        return members;
    }

    public void setMembers(Set<ADEntity> members) {
        this.members = members;
    }

    public Set<Name> getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(Set<Name> memberOf) {
        this.memberOf = memberOf;
    }

    public Set<Group> getGroups() {
        if (!CollectionUtils.isEmpty(memberOf) && CollectionUtils.isEmpty(groups)) {
            groups = new HashSet<>();
            ActiveDirectoryService activeDirectoryService = AppBeans.get(ActiveDirectoryService.class);
            memberOf.stream()
                    .map(groupDn -> activeDirectoryService.findByDn(groupDn, Group.class))
                    .filter(Objects::nonNull)
                    .forEach(groups::add);
        }
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
