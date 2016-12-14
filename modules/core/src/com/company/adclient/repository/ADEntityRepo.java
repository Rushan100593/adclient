/*
 * TODO Copyright
 */

package com.company.adclient.repository;

import com.company.adclient.entity.activedirectory.ADEntity;

import javax.naming.Name;
import javax.naming.ldap.LdapName;
import java.util.List;

/**
 * @author rushan
 * @since 12.12.2016
 */
public interface ADEntityRepo {

    <T extends ADEntity> T create(T entry);

    <T extends ADEntity> void update(T entry);

    <T extends ADEntity> void delete(T entry);

    <T extends ADEntity> List<T> findAll(Class<T> clazz);

    <T extends ADEntity> T findByUid(String uid, Class<T> clazz);

    <T extends ADEntity> T findByDn(Name dn, Class<T> clazz);

    <T extends ADEntity> T findByDn(String dn, Class<T> clazz);

    LdapName getBaseLdapPath();
}
