/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs;

import info.chili.commons.SearchUtils;
import info.chili.reporting.ReportGenerator;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import java.util.ArrayList;

import java.util.List;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author ayalamanchili
 */
public abstract class CRUDResource<T> extends info.chili.service.jrs.CRUDResource<T> {

    @PUT
    @Path("/search_report")
    public Response searchReport(T entity, @QueryParam("format") String format) {
        Response.ResponseBuilder response;
        //TODO get autogenerate unique file name
        String fileName = "report" + "." + format;
        List<T> data = new ArrayList<T>();
        Long size = SearchUtils.getSearchSize(getDao().getEntityManager(), entity);
        int start = 0;
        int limit = 100;
        do {
            data.addAll(search(entity, start, limit));
            start = start + limit;
        } while ((start + limit) < size);
        try {
            ReportGenerator.generateReport(data, format, OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + fileName);
            response = Response.ok(fileName.getBytes());
        } catch (JRException e) {
            response = Response.serverError();
        }
        return response.build();
    }
}
