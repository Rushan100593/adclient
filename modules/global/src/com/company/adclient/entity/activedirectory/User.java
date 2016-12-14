/*
 * TODO Copyright
 */

package com.company.adclient.entity.activedirectory;

import com.company.adclient.service.ActiveDirectoryService;
import com.company.adclient.util.ActiveDirectoryUtils;
import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.model.Instance;
import com.haulmont.cuba.core.global.AppBeans;
import org.apache.commons.lang.BooleanUtils;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;
import org.springframework.ldap.odm.annotations.Transient;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.util.CollectionUtils;

import javax.naming.Name;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NamePattern("%s|name")
@MetaClass(name = "adclient$User")
@Entry(objectClasses = {"user", "organizationalPerson", "person", "top"})
public final class User extends ADEntity {
    private static final long serialVersionUID = -3759057193057092799L;

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
    @MetaProperty(mandatory = true)
    private String displayName;

    /**
     * Описание
     */
    @MetaProperty
    private String description;

    /**
     * Имя
     */
    @MetaProperty
    private String givenName;

    /**
     * Инициалы
     */
    @MetaProperty
    private String initials;

    /**
     * Фамилия
     */
    @MetaProperty
    private String sn;

    /**
     * Комната
     */
    @MetaProperty
    private String physicalDeliveryOfficeName;

    /**
     * Номер телефона
     */
    @MetaProperty
    private String telephoneNumber;

    /**
     * Электронная почта
     */
    @MetaProperty
    private String mail;

    /**
     * Веб-страница
     */
    @MetaProperty
    private String wWWHomePage;

    /**
     * Имя входа пользователя
     */
    @MetaProperty(mandatory = true)
    private String userPrincipalName;

    /**
     * Имя входа пользователя(пред-Windows 2000)
     */
    @MetaProperty(mandatory = true)
    private String sAMAccountname;

    /**
     * Пароль
     */
    private String unicodePwd;

    /**
     * Срок действия учетной записи
     */
    @MetaProperty
    private String accountExpires;

    /**
     * Улица
     */
    @MetaProperty
    private String streetAddress;

    /**
     * Почтовый ящик
     */
    @MetaProperty
    private String postOfficeBox;

    /**
     * Город
     */
    @MetaProperty
    private String l;

    /**
     * Область, край
     */
    @MetaProperty
    private String st;

    /**
     * Почтовый индекс
     */
    @MetaProperty
    private String postalCode;

    /**
     * Должность
     */
    @MetaProperty
    private String title;

    /**
     * Oтдел
     */
    @MetaProperty
    private String department;

    /**
     * Организация
     */
    @MetaProperty
    private String company;

    /**
     * Руководитель
     */
    @MetaProperty
    @Attribute(name = "manager")
    private String managerDn;

    @MetaProperty
    @Transient
    private User manager;

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

    @Override
    public String getNameAttr() {
        return "CN";
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getPhysicalDeliveryOfficeName() {
        return physicalDeliveryOfficeName;
    }

    public void setPhysicalDeliveryOfficeName(String physicalDeliveryOfficeName) {
        this.physicalDeliveryOfficeName = physicalDeliveryOfficeName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWWWHomePage() {
        return wWWHomePage;
    }

    public void setWWWHomePage(String wWWHomePage) {
        this.wWWHomePage = wWWHomePage;
    }

    public String getUserPrincipalName() {
        return userPrincipalName;
    }

    public void setUserPrincipalName(String userPrincipalName) {
        this.userPrincipalName = userPrincipalName;
    }

    public String getSAMAccountname() {
        return sAMAccountname;
    }

    public void setSAMAccountname(String sAMAccountname) {
        this.sAMAccountname = sAMAccountname;
    }

    public String getUnicodePwd() {
        return unicodePwd;
    }

    public void setUnicodePwd(String unicodePwd) {
        this.unicodePwd = unicodePwd;
    }

    public String getAccountExpires() {
        return accountExpires;
    }

    public void setAccountExpires(String accountExpires) {
        this.accountExpires = accountExpires;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostOfficeBox() {
        return postOfficeBox;
    }

    public void setPostOfficeBox(String postOfficeBox) {
        this.postOfficeBox = postOfficeBox;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getManagerDn() {
        if(manager != null) {
            managerDn = manager != null ? manager.getFullDistinguishedName().toString() : null;
        }
        return managerDn;
    }

    public void setManagerDn(String managerDn) {
        this.managerDn = managerDn;
    }

    public User getManager() {
        if (managerDn != null && manager == null) {
            manager = AppBeans.get(ActiveDirectoryService.class).findByDn(managerDn, User.class);
        }
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
        managerDn = manager != null ? manager.getFullDistinguishedName().toString() : null;
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
                    .forEach(groups::add);
        }
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    @MetaProperty
    public Date getAccountExpiresDate() {
        return ActiveDirectoryUtils.convertFileTimeToDate(accountExpires);
    }

    public void setAccountExpiresDate(Date accountExpiresDate) {
        setAccountExpires(ActiveDirectoryUtils.convertDateToFileTime(accountExpiresDate));
    }

    @MetaProperty
    public Boolean getAccountNeverExpires() {
        return ActiveDirectoryUtils.checkAccountNeverExpires(accountExpires);
    }

    public void setAccountNeverExpires(Boolean accountNeverExpires) {
        if (BooleanUtils.isTrue(accountNeverExpires)) {
            setAccountExpires(String.valueOf(ActiveDirectoryUtils.ACCOUNT_NEVER_EXPIRES_VALUE));
        } else {
            setAccountExpires(ActiveDirectoryUtils.convertDateToFileTime(new Date()));
        }
    }
}