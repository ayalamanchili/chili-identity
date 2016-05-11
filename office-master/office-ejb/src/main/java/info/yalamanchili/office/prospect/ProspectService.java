/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.prospect;

import com.google.common.base.Strings;
import info.chili.audit.AuditService;
import info.chili.commons.DateUtils;
import info.chili.hibernate.envers.AuditRevisionEntity;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.service.jrs.types.EntityAuditDataTbl;
import info.chili.service.jrs.types.Entries;
import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import static info.yalamanchili.office.bpm.prospect.ProspectEmailEscalation.PROSPECT_ESCALATION_NOTIFICATION_GROUP;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.hr.ProspectDao;
import info.yalamanchili.office.dao.hr.ProspectReportDto;
import info.yalamanchili.office.dao.hr.ResumeDao;
import info.yalamanchili.office.dao.message.NotificationGroupDao;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.prospect.ProspectDto;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.hr.Prospect;
import info.yalamanchili.office.entity.hr.ProspectStatus;
import info.yalamanchili.office.entity.hr.Resume;
import info.yalamanchili.office.entity.message.NotificationGroup;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.ejb.hr.ProspectProcessBean;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.dozer.Mapper;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Component
@Scope("prototype")
public class ProspectService {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;

    @Autowired
    protected ProspectDao prospectDao;

    public ProspectDto save(ProspectDto dto) {
        if (ContactDao.instance().findByEmail(dto.getEmail()) != null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "email.already.exist", "Contact Already Exist With The Same Email");
        }
        Prospect entity = mapper.map(dto, Prospect.class);
        if (dto.getAssignedTo() != null) {
            entity.setAssigned(dto.getAssignedTo().getId());
        }
        if (dto.getCaseManager() != null) {
            entity.setManager(dto.getCaseManager().getId());
        }

        entity.setStartDate(new Date());
        entity.setStatus(ProspectStatus.IN_PROGRESS);
        Contact contact = new Contact();
        contact.setFirstName(dto.getFirstName());
        contact.setLastName(dto.getLastName());
        if (dto.getMiddleInitial() != null) {
            contact.setMiddleInitial(dto.getMiddleInitial());
        } else {
            contact.setMiddleInitial(null);
        }
        contact.setDateOfBirth(dto.getDateOfBirth());
        contact.setSex(dto.getSex());

        if (!Strings.isNullOrEmpty(dto.getEmail())) {
            Email email = new Email();
            email.setEmail(dto.getEmail());
            email.setPrimaryEmail(Boolean.TRUE);
            contact.addEmail(email);
        }
        //phone
        if (!Strings.isNullOrEmpty(dto.getPhoneNumber())) {
            Phone phone = new Phone();
            contact.addPhone(phone);
            phone.setPhoneNumber(dto.getPhoneNumber());
            phone.setCountryCode(dto.getCountryCode());
            phone.setExtension(dto.getExtension());
        }
        //address
        Address address;
        address = dto.getAddress();
        if (dto.getAddress() != null) {
            AddressDao.instance().save(address);
            contact.addAddress(address);
            address.setStreet1(dto.getAddress().getStreet1());
            address.setStreet2(dto.getAddress().getStreet2());
            address.setCity(dto.getAddress().getCity());
            address.setCountry(dto.getAddress().getCountry());
            address.setZip(dto.getAddress().getZip());
            address.setState(dto.getAddress().getState());
        }

        //contact
        contact = em.merge(contact);
        entity.setContact(contact);
        if (entity.getStatus().equals(ProspectStatus.CLOSED_WON)) {
            if (dto.getDateOfJoining() != null) {
                entity.setDateOfJoining(dto.getDateOfJoining());
            }
            if (dto.getPlacedBy() != null) {
                entity.setPlacedBy(dto.getPlacedBy());
            }
            if (dto.getTrfEmpType() != null) {
                entity.setTrfEmpType(dto.getTrfEmpType());
            }
            if (dto.getPetitionFiledFor() != null) {
                entity.setPetitionFiledFor(dto.getPetitionFiledFor());
            }
            if (dto.getCompany() != null) {
                entity.setCompany(dto.getCompany());
            }
        } else {
            entity.setDateOfJoining(null);
            entity.setPlacedBy(null);
            entity.setTrfEmpType(null);
            entity.setPetitionFiledFor(null);
            entity.setCompany(null);
        }
        for (Resume resume : entity.getResumeURL()) {
            if (!Strings.isNullOrEmpty(resume.getFileURL())) {
                resume.setProspect(entity);
                resume.setUpdatedTS(Calendar.getInstance().getTime());
            }
        }
        entity = em.merge(entity);
        if (dto.getEmployees() != null && dto.getEmployees().size() > 0) {
            List<String> emails = new ArrayList();
            String emaillist = "Email has been sent to : ";
            for (Long id : dto.getEmployees()) {
                String email = EmployeeDao.instance().findById(id).getPrimaryEmail().getEmail();
                emails.add(email);
            }
            if (dto.getCaseManager() != null) {
                for (String email : emails) {
                    emaillist = emaillist.concat(email) + " , ";
                }
                emaillist = emaillist.concat(EmployeeDao.instance().findById(dto.getCaseManager().getId()).getPrimaryEmail().getEmail());
            }
            CommentDao.instance().addComment(emaillist, entity);
        }
        CommentDao.instance().addComment(dto.getComment(), entity);
        dto.setId(entity.getId());
        ProspectProcessBean.instance().notifyCaseManager(entity, dto.getEmployees());
        return mapper.map(entity, ProspectDto.class);
    }

    public ProspectDto read(Long id) {
        Prospect ec = prospectDao.findById(id);
        ProspectDto dto = ProspectDto.map(mapper, ec);
        if (ec.getAssigned() != null) {
            dto.setAssignedTo(EmployeeDao.instance().findById(ec.getAssigned()));
        }
        if (ec.getManager() != null) {
            dto.setCaseManager(EmployeeDao.instance().findById(ec.getManager()));
        }
        if (ec.getStatus().equals(ProspectStatus.CLOSED_WON)) {
            if (ec.getDateOfJoining() != null) {
                dto.setDateOfJoining(ec.getDateOfJoining());
            }
            if (ec.getPlacedBy() != null) {
                dto.setPlacedBy(ec.getPlacedBy());
            }
            if (ec.getTrfEmpType() != null) {
                dto.setTrfEmpType(ec.getTrfEmpType());
            }
            if (ec.getPetitionFiledFor() != null) {
                dto.setPetitionFiledFor(ec.getPetitionFiledFor());
            }
        } else {
            dto.setDateOfJoining(null);
            dto.setPlacedBy(null);
            dto.setTrfEmpType(null);
            dto.setPetitionFiledFor(null);
        }
        return dto;
    }

    public ProspectDto clone(Long id) {
        Prospect entity = prospectDao.clone(id, "resumeURL");
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        entity.setStatus(ProspectStatus.IN_PROGRESS);
        ProspectDto res = ProspectDto.map(mapper, entity);
        return res;
    }

    public static ProspectService instance() {
        return SpringContext.getBean(ProspectService.class);
    }

    public ProspectDto update(ProspectDto dto) {
        Prospect entity = prospectDao.findById(dto.getId());
        if (dto.getCaseManager() != null && ProspectStatus.IN_PROGRESS.equals(entity.getStatus()) && (!OfficeSecurityService.instance().getCurrentUser().equals(EmployeeDao.instance().findById(dto.getCaseManager().getId())) && !OfficeSecurityService.instance().hasRole(OfficeRoles.OfficeRole.ROLE_PROSPECTS_MANAGER.name()))) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "you.cannot.update", "You may not have access to update prospect");
        } else if (dto.getCaseManager() == null && ProspectStatus.IN_PROGRESS.equals(entity.getStatus()) && (!OfficeSecurityService.instance().getCurrentUser().equals(EmployeeDao.instance().findById(dto.getAssignedTo().getId())) && !OfficeSecurityService.instance().hasRole(OfficeRoles.OfficeRole.ROLE_PROSPECTS_MANAGER.name()))) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "you.cannot.update", "You may not have access to update prospect");
        } else if ((ProspectStatus.RECRUITING.equals(entity.getStatus()) || ProspectStatus.BENCH.equals(entity.getStatus())) && (!OfficeSecurityService.instance().getCurrentUser().equals(EmployeeDao.instance().findById(dto.getAssignedTo().getId())) && !OfficeSecurityService.instance().hasRole(OfficeRoles.OfficeRole.ROLE_PROSPECTS_MANAGER.name()))) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "you.cannot.update", "You may not have access to update prospect");
        } else {
            if (dto.getAssignedTo() != null) {
                entity.setAssigned(dto.getAssignedTo().getId());
            }
            if (dto.getCaseManager() != null) {
                entity.setManager(dto.getCaseManager().getId());
            }
            if (dto.getScreenedBy() != null) {
                entity.setScreenedBy(dto.getScreenedBy());
            } else {
                entity.setScreenedBy(null);
            }
            if (dto.getStatus() != null) {
                if (entity.getStatus() != dto.getStatus()) {
                    entity.setStatus(dto.getStatus());
                    ProspectProcessBean.instance().notifyCaseManager(entity, dto.getEmployees());
                    sendProspectStatusNotification(entity);
                }
            } else {
                entity.setStatus(ProspectStatus.IN_PROGRESS);
            }
            //entity = prospectDao.save(entity);
            Contact contact = entity.getContact();
            contact.setFirstName(dto.getFirstName());
            contact.setLastName(dto.getLastName());
            if (dto.getMiddleInitial() != null) {
                contact.setMiddleInitial(dto.getMiddleInitial());
            } else {
                contact.setMiddleInitial(null);
            }
            contact.setDateOfBirth(dto.getDateOfBirth());
            contact.setSex(dto.getSex());
            entity.setReferredBy(dto.getReferredBy());
            //       entity.setResumeURL(dto.getResumeURL());
            if (entity.getStatus().equals(ProspectStatus.CLOSED_WON)) {
                if (dto.getDateOfJoining() != null) {
                    entity.setDateOfJoining(dto.getDateOfJoining());
                } else {
                    entity.setDateOfJoining(null);
                }
                if (dto.getPlacedBy() != null) {
                    entity.setPlacedBy(dto.getPlacedBy());
                } else {
                    entity.setPlacedBy(null);
                }
                if (dto.getTrfEmpType() != null) {
                    entity.setTrfEmpType(dto.getTrfEmpType());
                } else {
                    entity.setTrfEmpType(null);
                }
                if (dto.getPetitionFiledFor() != null) {
                    entity.setPetitionFiledFor(dto.getPetitionFiledFor());
                } else {
                    entity.setPetitionFiledFor(null);
                }
                Company company = CompanyDao.instance().findById(dto.getCompany().getId());
                if (dto.getCompany() != null) {
                    entity.setCompany(company);
                } else {
                    entity.setCompany(null);
                }
            } else {
                dto.setDateOfJoining(null);
                dto.setTrfEmpType(null);
                dto.setPlacedBy(null);
                dto.setPetitionFiledFor(null);
                dto.setCompany(null);
                entity.setDateOfJoining(null);
                entity.setTrfEmpType(null);
                entity.setPlacedBy(null);
                entity.setPetitionFiledFor(null);
                entity.setCompany(null);
            }
            if (dto.getComment() != null) {
                CommentDao.instance().addComment(dto.getComment(), entity);
            }
            if (dto.getEmployees() != null && dto.getEmployees().size() > 0) {
                List<String> emails = new ArrayList();
                String emaillist = "Email has been sent to : ";
                for (Long id : dto.getEmployees()) {
                    String email = EmployeeDao.instance().findById(id).getPrimaryEmail().getEmail();
                    emails.add(email);
                }
                for (String email : emails) {
                    emaillist = emaillist.concat(email) + " , ";
                }
                if (dto.getCaseManager() != null) {
                    emaillist = emaillist.concat(EmployeeDao.instance().findById(dto.getCaseManager().getId()).getPrimaryEmail().getEmail());
                }
                if (!dto.getStatus().equals(ProspectStatus.IN_PROGRESS)) {
                    emaillist = emaillist.concat(" , " + EmployeeDao.instance().findById(dto.getAssignedTo().getId()).getPrimaryEmail().getEmail());
                }
                CommentDao.instance().addComment(emaillist, entity);
            }
            if (!Strings.isNullOrEmpty(dto.getScreenedBy())) {
                entity.setScreenedBy(dto.getScreenedBy());
            } else {
                entity.setScreenedBy(null);
            }
            if (dto.getProcessDocSentDate() != null) {
                entity.setProcessDocSentDate(dto.getProcessDocSentDate());
            } else {
                entity.setProcessDocSentDate(null);
            }
            if (contact.getEmails().size() <= 0) {
                if (!Strings.isNullOrEmpty(dto.getEmail())) {
                    Email email = new Email();
                    email.setEmail(dto.getEmail());
                    email.setPrimaryEmail(Boolean.TRUE);
                    contact.addEmail(email);
                }
            } else {
                //TODO update existing email
                contact.getEmails().get(0).setEmail(dto.getEmail());
            }
            //phone
            if (contact.getPhones().size() <= 0) {
                if (!Strings.isNullOrEmpty(dto.getPhoneNumber())) {
                    Phone phone = new Phone();
                    phone.setPhoneNumber(dto.getPhoneNumber());
                    phone.setCountryCode(dto.getCountryCode());
                    phone.setExtension(dto.getExtension());
                    contact.addPhone(phone);
                }
            } else {
                //TODO update existing phone
                contact.getPhones().get(0).setPhoneNumber(dto.getPhoneNumber());
                contact.getPhones().get(0).setCountryCode(dto.getCountryCode());
                contact.getPhones().get(0).setExtension(dto.getExtension());
            }
            //address
            if (contact.getAddresss().size() <= 0) {
                if (dto.getAddress() != null) {
                    Address address = new Address();
                    address = dto.getAddress();
                    address = AddressDao.instance().save(address);
                    contact.addAddress(address);
                }
            } else {
                //TODO update existing address
                contact.getAddresss().get(0).setStreet1(dto.getAddress().getStreet1());
                contact.getAddresss().get(0).setStreet2(dto.getAddress().getStreet2());
                contact.getAddresss().get(0).setCity(dto.getAddress().getCity());
                contact.getAddresss().get(0).setState(dto.getAddress().getState());
                contact.getAddresss().get(0).setCountry(dto.getAddress().getCountry());
                contact.getAddresss().get(0).setZip(dto.getAddress().getZip());
            }
            //contact
            for (Resume resume : dto.getResumeURL()) {
                if (resume.getId() == null) {
                    resume.setProspect(entity);
                    resume.setUpdatedTS(Calendar.getInstance().getTime());
                    entity = prospectDao.getEntityManager().merge(entity);
                    entity.getResumeURL().add(resume);
                } else {
                    ResumeDao.instance().save(resume);
                }
            }
            contact = em.merge(contact);
            entity.setContact(contact);
            prospectDao.getEntityManager().flush();
            entity = prospectDao.findById(entity.getId());
            return mapper.map(entity, ProspectDto.class);
        }
    }

    public void sendProspectStatusNotification(Prospect prospect) {
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        info.chili.email.Email email = new info.chili.email.Email();
        if (prospect.getManager() != null) {
            email.addTo(EmployeeDao.instance().findById(prospect.getManager()).getPrimaryEmail().getEmail());
        }
        if (prospect.getAssigned() != null) {
            email.addTo(EmployeeDao.instance().findById(prospect.getAssigned()).getPrimaryEmail().getEmail());
        }
        NotificationGroup ng = NotificationGroupDao.instance().findByName(PROSPECT_ESCALATION_NOTIFICATION_GROUP);
        if (ng != null) {
            for (Employee employee : ng.getEmployees()) {
                email.addTo(employee.getPrimaryEmail().getEmail());
            }
        }
        if (prospect.getStatus().equals(ProspectStatus.CLOSED_WON)) {
            email.addTos(MailUtils.instance().getEmailsAddressesForRoles(OfficeRoles.OfficeRole.ROLE_HR.name()));
        }
        email.setHtml(Boolean.TRUE);
        email.setSubject("Prospect Status change for : " + prospect.getContact().getFirstName() + " " + prospect.getContact().getLastName() + "; " + "Status: " + prospect.getStatus());
        String messageText = " Prospect Information :: ";
        messageText = messageText.concat("\n Prospect     : " + prospect.getContact().getFirstName() + " " + prospect.getContact().getLastName());
        messageText = messageText.concat("\n Status       : " + prospect.getStatus());
        if (prospect.getManager() != null) {
            messageText = messageText.concat("\n Case Manager : " + EmployeeDao.instance().findById(prospect.getManager()).getFirstName());
        }
        if (prospect.getAssigned() != null) {
            messageText = messageText.concat("\n Assigned To  : " + EmployeeDao.instance().findById(prospect.getAssigned()).getFirstName());
        }
        messageText = messageText.concat("\n Updated_By   : " + emp.getFirstName() + " " + emp.getLastName());
        email.setBody(messageText);
        MessagingService.instance().sendEmail(email);
    }

    @Transactional
    public void sendProspectStatusNotChangeNotification() {
        List<Prospect> prospects = new ArrayList();
        AuditReader auditReader = AuditReaderFactory.get(em);
        List<Prospect> inProgressProspects = new ArrayList();
        List<Prospect> recruitingProspects2 = new ArrayList();
        List<Prospect> recruitingProspects3 = new ArrayList();

        prospects = prospectDao.query(0, 10000);
        if (prospects.size() > 0) {
            for (Prospect prospect : prospects) {
                Date updatedTimeStamp = null;
                for (Number revNumber : auditReader.getRevisions(Prospect.class, prospect.getId())) {
                    AuditRevisionEntity revEntity = auditReader.findRevision(AuditRevisionEntity.class, revNumber);
                    updatedTimeStamp = revEntity.getUpdatedTimeStamp();
                }
                if (prospect.getStatus().equals(ProspectStatus.IN_PROGRESS) && DateUtils.differenceInDays(updatedTimeStamp, new Date()) >= 2) {
                    inProgressProspects.add(prospect);
                }
                if (prospect.getStatus().equals(ProspectStatus.RECRUITING) && DateUtils.differenceInDays(updatedTimeStamp, new Date()) >= 2) {
                    recruitingProspects2.add(prospect);
                }
                if (prospect.getStatus().equals(ProspectStatus.RECRUITING) && DateUtils.differenceInDays(updatedTimeStamp, new Date()) >= 3) {
                    recruitingProspects3.add(prospect);
                }

            }
        }
        if (inProgressProspects.size() > 0) {
            ProspectProcessBean.instance().sendIPProspectsNotification(inProgressProspects, inProgressProspects.size(), true);
        }
        if (recruitingProspects2.size() > 0) {
            ProspectProcessBean.instance().sendIPProspectsNotification(recruitingProspects2, recruitingProspects2.size(), false);
        }
        if (recruitingProspects3.size() > 0) {
            ProspectProcessBean.instance().sendIPProspectsNotification(recruitingProspects3, recruitingProspects3.size(), true);
        }
    }

    @Transactional
    public void sendBenchProspectsWeeklyNotification() {
        ProspectReportDto dto = new ProspectReportDto();
        dto.setStatus(ProspectStatus.BENCH);
        List<Prospect> prospects = new ArrayList();
        Map<Prospect, String> benchProspects = new HashMap();
        prospects = ProspectDao.instance().report(dto);
        for (Prospect prospect : prospects) {
            Map<String, String> changesmap = new HashMap();
            changesmap = getChangesMap(prospect);
            TreeSet<Date> dates = new TreeSet();
            for (String key : changesmap.keySet()) {
                if (key.contains("BENCH")) {
                    String parse = changesmap.get(key).substring(0, 11);
                    Date date;
                    try {
                        date = new SimpleDateFormat("yyyy-MM-dd").parse(parse);
                        dates.add(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(ProspectService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
            if (dates.size() > 0) {
                benchProspects.put(prospect, new SimpleDateFormat("MM-dd-yyyy").format(dates.first()));
            }
        }
        if (benchProspects.size() > 0) {
            ProspectProcessBean.instance().benchProspectsWeeklyNotification(benchProspects);
        }
    }

    public void getProspectsStageProgressReport(List<Prospect> prospects) {
        for (Prospect prospect : prospects) {
            Map<String, String> changesmap = new LinkedHashMap();
            changesmap = getChangesMap(prospect);
            for (String key : changesmap.keySet()) {
                System.out.println("changes map key is ...." + key + " values is... " + changesmap.get(key));
            }
            TreeSet<Date> ipdates = new TreeSet();
            TreeSet<Date> recrdates = new TreeSet();
            TreeSet<Date> benchdates = new TreeSet();
            TreeSet<Date> closedwondates = new TreeSet();
            TreeSet<Date> closedlostdates = new TreeSet();
            TreeSet<Date> onholddates = new TreeSet();

            for (String key : changesmap.keySet()) {
                if (key.contains("IN_PROGRESS")) {
                    String parse = changesmap.get(key).substring(0, 11);
                    Date date;
                    try {
                        date = new SimpleDateFormat("yyyy-MM-dd").parse(parse);
                        ipdates.add(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(ProspectService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (key.contains("RECRUITING")) {
                    String parse = changesmap.get(key).substring(0, 11);
                    Date date;
                    try {
                        date = new SimpleDateFormat("yyyy-MM-dd").parse(parse);
                        recrdates.add(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(ProspectService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (key.contains("BENCH")) {
                    String parse = changesmap.get(key).substring(0, 11);
                    Date date;
                    try {
                        date = new SimpleDateFormat("yyyy-MM-dd").parse(parse);
                        benchdates.add(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(ProspectService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (key.contains("ON_HOLD")) {
                    String parse = changesmap.get(key).substring(0, 11);
                    Date date;
                    try {
                        date = new SimpleDateFormat("yyyy-MM-dd").parse(parse);
                        onholddates.add(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(ProspectService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (key.contains("CLOSED_WON")) {
                    String parse = changesmap.get(key).substring(0, 11);
                    Date date;
                    try {
                        date = new SimpleDateFormat("yyyy-MM-dd").parse(parse);
                        closedwondates.add(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(ProspectService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (key.contains("CLOSED_LOST")) {
                    String parse = changesmap.get(key).substring(0, 11);
                    Date date;
                    try {
                        date = new SimpleDateFormat("yyyy-MM-dd").parse(parse);
                        closedlostdates.add(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(ProspectService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
            String associateName = prospect.getContact().getFirstName() + " " + prospect.getContact().getLastName();
            ProspectStageProgressDto dto = new ProspectStageProgressDto();
            dto.setAssociateName(associateName);
            if (ipdates.size() > 0) {
//                System.out.println("ip dates first ...." + ipdates.first());
//                System.out.println("ip fdates last ....." + ipdates.last());
//                System.out.println("In progress count days :" + DateUtils.differenceInDays(ipdates.first(), recrdates.first()));
                //dto.setInprogress(DateUtils.differenceInDays(ipdates.first(), recrdates.first()));
            } else {
                dto.setInprogress(0);
            }
            if (recrdates.size() > 0) {
                //dto.setRecruiting(DateUtils.differenceInDays(recrdates.first(), recrdates.last()));
            } else {
                dto.setRecruiting(0);
            }
            System.out.println("assoc name : " + dto.getAssociateName() + " ip count :" + dto.getInprogress() + " recr count :" + dto.getRecruiting());
        }
    }

    private Map<String, String> getChangesMap(Prospect prospect) {
        List ignorelist = new ArrayList();
        ignorelist.add(prospect.getReferredBy());
        Map<String, String> changesmap = new HashMap();
        String status = null;
        String updatedDate = null;
        EntityAuditDataTbl recentChanges = AuditService.instance().getRecentChanges(Prospect.class.getCanonicalName(), prospect.getId(), ignorelist);
        List<Entries> entityAuditData = recentChanges.getEntityAuditData();
        for (Entries entry : entityAuditData) {
            List<Entry> entries = entry.getEntries();
            for (Entry entry1 : entries) {
                if (entry1.getId().equals("UPDATED-AT")) {
                    updatedDate = entry1.getValue().substring(0);
                }
                if (entry1.getId().equals("status")) {
                    status = entry1.getValue();
                }
                if (status != null && updatedDate != null) {
                    System.out.println("status :" + status + " Date: " + updatedDate);
                    changesmap.put(status, updatedDate);
                    status = null;
                    updatedDate = null;
                }
            }
        }
        return changesmap;
    }
}
