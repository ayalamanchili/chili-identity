/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.immigration;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.invite.InviteCodeDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.ext.EmployeeAdditionalDetailsDao;
import info.yalamanchili.office.dao.profile.immigration.AlienNumberDao;
import info.yalamanchili.office.dao.profile.immigration.ExperienceSummaryDao;
import info.yalamanchili.office.dao.profile.immigration.I94RecordDao;
import info.yalamanchili.office.dao.profile.immigration.ImmigrationCaseAdditionalDetailsDao;
import info.yalamanchili.office.dao.profile.immigration.ImmigrationCaseDao;
import info.yalamanchili.office.dao.profile.immigration.MiscellaneousInfoDao;
import info.yalamanchili.office.dao.profile.immigration.OtherNamesInfoDao;
import info.yalamanchili.office.dao.profile.immigration.PassportDao;
import info.yalamanchili.office.dao.profile.immigration.UsEducationRecordDao;
import info.yalamanchili.office.entity.immigration.AlienNumber;
import info.yalamanchili.office.entity.immigration.ExperienceSummary;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.entity.immigration.ImmigrationCaseAdditionalDetails;
import info.yalamanchili.office.entity.immigration.MiscellaneousInfo;
import info.yalamanchili.office.entity.immigration.OtherNamesInfo;
import info.yalamanchili.office.entity.immigration.Passport;
import info.yalamanchili.office.entity.immigration.USEducationRecord;
import info.yalamanchili.office.entity.immigration.i94Record;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.EmailType;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.ext.EmployeeAdditionalDetails;
import info.yalamanchili.office.entity.profile.ext.MaritalStatus;
import info.yalamanchili.office.entity.profile.invite.InviteCode;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author radhika.mukkala
 */
@Component
@Scope("prototype")
public class ImmigrationCaseService {

    @PersistenceContext
    protected EntityManager em;

    @Autowired
    protected ImmigrationCaseDao immigrationCaseDao;

    public static ImmigrationCaseService instance() {
        return SpringContext.getBean(ImmigrationCaseService.class);
    }

    public EmployeeH1BDetailsDto loadPage1Details(String invitationCode) {
        EmployeeH1BDetailsDto detailsDto = new EmployeeH1BDetailsDto();
        // employee personal details
        PersonalInfoDto res = new PersonalInfoDto();
        Employee emp = getEmployee(invitationCode);
        ImmigrationCase iCase = getCase(invitationCode);
        if (emp != null) {
            res.setEmail(emp.getPrimaryEmail().getEmail());
            for (info.yalamanchili.office.entity.profile.Email emailAddr : emp.getEmails()) {
                if (emailAddr.getEmailType() != null && emailAddr.getEmailType().getEmailType().equals("Work")) {
                    res.setWorkEmail(emailAddr.getEmail());
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
            detailsDto.setEmpPersonalInfo(res);
        } else {
            Contact cnt = getContact(invitationCode);
            if (cnt != null) {
                res.setEmpFirstName(cnt.getFirstName());
                res.setEmpLastName(cnt.getLastName());
                res.setMiddleInitial(cnt.getMiddleInitial());
                res.setDateOfBirth(cnt.getDateOfBirth());
                res.setGender(cnt.getSex().name());
                res.setEmail(cnt.getEmails().get(0).getEmail());
                res.setMaritalStatus(getMaritalStatus(iCase.getId(), ImmigrationCase.class.getCanonicalName()));
                detailsDto.setEmpPersonalInfo(res);
            }
        }

        // other names info
        List<OtherNamesInfo> otherNames = OtherNamesInfoDao.instance().findAll(iCase.getId(), ImmigrationCase.class.getCanonicalName());
        if (otherNames != null && otherNames.size() > 0) {
            detailsDto.setOtherNamesInfo(otherNames.get(0));
        }
        //alien number
        List<AlienNumber> alienNumbers = AlienNumberDao.instance().findAll(iCase.getId(), ImmigrationCase.class.getCanonicalName());
        if (alienNumbers != null && alienNumbers.size() > 0) {
            detailsDto.setAlienNumber(alienNumbers.get(0));
        }
        EducationDto dto = new EducationDto();
        List<USEducationRecord> records = UsEducationRecordDao.instance().findAll(iCase.getId(), ImmigrationCase.class.getCanonicalName());
        if (records != null && records.size() > 0) {
            USEducationRecord rec = records.get(0);
            dto.setHighestLevelOfEdu(rec.getHighestLevelOfEdu());
            dto.setFieldOfStudy(rec.getFieldOfStudy());
            detailsDto.setUsEducRec(rec);
        }
        List<ImmigrationCaseAdditionalDetails> details = ImmigrationCaseAdditionalDetailsDao.instance().findAll(iCase.getId(), ImmigrationCase.class.getCanonicalName());
        if (details != null && details.size() > 0) {
            ImmigrationCaseAdditionalDetails addtnDetails = details.get(0);
            dto.setNoOfDependents(addtnDetails.getNoOfDependents());
            detailsDto.setEduDto(dto);
        }
        return detailsDto;
    }

    public EmployeeH1BDetailsDto loadPage2Details(String invitationCode) {
        EmployeeH1BDetailsDto detailsDto = new EmployeeH1BDetailsDto();
        ImmigrationCase immiCase = getCase(invitationCode);
        List<Passport> passportRecs = PassportDao.instance().findAll(immiCase.getId(), ImmigrationCase.class.getCanonicalName());
        if (passportRecs != null && passportRecs.size() > 0) {
            detailsDto.setPassport(passportRecs.get(0));
        }
        List<i94Record> i94Recs = I94RecordDao.instance().findAll(immiCase.getId(), ImmigrationCase.class.getCanonicalName());
        if (i94Recs != null && i94Recs.size() > 0) {
            detailsDto.setI94Info(i94Recs.get(0));
        }
        //MiscellaneousInfo
        List<MiscellaneousInfo> misceInfos = MiscellaneousInfoDao.instance().findAll(immiCase.getId(), ImmigrationCase.class.getCanonicalName());
        if (misceInfos != null && misceInfos.size() > 0) {
            detailsDto.setMisceInfo(misceInfos.get(0));
        }
        //Experience Summary
        List<ExperienceSummary> expSummarys = ExperienceSummaryDao.instance().findAll(immiCase.getId(), ImmigrationCase.class.getCanonicalName());
        if (expSummarys != null && expSummarys.size() > 0) {
            detailsDto.setExpSummary(expSummarys.get(0));
        }

        List<ImmigrationCaseAdditionalDetails> details = ImmigrationCaseAdditionalDetailsDao.instance().findAll(immiCase.getId(), ImmigrationCase.class.getCanonicalName());
        if (details != null && details.size() > 0) {
            detailsDto.setCaseAddtnDetails(details.get(0));
        }
        return detailsDto;
    }

    public Employee getEmployee(String invitationCode) {
        ImmigrationCase iCase = getCase(invitationCode);
        Employee emp;
        if (iCase != null && iCase.getEmployee() != null) {
            emp = EmployeeDao.instance().findById(iCase.getEmployee().getId());
            return emp;
        }
        return null;
    }

    public Contact getContact(String invitationCode) {
        ImmigrationCase iCase = getCase(invitationCode);
        Contact cnt;
        if (iCase != null) {
            cnt = ContactDao.instance().findByEmail(iCase.getEmail());
            return cnt;
        }
        return null;
    }

    public InviteCode getInviteCode(String invitationCode) {
        String invCde = invitationCode.trim();
        return InviteCodeDao.instance().find(invCde);
    }

    public ImmigrationCase getCase(String invitationCode) {
        InviteCode code = getInviteCode(invitationCode);
        List<ImmigrationCase> immigrationCases = new ArrayList();
        immigrationCases = immigrationCaseDao.findByEmail(code.getEmail());
        if (immigrationCases.size() > 0) {
            return immigrationCases.get(0);
        }
        return null;
    }

    private String getMaritalStatus(Long targetId, String targetName) {
        List<EmployeeAdditionalDetails> listDetails = EmployeeAdditionalDetailsDao.instance().findAll(targetId, targetName);
        if (listDetails != null && listDetails.size() > 0) {
            EmployeeAdditionalDetails details = listDetails.get(0);
            MaritalStatus maritalStatus = details.getMaritalStatus();
            return maritalStatus.name();
        }
        return null;
    }
}