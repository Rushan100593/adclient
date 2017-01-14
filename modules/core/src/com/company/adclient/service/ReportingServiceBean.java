/*
 * TODO Copyright
 */

package com.company.adclient.service;

import com.haulmont.yarg.formatters.factory.DefaultFormatterFactory;
import com.haulmont.yarg.loaders.factory.DefaultLoaderFactory;
import com.haulmont.yarg.loaders.impl.GroovyDataLoader;
import com.haulmont.yarg.reporting.ReportOutputDocument;
import com.haulmont.yarg.reporting.Reporting;
import com.haulmont.yarg.reporting.RunParams;
import com.haulmont.yarg.structure.Report;
import com.haulmont.yarg.structure.xml.impl.DefaultXmlReader;
import com.haulmont.yarg.util.groovy.DefaultScriptingImpl;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.readFileToString;

@Service(ReportingService.NAME)
public class ReportingServiceBean implements ReportingService {
    @Override
    public ReportOutputDocument runGroupsMembershipReport() throws IOException {
        Report report = new DefaultXmlReader()
                .parseXml(readFileToString(new File("../report/groupsmembership/dataloader.xml")));

        Reporting reporting = new Reporting();
        reporting.setFormatterFactory(new DefaultFormatterFactory());
        reporting.setLoaderFactory(
                new DefaultLoaderFactory()
                        .setGroovyDataLoader(new GroovyDataLoader(new DefaultScriptingImpl())));

        return reporting.runReport(new RunParams(report));
    }
}