package com.company.adclient.entity;

import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.cuba.core.entity.AbstractNotPersistentEntity;
import com.haulmont.chile.core.annotations.MetaProperty;

@MetaClass(name = "adclient$TestEntity")
public class TestEntity extends AbstractNotPersistentEntity {
    private static final long serialVersionUID = 9098595374977926096L;

    @MetaProperty
    protected String field;

    public void setField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }


}