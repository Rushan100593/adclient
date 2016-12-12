/*
 * TODO Copyright
 */

package com.company.adclient.entity.activedirectory;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@NamePattern("%s|name")
@MetaClass(name = "adclient$User")
@Entry(objectClasses = {"user", "organizationalUnit", "person", "top"})
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
    @MetaProperty
    private String userPrincipalName;

    /**
     * Имя входа пользователя(пред-Windows 2000)
     */
    @MetaProperty
    private String sAMAccountname;

    /**
     * Срок действия учетной записи
     */
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
    private String manager;

    @MetaProperty
    private String memberOf;

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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(String memberOf) {
        this.memberOf = memberOf;
    }

    @MetaProperty
    public Date getAccountExpiresDate() {
        if(StringUtils.isBlank(accountExpires)) {
            return null;
        }
        Long accountExpiresLong = Long.parseLong(accountExpires);
        if(accountExpiresLong == 0L || accountExpiresLong == 9223372036854775807L) {
            return null;
        }
        Calendar ldapStart = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        ldapStart.clear();
        ldapStart.set(1601, 0, 1);
        long t2 = ldapStart.getTimeInMillis();
        Date date = new Date(accountExpiresLong * 10000 + t2);
        return date;
    }

    public void setAccountExpiresDate(Date date) {
        Long accountExpiresLong;
        if (date != null) {
            Calendar ldapStart = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            ldapStart.clear();
            ldapStart.set(1601, 0, 1);
            long t1 = date.getTime();
            long t2 = ldapStart.getTimeInMillis();
            accountExpiresLong = (t1 - t2) * 10000;
        } else {
            accountExpiresLong = 0L;
        }
        accountExpires = String.valueOf(accountExpiresLong);
    }

    @MetaProperty
    public Boolean getAccountNeverExpires() {
        if(StringUtils.isBlank(accountExpires)) {
            return true;
        }
        Long accountExpiresLong = Long.parseLong(accountExpires);
        return accountExpiresLong == 0L || accountExpiresLong == 9223372036854775807L;
    }

    public void setAccountNeverExpires(Boolean accountNeverExpires) {
        if(BooleanUtils.isTrue(accountNeverExpires)) {
            accountExpires = String.valueOf(0);
        } else {
            Calendar ldapStart = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            ldapStart.clear();
            ldapStart.set(1601, 0, 1);
            long t1 = new Date().getTime();
            long t2 = ldapStart.getTimeInMillis();
            accountExpires = String.valueOf((t1 - t2) * 10000);
        }
    }

    /*@Override
    public ModificationItem[] getModificationItems() {
        List<ModificationItem> items = Lists.newArrayList(super.getModificationItems());

        items.add(new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                new BasicAttribute("givenName", getGivenName())));
        items.add(new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                new BasicAttribute("initials", getInitials())));
        items.add(new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                new BasicAttribute("sn", getSn())));
        items.add(new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                new BasicAttribute("physicaldeliveryofficename", getPhysicalDeliveryOfficeName())));
        items.add(new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                new BasicAttribute("telephonenumber", getTelephoneNumber())));
        items.add(new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                new BasicAttribute("mail", getMail())));
        items.add(new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                new BasicAttribute("wwwhomepage", getWWWHomePage())));
        items.add(new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                new BasicAttribute("userprincipalname", getUserPrincipalName())));
        items.add(new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                new BasicAttribute("samaccountname", getSAMAccountname())));
        items.add(new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
                new BasicAttribute("accountexpires", getAccountExpires())));

        return items.toArray(new ModificationItem[items.size()]);
    }

    public Attributes getAttributes() {
        Attributes attributes = super.getAttributes();
        attributes.get("objectclass").add("person");
        attributes.get("objectclass").add("organizationalperson");
        attributes.get("objectclass").add(OBJECT_CLASS);
        return attributes;
    }

    public void setAttributes(Attributes attributes) throws NamingException {
        super.setAttributes(attributes);
        NamingEnumeration namingEnumeration = attributes.getAll();
        while (namingEnumeration.hasMoreElements()) {
            Attribute attribute = (Attribute) namingEnumeration.next();
            switch (attribute.getID().toLowerCase()) {
                case "givenname":
                    this.givenName = (String) attribute.get();
                    break;
                case "initials":
                    this.initials = (String) attribute.get();
                    break;
                case "sn":
                    this.sn = (String) attribute.get();
                    break;
                case "physicaldeliveryofficename":
                    this.physicalDeliveryOfficeName = (String) attribute.get();
                    break;
                case "telephonenumber":
                    this.telephoneNumber = (String) attribute.get();
                    break;
                case "mail":
                    this.mail = (String) attribute.get();
                    break;
                case "wwwhomepage":
                    this.wWWHomePage = (String) attribute.get();
                    break;
                case "userprincipalname":
                    this.userPrincipalName = (String) attribute.get();
                    break;
                case "samaccountname":
                    this.sAMAccountname = (String) attribute.get();
                    break;
                case "accountexpires":
                    this.accountExpires = (String) attribute.get();
                    break;
                case "memberof":
                    this.memberOf = (String) attribute.get();
                    break;
            }
        }
    }*/
}