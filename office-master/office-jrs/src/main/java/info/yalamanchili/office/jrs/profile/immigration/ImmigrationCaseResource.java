/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.immigration;

import info.chili.commons.SearchUtils;
import info.chili.dao.CRUDDao;
import info.chili.document.dao.SerializedEntityDao;
import info.chili.email.Email;
import info.chili.jpa.validation.Validate;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.invite.InviteCodeDao;
import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dao.profile.EmailDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.ext.EmployeeAdditionalDetailsDao;
import info.yalamanchili.office.dao.profile.immigration.EducationRecordDao;
import info.yalamanchili.office.dao.profile.immigration.ImmigrationCaseDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.immigration.EducationRecord;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.entity.immigration.ImmigrationCaseStatus;
import info.yalamanchili.office.entity.profile.EmailType;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Sex;
import info.yalamanchili.office.entity.profile.ext.EmployeeAdditionalDetails;
import info.yalamanchili.office.entity.profile.ext.Ethnicity;
import info.yalamanchili.office.entity.profile.ext.MaritalStatus;
import info.yalamanchili.office.entity.profile.invite.InvitationType;
import info.yalamanchili.office.entity.profile.invite.InviteCode;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.EmployeeOnBoardingService;
import info.yalamanchili.office.profile.invite.InviteCodeGeneratorService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Bhavana.Atluri
 */
@Path("secured/immigrationcase")
@Component
@Transactional
@Scope("request")
public class ImmigrationCaseResource extends CRUDResource<ImmigrationCase> {

    @Autowired
    protected ImmigrationCaseDao immigrationCaseDao;

    @Override
    public CRUDDao getDao() {
        return immigrationCaseDao;
    }

    @PUT
    @Path("/{employeeId}")
    @Validate
    public ImmigrationCase save(@PathParam("employeeId") Long employeeId, ImmigrationCase entity) {
        entity.setEmployee(EmployeeDao.instance().findById(employeeId));
        entity.setCreatedBy(OfficeSecurityService.instance().getCurrentUserName());
        entity.setImmigrationCaseStatus(ImmigrationCaseStatus.New);
        entity.setCreatedDate(new Date());
        return immigrationCaseDao.save(entity);
    }

    @PUT
    @Validate
    @Path("/add-case")
    public ImmigrationCase saveImmigration(ImmigrationCase entity) {
        if (entity.getId() == null) {
            if (entity.getEmployee() != null) {
                Employee emp = EmployeeDao.instance().findById(entity.getEmployee().getId());
                entity.setEmployee(emp);
                entity.setEmail(emp.getPrimaryEmail().getEmail());
                if (emp.getCompany() != null) {
                    entity.setCompany(CompanyDao.instance().findById(emp.getCompany().getId()));
                } else {
                    entity.setCompany(CompanyDao.instance().findByCompanyName(Company.SSTECH_LLC));
                }
            }
            if (entity.getCompany() != null) {
                entity.setCompany(CompanyDao.instance().findById(entity.getCompany().getId()));
            }
            entity.setCreatedBy(OfficeSecurityService.instance().getCurrentUserName());
            entity.setImmigrationCaseStatus(ImmigrationCaseStatus.New);
            entity.setCreatedDate(new Date());
            return immigrationCaseDao.save(entity);
        } else {
            ImmigrationCase newCase = ImmigrationCaseDao.instance().findById(entity.getId());
            if (entity.getEmployee() != null) {
                Employee emp = EmployeeDao.instance().findById(entity.getEmployee().getId());
                newCase.setEmployee(emp);
                newCase.setEmail(entity.getEmail());
            } else {
                newCase.setEmail(entity.getEmail());
            }
            if (entity.getCompany() != null) {
                newCase.setCompany(CompanyDao.instance().findById(entity.getCompany().getId()));
            }
            newCase.setSponsorType(entity.getSponsorType());
            newCase.setImmigrationCaseStatus(entity.getImmigrationCaseStatus());
            newCase.setImmigrationCaseType(entity.getImmigrationCaseType());
            return immigrationCaseDao.getEntityManager().merge(newCase);
        }
    }

    @GET
    @Path("/{empId}/{start}/{limit}")
    @Cacheable(OfficeCacheKeys.IMMIGRATION_CASE)
    public ImmigrationCaseTable table(@PathParam("empId") long empId, @PathParam("start") int start, @PathParam("limit") int limit) {
        Employee emp = EmployeeDao.instance().findById(empId);
        ImmigrationCaseTable tableObj = new ImmigrationCaseTable();
        tableObj.setEntities(immigrationCaseDao.getImmigrationCases(emp, start, limit));
        tableObj.setSize(immigrationCaseDao.getImmigrationCaseSize(emp, start, limit));
        return tableObj;
    }

    @GET
    @Path("/read-all/{start}/{limit}")
    public ImmigrationCaseTable readAllTable(@PathParam("start") int start, @PathParam("limit") int limit) {
        ImmigrationCaseTable tableObj = new ImmigrationCaseTable();
        tableObj.setEntities(immigrationCaseDao.query(start, limit));
        tableObj.setSize(Long.valueOf(tableObj.getEntities().size()));
        return tableObj;
    }

    @GET
    @Path("send-questionnaire/{caseId}")
    @CacheEvict(value = OfficeCacheKeys.IMMIGRATION_CASE, allEntries = true)
    public void sendH1BQuestionnaire(@PathParam("caseId") Long caseId) {
        ImmigrationCase immigrationCase = immigrationCaseDao.findById(caseId);
        immigrationCase.setImmigrationCaseStatus(ImmigrationCaseStatus.Pending_Questionnaire_Submission);
        immigrationCaseDao.getEntityManager().merge(immigrationCase);
        String empEmail = null;
        Employee emp = null;
        if (immigrationCase.getEmployee() != null) {
            emp = EmployeeDao.instance().findById(immigrationCase.getEmployee().getId());
            empEmail = emp.getPrimaryEmail().getEmail();
        } else {
            empEmail = immigrationCase.getEmail();
        }
        InviteCode code = InviteCodeGeneratorService.instance().generate(InvitationType.H1B_Questionnaire, empEmail, new Date(), DateUtils.addDays(new Date(), 7), false, immigrationCase);
        SerializedEntityDao.instance().save(immigrationCase, code.getClass().getCanonicalName(), code.getId());
        Email email = new Email();
        email.addTo(empEmail);
        Map<String, Object> emailCtx = new HashMap<>();
        emailCtx.put("invitationCode", OfficeServiceConfiguration.instance().getPortalWebUrl() + "?h1b-questionnaire=" + code.getInvitationCode()); //+ "&invitationType=" + code.getInviteType().getInvitationType().name());
        if (emp != null) {
            emailCtx.put("employeeName", emp.getFirstName() + " " + emp.getLastName());
            if (emp.getCompany() != null) {
                emailCtx.put("companyName", emp.getCompany().getName());
            } else {
                emailCtx.put("companyName", Company.SSTECH_LLC);
            }
        } else {
            emailCtx.put("employeeName", immigrationCase.getEmployeeName());
            emailCtx.put("companyName", CompanyDao.instance().findById(immigrationCase.getCompany().getId()).getName());
        }
        emailCtx.put("caseType", immigrationCase.getImmigrationCaseType().name());
        emailCtx.put("validFrom", new SimpleDateFormat("MM/dd/yyyy").format(code.getValidFromDate()));
        emailCtx.put("validTo", new SimpleDateFormat("MM/dd/yyyy").format(code.getExpiryDate()));
        email.setTemplateName("questionnaire_invitation_email_template.html");
        String messageText = "Processing of your " + immigrationCase.getImmigrationCaseType() + " Visa Petition - " + CompanyDao.instance().findById(immigrationCase.getCompany().getId()).getName();
        email.setContext(emailCtx);
        email.setSubject(messageText);
        email.setBody(code.getInvitationCode());
        MessagingService.instance().sendEmail(email);
    }

    @GET
    @Path("h1b-questionnaire/get-details")
    @CacheEvict(value = OfficeCacheKeys.IMMIGRATION_CASE)
    public EmployeeH1BDetailsDto getdetails(@QueryParam("invitationCode") String invitationCode) {
        EmployeeH1BDetailsDto detailsDto = new EmployeeH1BDetailsDto();
        PersonalInfoDto res = new PersonalInfoDto();
        info.yalamanchili.office.entity.profile.Email email;
        Employee emp = getEmployee(invitationCode);
        if (emp != null) {
            if (emp.getEmails().size() > 0) {
                email = emp.getEmails().get(emp.getEmails().size() - 1);
                res.setEmail(email.getEmail());
                if (email.getEmailType().getEmailType().equals("Work")) {
                    res.setWorkEmail(email.getEmail());
                }
            }
            res.setEmpFirstName(emp.getFirstName());
            res.setEmpLastName(emp.getLastName());
            if (emp.getMiddleInitial() != null) {
                res.setMiddleInitial(emp.getMiddleInitial());
            }
            res.setDateOfBirth(emp.getDateOfBirth());
            res.setSsn(emp.getSsn());
            EmployeeAdditionalDetails details = EmployeeAdditionalDetailsDao.instance().find(emp);
            if (details != null && details.getId() != null) {
                res.setMaritalStatus(details.getMaritalStatus().name());
            } else {
                res.setMaritalStatus(MaritalStatus.Unknown.name());
            }
            if (emp.getSex() != null) {
                res.setGender(emp.getSex().name());
            }
        }
        detailsDto.setEmpPersonalInfo(res);
        return detailsDto;
    }

    @PUT
    @Path("save-personal-info/{invitationCode}")
    public EmployeeH1BDetailsDto savePersonalInfo(@PathParam("invitationCode") String invitationCode, EmployeeH1BDetailsDto dto) {
        Employee emp = getEmployee(invitationCode);
        if (dto.getEmpPersonalInfo() != null) {
            PersonalInfoDto personalInfoDto = dto.getEmpPersonalInfo();
            emp.setFirstName(personalInfoDto.getEmpFirstName());
            emp.setLastName(personalInfoDto.getEmpLastName());
            emp.setDateOfBirth(personalInfoDto.getDateOfBirth());
            if (personalInfoDto.getMiddleInitial() != null) {
                emp.setMiddleInitial(personalInfoDto.getMiddleInitial());
            }
            emp.setSsn(personalInfoDto.getSsn());
            //Personal Email
            info.yalamanchili.office.entity.profile.Email emailAdd = new info.yalamanchili.office.entity.profile.Email();
            emailAdd.setEmail(personalInfoDto.getEmail());
            emailAdd.setPrimaryEmail(Boolean.TRUE);
            //emailAdd.setEmailType(new EmployeeOnBoardingService().getPersonalEmailType());
            emailAdd.setContact(ContactDao.instance().findByEmail(InviteCodeDao.instance().find(invitationCode.trim()).getEmail()));
            emp.addEmail(EmailDao.instance().save(emailAdd));
            //Work Email
            info.yalamanchili.office.entity.profile.Email workEmail = new info.yalamanchili.office.entity.profile.Email();
            workEmail.setEmail(personalInfoDto.getEmail());
            workEmail.setPrimaryEmail(Boolean.TRUE);
            workEmail.setEmailType(getWorkEmailType());
            workEmail.setContact(ContactDao.instance().findByEmail(InviteCodeDao.instance().find(invitationCode.trim()).getEmail()));
            emp.addEmail(EmailDao.instance().save(workEmail));
            if (personalInfoDto.getGender().equalsIgnoreCase("male")) {
                emp.setSex(Sex.MALE);
            } else {
                emp.setSex(Sex.FEMALE);
            }
            if (personalInfoDto.getMaritalStatus() != null) {
                EmployeeAdditionalDetails details = EmployeeAdditionalDetailsDao.instance().find(emp);
                if (details != null) {
                    details.setMaritalStatus(setMaritalStatus(personalInfoDto.getMaritalStatus()));
                    EmployeeAdditionalDetailsDao.instance().getEntityManager().merge(details);
                } else {
                    EmployeeAdditionalDetails addtnDetails = new EmployeeAdditionalDetails();
                    addtnDetails.setMaritalStatus(setMaritalStatus(personalInfoDto.getMaritalStatus()));
                    addtnDetails.setEthnicity(Ethnicity.Unspecified);
                    addtnDetails.setReferredBy("Unknown");
                    addtnDetails.setTargetEntityId(emp.getId());
                    addtnDetails.setTargetEntityName(Employee.class.getCanonicalName());
                    EmployeeAdditionalDetailsDao.instance().save(addtnDetails);
                }
            }
            EmployeeDao.instance().getEntityManager().merge(emp);
        }
        return dto;
    }

//    @PUT
//    @Path("save-edu-info2/{invitationCode}")
//    public EmployeeH1BDetailsDto saveEducatnRecInfo(@PathParam("invitationCode") String invitationCode, EmployeeH1BDetailsDto dto) {
//        ImmigrationCase immiCase = getCase(invitationCode);
//        EducationRecord record = new EducationRecord();
//        if (dto.getEduRecord() != null) {
//            EducationRecord immiEduRec = dto.getEduRecord();
//            record.setAddress(immiEduRec.getAddress());
//            record.setDateDegreeAwarded(immiEduRec.getDateDegreeAwarded());
//            record.setDegreeOfStudy(immiEduRec.getDegreeOfStudy());
//            record.setFieldOfStudy(immiEduRec.getFieldOfStudy());
//            record.setNameOfSchool(immiEduRec.getNameOfSchool());
//            record.setTargetEntityId(immiCase.getId());
//            record.setTargetEntityName(ImmigrationCase.class.getCanonicalName());
//            EducationRecordDao.instance().save(record);
//        }
//        return dto;
//    }

    private MaritalStatus setMaritalStatus(String maritalStatus) {
        MaritalStatus status = null;
        switch (maritalStatus) {
            case "Married":
                status = MaritalStatus.Married;
                break;
            case "Unmarried":
                status = MaritalStatus.Unmarried;
                break;
            case "Unknown":
                status = MaritalStatus.Unknown;
                break;
        }
        return status;
    }

    public EmailType getWorkEmailType() {
        Query getEmailType = EmailDao.instance().getEntityManager().createQuery("from " + EmailType.class.getCanonicalName()
                + " where emailType=:emailTypeParam");
        getEmailType.setParameter("emailTypeParam", "Work");
        if (getEmailType.getResultList().size() > 0) {
            return (EmailType) getEmailType.getResultList().get(0);
        } else {
            EmailType workEmailType = new EmailType();
            workEmailType.setEmailType("Work");
            return EmailDao.instance().getEntityManager().merge(workEmailType);
        }
    }

    private Employee getEmployee(String invitationCode) {
        InviteCode code = getInviteCode(invitationCode);
        Employee emp;
        if (EmployeeDao.instance().findByEmail(code.getEmail()) != null) {
            emp = EmployeeDao.instance().findByEmail(code.getEmail());
            return emp;
        }
        return null;
    }

    private InviteCode getInviteCode(String invitationCode) {
        String invCde = invitationCode.trim();
        return InviteCodeDao.instance().find(invCde);
    }

//    private ImmigrationCase getCase(String invitationCode) {
//        InviteCode code = getInviteCode(invitationCode);
//        Employee emp = getEmployee(code.getInvitationCode());
//        List<ImmigrationCase> immigrationCases = immigrationCaseDao.instance().getImmigrationCases(emp, 0, 10);
//        for (ImmigrationCase iCase : immigrationCases) {
//            if (iCase.getEmail().equals(code.getEmail())) {
//                return iCase;
//            }
//        }
//        return null;
//    }

    @PUT
    @Path("/search-case/{start}/{limit}")
    @Transactional(propagation = Propagation.NEVER)
    @Override
    public List<ImmigrationCase> search(ImmigrationCase entity, @PathParam("start") int start, @PathParam("limit") int limit) {
        Query searchQuery = SearchUtils.getSearchQuery(immigrationCaseDao.getEntityManager(), entity, new SearchUtils.SearchCriteria());
        searchQuery.setFirstResult(start);
        searchQuery.setMaxResults(limit);
        return searchQuery.getResultList();
    }

    @XmlRootElement
    @XmlType
    public static class ImmigrationCaseTable implements java.io.Serializable {

        protected Long size;
        protected List<ImmigrationCase> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<ImmigrationCase> getEntities() {
            return entities;
        }

        public void setEntities(List<ImmigrationCase> entities) {
            this.entities = entities;
        }
    }
}
