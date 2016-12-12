/*
 * TODO Copyright
 */

package com.company.adclient.repository;

import com.company.adclient.entity.activedirectory.ADEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.naming.Name;
import java.util.List;

/**
 * @author rushan
 * @since 12.12.2016
 */
@Component
public class ADEntityRepoImpl implements ADEntityRepo {
    @Inject
    private LdapTemplate ldapTemplate;


    public <T extends ADEntity> T create(T entry) {
        if(entry.getDistinguishedName() == null) {
            String name = entry.getNameAttr().concat("=").concat(entry.getDisplayName());
            Name distinguishedName = LdapNameBuilder.newInstance(name).build();
            entry.setDistinguishedName(distinguishedName);
        }
        ldapTemplate.create(entry);
        return entry;
    }

    public <T extends ADEntity> void update(T entry) {
        ldapTemplate.update(entry);
    }

    public <T extends ADEntity> void delete(T entry) {
        ldapTemplate.delete(entry);
    }

    public <T extends ADEntity> List<T> findAll(Class<T> clazz) {
        return ldapTemplate.findAll(clazz);
    }

    public <T extends ADEntity> T findByUid(String uid, Class<T> clazz) {
        return ldapTemplate.findOne(LdapQueryBuilder.query().where("uid").is(uid), clazz);
    }

    public <T extends ADEntity> T findByDn(Name dn, Class<T> clazz) {
        return ldapTemplate.findByDn(dn, clazz);
    }
}
