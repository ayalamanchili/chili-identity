package info.yalamanchili.office.jrs;

import info.yalamanchili.office.config.OfficeServiceConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Path("file")
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Component
@Transactional
@Scope("request")
public class FileResource {

    @Autowired
    protected OfficeServiceConfiguration officeServiceConfiguration;

    @POST
    @Path("/upload")
    public Response uploadFile(@Context HttpServletRequest request) {
        System.out.println("---------------uploading file-----------------");
        processImageUpload(request);
        return Response.ok().build();
    }

    @GET
    @Path("/download")
    @Produces("image/*")
    public Response downloadFile(@QueryParam("path") String path) {
        ResponseBuilder response = null;
        if (path == null || path.trim().length() < 1) {
            response = Response.status(Response.Status.BAD_REQUEST);
            return response.build();
        }
        File file = null;
        try {
            file = new File(officeServiceConfiguration.getContentManagementLocationRoot() + path);
            if (file.exists()) {
                System.out.println("downloading---------:" + file.getPath());
                response = Response.ok((Object) file);
                response.header("Content-Disposition", "attachment; filename=" + file.getName());
                response.header("Content-Type", "application/pdf");
                return response.build();
            } else {
                response = Response.status(Response.Status.NOT_FOUND);
                return response.build();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error processing File download" + e);
        }

    }

    protected void processImageUpload(HttpServletRequest request) {
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
            File fileurl = new File(officeServiceConfiguration.getContentManagementLocationRoot() + item.getFieldName()
                    + item.getName());
            try {
                System.out.println("----------writing image to-----------:" + fileurl.getAbsolutePath());
                item.write(fileurl);
            } catch (Exception e) {
                throw new RuntimeException("Error saving File:" + fileurl + ": to disk.", e);
            }
        }
    }
}
