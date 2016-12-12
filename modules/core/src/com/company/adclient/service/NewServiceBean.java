package com.company.adclient.service;

import org.springframework.stereotype.Service;


@Service(NewService.NAME)
public class NewServiceBean implements NewService {

    @Override
    public String getMessage() {
        return "Hello";
    }
}