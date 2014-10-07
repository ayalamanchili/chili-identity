/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.employee;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.employee.StatusReport;
import java.io.ByteArrayOutputStream;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component
public class StatusReportGenerator {

    public byte[] generateStatusReport(StatusReport entity) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            //Inserting Image in PDF
            Image image = Image.getInstance("https://yalamanchili.googlecode.com/files/sst-logo.png");
            image.scaleAbsolute(120f, 60f);//image width,height    
            //Inserting Table in PDF
            PdfPTable table = new PdfPTable(3);

            PdfPCell cell = new PdfPCell(new Paragraph("Status Reports"));
            cell.setColspan(3);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(10.0f);
            cell.setBackgroundColor(new BaseColor(140, 221, 8));
            table.addCell(cell);
            table.addCell("Employee");
            table.addCell("Date of Request ");
            table.addCell("Date Advance, needed by");
            table.addCell("Requested Amount ");
            table.addCell("Payroll File Number");
            table.addCell("Advance Purpose ");
            table.setSpacingBefore(30.0f);
            table.setSpacingAfter(30.0f);
            //Now Insert Every Thing Into PDF Document           
            document.open();
            document.add(image);
            document.add(new Paragraph(entity.getReport()));
            document.add(table);
            document.newPage();
            document.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return out.toByteArray();
    }

    public static StatusReportGenerator instance() {
        return SpringContext.getBean(StatusReportGenerator.class);
    }
}
