/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.jrs;

import com.google.common.base.Splitter;
import com.google.common.io.ByteStreams;
import info.chili.commons.FileUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.email.MailUtils;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
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
import org.owasp.esapi.Validator;
import org.owasp.esapi.errors.IntrusionException;
import org.owasp.esapi.errors.ValidationException;
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
        return processFileUpload(request);
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
                setResponseHeaders(response, file);
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

    protected void setResponseHeaders(ResponseBuilder response, File file) {
        setContentHeaders(response, file);
        setCacheControlHeaders(response, file);
    }

    protected void setCacheControlHeaders(ResponseBuilder response, File file) {
        CacheControl cc = new CacheControl();
        //1 week
        //TODO externalize this
        cc.setMaxAge(604800);
        cc.setPrivate(false);
        //ETag
        final EntityTag eTag = new EntityTag(file.getName() + "_"
                + file.lastModified());
        response.tag(eTag);
        response.lastModified(new Date(file.lastModified()));
        response.cacheControl(cc);
    }
//TODO move to utils

    protected void setContentHeaders(ResponseBuilder response, File file) {
        String contentType = FileUtils.getFileContentType(file);
        if (contentType == null) {
            response.header("Content-Disposition", "attachment;");
        } else {
            response.header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
        }
        response.header("Content-Type", contentType);
        //Content disposition with attachement forces the browser to download as attachment(avod inconsistent file type handles by browser)
        response.header("Content-Length", file.length());
    }

    protected Response validateFileUpload(FileItem item, int index) {
        try {
            Validator validator = (Validator) SpringContext.getBean("securityValidator");
            File file = new File(officeServiceConfiguration.getContentManagementLocationRoot() + getFileName(item, index) + item.getName());
            validator.assertValidFileUpload(file.getName(), file.getParentFile().getCanonicalPath(), file.getName(), file.getParentFile(), ByteStreams.toByteArray(item.getInputStream()), getFileUploadSize(item), OfficeServiceConfiguration.instance().getAllowedFileExtensionsAsList(), true);
            //TODO provide more detail
        } catch (IntrusionException ex) {
            return buildResponse(Response.Status.BAD_REQUEST, "Invalid File Upload", ex);
        } catch (ValidationException ex) {
            return buildResponse(Response.Status.BAD_REQUEST, "File Size Exceeded or Invalid File Extension", ex);
        } catch (IOException ex) {
            return buildResponse(Response.Status.INTERNAL_SERVER_ERROR, "Error Uploading File", ex);
        }
        return null;
    }

    protected Response processFileUpload(HttpServletRequest request) {
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            MailUtils.logExceptionDetials(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error Uploading File").build();
        }
        int i = 0;
        for (FileItem item : items) {
            if (item.isFormField() || item.getName() == null || item.getName().trim().equals("")) {
                continue;
            }
            Response res = validateFileUpload(item, i);
            if (res != null) {
                return res;
            }
            String fileName = item.getName().replaceAll("[^a-zA-Z0-9\\._]+", "_");
            File file = new File(officeServiceConfiguration.getContentManagementLocationRoot() + getFileName(item, i)
                    + fileName);
            try {
                log.info("----------writing image to-----------:" + file.getAbsolutePath());
                item.write(file);
                i++;
            } catch (Exception e) {
                return buildResponse(Response.Status.INTERNAL_SERVER_ERROR, "Error Uploading File", e);
            }
        }
        return Response.ok().build();
    }

    protected String getFileName(FileItem item, int index) {
        if (item.getFieldName().contains(";")) {
            return item.getFieldName().split(";")[index];
        } else {
            return item.getFieldName();
        }
    }

    protected Response buildResponse(Response.Status status, String errorMsg, Exception e) {
        MailUtils.logExceptionDetials(e);
        errorMsg = "Error: " + errorMsg;
        return Response.status(status).entity(errorMsg).header("Content-Type", "text/html").header("Content-Length", errorMsg.length()).build();
    }

    protected int getFileUploadSize(FileItem file) {
        if (FileUtils.isImage(file.getName()) && file.getSize() > OfficeServiceConfiguration.instance().getImageSizeLimit()) {
            return (int) OfficeServiceConfiguration.instance().getImageSizeLimit();
        } else if (FileUtils.isDocument(file.getName()) && file.getSize() > OfficeServiceConfiguration.instance().getFileSizeLimit()) {
            return (int) OfficeServiceConfiguration.instance().getFileSizeLimit();
        } //all others
        else {
            return (int) OfficeServiceConfiguration.instance().getFileSizeLimit();
        }
    }

    public static FileResource instance() {
        return SpringContext.getBean(FileResource.class);
    }
}
