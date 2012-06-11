package info.yalamanchili.office.jrs;

import info.yalamanchili.office.config.OfficeServiceConfiguration;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
		System.out.println(request.getContentType());
		processImageUpload(request);
		return Response.ok().build();
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
			System.out.println("222222222222222222222222");
			String fileName = getFileName(items);
			if (fileName == null) {
				fileName = item.getName();
			}
			File fileurl = new File(officeServiceConfiguration.getContentManagementLocationRoot() + fileName);
			try {
				System.out.println("----------writing image to-----------:" + fileurl.getAbsolutePath());
				item.write(fileurl);
			} catch (Exception e) {
				throw new RuntimeException("Error saving File:" + fileurl + ": to disk.", e);
			}
		}
	}

	protected String getFileName(List<FileItem> items) {
		String fileName = null;
		for (FileItem item : items) {
			if (item.isFormField()) {
				if ("filename".equalsIgnoreCase(item.getFieldName())) {
					fileName = item.getString();
				}
			}
		}
		return fileName;
	}
}
