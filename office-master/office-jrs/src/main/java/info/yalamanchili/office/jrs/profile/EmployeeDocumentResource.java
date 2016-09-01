/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.dao.profile.EmployeeDocumentDao;
import info.yalamanchili.office.dao.profile.onboarding.EmployeeOnBoardingDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.privacy.PrivacyData;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeDocument;
import info.yalamanchili.office.entity.profile.onboarding.EmployeeOnBoarding;
import info.yalamanchili.office.entity.profile.onboarding.OnBoardingStatus;
import info.yalamanchili.office.privacy.PrivacyAware;
import info.yalamanchili.office.security.AccessCheck;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author raghu.l
 */
@Path("secured/employee-document")
@Component
@Transactional
@Scope("request")
public class EmployeeDocumentResource extends CRUDResource<EmployeeDocument> {

    @Autowired
    public EmployeeDocumentDao employeeDocumentDao;

    @PUT
    @Validate
    @Path("/{empId}")
    @Produces("application/text")
//    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_HR", "ROLE_RELATIONSHIP"}, strictOrderCheck = false, checkOnReturnObj = true, employeePropertyName = "employee")
    public String createEmployeeDocument(@PathParam("empId") Long empId, EmployeeDocument doc) {
        doc.setEmployee(EmployeeDao.instance().findById(empId));
        return employeeDocumentDao.save(doc).getId().toString();
    }

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR','ROLE_RELATIONSHIP')")
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    @GET
    @Path("/{empid}/{start}/{limit}")
    @AccessCheck(roles = {"ROLE_BACKGROUND_SCREENING_MGR", "ROLE_E_VERIFY_MGR", "ROLE_ON_BOARDING_MGR", "ROLE_HR_ADMINSTRATION", "ROLE_PAYROLL_AND_BENIFITS"})
    public EmployeeDocumentTable getDocuments(@PathParam("empid") long empid, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        EmployeeDocumentTable tableObj = new EmployeeDocumentTable();
        tableObj.setEntities(employeeDocumentDao.getDocuments(empid));
        tableObj.setSize((long) employeeDocumentDao.getDocuments(empid).size());
        return tableObj;
    }

    @PUT
    @Path("/update")
    public EmployeeDocument update(EmployeeDocument entity) {
        String empId = entity.getUpdatedBy();
        if (empId == null || empId.equals("anonymousUser")) {
            empId = OfficeSecurityService.instance().getCurrentUserName();
        }
        EmployeeDocument document = new EmployeeDocument();
        Employee emp = EmployeeDao.instance().findEmployeWithEmpId(empId);
        if (emp.getEmails().size() > 0) {
            for (Email email : emp.getEmails()) {
                if (EmployeeOnBoardingDao.instance().findByEmail(email.getEmail()) != null) {
                    EmployeeOnBoarding onboarding = EmployeeOnBoardingDao.instance().findByEmail(email.getEmail());
                    if (!onboarding.getStatus().equals(OnBoardingStatus.Complete)) {
                        document = employeeDocumentDao.save(entity);
                    } else {
                        throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.update.documents", "You May Not Upload Documents: Onboarding Process Completed");
                    }
                } else {
                    throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.update.documents", "You May Not Upload Documents");
                }
            }
        }
        if (document != null) {
            return document;
        } else {
            return null;
        }
    }

    @Override
    public CRUDDao getDao() {
        return employeeDocumentDao;
    }

    @XmlRootElement
    @XmlType
    public static class EmployeeDocumentTable implements java.io.Serializable {

        protected Long size;
        protected List<EmployeeDocument> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<EmployeeDocument> getEntities() {
            return entities;
        }

        public void setEntities(List<EmployeeDocument> entities) {
            this.entities = entities;
        }
    }
}
