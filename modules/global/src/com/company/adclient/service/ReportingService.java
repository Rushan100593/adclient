/*
 * TODO Copyright
 */

package com.company.adclient.service;

import com.haulmont.yarg.reporting.ReportOutputDocument;

import java.io.IOException;

public interface ReportingService {
    String NAME = "adclient_ReportingService";

    ReportOutputDocument runGroupsMembershipReport() throws IOException;
}