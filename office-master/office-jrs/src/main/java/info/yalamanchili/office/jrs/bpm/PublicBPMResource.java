/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.bpm;

import info.chili.service.jrs.types.Entries;
import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.bpm.OfficeBPMFormService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.bpm.types.FormProperty;
import info.yalamanchili.office.bpm.types.Task;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("public/bpm")
@Component
@Scope("request")
@Produces("application/json")
@Consumes("application/json")
@Transactional
public class PublicBPMResource {

    @Autowired
    protected OfficeBPMTaskService officeBPMTaskService;

    @Autowired
    protected OfficeBPMFormService officeBPMFormService;

    @POST
    @Path("/completetask/{taskId}")
    public void completeTask(@PathParam("taskId") String taskId, Entries vars) {
        officeBPMTaskService.completeTask(taskId, vars.getEntries());
    }

    @GET
    @Path("/task/{taskId}")
    @Produces(MediaType.TEXT_HTML)
    public Response viewTask(@PathParam("taskId") String taskId) {
        StringBuilder res = new StringBuilder();
        Task task = officeBPMTaskService.getTaskForId(taskId);
        res.append("<body><pre>").append(task.getDescription()).append(buildForm(taskId)).append("</pre></body>");
        return Response.ok(res.toString(), MediaType.TEXT_HTML).build();
    }

    public String buildForm(String taskId) {
        StringBuilder form = new StringBuilder();
        form.append("<form method=\"post\" action=\"http://localhost:9080/office/resources/public/bpm/task/" + taskId + "\">");
        for (FormProperty property : officeBPMFormService.getTaskFormProperties(taskId)) {
            form.append(property.getName()).append(" : ");
            if (property.getType().getName().equals("string")) {
                form.append("<input type=\"text\" type=\"").append(property.getName()).append("\"/>");
            }
            if (property.getType().getName().equals("enum")) {
                form.append("<select>");
                for (Entry entry : property.getType().getValues()) {
                    form.append("<option value=\"").append(entry.getValue()).append("\">").append(entry.getValue()).append("</option>");
                }
                form.append("</select>");
            }
            form.append("</br>");
        }
        form.append("</form>");
        return form.toString();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/task")
    public Response completeTask(
            @FormParam("key") List<String> values,
            @FormParam("key") List<String> keys) {
        return Response.ok().build();
    }
}
