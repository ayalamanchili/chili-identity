/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.immigration;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.immigration.OtherNamesInfo;
import info.yalamanchili.office.jrs.CRUDResource;
import javax.ws.rs.Path;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rohith.Vallabhaneni
 */
@Path("secured/othernamesinfo")
@Component
@Transactional
@Scope("request")
public class OtherNamesInfoResource extends CRUDResource<OtherNamesInfo> {

    @Override
    public CRUDDao getDao() {
        return null;
    }
    
}
