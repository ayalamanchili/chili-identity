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
import info.yalamanchili.office.entity.profile.Employee;
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
@Component
@Transactional
public class EmployeeDataTool {

    private final static Logger logger = Logger.getLogger(EmployeeDataTool.class.getName());
    @PersistenceContext
    protected EntityManager em;

    public static void main(String... args) {
        EmployeeDataTool load = new EmployeeDataTool();
        System.out.println(load.loadADPRecords());
    }

    public void syncADPEmpployeeData() {
        for (ADPEmployeeRecord record : loadADPRecords()) {
            if (record.getSsn() != null) {
                Employee emp = SecurityService.instance().findEmployeeBySSN(record.getSsn());
                if (emp != null) {
                    syncEmployeeAddresses(record, emp);
                }
            }
        }
    }

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
            if (record.getStreet1() != null && address.getStreet1().equals(record.getStreet1().trim())) {
                return true;
            }
        }
        return false;
    }

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
            return str.replace("-", "");
        } else {
            return null;
        }
    }

    protected String getDataFileUrl() {
        return OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "load.xls";
    }

    public static EmployeeDataTool instance() {
        return SpringContext.getBean(EmployeeDataTool.class);
    }
}
