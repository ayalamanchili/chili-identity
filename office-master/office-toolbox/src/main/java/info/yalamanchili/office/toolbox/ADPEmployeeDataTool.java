/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox;

import info.chili.jpa.QueryUtils;
import info.chili.jpa.validation.ValidationUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.toolbox.types.ADPEmployeeRecord;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.AddressType;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.entity.profile.PhoneType;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import static info.yalamanchili.office.toolbox.ExcelUtils.*;

/**
 *
 * @author ayalamanchili
 */
@Component("adpEmployeeDataTool")
@Transactional
public class ADPEmployeeDataTool {

    private final static Logger logger = Logger.getLogger(ADPEmployeeDataTool.class.getName());
    @PersistenceContext
    protected EntityManager em;

    public static void main(String... args) {
        ADPEmployeeDataTool load = new ADPEmployeeDataTool();
        System.out.println(load.loadADPRecords());
    }

    public void syncADPEmpployeeData() {
        for (ADPEmployeeRecord record : loadADPRecords()) {
            if (record.getSsn() != null) {
                Employee emp = SecurityService.instance().findEmployeeBySSN(record.getSsn());
                if (emp != null) {
                    syncEmployeeAddresses(record, emp);
                    syncEmployeePhones(record, emp);
                    syncEmployeeEmails(record, emp);
                }
            }
        }
    }
    /*
     * Sync addresses
     */

    public void syncEmployeeAddresses(ADPEmployeeRecord record, Employee emp) {
        logger.log(Level.INFO, "sync Address for emp:{0}", emp.getEmployeeId());
        if (!isExistingAddress(record, emp)) {
            Address address = new Address();
            address.setStreet1(record.getStreet1());
            address.setStreet2(record.getStreet2());
            address.setCity(record.getCity());
            address.setState(record.getState());
            address.setZip(record.getZip());
            address.setCountry("USA");
            address.setAddressType((AddressType) QueryUtils.findEntity(em, AddressType.class, "addressType", "HOME"));
            address.setContact(emp);
            if (ValidationUtils.validate(address).isEmpty()) {
                logger.log(Level.INFO, "inserting address:{0}: for employee:{1}", new Object[]{address, emp.getEmployeeId()});
                em.merge(address);
            } else {
                logger.log(Level.SEVERE, "validation error:{0}", address);
            }
        }

    }

    protected boolean isExistingAddress(ADPEmployeeRecord record, Employee emp) {
        for (Address address : emp.getAddresss()) {
            if (record.getStreet1() != null && address.getStreet1().trim().equals(record.getStreet1().trim())) {
                return true;
            }
        }
        return false;
    }
    /*
     * sync phones
     */

    public void syncEmployeePhones(ADPEmployeeRecord record, Employee emp) {
        if (record.getCellPhone() != null && !phoneExists(record.getCellPhone(), emp)) {
            insertPhone(emp, record.getCellPhone(), (PhoneType) QueryUtils.findEntity(em, PhoneType.class, "phoneType", "CELL"));
        }
        if (record.getHomePhone() != null && !phoneExists(record.getHomePhone(), emp)) {
            insertPhone(emp, record.getHomePhone(), (PhoneType) QueryUtils.findEntity(em, PhoneType.class, "phoneType", "HOME"));
        }
    }

    protected void insertPhone(Employee emp, String number, PhoneType phoneType) {
        Phone phone = new Phone();
        phone.setPhoneNumber(number);
        phone.setPhoneType(phoneType);
        phone.setContact(emp);
        if (ValidationUtils.validate(phone).isEmpty()) {
            logger.log(Level.INFO, "inserting phone:{0}: for employee:{1}", new Object[]{phone, emp.getEmployeeId()});
            em.merge(phone);
        } else {
            logger.log(Level.SEVERE, "validation error:{0}", phone);
        }
    }

    protected boolean phoneExists(String phoneNumber, Employee emp) {
        for (Phone phone : emp.getPhones()) {
            if (phone.getPhoneNumber() != null && phone.getPhoneNumber().trim().equals(phoneNumber.trim())) {
                return true;
            }
        }
        return false;
    }
    /*
     * Sync emails
     */

    public void syncEmployeeEmails(ADPEmployeeRecord record, Employee emp) {
        if (record.getEmail() != null && !emailExists(record.getEmail(), emp)) {
            Email email = new Email();
            email.setEmail(record.getEmail());
            email.setEmailHash(record.getEmail());
            email.setPrimaryEmail(false);
            email.setContact(emp);
            if (ValidationUtils.validate(email).isEmpty()) {
                logger.log(Level.INFO, "inserting email:{0}: for employee:{1}", new Object[]{email, emp.getEmployeeId()});
                em.merge(email);
            } else {
                logger.log(Level.SEVERE, "validation error:{0}", email);
            }
        }
    }

    protected boolean emailExists(String emailAddress, Employee emp) {
        for (Email email : emp.getEmails()) {
            if (email.getEmail() != null && email.getEmail().trim().equals(emailAddress.trim())) {
                return true;
            }
        }
        return false;
    }
    /*
     * load adp records from excel
     */

    public List<ADPEmployeeRecord> loadADPRecords() {
        List<ADPEmployeeRecord> adpEmpRecords = new ArrayList<ADPEmployeeRecord>();
        InputStream inp;
        HSSFWorkbook workbook;
        try {
            inp = new FileInputStream(getDataFileUrl());
            workbook = new HSSFWorkbook(inp);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        HSSFSheet sheet = workbook.getSheetAt(1);
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row record = rowIterator.next();
            ADPEmployeeRecord adpEmpRecord = new ADPEmployeeRecord();

            adpEmpRecord.setSsn(removeDashes(getCellStringValue(record, 6)));
            adpEmpRecord.setFirstName((getCellStringValue(record, 10)));
            adpEmpRecord.setLastName((getCellStringValue(record, 12)));
            adpEmpRecord.setEmail((getCellStringValue(record, 28)));
            adpEmpRecord.setCellPhone(removeDashes((getCellStringValue(record, 4))));
            adpEmpRecord.setHomePhone(removeDashes((getCellStringValue(record, 14))));
            adpEmpRecord.setStatus(getCellStringValue(record, 8));
            adpEmpRecord.setDob(getCellNumericValue(record, 16));
            adpEmpRecord.setStreet1(getCellStringValue(record, 18));
            adpEmpRecord.setStreet2(getCellStringValue(record, 20));
            adpEmpRecord.setCity(getCellStringValue(record, 22));
            adpEmpRecord.setState(getCellStringValue(record, 24));
            adpEmpRecord.setZip(getCellStringValue(record, 26));
            adpEmpRecords.add(adpEmpRecord);
        }
        return adpEmpRecords;
    }

    protected String removeDashes(String str) {
        if (str != null) {
            str = str.replace("-", "");
            str = str.replace("(", "");
            str = str.replace(")", "");
            str = str.replace(" ", "");
            str = str.replace("_", "");
            return str;
        } else {
            return null;
        }
    }

    protected String getDataFileUrl() {
        return OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "load.xls";
    }

    public static ADPEmployeeDataTool instance() {
        return (ADPEmployeeDataTool) SpringContext.getBean("adpEmployeeDataTool");
    }
}
