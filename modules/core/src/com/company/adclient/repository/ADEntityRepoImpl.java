/*
 * TODO Copyright
 */

package com.company.adclient.repository;

import com.company.adclient.entity.activedirectory.ADEntity;

import javax.naming.Name;
import java.util.List;

/**
 * @author rushan
 * @since 12.12.2016
 */
public class ADEntityRepoImpl implements ADEntityRepo {
    /*@Autowired
    private LdapTemplate ldapTemplate;
*/


    public <T extends ADEntity> T create(T entry) {
        //ldapTemplate.create(entry);
        return entry;
    }

    public <T extends ADEntity> void update(T entry) {
        //ldapTemplate.update(entry);
    }

    public <T extends ADEntity> void delete(T entry) {
        //ldapTemplate.delete(entry);
    }

    public <T extends ADEntity> List<T> findAll(Class<T> clazz) {
        return null;//ldapTemplate.findAll(clazz);
    }

    public <T extends ADEntity> T findByUid(String uid, Class<T> clazz) {
        return null;//ldapTemplate.findOne(LdapQueryBuilder.query().where("uid").is(uid), clazz);
    }

    public <T extends ADEntity> T findByDn(Name dn, Class<T> clazz) {
        return null;//ldapTemplate.findByDn(dn, clazz);
    }
}
