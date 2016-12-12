/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox;

import info.chili.commons.EntityQueryUtils;
import static info.chili.docs.ExcelUtils.getCellNumericValue;
import static info.chili.docs.ExcelUtils.getCellStringOrNumericValue;
import static info.chili.docs.ExcelUtils.getCellStringValue;
import info.chili.identity.jrsc.IdentityServiceClient;
import info.chili.security.domain.CRole;
import info.chili.security.domain.CUser;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.AddressType;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.entity.profile.PhoneType;
import info.yalamanchili.office.entity.profile.Preferences;
import info.yalamanchili.office.entity.profile.Sex;
import info.yalamanchili.office.toolbox.types.OnboardingRecord;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@Component("onBoardingDataTool")
@Transactional
public class OnBoardingDataTool {

    private static final Log logger = LogFactory.getLog(OnBoardingDataTool.class);

    public static void main(String... args) {
        OnBoardingDataTool tool = new OnBoardingDataTool();
        tool.migrateConsultantsData();
    }

    @PersistenceContext
    protected EntityManager em;

    public void migrateConsultantsData() {
        InputStream inp;
        int i = 0;
        Long id_1 = 1L;
        Long id_2 = 2L;
        Long id_3 = 3L;
        Long id_4 = 4L;
        Long id_5 = 5L;
        Long id_9 = 9L;
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
            Employee emp = new Employee();
            Phone phone = new Phone();
            Email email = new Email();
            Address address = new Address();
            Address permAddress = new Address();
            Phone permPhone = new Phone();
            String employeeId = "";
            if (record.getRowNum() == 0) {
                continue;
            }
            OnboardingRecord or = new OnboardingRecord();
            or.setSimilarity(new Double(getCellNumericValue(record, 43)));
            if (or.getSimilarity() == 1.0000 || or.getSimilarity() == 2.0000 || or.getSimilarity() == 5.0000 || or.getSimilarity() == 7.0000 || or.getSimilarity() == 8.0000) {
                continue;
            }

            or.setEmployeeType(convertDcimalToWhole(getCellStringOrNumericValue(record, 3)));
            if (or.getEmployeeType() != null && !or.getEmployeeType().isEmpty()) {
                if (or.getEmployeeType().equals("SubContractor")) {
                    emp.setEmployeeType(em.find(EmployeeType.class, id_3));
                } else if (or.getEmployeeType().equals("1099")) {
                    emp.setEmployeeType(em.find(EmployeeType.class, id_4));
                } else if (or.getEmployeeType().equals("Techpillars")) {
                    emp.setEmployeeType(em.find(EmployeeType.class, id_2));
                    emp.setCompany(em.find(Company.class, id_2));
                } else if (or.getEmployeeType().equals("SSTECH")) {
                    emp.setEmployeeType(em.find(EmployeeType.class, id_2));
                    emp.setCompany(em.find(Company.class, id_9));
                }
            }

            or.setFirstName(getCellStringValue(record, 1));
            or.setLastName(getCellStringValue(record, 2));
            if (or.getFirstName() != null && !or.getFirstName().isEmpty()) {
                or.setFirstName(or.getFirstName().replaceAll("[^a-zA-Z0-9\\s\\/\\.\\']", ""));
                emp.setFirstName(or.getFirstName());
            } else {
                continue;
            }
            if (or.getLastName() != null && !or.getLastName().isEmpty()) {
                or.setLastName(or.getLastName().replaceAll("[^a-zA-Z0-9\\s\\/\\.\\']", ""));
                emp.setLastName(or.getLastName());
            } else {
                emp.setLastName(or.getFirstName());
            }
            System.out.println("Consultant Name >>>>>>>>>>>>>>>><<<<<<<<<<<<<<: " + or.getFirstName() + " " + or.getLastName());
            or.setDateOfBirth(convertToDate(getCellNumericValue(record, 4)));
            or.setDateOfJoining(convertToDate(getCellNumericValue(record, 13)));
            or.setDateOfRelieving(convertToDate(getCellNumericValue(record, 14)));
            if (or.getDateOfJoining() != null) {
                emp.setStartDate(or.getDateOfJoining());
            }
            if (or.getDateOfRelieving() != null) {
                emp.setEndDate(or.getDateOfRelieving());
            }
            if (or.getDateOfBirth() != null) {
                emp.setDateOfBirth(or.getDateOfBirth());
            }
            or.setEmail(getCellStringValue(record, 27));
            if (or.getEmail() != null && !or.getEmail().isEmpty()) {
                email.setEmail(or.getEmail().replaceAll("\\s+", ""));
                email.setPrimaryEmail(true);
                emp.addEmail(email);
            }

            or.setPhoneNumber(convertDcimalToWhole(getCellStringOrNumericValue(record, 25)));
            if (or.getPhoneNumber() != null && !or.getPhoneNumber().isEmpty()) {
                phone.setPhoneNumber(or.getPhoneNumber());
                phone.setPhoneType(em.find(PhoneType.class, id_1));
                emp.addPhone(phone);
            }

            or.setPermphoneNumber(convertDcimalToWhole(getCellStringOrNumericValue(record, 23)));
            if (or.getPermphoneNumber() != null && !or.getPermphoneNumber().isEmpty()) {
                permPhone.setPhoneNumber(or.getPermphoneNumber());
                permPhone.setPhoneType(em.find(PhoneType.class, id_2));
                emp.addPhone(permPhone);
            }
            or.setSex((Sex) convertEnum(Sex.class, getCellStringValue(record, 5)));
            emp.setSex(or.getSex());
            or.setStreet(getCellStringValue(record, 7));
            or.setState(getCellStringValue(record, 11));
            or.setCity(getCellStringValue(record, 9));
            or.setZipCode(convertDcimalToWhole(getCellStringOrNumericValue(record, 12)));

            if (or.getZipCode() != null && !or.getZipCode().isEmpty()) {
                int len = or.getZipCode().length();
                if (len == 4) {
                    or.setZipCode("0" + or.getZipCode());
                } else if (len == 3) {
                    or.setZipCode("00" + or.getZipCode());
                } else if (len == 2) {
                    or.setZipCode("000" + or.getZipCode());
                } else if (len == 1) {
                    or.setZipCode("0000" + or.getZipCode());
                }
            }

            if ((or.getState() != null && !or.getState().isEmpty())
                    && (or.getCity() != null && !or.getCity().isEmpty())) {
                if (or.getStreet() != null && !or.getStreet().isEmpty()) {
                    address.setStreet1(or.getStreet());
                } else {
                    address.setStreet1(or.getCity().trim());
                }
                address.setState(or.getState().trim());
                address.setCountry("USA");
                address.setCity(or.getCity().trim());
                if (or.getZipCode() != null && !or.getZipCode().isEmpty()) {
                    address.setZip(or.getZipCode().trim());
                }
                address.setAddressType(em.find(AddressType.class, id_1));
                emp.addAddress(address);
            }

            or.setPermStreet(getCellStringValue(record, 15));
            or.setPermCity(getCellStringValue(record, 17));
            or.setPermState(getCellStringValue(record, 19));
            or.setPermCountry(getCellStringValue(record, 21));
            or.setPermZipCode(convertDcimalToWhole(getCellStringOrNumericValue(record, 22)));

            if (or.getPermZipCode() != null && !or.getPermZipCode().isEmpty()) {
                int len = or.getPermZipCode().length();
                if (len == 4) {
                    or.setPermZipCode("0" + or.getPermZipCode());
                } else if (len == 3) {
                    or.setPermZipCode("00" + or.getPermZipCode());
                } else if (len == 2) {
                    or.setPermZipCode("000" + or.getPermZipCode());
                } else if (len == 1) {
                    or.setPermZipCode("0000" + or.getPermZipCode());
                }
            }

            if ((or.getPermState() != null && !or.getPermState().isEmpty())
                    && (or.getPermCity() != null && !or.getPermCity().isEmpty())) {
                if (or.getPermStreet() != null && !or.getPermStreet().isEmpty()) {
                    permAddress.setStreet1(or.getPermStreet());
                } else {
                    permAddress.setStreet1(or.getPermCity().trim());
                }
                permAddress.setState(or.getPermState().trim());
                permAddress.setCountry(or.getPermCountry().trim());
                permAddress.setCity(or.getPermCity().trim());
                if (or.getPermZipCode() != null && !or.getPermZipCode().isEmpty()) {
                    permAddress.setZip(or.getPermZipCode().trim());
                }
                permAddress.setAddressType(em.find(AddressType.class, id_5));
                emp.addAddress(permAddress);
            }

            employeeId = generateEmployeeId(emp.getFirstName(), emp.getLastName(), emp.getDateOfBirth(), emp.getStartDate());
            if (or.getEmployeeType() != null && !or.getEmployeeType().isEmpty()) {
                if (or.getEmployeeType().equals("SSTECH") || or.getEmployeeType().equals("Techpillars")) {
                    CUser user = new CUser();
                    user.setUsername(employeeId);
                    user.setPasswordHash(generatepassword());
                    user.setEnabled(true);
                    user.addRole((CRole) EntityQueryUtils.findEntity(em, CRole.class, "rolename", OfficeRoles.OfficeRole.ROLE_USER.name()));
                    user = IdentityServiceClient.instance().createUser(user);
                    emp.setUser(user);
                }
            }

            emp.setEmployeeId(employeeId);
            Preferences prefs = new Preferences();
            prefs.setEnableEmailNotifications(Boolean.TRUE);
            emp.setPreferences(prefs);
            i += 1;
            //emp = EmployeeDao.instance().save(emp);
            if (or.getEmployeeType() != null && !or.getEmployeeType().isEmpty()) {
                if (or.getEmployeeType().equals("SSTECH") || or.getEmployeeType().equals("Techpillars")) {
                    OfficeSecurityService.instance().createUserCert(emp, null, null);
                }
            }
        }
        System.out.println("Total Consultants Records Written :::<<<>>>>::: " + i);
    }

    protected String getDataFileUrl() {
        return OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "BIS_ConsultantsData.xlsx";
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

    public String generatepassword() {
        final int PASSWORD_LENGTH = 6;
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < PASSWORD_LENGTH; x++) {
            sb.append((char) ((int) (Math.random() * 26) + 97));
        }
        return sb.toString();
    }

    protected Date convertToDate(String dte) {
        if (dte != null) {
            Date date = null;
            try {
                date = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).parse(dte);
                return date;
            } catch (ParseException ex) {
                System.out.println("date parsing error" + dte);
            }
        }
        return null;
    }

    public String generateEmployeeId(String firstName, String lastName, Date dateofBirth, Date startDate) {
        Date todayDate = new Date();
        String empId = firstName.toLowerCase().charAt(0) + lastName.toLowerCase();
        javax.persistence.Query findUserQuery = em.createQuery("from Employee where employeeId=:empIdParam");
        findUserQuery.setParameter("empIdParam", empId);
        if (findUserQuery.getResultList().size() > 0) {
            System.out.println("FIRSTNAME:LASTNAME ::" + firstName + " " + lastName);
            if (dateofBirth != null) {
                empId = empId + Integer.toString(dateofBirth.getDate());
            } else if (startDate != null) {
                empId = empId + Integer.toString(startDate.getDate());
            } else {
                empId = empId + Integer.toString(todayDate.getDate());
            }
        }
        if (empId.contains(" ")) {
            empId = empId.replace(" ", "_");
        }
        return empId;
    }

    public static OnBoardingDataTool instance() {
        return SpringContext.getBean(OnBoardingDataTool.class);
    }

}
