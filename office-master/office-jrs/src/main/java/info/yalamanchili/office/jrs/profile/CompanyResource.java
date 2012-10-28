/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.jrs.CRUDResource;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * @author ayalamanchili
 */
@Path("company")
@Component
@Scope("request")
public class CompanyResource extends CRUDResource<Company> {

	@Autowired
	public CompanyDao companyDao;

	@Override
	public CRUDDao getDao() {
		return companyDao;
	}

}
