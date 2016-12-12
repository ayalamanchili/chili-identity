/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs;

import com.google.common.base.Strings;
import info.chili.commons.SearchUtils;
import info.chili.reporting.ReportGenerator;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import java.util.ArrayList;

import java.util.List;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author ayalamanchili
 */
public abstract class CRUDResource<T> extends info.chili.service.jrs.CRUDResource<T> {

    @PUT
    @Path("/search_report")
    public Response searchReport(T entity,@QueryParam("fileName")String reportName, @QueryParam("format") String format) {
        Response.ResponseBuilder response;
        if(Strings.isNullOrEmpty(reportName)){
            reportName="report";
        }
        List<T> data = new ArrayList<T>();
        Long size = SearchUtils.getSearchSize(getDao().getEntityManager(), entity);
        int start = 0;
        int limit = 100;
        do {
            data.addAll(search(entity, start, limit));
            start = start + limit;
        } while ((start + limit) < size);
            return ReportGenerator.generateReport(data,reportName, format, OfficeServiceConfiguration.instance().getContentManagementLocationRoot());
    }
}
