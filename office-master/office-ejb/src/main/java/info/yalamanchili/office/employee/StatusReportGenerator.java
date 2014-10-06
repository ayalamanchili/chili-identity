/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.employee;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
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
            document.open();
            Image logo = Image.getInstance("https://yalamanchili.googlecode.com/files/sst-logo.png");
            logo.setAlignment(Image.MIDDLE);
            logo.scaleAbsoluteHeight(20);
            logo.scaleAbsoluteWidth(20);
            logo.scalePercent(100);
            Chunk chunk = new Chunk(logo, 0, -45);
          
           
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
