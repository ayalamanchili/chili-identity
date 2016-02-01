/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.bpm;

import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.bpm.OfficeBPMFormService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.chili.bpm.types.FormProperty;
import info.chili.bpm.types.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * This will server the html for managing tasks from email and other browser
 * based sessions
 *
 * @author ayalamanchili
 */
//@Path("secured/web/bpm/")
//@Component
//@Scope("request")
//@Produces("application/json")
//@Consumes("application/json")
//@Transactional
public class WebBpmResource {

    @Autowired
    protected OfficeBPMTaskService officeBPMTaskService;

    @Autowired
    protected OfficeBPMFormService officeBPMFormService;

    @GET
    @Path("/task/{taskId}")
    @Produces(MediaType.TEXT_HTML)
    public Response viewTask(@PathParam("taskId") String taskId) {
        StringBuilder res = new StringBuilder();
        Task task = officeBPMTaskService.getTaskForId(taskId);
        res.append("<body><pre>").append(task.getDescription()).append(buildForm(taskId)).append("</pre></body>");
        return Response.ok(res.toString(), MediaType.TEXT_HTML).header("Referer", "/office/resources/public/web/bpm/task/" + taskId).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/task/{taskId}")
    public void completeTask(@PathParam("taskId") String taskId, MultivaluedMap<String, String> formParams) {
        List<Entry> vars = new ArrayList();
        for (Map.Entry<String, List<String>> v : formParams.entrySet()) {
            if (v.getValue().size() > 0) {
                vars.add(new Entry(v.getKey(), v.getValue().get(0)));
            }
        }
        officeBPMTaskService.completeTask(taskId, vars);
    }

    public String buildForm(String taskId) {
        StringBuilder form = new StringBuilder();
        form.append("<form method=\"post\" action=\"/office/resources/public/web/bpm/task/").append(taskId).append("\">");
        for (FormProperty property : officeBPMFormService.getTaskFormProperties(taskId)) {
            form.append(property.getName()).append(" : ");
            if (property.getType().getName().equals("string")) {
                form.append("<input type=\"text\" name=\"").append(property.getId()).append("\"/>");
            }
            if (property.getType().getName().equals("enum")) {
                form.append("<select name=\"" + property.getId() + "\">");
                for (Entry entry : property.getType().getValues()) {
                    form.append("<option value=\"").append(entry.getId()).append("\">").append(entry.getValue()).append("</option>");
                }
                form.append("</select>");
            }
            form.append("</br>");
        }
        form.append("<input type=\"submit\" value=\"Submit\"> ");
        form.append("</form>");
        return form.toString();
    }
}
