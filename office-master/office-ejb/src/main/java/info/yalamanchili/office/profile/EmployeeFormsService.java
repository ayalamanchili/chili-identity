/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.chili.commons.pdf.PDFUtils;
import info.chili.commons.pdf.PdfDocumentData;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.expense.BankAccountDao;
import info.yalamanchili.office.dao.profile.ext.DependentDao;
import info.yalamanchili.office.dao.profile.ext.EmployeeAdditionalDetailsDao;
import info.yalamanchili.office.entity.expense.AccountType;
import info.yalamanchili.office.entity.expense.BankAccount;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.EmergencyContact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.entity.profile.ext.Dependent;
import info.yalamanchili.office.entity.profile.ext.EmployeeAdditionalDetails;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    /**
     * returns the joining form details of the employee for viewing purpose.
     * @param emp
     * @return 
     */
    
    public Response printJoiningForm(Employee emp) {
//TODO  update this method to call the getJoiningForm method and use it to populate the pdf.
        EmployeeAdditionalDetails ead = EmployeeAdditionalDetailsDao.instance().find(emp);
        Dependent dep = DependentDao.instance().find(emp);
        PdfDocumentData data = new PdfDocumentData();
        
        data.setTemplateUrl("/templates/pdf/Joining-form-fillable-template.pdf");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date dateOfBirth = emp.getDateOfBirth();
        Date depDateOfBirth = dep.getDdateOfBirth();

        //print joining form @radhika
        data.getData().put("fmName", emp.getFirstName());
        String empMiddleInitial = emp.getMiddleInitial();
        if (empMiddleInitial != null) {
            data.getData().put("fmName", " " + empMiddleInitial);
        }
        data.getData().put("lastName", emp.getLastName());
        data.getData().put("dateOfBirth", sdf.format(dateOfBirth));

        //gender doubt
        //education 
        data.getData().put("maritalStatus", ead.getMaritalStatus().name());
        for (Email email : emp.getEmails()) {
            if ("Personal".equals(email.getEmailType().toString())) {
                data.getData().put("email", email.getEmail() + "  ");
            }
        }
        
        for (Phone phone : emp.getPhones()) {
            if ("Cell".equals(phone.getPhoneType().toString())) {
                data.getData().put("cellPhone", phone.getPhoneNumber());
            } else {
                data.getData().put("homePhone", phone.getPhoneNumber());
            }
        }
        for (Address address : emp.getAddresss()) {
            if ("Home".equals(address.getAddressType().toString())) {
                data.getData().put("residentialAddress", address.getStreet1());
                String street2 = address.getStreet2();
                if (street2 != null || !"".equals(street2)) {
                    data.getData().put("residentialAddress", " , " + street2);
                }
                data.getData().put("csz", address.getCity() + " , " + address.getState());
                String zip = address.getZip();
                if (zip != null) {
                    data.getData().put("csz", " , " + zip);
                }
            }
        }
        
        data.getData().put("ethnicity", ead.getEthnicity().name());
        data.getData().put("referredBy", ead.getReferredBy());

        //section 2: Dependents
        data.getData().put("nameOfSpouse", dep.getDfirstName());
        String depLastName = dep.getDlastName();
        if (depLastName != null || !"".equals(depLastName)) {
            data.getData().put("nameOfSpouse", " , " + depLastName);
        }
        data.getData().put("spouseDOB", sdf.format(depDateOfBirth));

        //section 3 : Project Details
        for (ClientInformation clientInfo : emp.getClientInformations()) {
            data.getData().put("clientName", clientInfo.getClient().getName());
        }
        
        for (Phone phone : emp.getPhones()) {
            if ("Cell".equals(phone.getPhoneType().toString())) {
                data.getData().put("workPhone", phone.getPhoneNumber() + " ");
            }
        }
        
        for (Email email : emp.getEmails()) {
            if ("Work".equals(email.getEmailType().toString())) {
                data.getData().put("workEmail", email.getEmail());
            }
        }

        //company address [work location]
        for (Address address : emp.getAddresss()) {
            if ("Office".equals(address.getAddressType().toString())) {
                data.getData().put("officeAddress", address.getStreet1());
                String street2 = address.getStreet2();
                if (street2 != null || !"".equals(street2)) {
                    data.getData().put("officeAddress", " , " + street2);
                }
                data.getData().put("officeCSZ", address.getCity() + " , " + address.getState());
                String zip = address.getZip();
                if (zip != null) {
                    data.getData().put("officeCSZ", " , " + zip);
                }
            }
        }

        //section 5 :Emergency Contact Information - Other
        for (EmergencyContact emergencyContact : emp.getEmergencyContacts()) {
            
            data.getData().put("ecName", emergencyContact.getContact().getFirstName());
            data.getData().put("ecRelation", emergencyContact.getRelation());
            for (Phone phone : emergencyContact.getContact().getPhones()) {
                data.getData().put("ecPhone", phone.getPhoneNumber());
            }
            for (Address address1 : emergencyContact.getContact().getAddresss()) {
                data.getData().put("ecAddress", address1.getStreet1() + "," + address1.getCity() + "," + address1.getState() + "," + address1.getCountry());
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
        PdfDocumentData data = new PdfDocumentData();
        data.setTemplateUrl("/templates/pdf/ach-direct-deposit-form-template.pdf");

        //print ACH Form with the employee and bank details. @radhika
        data.getData().put("employeeName", emp.getLastName() + " , " + emp.getFirstName());
        for (Address address : emp.getAddresss()) {
            String street2 = address.getStreet2();
            String zip = address.getZip();
           
            if (street2 == null || "".equals(street2)) {
                data.getData().put("address1", address.getStreet1());
            }
            else
                 data.getData().put("address1", address.getStreet1()+" , " + street2);
            
            if (zip == null || "".equals(zip)) {
                data.getData().put("address2", address.getCity() + " , " + address.getState() + " , " + address.getCountry());  
            }
            else
                data.getData().put("address2", address.getCity() + " , " + address.getState() + " , " + address.getCountry()+" ," + zip);
        }
        data.getData().put("accountNumber", ba.getBankAccountNumber());
        data.getData().put("routingNumber", ba.getBankRoutingNumber());
        
        
        data.getData().put("bankName", ba.getBankName());
        //TODO no need address1 and address2
        if(ba.getBankAddress1()!=null || !"".equals(ba.getBankAddress1()))
            data.getData().put("bankAccountAddress1", ba.getBankAddress1());
       if(ba.getBankAddress2()!=null || !"".equals(ba.getBankAddress2()))
           data.getData().put("bankAccountAddress2",ba.getBankAddress2());
        /*
        if(ba.getAccountType().equals(AccountType.CHECKING))
            data.getData().put("checkingAccountType", String.valueOf(true));
        else
            data.getData().put("savingsAccountType", String.valueOf(true));
        data.getData().put("isACHBlock", String.valueOf(ba.isAchBlocked()));
       
                */
        
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
