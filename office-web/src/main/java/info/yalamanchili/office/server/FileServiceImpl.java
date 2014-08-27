/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.server;

import info.chili.gwt.server.AbstractFileServiceServlet;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeWebConfiguration;

/**
 *
 * @author yphanikumar
 *
 */
/**
 * This servlet acts a proxy router to fileService to add authentication header
 */
public class FileServiceImpl extends AbstractFileServiceServlet {

    protected OfficeWebConfiguration officeWebConfiguration;

    @Override
    protected String getServiceBaseUrl() {
        if (officeWebConfiguration == null) {
            officeWebConfiguration = SpringContext.getBean(OfficeWebConfiguration.class);
        }
        return officeWebConfiguration.getOfficeServicesUrl();
    }
}
