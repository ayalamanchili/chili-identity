/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.chili.commons.DateUtils;
import info.chili.commons.pdf.PDFUtils;
import info.chili.commons.pdf.PdfDocumentData;
import info.chili.security.Signature;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.expense.BankAccountDao;
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
import info.yalamanchili.office.entity.profile.ext.Relationship;
import info.yalamanchili.office.entity.profile.onboarding.EmployeeOnBoarding;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import javax.ws.rs.core.Response;
import org.dozer.Mapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author prasanthi.p
 */
@Component
@Scope("request")
public class EmployeeFormsService {

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
        if (empMiddleInitial == null) {
            data.getData().put("fmName", emp.getFirstName());
        } else {
            data.getData().put("fmName", emp.getFirstName() + " " + empMiddleInitial);
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
        for (Dependent dep : dto.getDependent()) {
            if (dep.getRelationship().equals(Relationship.Spouse)) {
                Date depDateOfBirth = dep.getDdateOfBirth();
                data.getData().put("spouseName", dep.getDfirstName());
                String depLastName = dep.getDlastName();
                if (depLastName != null || !"".equals(depLastName)) {
                    data.getData().put("spouseName", dep.getDfirstName() + " , " + depLastName);
                }
                data.getData().put("spouseDOB", sdf.format(depDateOfBirth));
            } else if (dep.getRelationship().equals(Relationship.Child1)) {
                counter++;
                Date depDateOfBirth = dep.getDdateOfBirth();
                data.getData().put("childName1", dep.getDfirstName());
                String depLastName = dep.getDlastName();
                if (depLastName != null || !"".equals(depLastName)) {
                    data.getData().put("childName1", dep.getDfirstName() + " , " + depLastName);
                }
                data.getData().put("childDOB1", sdf.format(depDateOfBirth));
            } else if (dep.getRelationship().equals(Relationship.Child2)) {
                counter++;
                Date depDateOfBirth = dep.getDdateOfBirth();
                data.getData().put("childName2", dep.getDfirstName());
                String depLastName = dep.getDlastName();
                if (depLastName != null || !"".equals(depLastName)) {
                    data.getData().put("childName2", dep.getDfirstName() + " , " + depLastName);
                }
                data.getData().put("childDOB2", sdf.format(depDateOfBirth));
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
            Company company = emp.getCompany();
            String nameOfCompany = company.getName();
            if (nameOfCompany.contains("LLC")) {
                data.getData().put("companyLLC", "true");
            } else if (nameOfCompany.contains("INC")) {
                data.getData().put("companyINC", "true");
            } else if (nameOfCompany.contains("Tech Pillars")) {
                data.getData().put("companyTP", "true");
            } else if (nameOfCompany.contains("CGS")) {
                data.getData().put("companyCGS", "true");
            }
            if (emp.getCompany().getAbbreviation() != null) {
                data.getData().put("companyCode", emp.getCompany().getAbbreviation());
            }
        }

        byte[] pdf = PDFUtils.generatePdf(data);
        return Response.ok(pdf)
                .header("content-disposition", "filename = Joining-form-fillable.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    public Response printACHForm(Employee emp) {
        BankAccount ba = BankAccountDao.instance().find(emp);
        OfficeSecurityConfiguration securityConfiguration = OfficeSecurityConfiguration.instance();

        PdfDocumentData data = new PdfDocumentData();
        data.setTemplateUrl("/templates/pdf/ach-direct-deposit-form-template.pdf");
        data.setKeyStoreName(securityConfiguration.getKeyStoreName());

        //print ACH Form with the employee and bank details. @radhika
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
        data.getData().put("accountNumber", ba.getBankAccountNumber());
        data.getData().put("routingNumber", ba.getBankRoutingNumber());

        data.getData().put("bankName", ba.getBankName());
        //TODO no need address1 and address2

        data.getData().put("bankAccountAddress1", ba.getBankAddress1());
        if (!"".equals(ba.getBankAddress2()) || ba.getBankAddress2() != null) {
            data.getData().put("bankAccountAddress2", ba.getBankAddress2());
        }

        if (!ba.getAccountType().equals(AccountType.CHECKING)) {
            data.getData().put("savingsAccountType", "true");
        } else {
            data.getData().put("checkingAccountType", "true");
        }

        if (ba.getAchBlocked() == false) {
            data.getData().put("achReversalBlockNo", "true");
        } else if (ba.getAchBlocked() == true) {
            data.getData().put("achReversalBlockYes", "true");
        }
        emp.getPhones().stream().filter((phone) -> (phone.getPhoneNumber() != null)).forEach((_item) -> {
            data.getData().put("phoneNumber", emp.getPhones().get(0).getPhoneNumber());
        });
        EmployeeOnBoarding onboarding = EmployeeOnBoardingDao.instance().findByEmployeeId(emp.getId());
        Date onboardingDate = null;
        if (onboarding != null) {
            onboardingDate = onboarding.getStartedDate();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            data.getData().put("Date", sdf.format(onboardingDate));
            Signature signature = new Signature(emp.getEmployeeId(), emp.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "Signature", DateUtils.dateToCalendar(onboardingDate), onboarding.getEmail(), null);
            data.getSignatures().add(signature);
        }
        data.getData().put("Name", emp.getFirstName() + " " + emp.getLastName());

        //TODO fill ach with emp and bank account details
        byte[] pdf = PDFUtils.generatePdf(data);

        return Response.ok(pdf)
                .header("content-disposition", "filename = ach-direct-deposit-form.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    public static EmployeeFormsService instance() {
        return SpringContext.getBean(EmployeeService.class);
    }

    public void updateRolesAndResponsibilities(String id, EmployeeAdditionalDetails details) {
        Long id1 = Long.valueOf(id);
        Employee emp = EmployeeDao.instance().findById(id1);
        EmployeeAdditionalDetails empAdditionalDetails = EmployeeAdditionalDetailsDao.instance().find(emp);
        empAdditionalDetails.setRolesAndResponsibilities(details.getRolesAndResponsibilities());
        EmployeeAdditionalDetailsDao.instance().save(empAdditionalDetails, emp);
    }
}
