package info.yalamanchili.office.jrs;

import java.io.File;
import java.util.Iterator;
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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Path("/file")
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Component
@Transactional
@Scope("request")
public class FileResource {

	protected String fileTargetDirectory = "E://content-management//office/";

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
		List<?> items = null;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			throw new RuntimeException("Error on Image upload", e);
		}
		for (Iterator<?> i = items.iterator(); i.hasNext();) {
			FileItem item = (FileItem) i.next();
			if (item.isFormField() || item.getName() == null || item.getName().trim().equals(""))
				continue;
			File imageurl = new File(fileTargetDirectory + "/" + item.getName());
			try {
				System.out.println("writing image to:" + imageurl.getAbsolutePath());
				item.write(imageurl);
			} catch (Exception e) {
				throw new RuntimeException("Error saving image:" + imageurl + ": to disk.", e);
			}
		}
	}
}
