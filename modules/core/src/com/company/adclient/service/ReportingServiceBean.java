/*
 * TODO Copyright
 */

package com.company.adclient.service;

import com.haulmont.cuba.core.sys.AppContext;
import com.haulmont.yarg.formatters.factory.DefaultFormatterFactory;
import com.haulmont.yarg.loaders.factory.DefaultLoaderFactory;
import com.haulmont.yarg.loaders.impl.GroovyDataLoader;
import com.haulmont.yarg.reporting.ReportOutputDocument;
import com.haulmont.yarg.reporting.Reporting;
import com.haulmont.yarg.reporting.RunParams;
import com.haulmont.yarg.structure.Report;
import com.haulmont.yarg.structure.ReportBand;
import com.haulmont.yarg.structure.ReportOutputType;
import com.haulmont.yarg.structure.impl.BandBuilder;
import com.haulmont.yarg.structure.impl.ReportBuilder;
import com.haulmont.yarg.structure.impl.ReportTemplateBuilder;
import com.haulmont.yarg.util.groovy.DefaultScriptingImpl;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service(ReportingService.NAME)
public class ReportingServiceBean implements ReportingService {
    @Override
    public ReportOutputDocument runGroupsMembershipReport() throws IOException {
        String reportDir = AppContext.getProperty("adclient.reportsDir") + "/groupsmembership/";

        ReportBuilder reportBuilder = new ReportBuilder();
        ReportTemplateBuilder reportTemplateBuilder = new ReportTemplateBuilder()
                .documentPath(reportDir + "template.xlsx")
                .documentName("Groups membership.xlsx")
                .outputType(ReportOutputType.xlsx)
                .readFileFromPath();
        reportBuilder.template(reportTemplateBuilder.build());

        BandBuilder bandBuilder = new BandBuilder();
        ReportBand header= bandBuilder.name("Header").build();
        reportBuilder.band(header);

        bandBuilder = new BandBuilder();
        String query = FileUtils.readFileToString(new File(reportDir, "bands/GroupsMembership.groovy"));
        ReportBand users = bandBuilder.name("GroupsMembership")
                .query("GroupsMembership", query, "groovy")
                .build();

        reportBuilder.band(users);

        Report report = reportBuilder.build();

        Reporting reporting = new Reporting();
        reporting.setFormatterFactory(new DefaultFormatterFactory());
        reporting.setLoaderFactory(
                new DefaultLoaderFactory()
                        .setGroovyDataLoader(new GroovyDataLoader(new DefaultScriptingImpl())));

        return reporting.runReport(new RunParams(report));
    }
}