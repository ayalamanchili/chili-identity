/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox;

import info.chili.commons.DateUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dto.profile.EmployeeCreateDto;
import info.yalamanchili.office.entity.client.Subcontractor;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.Sex;
import info.yalamanchili.office.profile.EmployeeService;
import static info.yalamanchili.office.toolbox.ExcelUtils.getCellStringOrNumericValue;
import static info.yalamanchili.office.toolbox.ExcelUtils.getCellStringValue;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
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
 * @author ayalamanchili
 */
@Component("nonEmpDataTool")
@Transactional
public class NonEmpDataTool {

    private static final Log log = LogFactory.getLog(NonEmpDataTool.class);

    @PersistenceContext
    protected EntityManager em;

    public static void main(String... strings) {
        NonEmpDataTool tool = new NonEmpDataTool();
        tool.loadNonEmpData();
    }

    public void loadNonEmpData() {
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
            if (record.getRowNum() == 0) {
                continue;
            }
            String empType = getCellStringValue(record, 24);
            if (StringUtils.isNotBlank(empType) && (empType.equalsIgnoreCase("Subcontractor") || empType.equalsIgnoreCase("1099"))) {
                EmployeeCreateDto dto = new EmployeeCreateDto();
                dto.setFirstName(getCellStringValue(record, 25));
                dto.setLastName(getCellStringValue(record, 26));
                dto.setEmail(getCellStringValue(record, 41));
                EmployeeType type = new EmployeeType();
                if (empType.equalsIgnoreCase("Subcontractor")) {
                    type.setName("SUB_CONTRACTOR");
                }
                if (empType.equalsIgnoreCase("1099")) {
                    type.setName("1099");
                }
                dto.setEmployeeType(type);
                String gender = getCellStringValue(record, 43);
                if (StringUtils.isNotBlank(gender)) {
                    dto.setSex(Sex.valueOf(gender.toUpperCase()));
                }
                String dob = getCellStringOrNumericValue(record, 42);
                if (StringUtils.isNotBlank(dob) && dob.length() > 4) {
                    dto.setDateOfBirth(DateUtils.parse(dob, "dd-MMM-yyyy"));
                }
                String empId = EmployeeService.instance().createUser(dto);
                //read sub contractor information
                Subcontractor subContractor = new Subcontractor();
                subContractor.setName(getCellStringValue(record, 14));

                ClientInformation ci = new ClientInformation();
                ci.setSubcontractor(subContractor);

            }
        }
    }

    protected String getDataFileUrl() {
        return "C:\\Users\\ayalamanchili\\Desktop\\BIS_SUB_CONTRACTORS.xlsx";
//        return OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "load.xlsx";
    }

    public static NonEmpDataTool instance() {
        return (NonEmpDataTool) SpringContext.getBean("nonEmpDataTool");
    }
}
