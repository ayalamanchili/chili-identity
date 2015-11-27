/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox;

import static info.chili.docs.ExcelUtils.getCellStringOrNumericValue;
import static info.chili.docs.ExcelUtils.getCellStringValue;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.client.ClientDao;
import info.yalamanchili.office.dao.client.SubcontractorDao;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.Subcontractor;
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

/**
 *
 * @author Madhu.Badiginchala
 */
public class SubContractorContactDataTool {

    private static final Log log = LogFactory.getLog(SubContractorContactDataTool.class);

    public static void main(String... args) {
        SubContractorContactDataTool tool = new SubContractorContactDataTool();
        tool.migrateSubContractorContactData();
    }

    public void migrateSubContractorContactData() {
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
            Subcontractor subContractor = new Subcontractor();
            Contact contact = new Contact();
            Phone phone = new Phone();
            Email email = new Email();
            if (record.getRowNum() == 0) {
                continue;
            }
            ContactRecord cr = new ContactRecord();
            subContractor = SubcontractorDao.instance().findById(cr.getId());
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

            cr.setPhoneNumber(convertDcimalToWhole(getCellStringOrNumericValue(record, 9)));
            cr.setExtension(convertDcimalToWhole(getCellStringOrNumericValue(record, 9)));
            
            if (cr.getPhoneNumber() != null && !cr.getPhoneNumber().isEmpty()) {
                phone.setPhoneNumber(cr.getPhoneNumber());
                if (cr.getExtension() != null && !cr.getExtension().isEmpty()) {
                   phone.setExtension(cr.getExtension()); 
                }
                contact.addPhone(phone);
            }
            
            cr.setEmail(getCellStringValue(record, 2));
            
            if (cr.getEmail() != null && !cr.getEmail().isEmpty()) {
                email.setEmail(cr.getEmail());
                contact.addEmail(email);
            }
            
            cr.setRole(getCellStringValue(record, 2));
            if (cr.getRole() != null && !cr.getRole().isEmpty()) {
                    subContractor.addContact(contact);
            }
            
            SubcontractorDao.instance().getEntityManager().merge(subContractor);
        }
    }

    protected String getDataFileUrl() {
        return OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "BIS_SubcontractorContactData.xlsx";
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

    public static SubContractorContactDataTool instance() {
        return SpringContext.getBean(SubContractorContactDataTool.class);
    }
}
