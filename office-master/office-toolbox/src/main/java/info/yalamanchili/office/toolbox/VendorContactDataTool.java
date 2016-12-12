/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox;

import static info.chili.docs.ExcelUtils.getCellNumericValue;
import static info.chili.docs.ExcelUtils.getCellStringOrNumericValue;
import static info.chili.docs.ExcelUtils.getCellStringValue;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.client.VendorDao;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.toolbox.types.ContactRecord;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Component("vendorContactDataTool")
@Transactional
public class VendorContactDataTool {

    private static final Log log = LogFactory.getLog(VendorContactDataTool.class);

    public static void main(String... args) {
        VendorContactDataTool tool = new VendorContactDataTool();
        tool.migrateVendorContactData();
    }

    public void migrateVendorContactData() {
        int i = 0;
        InputStream inp;
        XSSFWorkbook workbook;
        try {
            inp = new FileInputStream(getDataFileUrl());
            workbook = new XSSFWorkbook(inp);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row record = rowIterator.next();
            Vendor vendor = new Vendor();
            Contact contact = new Contact();
            Phone phone = new Phone();
            Email email = new Email();
            if (record.getRowNum() == 0) {
                continue;
            }
            ContactRecord cr = new ContactRecord();
            cr.setId(new Long(convertDcimalToWhole(getCellNumericValue(record, 11))));
            vendor = VendorDao.instance().findById(cr.getId());

            cr.setRole(getCellStringValue(record, 8));
            cr.setSimilarity(new Double(getCellNumericValue(record, 12)));
            if (cr.getSimilarity() == 2.0000) {
                if (cr.getRole() != null && !cr.getRole().isEmpty()) {
                    if (cr.getRole().equals("Recruiter")) {
                        continue;
                    }
                }
            }

            cr.setFirstName(getCellStringValue(record, 3));
            cr.setLastName(getCellStringValue(record, 4));
            if (cr.getFirstName() != null && !cr.getFirstName().isEmpty()) {
                cr.setFirstName(cr.getFirstName().replaceAll("[^a-zA-Z0-9\\s\\/\\.\\']", ""));
                contact.setFirstName(cr.getFirstName());
            } else {
                continue;
            }
            if (cr.getLastName() != null && !cr.getLastName().isEmpty()) {
                cr.setLastName(cr.getLastName().replaceAll("[^a-zA-Z0-9\\s\\/\\.\\']", ""));
                contact.setLastName(cr.getLastName());
            } else {
                contact.setLastName(cr.getFirstName());
            }
            
            System.out.println("Vendor Name >>>>>>>>>>>>>>>><<<<<<<<<<<<<<: " + cr.getFirstName() + " " + cr.getLastName());
            
            cr.setEmail(getCellStringValue(record, 5));
            if (cr.getEmail() != null && !cr.getEmail().isEmpty()) {
                email.setEmail(cr.getEmail().replaceAll("\\s+",""));
                email.setPrimaryEmail(true);
                contact.addEmail(email);
            }

            
            cr.setPhoneNumber(convertDcimalToWhole(getCellStringOrNumericValue(record, 6)));
            cr.setExtension(convertDcimalToWhole(getCellStringOrNumericValue(record, 7)));
            if (cr.getPhoneNumber() != null && !cr.getPhoneNumber().isEmpty()) {
                phone.setPhoneNumber(cr.getPhoneNumber());
                if (cr.getExtension() != null && !cr.getExtension().isEmpty()) {
                    phone.setExtension(cr.getExtension());
                }
                contact.addPhone(phone);
            }

            if (cr.getRole() != null && !cr.getRole().isEmpty()) {
                if (cr.getRole().equals("Recruiter")) {
                    vendor.addContact(contact);
                } else if (cr.getRole().equals("APContactperson")) {
                    vendor.addAcctPayContact(contact);
                }
            }
            i += 1;
           // VendorDao.instance().getEntityManager().merge(vendor);
        }
         System.out.println("Total Vendor Contact Records Written :::<<<>>>>::: " + i);
    }

    protected boolean emailExists(String emailAddress, Contact con) {
        for (Email email : con.getEmails()) {
            if (email.getEmail() != null && email.getEmail().trim().equals(emailAddress.trim())) {
                return true;
            }
        }
        return false;
    }

    protected boolean phoneExists(String phoneNumber, Contact con) {
        for (Phone phone : con.getPhones()) {
            if (phone.getPhoneNumber() != null && phone.getPhoneNumber().trim().equals(phoneNumber.trim())) {
                return true;
            }
        }
        return false;
    }

    protected String getDataFileUrl() {
        return OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "BIS_VendorContactData.xlsx";
    }

    protected String convertDcimalToWhole(String id) {
        if (StringUtils.isNotEmpty(id) && id.contains(".")) {
            return id.substring(0, id.indexOf("."));
        } else {
            return id;
        }
    }

    protected Enum convertEnum(Class enumClass, String value) {
        try {
            if (StringUtils.isNotBlank(value)) {
                return Enum.valueOf(enumClass, value.toUpperCase().replace("-", "_"));
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static VendorContactDataTool instance() {
        return SpringContext.getBean(VendorContactDataTool.class);
    }
}
