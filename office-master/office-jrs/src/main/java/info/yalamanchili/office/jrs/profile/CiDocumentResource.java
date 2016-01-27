/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.CiDocumentDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.entity.profile.CIDocument;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Path("secured/cidocument")
@Component
@Transactional
@Scope("request")
public class CiDocumentResource extends CRUDResource<CIDocument> {

    @Autowired
    public CiDocumentDao ciDocumentDao;

    @Override
    public CRUDDao getDao() {
        return ciDocumentDao;
    }

    @GET
    @Path("/cidocs/{ciId}")
    public List<CIDocument> getDocuments(@PathParam("ciId") Long ciId) {
        return new ArrayList<>(ClientInformationDao.instance().findById(ciId).getCidocument());
    }

}
