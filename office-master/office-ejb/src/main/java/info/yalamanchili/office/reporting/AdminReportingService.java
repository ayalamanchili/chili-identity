/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.reporting;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component
public class AdminReportingService {

    public byte[] doPdfReport() {
        try {

            InputStream is = this.getClass().getClassLoader().getResourceAsStream("reports/LivrosReport.jasper");
            JREmptyDataSource emptyDataSource = new JREmptyDataSource();

            HashMap<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("tittle", "asdf");
            parameters.put("owner", "asdfa");

            JasperPrint jasperPrint = JasperFillManager.fillReport(is, parameters, emptyDataSource);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JRExporter exporter = new JRPdfExporter();

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
            exporter.exportReport();

            return baos.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
