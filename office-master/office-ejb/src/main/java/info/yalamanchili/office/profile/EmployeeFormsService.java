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
import info.yalamanchili.office.dao.expense.BankAccountDao;
import info.yalamanchili.office.dao.profile.ext.DependentDao;
import info.yalamanchili.office.dao.profile.ext.EmployeeAdditionalDetailsDao;
import info.yalamanchili.office.dao.profile.onboarding.EmployeeOnBoardingDao;
import info.yalamanchili.office.dto.onboarding.JoiningFormsDto;
import info.yalamanchili.office.entity.expense.AccountType;
import info.yalamanchili.office.entity.expense.BankAccount;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Email;
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
import javax.ws.rs.core.Response;
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
        List<Address> listOfAddress = emp.getAddresss();
        Address address = listOfAddress.get(0);
        dto.setAddress(address);
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

        data.getData().put("maritalStatus", ead.getMaritalStatus().name());

        for (Email email : emp.getEmails()) {
            if (email.getEmailType() != null) {
                if ("Personal".equals(email.getEmailType())) {
                    data.getData().put("email", email.getEmail() + "  ");
                }
            }
        }

        for (Phone phone : emp.getPhones()) {
            if (phone.getPhoneType() != null) {
                if ("Cell".equals(phone.getPhoneType())) {
                    data.getData().put("cellPhone", phone.getPhoneNumber());
                } else if ("Home".equals(phone.getPhoneType())) {
                    data.getData().put("homePhone", phone.getPhoneNumber());
                }
            }
        }
        for (Address address : emp.getAddresss()) {
            String street2 = address.getStreet2();
            if (street2 == null || "".equals(street2)) {
                data.getData().put("residentialAddress1", address.getStreet1());
            } else {
                data.getData().put("residentialAddress1", address.getStreet1() + " , " + street2);
            }
            String zip = address.getZip();
            if (zip == null) {
                data.getData().put("residentialAddress2", address.getCity() + " , " + address.getState());
            } else {
                data.getData().put("residentialAddress2", address.getCity() + " , " + address.getState() + " , " + zip);
            }
        }

        if (ead.getEthnicity().equals(Ethnicity.Asian)) {
            data.getData().put("asian", "true");
        } else if (ead.getEthnicity().equals(Ethnicity.Latino_Hispanic)) {
            data.getData().put("hispanicLatino", "true");
        } else if (ead.getEthnicity().equals(Ethnicity.AmericanIndian_AlaskaNative)) {
            data.getData().put("americanIndian", "true");
        } else if (ead.getEthnicity().equals(Ethnicity.Black_AfricanAmerican)) {
            data.getData().put("black", "true");
        } else if (ead.getEthnicity().equals(Ethnicity.NativeHawaiian_OtherPacificIslander)) {
            data.getData().put("hawalian", "true");
        } else if (ead.getEthnicity().equals(Ethnicity.White)) {
            data.getData().put("white", "true");
        }

        data.getData().put("referredBy", ead.getReferredBy());

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
        for (ClientInformation clientInfo : emp.getClientInformations()) {
            data.getData().put("clientName", clientInfo.getClient().getName());
        }

        for (Phone phone : emp.getPhones()) {
            if (phone.getPhoneType() != null) {
                if ("Cell".equals(phone.getPhoneType().toString())) {
                    data.getData().put("workPhone", phone.getPhoneNumber() + " ");
                }
            }
        }

        for (Email email : emp.getEmails()) {
            if (email.getEmailType() != null) {
                if ("Work".equals(email.getEmailType().toString())) {
                    data.getData().put("workEmail", email.getEmail());
                }
            }
        }

        //company address [work location]
        for (Address address : emp.getAddresss()) {
            if (address.getAddressType() != null) {
                if ("Office".equals(address.getAddressType().toString())) {
                    data.getData().put("wlStreet1", address.getStreet1());
                    String street2 = address.getStreet2();
                    if (street2 != null || !"".equals(street2)) {
                        data.getData().put("wlStreet1", " , " + street2);
                    }
                    data.getData().put("wlStreet2", address.getCity() + " , " + address.getState());
                    String zip = address.getZip();
                    if (zip != null) {
                        data.getData().put("wlStreet2", " , " + zip);
                    }
                }
            }
        }

        //section 5 :Emergency Contact Information - Other
        for (EmergencyContact emergencyContact : emp.getEmergencyContacts()) {
            if ((emergencyContact.getContact() != null)
                    && (emergencyContact.getRelation() != null)) {
                data.getData().put("ecName2", emergencyContact.getContact().getFirstName());
                data.getData().put("ecRelation2", emergencyContact.getRelation());
                for (Phone phone : emergencyContact.getContact().getPhones()) {
                    data.getData().put("ecPhone2", phone.getPhoneNumber());
                }
                for (Address address1 : emergencyContact.getContact().getAddresss()) {
                    data.getData().put("ecAddress2", address1.getStreet1() + "," + address1.getCity() + "," + address1.getState() + "," + address1.getCountry());
                }
            }
        }

        byte[] pdf = PDFUtils.generatePdf(data);
        return Response.ok(pdf)
                .header("content-disposition", "filename = Joining-form-fillable.pdf")
                .header("Content-Length", pdf)
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
        for (Address address : emp.getAddresss()) {
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
        }
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
        } else if (ba.getAchBlocked()== true) {
            data.getData().put("achReversalBlockYes", "true");
        }
        EmployeeOnBoarding onboarding = EmployeeOnBoardingDao.instance().findByEmployeeId(emp.getId());
        Date onboardingDate = onboarding.getStartedDate();

        data.getData().put("Name", emp.getFirstName() + " " + emp.getLastName());
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        data.getData().put("Date", sdf.format(onboardingDate));

        Signature signature = new Signature(emp.getEmployeeId(), emp.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "Signature", DateUtils.dateToCalendar(onboardingDate), onboarding.getEmail(), null);
        data.getSignatures().add(signature);

        //TODO fill ach with emp and bank account details
        byte[] pdf = PDFUtils.generatePdf(data);

        return Response.ok(pdf)
                .header("content-disposition", "filename = ach-direct-deposit-form.pdf")
                .header("Content-Length", pdf)
                .build();
    }

    public static EmployeeFormsService instance() {
        return SpringContext.getBean(EmployeeService.class);
    }
}
