/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.bulkimport;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.bulkimport.BulkImportDao;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.jrs.CRUDResource;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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

    @Override
    public CRUDDao getDao() {
        return bulkImportDao;
    }

    @PUT
    @Path("/save")
    @Produces("application/text")
    public String saveBulkUpload(BulkImport entity) {
        BulkImport bi = (BulkImport) getDao().save(entity);
        return bi.getId().toString();
    }

    @GET
    @Path("/{start}/{limit}")
    public BulkImportTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        BulkImportTable tableObj = new BulkImportTable();
        tableObj.setEntities(getDao().query(start, limit));
        tableObj.setSize(getDao().size());
        return tableObj;
    }

    @XmlRootElement
    @XmlType
    public static class BulkImportTable {

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
}
