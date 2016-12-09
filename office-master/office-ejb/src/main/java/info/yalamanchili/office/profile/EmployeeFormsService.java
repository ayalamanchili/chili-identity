/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import info.chili.commons.DateUtils;
import info.chili.commons.pdf.PDFUtils;
import info.chili.commons.pdf.PdfDocumentData;
import info.chili.security.Signature;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.expense.BankAccountDao;
import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.ext.DependentDao;
import info.yalamanchili.office.dao.profile.ext.EmployeeAdditionalDetailsDao;
import info.yalamanchili.office.dao.profile.onboarding.EmployeeOnBoardingDao;
import info.yalamanchili.office.dto.onboarding.JoiningFormsDto;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.expense.AccountType;
import info.yalamanchili.office.entity.expense.BankAccount;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.EmergencyContact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.entity.profile.Sex;
import info.yalamanchili.office.entity.profile.ext.Dependent;
import info.yalamanchili.office.entity.profile.ext.EmployeeAdditionalDetails;
import info.yalamanchili.office.entity.profile.ext.Ethnicity;
import info.yalamanchili.office.entity.profile.ext.Disability;
import info.yalamanchili.office.entity.profile.ext.MaritalStatus;
import info.yalamanchili.office.entity.profile.ext.Relationship;
import info.yalamanchili.office.entity.profile.ext.VeteranStatus;
import info.yalamanchili.office.entity.profile.onboarding.EmployeeOnBoarding;
import info.yalamanchili.office.template.TemplateService;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import javax.ws.rs.core.Response;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author prasanthi.p
 */
@Component
@Scope("request")
public class EmployeeFormsService {

    @Autowired
    protected Mapper mapper;

    public JoiningFormsDto getJoiningForm(Employee emp) {
        JoiningFormsDto dto = new JoiningFormsDto();
        dto.setEmployee(emp);
        // To avoid index 0, size 0 exception while invoking this method
        if (emp.getAddresss().size() > 0) {
            List<Address> listOfAddress = emp.getAddresss();
            Address address = listOfAddress.get(0);
            dto.setAddress(address);
        }
        List<Dependent> dependent = DependentDao.instance().findAll(emp.getId(), emp.getClass().getCanonicalName());
        dto.setDependent(dependent);
        EmployeeAdditionalDetails empAddnlDetails = EmployeeAdditionalDetailsDao.instance().find(emp);
        dto.setEmpAddnlDetails(empAddnlDetails);
        return dto;
    }

    public Response printJoiningForm(Employee emp) {
        JoiningFormsDto dto = getJoiningForm(emp);
        EmployeeAdditionalDetails ead = dto.getEmpAddnlDetails();
        PdfDocumentData data = new PdfDocumentData();

        data.setTemplateUrl("/templates/pdf/Joining-form-fillable-template.pdf");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date dateOfBirth = emp.getDateOfBirth();

        //print joining form @radhika
        String empMiddleInitial = emp.getMiddleInitial();

        data.getData().put("fmName", emp.getFirstName());
        if (empMiddleInitial != null) {
            data.getData().put("middleName", empMiddleInitial);
        }

        data.getData().put("lastName", emp.getLastName());
        data.getData().put("dateOfBirth", sdf.format(dateOfBirth));

        if (emp.getSex().equals(Sex.MALE)) {
            data.getData().put("genderMale", "true");
        } else {
            data.getData().put("genderFemale", "true");
        }
        if (ead != null) {
            data.getData().put("maritalStatus", ead.getMaritalStatus().name());
            if (ead.getEthnicity() != null) {
                Ethnicity ethnicity = ead.getEthnicity();
                switch (ethnicity) {
                    case Asian:
                        data.getData().put("asian", "true");
                        break;
                    case Latino_Hispanic:
                        data.getData().put("hispanicLatino", "true");
                        break;
                    case AmericanIndian_AlaskaNative:
                        data.getData().put("americanIndian", "true");
                        break;
                    case Black_AfricanAmerican:
                        data.getData().put("black", "true");
                        break;
                    case NativeHawaiian_OtherPacificIslander:
                        data.getData().put("hawalian", "true");
                        break;
                    case White:
                        data.getData().put("white", "true");
                        break;
                    case Unspecified:
                        data.getData().put("other", "true");
                        break;
                }
            }
            if (ead.getReferredBy() != null) {
                data.getData().put("referredBy", ead.getReferredBy());
            }
        }

        emp.getEmails().stream().filter((email) -> (email.getEmailType() != null)).filter((email) -> ("Personal".equals(email.getEmailType().getEmailType()))).forEach((email) -> {
            data.getData().put("email", email.getEmail() + "  ");
        });

        emp.getPhones().stream().filter((phone) -> (phone.getPhoneType() != null)).forEach(new Consumer<Phone>() {

            public void accept(Phone phone) {
                if (null != phone.getPhoneType().getPhoneType()) {
                    switch (phone.getPhoneType().getPhoneType()) {
                        case "Cell":
                            data.getData().put("cellPhone", phone.getPhoneNumber());
                            break;
                        case "Home":
                            data.getData().put("homePhone", phone.getPhoneNumber());
                            break;
                    }
                }
            }
        });
        emp.getAddresss().stream().map((address) -> {
            String street2 = address.getStreet2();
            if (street2 == null || "".equals(street2)) {
                data.getData().put("residentialAddress1", address.getStreet1());
            } else {
                data.getData().put("residentialAddress1", address.getStreet1() + " , " + street2);
            }
            return address;
        }).forEach((address) -> {
            String zip = address.getZip();
            if (zip == null) {
                data.getData().put("residentialAddress2", address.getCity() + " , " + address.getState());
            } else {
                data.getData().put("residentialAddress2", address.getCity() + " , " + address.getState() + " , " + zip);
            }
        });
        //section 2: Dependents
        int counter = 0;
        List<Dependent> dependents = dto.getDependent();
        List<Dependent> childDep = new ArrayList();
        for (Dependent dep : dependents) {
            if (dep.getRelationship().equals(Relationship.Spouse)) {
                Date depDateOfBirth = dep.getDdateOfBirth();
                data.getData().put("spouseName", dep.getDfirstName());
                String depLastName = dep.getDlastName();
                if (depLastName != null || !"".equals(depLastName)) {
                    data.getData().put("spouseName", dep.getDfirstName() + " , " + depLastName);
                }
                data.getData().put("spouseDOB", sdf.format(depDateOfBirth));
            }
            if (dep.getRelationship().equals(Relationship.Child)) {
                childDep.add(dep);
                counter++;
            }
        }
        if (childDep.size() > 0) {
            for (int i = 0; i < childDep.size(); i++) {
                Dependent dep = childDep.get(i);
                if (dep.getRelationship().equals(Relationship.Child)) {
                    Date depDateOfBirth = dep.getDdateOfBirth();
                    data.getData().put("childName" + i, dep.getDfirstName());
                    String depLastName = dep.getDlastName();
                    if (depLastName != null || !"".equals(depLastName)) {
                        data.getData().put("childName" + i, dep.getDfirstName() + " , " + depLastName);
                    }
                    data.getData().put("CDOB" + i, sdf.format(depDateOfBirth));
                }
            }
        }

        data.getData().put("numberOfChildren", String.valueOf(counter));

        //section 3 : Project Details
        emp.getClientInformations().stream().map((clientInfo) -> {
            data.getData().put("clientName", clientInfo.getClient().getName());
            return clientInfo;
        }).map((clientInfo) -> {
            //client address location
            data.getData().put("wlStreet1", clientInfo.getClient().getLocations().get(0).getStreet1());
            return clientInfo;
        }).map((clientInfo) -> {
            if (clientInfo.getClient().getLocations().get(0).getStreet2() != null) {
                String street2 = clientInfo.getClient().getLocations().get(0).getStreet2();
                if (street2 != null || !"".equals(street2)) {
                    data.getData().put("wlStreet1", clientInfo.getClient().getLocations().get(0).getStreet1() + " , " + street2);
                }
            }
            return clientInfo;
        }).map((clientInfo) -> {
            data.getData().put("wlStreet2", clientInfo.getClient().getLocations().get(0).getCity() + " , " + clientInfo.getClient().getLocations().get(0).getState());
            return clientInfo;
        }).forEach((clientInfo) -> {
            String zip = clientInfo.getClient().getLocations().get(0).getZip();
            if (zip != null) {
                data.getData().put("wlStreet2", clientInfo.getClient().getLocations().get(0).getCity() + " , " + clientInfo.getClient().getLocations().get(0).getState() + " , " + zip);
            }
        });

        emp.getPhones().stream().filter((phone) -> (phone.getPhoneType() != null)).filter((phone) -> ("Cell".equals(phone.getPhoneType().getPhoneType()))).forEach((phone) -> {
            data.getData().put("workPhone", phone.getPhoneNumber() + " ");
        });

        emp.getEmails().stream().filter((email) -> (email.getEmailType() != null)).filter((email) -> ("Work".equals(email.getEmailType().getEmailType()))).forEach((email) -> {
            data.getData().put("workEmail", email.getEmail());
        });

        //section 5 :Emergency Contact Information - Other
        emp.getEmergencyContacts().stream().filter((emergencyContact) -> ((emergencyContact.getContact() != null)
                && (emergencyContact.getRelation() != null))).map((emergencyContact) -> {
                    data.getData().put("ecName2", emergencyContact.getContact().getFirstName());
                    return emergencyContact;
                }).map((emergencyContact) -> {
                    data.getData().put("ecRelation2", emergencyContact.getRelation());
                    return emergencyContact;
                }).map((emergencyContact) -> {
                    emergencyContact.getContact().getPhones().stream().forEach((phone) -> {
                        data.getData().put("ecPhone2", phone.getPhoneNumber());
                    });
                    return emergencyContact;
                }).forEach((EmergencyContact emergencyContact) -> {
                    emergencyContact.getContact().getAddresss().stream().forEach((address1) -> {
                        data.getData().put("ecAddress2", address1.getStreet1() + "," + address1.getCity() + "," + address1.getState() + "," + address1.getCountry());
                    });
                });
        data.getData().put("employeeId", emp.getEmployeeId());
        if (emp.getJobTitle() != null) {
            data.getData().put("designation", emp.getJobTitle());
        }
        if (emp.getWorkStatus() != null) {
            data.getData().put("status", emp.getWorkStatus().name());
        }
        data.getData().put("DOJ", sdf.format(emp.getStartDate()));
        if (CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Reports_To") != null) {
            Employee reportsToEmp = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Reports_To");
            data.getData().put("reportingTo", reportsToEmp.getFirstName() + " , " + reportsToEmp.getLastName());
        }
        if (CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Perf_Eval_Manager") != null) {
            Employee manager = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Perf_Eval_Manager");
            if (manager.getId() != null) {
                data.getData().put("perfEvol", manager.getFirstName() + " , " + manager.getLastName());
            }
        }
        if (emp.getCompany() != null) {
            data.getData().put("companyCB", "true");
            data.getData().put("companyName", emp.getCompany().getName());
            if (emp.getCompany().getAbbreviation() != null) {
                data.getData().put("companyCode", emp.getCompany().getAbbreviation());
            }
        }

        if (emp.getBranch() != null) {
            data.getData().put("departmentName", emp.getBranch().name());
        }

        String empCompanyLogo = "";
        if (emp.getCompany() != null) {
            empCompanyLogo = emp.getCompany().getLogoURL().replace("entityId", emp.getCompany().getId().toString());
        } else {
            Company company = CompanyDao.instance().findByCompanyName(Company.SSTECH_LLC);
            empCompanyLogo = company.getLogoURL().replace("entityId", company.getId().toString());
        }
        byte[] pdf = PDFUtils.generatePdf(data, empCompanyLogo);

        return Response.ok(pdf)
                .header("content-disposition", "filename = Joining-form-fillable.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    public Response printACHForm(Employee emp) {
        List<BankAccount> bankAccountList = BankAccountDao.instance().findAll(emp);
        OfficeSecurityConfiguration securityConfiguration = OfficeSecurityConfiguration.instance();

        PdfDocumentData data = new PdfDocumentData();
        data.setTemplateUrl("/templates/pdf/ach-direct-deposit-form-template.pdf");
        data.setKeyStoreName(securityConfiguration.getKeyStoreName());

        data.getData().put("employeeName", emp.getLastName() + " , " + emp.getFirstName());
        emp.getAddresss().stream().forEach((address) -> {
            String street2 = address.getStreet2();
            String zip = address.getZip();

            if (street2 == null || "".equals(street2)) {
                data.getData().put("address1", address.getStreet1());
            } else {
                data.getData().put("address1", address.getStreet1() + " , " + street2);
            }

            if (zip == null || "".equals(zip)) {
                data.getData().put("address2", address.getCity() + " , " + address.getState() + " , " + address.getCountry());
            } else {
                data.getData().put("address2", address.getCity() + " , " + address.getState() + " , " + address.getCountry() + " ," + zip);
            }
        });

        if (emp.getPhones() != null && emp.getPhones().size() > 0) {
            for (int i = 0; i < emp.getPhones().size(); i++) {
                data.getData().put("phoneNumber" + i, emp.getPhones().get(i).getPhoneNumber());
            }
        }

        if (bankAccountList != null && bankAccountList.size() > 0) {
            for (int i = 0; i < bankAccountList.size(); i++) {
                BankAccount ba = bankAccountList.get(i);
                data.getData().put("accountNumber" + i, ba.getBankAccountNumber());
                data.getData().put("routingNumber" + i, ba.getBankRoutingNumber());
                data.getData().put("bankName" + i, ba.getBankName());
                data.getData().put("bankAccountAddress1" + i, ba.getBankAddress1());
                if (!"".equals(ba.getBankAddress2()) || ba.getBankAddress2() != null) {
                    data.getData().put("bankAccountAddress2" + i, ba.getBankAddress2());
                }
                if (!ba.getAccountType().equals(AccountType.CHECKING)) {
                    data.getData().put("savingsAccountType" + i, "true");
                } else {
                    data.getData().put("checkingAccountType" + i, "true");
                }
                if (ba.getAchBlocked() == false) {
                    data.getData().put("achReversalBlockNo" + i, "true");
                } else if (ba.getAchBlocked() == true) {
                    data.getData().put("achReversalBlockYes" + i, "true");
                }
            }
        }
        EmployeeOnBoarding onboarding = EmployeeOnBoardingDao.instance().findByEmployeeId(emp.getId());
        Date onboardingDate = null;
        if (onboarding != null) {
            onboardingDate = onboarding.getStartedDate();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            data.getData().put("Date", sdf.format(onboardingDate));
            Signature signature = new Signature(emp.getEmployeeId(), emp.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "Signature", DateUtils.dateToCalendar(onboardingDate), onboarding.getEmail(), null);
            data.getSignatures().add(signature);
        } else {
            onboardingDate = emp.getStartDate();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            data.getData().put("Date", sdf.format(onboardingDate));
            Signature signature = new Signature(emp.getEmployeeId(), emp.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "Signature", DateUtils.dateToCalendar(onboardingDate), emp.getPrimaryEmail().getEmail(), null);
            data.getSignatures().add(signature);
        }
        data.getData().put("Name", emp.getFirstName() + " " + emp.getLastName());

        String empCompanyLogo = "";
        if (emp.getCompany() != null) {
            empCompanyLogo = emp.getCompany().getLogoURL().replace("entityId", emp.getCompany().getId().toString());
        } else {
            Company company = CompanyDao.instance().findByCompanyName(Company.SSTECH_LLC);
            empCompanyLogo = company.getLogoURL().replace("entityId", company.getId().toString());
        }
        byte[] pdf = PDFUtils.generatePdf(data, empCompanyLogo);

        return Response.ok(pdf)
                .header("content-disposition", "filename = ach-direct-deposit-form.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    public static EmployeeFormsService instance() {
        return SpringContext.getBean(EmployeeService.class);
    }

    public EmployeeAdditionalDetailsDto updateRolesAndResponsibilities(String id, EmployeeAdditionalDetails details) {
        Long id1 = Long.valueOf(id);
        Employee emp = EmployeeDao.instance().findById(id1);
        EmployeeAdditionalDetails empAdditionalDetails = EmployeeAdditionalDetailsDao.instance().find(emp);
        EmployeeAdditionalDetails additionalDetails = new EmployeeAdditionalDetails();
        if (empAdditionalDetails != null) {
            empAdditionalDetails.setRolesAndResponsibilities(details.getRolesAndResponsibilities());
            EmployeeAdditionalDetailsDao.instance().getEntityManager().merge(empAdditionalDetails);
        } else {
            additionalDetails.setReferredBy("Unknown");
            additionalDetails.setEthnicity(Ethnicity.Unspecified);
            additionalDetails.setMaritalStatus(MaritalStatus.Unknown);
            additionalDetails.setTargetEntityId(emp.getId());
            additionalDetails.setTargetEntityName(EmployeeAdditionalDetails.class.getCanonicalName());
            additionalDetails.setRolesAndResponsibilities(details.getRolesAndResponsibilities());
            EmployeeAdditionalDetailsDao.instance().save(additionalDetails, emp);
        }
        EmployeeAdditionalDetailsDto dto = EmployeeAdditionalDetailsDto.map(mapper, additionalDetails);
        dto.setEmployee(emp);
        return dto;
    }

    public Response printRolesAndRespForm(Employee emp) {
        PdfDocumentData data = new PdfDocumentData();
        data.getData().put("employee", emp.getLastName() + " , " + emp.getFirstName());
        if (emp.getBranch() != null) {
            data.getData().put("branch", emp.getBranch().name());
        } else {
            data.getData().put("branch", "");
        }
        if (emp.getJobTitle() != null) {
            data.getData().put("jobtitle", emp.getJobTitle());
        } else {
            data.getData().put("jobtitle", "");
        }
        if (emp.getStartDate() != null) {
            data.getData().put("startDate", new SimpleDateFormat("MM/dd/yyyy").format(emp.getStartDate()));
        } else {
            data.getData().put("startDate", "");
        }
        if (CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Reports_To") != null) {
            Employee reportsToEmp = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Reports_To");
            data.getData().put("reporsToMgr", reportsToEmp.getFirstName() + " , " + reportsToEmp.getLastName());
        } else {
            data.getData().put("reporsToMgr", "");
        }
        if (CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Perf_Eval_Manager") != null) {
            Employee manager = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Perf_Eval_Manager");
            if (manager.getId() != null) {
                data.getData().put("perfEvolMgr", manager.getFirstName() + " , " + manager.getLastName());
            }
        } else {
            data.getData().put("perfEvolMgr", "");
        }
        EmployeeAdditionalDetails empAddnlDetails = EmployeeAdditionalDetailsDao.instance().find(emp);
        if (empAddnlDetails != null && empAddnlDetails.getRolesAndResponsibilities() != null) {
            data.getData().put("roles", empAddnlDetails.getRolesAndResponsibilities());
        } else {
            data.getData().put("roles", "");
        }
        String empCompanyLogo = "";
        if (emp.getCompany() != null) {
            empCompanyLogo = emp.getCompany().getLogoURL().replace("entityId", emp.getCompany().getId().toString());

        } else {
            Company company = CompanyDao.instance().findByCompanyName(Company.SSTECH_LLC);
            empCompanyLogo = company.getLogoURL().replace("entityId", company.getId().toString());

        }
        String html = TemplateService.instance().process("emp-roles-responsibilities.xhtml", "entity", data.getData());

        byte[] pdf = PDFUtils.convertToPDF(html);
        ByteArrayOutputStream pdfOut = new ByteArrayOutputStream();
        try {
            PdfReader pdfReader = new PdfReader(pdf);
            PdfStamper pdfStamper = new PdfStamper(pdfReader,
                    pdfOut);

            Image image = Image.getInstance("C:\\content-management\\office\\" + empCompanyLogo);
            Rectangle pagesize;
            for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
                PdfContentByte content = pdfStamper.getOverContent(i);
                pagesize = pdfReader.getPageSize(i);
                float x = pagesize.getLeft() + 20;
                float y = pagesize.getTop() - 30;
                image.setAbsolutePosition(x, y);
                image.scaleAbsoluteHeight(25);
                image.scaleAbsoluteWidth(image.getWidth() / 3);
                content.addImage(image);
                content.addImage(image);
            }
            pdfStamper.close();
            pdfReader.close();
        } catch (IOException | DocumentException e) {
            throw new RuntimeException(e);
        }
        byte[] newPDF = pdfOut.toByteArray();
        return Response
                .ok(newPDF)
                .header("content-disposition", "filename = emp-roles-responsibilities.pdf")
                .header("Content-Length", newPDF.length)
                .build();

    }

    public Response printSelfIdentificationForm(Employee emp) {
        JoiningFormsDto dto = getJoiningForm(emp);
        EmployeeAdditionalDetails ead = dto.getEmpAddnlDetails();
        if (ead.getVeteranStatus() == null || ead.getDisability() == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "self.identification.not.submitted", "Self Identification form not submittted");
        }

        OfficeSecurityConfiguration securityConfiguration = OfficeSecurityConfiguration.instance();
        PdfDocumentData data = new PdfDocumentData();
        data.setTemplateUrl("/templates/pdf/sst-voluntary-selfIdentification-template.pdf");
        data.setKeyStoreName(securityConfiguration.getKeyStoreName());
        String empMiddleInitial = emp.getMiddleInitial();
        data.getData().put("firstName", emp.getFirstName());
        if (empMiddleInitial != null) {
            data.getData().put("middleName", empMiddleInitial);
        }
        data.getData().put("lastName", emp.getLastName());
        if (emp.getSsn() != null) {
            data.getData().put("ssn", emp.getSsn());
        }
        if (emp.getSex().equals(Sex.MALE)) {
            data.getData().put("genderMale", "true");
        } else {
            data.getData().put("genderFemale", "true");
        }
        if (ead != null) {
            if (ead.getEthnicity() != null) {
                Ethnicity ethnicity = ead.getEthnicity();
                switch (ethnicity) {
                    case Asian:
                        data.getData().put("asian", "true");
                        break;
                    case Latino_Hispanic:
                        data.getData().put("hispanicLatino", "true");
                        break;
                    case AmericanIndian_AlaskaNative:
                        data.getData().put("americanIndian", "true");
                        break;
                    case Black_AfricanAmerican:
                        data.getData().put("black", "true");
                        break;
                    case NativeHawaiian_OtherPacificIslander:
                        data.getData().put("hawalian", "true");
                        break;
                    case White:
                        data.getData().put("white", "true");
                        break;
                    case Unspecified:
                        data.getData().put("other", "true");
                        break;
                }
            }
            if (ead.getVeteranStatus() != null) {
                VeteranStatus veteranStatus = ead.getVeteranStatus();
                switch (veteranStatus) {
                    case One_or_more_of_the_classifications:
                        data.getData().put("oneormore", "true");
                        break;
                    case Veteran_but_not_a_protected_veteran:
                        data.getData().put("asaveteran", "true");
                        break;
                    case Not_a_veteran:
                        data.getData().put("notveteran", "true");
                        break;
                    case Do_not_wish:
                        data.getData().put("selfIdentify", "true");
                        break;
                }
            } 
            if (ead.getDisability() != null) {
                Disability disability = ead.getDisability();
                switch (disability) {
                    case Have_A_Disability:
                        data.getData().put("yes", "true");
                        break;
                    case Dont_Have_Disability:
                        data.getData().put("no", "true");
                        break;
                    case Do_not_wish:
                        data.getData().put("dontwishselfidentify", "true");
                        break;
                }
            } 
        }
        EmployeeOnBoarding onboarding = EmployeeOnBoardingDao.instance().findByEmployeeId(emp.getId());
        Date onboardingDate = null;
        if (onboarding != null) {
            onboardingDate = onboarding.getStartedDate();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            data.getData().put("Date", sdf.format(onboardingDate));
            Signature signature = new Signature(emp.getEmployeeId(), emp.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "Signature", DateUtils.dateToCalendar(onboardingDate), onboarding.getEmail(), null);
            data.getSignatures().add(signature);
        } else {
            onboardingDate = emp.getStartDate();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            data.getData().put("Date", sdf.format(onboardingDate));
            Signature signature = new Signature(emp.getEmployeeId(), emp.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "Signature", DateUtils.dateToCalendar(onboardingDate), emp.getPrimaryEmail().getEmail(), null);
            data.getSignatures().add(signature);
        }

        String empCompanyLogo = "";
        if (emp.getCompany() != null) {
            empCompanyLogo = emp.getCompany().getLogoURL().replace("entityId", emp.getCompany().getId().toString());
        } else {
            Company company = CompanyDao.instance().findByCompanyName(Company.SSTECH_LLC);
            empCompanyLogo = company.getLogoURL().replace("entityId", company.getId().toString());
        }
        byte[] pdf = PDFUtils.generatePdf(data, empCompanyLogo);

        return Response.ok(pdf)
                .header("content-disposition", "filename = Joining-form-fillable.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

}
