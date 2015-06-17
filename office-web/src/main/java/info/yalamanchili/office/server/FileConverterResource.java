/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.server;

import info.chili.docs.ExcelToHtml;
import info.chili.docs.WordToHtml;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author ayalamanchili
 */
public class FileConverterResource extends HttpServlet implements Serializable {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            throw new RuntimeException(e);
        }
        for (FileItem item : items) {
            if (item.isFormField() || item.getName() == null || item.getName().trim().equals("")) {
                continue;
            }
            try {
                String html = "";
                if (item.getName().contains("xls")) {
                    html = new ExcelToHtml(item.getInputStream()).getHTML();
                } else if (item.getName().contains("doc")) {
                    html = WordToHtml.convert(item.getInputStream());
                }
                response.setContentType("text/html");
                response.getWriter().write(html);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
