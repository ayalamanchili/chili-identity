/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.jrs;

import info.chili.commons.FileUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Path("secured/file")
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Component
@Transactional
@Scope("request")
public class FileResource {

    private static final Log log = LogFactory.getLog(FileResource.class);
    @Autowired
    protected OfficeServiceConfiguration officeServiceConfiguration;

    @POST
    @Path("/upload")
    public Response uploadFile(@Context HttpServletRequest request) {
        log.info("---------------uploading file-----------------");
        processFileUpload(request);
        return Response.ok().build();
    }

    @GET
    @Path("/download")
    public Response downloadFile(@QueryParam("path") String path, @QueryParam("entityId") String entityId) {
        ResponseBuilder response = null;
        if (path == null || path.trim().length() < 1) {
            response = Response.status(Response.Status.BAD_REQUEST);
            return response.build();
        }
        File file = null;
        path = swapEntityId(path, entityId);
        try {
            file = new File(officeServiceConfiguration.getContentManagementLocationRoot() + path);
            if (file.exists()) {
                log.info("downloading---------:" + file.getPath());
                response = Response.ok((Object) file);
                setContentHeaders(response, file.getName());
                return response.build();
            } else {
                response = Response.status(Response.Status.NOT_FOUND);
                return response.build();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error processing File download" + e);
        }

    }
//TODO move to commons

    public boolean deleteFile(String path, String entityId) {
        File file = null;
        path = swapEntityId(path, entityId);
        try {
            file = new File(officeServiceConfiguration.getContentManagementLocationRoot() + path);
            if (file.exists()) {
                log.info("deleting---------:" + file.getPath());
                return file.delete();
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deleting file" + e);
        }

    }

    protected String swapEntityId(String path, String entityId) {
        if (entityId != null && path.contains("entityId")) {
            return path.replace("entityId", entityId);
        } else {
            return path;
        }
    }

//TODO move to utils
    protected void setContentHeaders(ResponseBuilder response, String fileName) {
        if (info.chili.commons.FileUtils.isPDF(fileName)) {
            response.header("Content-Disposition", "filename=" + fileName);
            response.header("Content-Type", "application/pdf");
            return;
        }
        //Content disposition with attachement forces the browser to download as attachment(avod inconsistent file type handles by browser)
        response.header("Content-Disposition", "attachment; filename=" + fileName);
        response.header("Content-Length", fileName);
    }

    protected void processFileUpload(HttpServletRequest request) {
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            throw new RuntimeException("Error on File upload", e);
        }
        for (FileItem item : items) {
            if (item.isFormField() || item.getName() == null || item.getName().trim().equals("")) {
                continue;
            }
            validateFileSizeLimits(item);
            File fileurl = new File(officeServiceConfiguration.getContentManagementLocationRoot() + item.getFieldName()
                    + item.getName());
            try {
                log.info("----------writing image to-----------:" + fileurl.getAbsolutePath());
                item.write(fileurl);
            } catch (Exception e) {
                throw new RuntimeException("Error saving File:" + fileurl + ": to disk.", e);
            }
        }
    }

    protected void validateFileSizeLimits(FileItem file) {
        if (FileUtils.isImage(file.getName()) && file.getSize() > OfficeServiceConfiguration.instance().getImageSizeLimit()) {
            throw new RuntimeException("Image Size exceeded please upload a smaler Image Limit:" + OfficeServiceConfiguration.instance().getImageSizeLimit() / 100000 + "MB");
        }
        if (FileUtils.isDocument(file.getName()) && file.getSize() > OfficeServiceConfiguration.instance().getFileSizeLimit()) {
            throw new RuntimeException("File Size exceeded please upload a smaler Image Limit:" + OfficeServiceConfiguration.instance().getFileSizeLimit() / 100000 + "MB");
        }
        //all others
        if (file.getSize() > OfficeServiceConfiguration.instance().getFileSizeLimit()) {
            throw new RuntimeException("Exceeded max file size permitted by esrver Limit:" + OfficeServiceConfiguration.instance().getFileSizeLimit() / 100000 + "MB");
        }
    }

    public static FileResource instance() {
        return SpringContext.getBean(FileResource.class);
    }
}
