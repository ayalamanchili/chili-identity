/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.bulkimport;

import info.chili.service.jrs.types.Entry;
import info.yalamanchili.office.bulkimport.BulkImportService;
import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.dao.bulkimport.BulkImportDao;
import info.yalamanchili.office.dao.bulkimport.BulkImportMessageDao;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.bulkimport.BulkImportEntity;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessage;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessageType;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("secured/bulkimport")
@Component
@Scope("request")
@Transactional
public class BulkImportResource extends CRUDResource<BulkImport> {

    @Autowired
    protected BulkImportDao bulkImportDao;
    @Autowired
    protected BulkImportService bulkImportService;
    @Autowired
    BulkImportMessageDao bulkImportMessageDao;

    @Override
    public CRUDDao getDao() {
        return bulkImportDao;
    }

    @PUT
    @Validate
    @Path("/save")
    @Produces("application/text")
    @PreAuthorize("hasRole('ROLE_BULK_IMPORT')")
    public String saveBulkUpload(BulkImport entity) {
        return bulkImportService.saveBulkUpload(entity);
    }

    @GET
    @Path("/adapters")
    public List<Entry> getBulkImportAdapters() {
        return bulkImportService.getBulkImportAdapters();
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void delete(@PathParam("id") Long id) {
        bulkImportService.delete(id);
    }

    @GET
    @Path("/{start}/{limit}")
    public BulkImportTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        BulkImportTable tableObj = new BulkImportTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @GET
    @Path("/entities/{bulkImportId}/{start}/{limit}")
    public BulkImportEntityTable getEntities(@PathParam("bulkImportId") Long bulkImportId, @PathParam("start") int start, @PathParam("limit") int limit, @QueryParam("messageType") String messageType) {
        BulkImportEntityTable tableObj = new BulkImportEntityTable();
        BulkImport bulkImport = bulkImportDao.findById(bulkImportId);
        tableObj.setEntities(bulkImport.getEntities());
        tableObj.setSize(Integer.valueOf(bulkImport.getEntities().size()).longValue());
        return tableObj;
    }

    @GET
    @Path("/messages/{bulkImportId}/{start}/{limit}")
    public BulkImportMessageTable getMessages(@PathParam("bulkImportId") Long bulkImportId, @PathParam("start") int start, @PathParam("limit") int limit, @QueryParam("messageType") String messageType) {
        BulkImportMessageTable tableObj = new BulkImportMessageTable();
        if (messageType != null) {
            tableObj.setEntities(bulkImportMessageDao.getMessages(bulkImportId, BulkImportMessageType.valueOf(messageType), start, limit));
        } else {
            tableObj.setEntities(bulkImportMessageDao.getMessages(bulkImportId, null, start, limit));
        }
        tableObj.setSize(bulkImportMessageDao.getMessagesSize(bulkImportId, BulkImportMessageType.valueOf(messageType)));
        return tableObj;
    }

    @XmlRootElement
    @XmlType
    public static class BulkImportTable implements java.io.Serializable {

        protected Long size;
        protected List<BulkImport> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<BulkImport> getEntities() {
            return entities;
        }

        public void setEntities(List<BulkImport> entities) {
            this.entities = entities;
        }
    }

    @XmlRootElement
    @XmlType
    public static class BulkImportMessageTable implements java.io.Serializable {

        protected Long size;
        protected List<BulkImportMessage> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<BulkImportMessage> getEntities() {
            return entities;
        }

        public void setEntities(List<BulkImportMessage> entities) {
            this.entities = entities;
        }
    }

    @XmlRootElement
    @XmlType
    public static class BulkImportEntityTable implements java.io.Serializable {

        protected Long size;
        protected List<BulkImportEntity> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<BulkImportEntity> getEntities() {
            return entities;
        }

        public void setEntities(List<BulkImportEntity> entities) {
            this.entities = entities;
        }
    }
}
