package com.company.adclient.gui.screens;

import com.company.adclient.service.NewService;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.AbstractEditor;

import javax.inject.Inject;
import java.util.Map;

public class Screen extends AbstractEditor {
    @Inject
    private NewService newService;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
    }
}