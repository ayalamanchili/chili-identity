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
    public boolean isContactexists;

    public static void main(String... args) {
        VendorContactDataTool tool = new VendorContactDataTool();
        tool.migrateVendorContactData();
    }

    public void migrateVendorContactData() {
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
            isContactexists = false;
            Row record = rowIterator.next();
            Vendor vendor = new Vendor();
            Contact contact = new Contact();
            Phone phone = new Phone();
            Email email = new Email();
            if (record.getRowNum() == 0) {
                continue;
            }
            ContactRecord cr = new ContactRecord();
            vendor = VendorDao.instance().findById(cr.getId());

            cr.setSimilarity(new Double(getCellNumericValue(record, 5)));
            if (cr.getSimilarity() < 1.0000) {
                isContactexists = false;
            } else {
                isContactexists = true;
            }

            cr.setEmail(getCellStringValue(record, 2));
            cr.setPhoneNumber(convertDcimalToWhole(getCellStringOrNumericValue(record, 9)));
            cr.setExtension(convertDcimalToWhole(getCellStringOrNumericValue(record, 9)));

            if (!isContactexists) {
                cr.setFirstName(getCellStringValue(record, 2));
                cr.setLastName(getCellStringValue(record, 2));
                if (cr.getFirstName() != null && !cr.getFirstName().isEmpty()) {
                    cr.setFirstName(cr.getFirstName().replaceAll("[^a-zA-Z0-9\\s\\/]", ""));
                    contact.setFirstName(cr.getFirstName());
                } else {
                    continue;
                }
                if (cr.getLastName() != null && !cr.getLastName().isEmpty()) {
                    cr.setLastName(cr.getLastName().replaceAll("[^a-zA-Z0-9\\s\\/]", ""));
                    contact.setLastName(cr.getLastName());
                } else {
                    contact.setLastName(cr.getFirstName());
                }
            } else if (isContactexists) {
                for (Contact contct : vendor.getContacts()) {
                    if (cr.getEmail() != null && !cr.getEmail().isEmpty() && !emailExists(cr.getEmail(), contct)) {
                        email.setEmail(cr.getEmail());
                        contact.addEmail(email);
                    }
                    if (cr.getPhoneNumber() != null && !cr.getPhoneNumber().isEmpty() && !phoneExists(cr.getPhoneNumber(), contct)) {
                        phone.setPhoneNumber(cr.getPhoneNumber());
                        if (cr.getExtension() != null && !cr.getExtension().isEmpty()) {
                            phone.setExtension(cr.getExtension());
                        }
                        contact.addPhone(phone);
                    }
                }
            }

            if (cr.getEmail() != null && !cr.getEmail().isEmpty() && !isContactexists) {
                email.setEmail(cr.getEmail());
                contact.addEmail(email);
            }

            if (cr.getPhoneNumber() != null && !cr.getPhoneNumber().isEmpty() && !isContactexists) {
                phone.setPhoneNumber(cr.getPhoneNumber());
                if (cr.getExtension() != null && !cr.getExtension().isEmpty()) {
                    phone.setExtension(cr.getExtension());
                }
                contact.addPhone(phone);
            }
            
            cr.setRole(getCellStringValue(record, 2));
            if (cr.getRole() != null && !cr.getRole().isEmpty()) {
                if (cr.getRole() == "Recruiter") {
                    vendor.addContact(contact);
                } else if (cr.getRole() == "APContactperson") {
                    vendor.addAcctPayContact(contact);
                }
            }

            VendorDao.instance().getEntityManager().merge(vendor);
        }
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
