/*
 * TODO Copyright
 */

package com.company.adclient.service;

import com.company.adclient.entity.activedirectory.ADEntity;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import java.util.List;

@Service(ActiveDirectoryService.NAME)
public class ActiveDirectoryServiceBean implements ActiveDirectoryService {
//private ADEntityRepo adEntityRepo = AppBeans.get(ADEntityRepo.class);

    @Override
    public <T extends ADEntity> T create(T entry) {
        //adEntityRepo.create(entry);
        return entry;
    }

    @Override
    public <T extends ADEntity> void update(T entry) {
        //adEntityRepo.update(entry);
    }

    @Override
    public <T extends ADEntity> void delete(T entry) {
        //adEntityRepo.delete(entry);
    }

    @Override
    public <T extends ADEntity> List<T> findAll(Class<T> clazz) {
        return null;//adEntityRepo.findAll(clazz);
    }

    @Override
    public <T extends ADEntity> T findByUid(String uid, Class<T> clazz) {
        return null;//adEntityRepo.findByUid(uid, clazz);
    }

    @Override
    public <T extends ADEntity> T findByDn(Name dn, Class<T> clazz) {
        return null;//adEntityRepo.findByDn(dn, clazz);
    }
}