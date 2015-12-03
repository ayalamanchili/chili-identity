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
import info.yalamanchili.office.dao.client.SubcontractorDao;
import info.yalamanchili.office.entity.client.Subcontractor;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.toolbox.types.SubContractorRecord;
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
@Component("subContractorDataTool")
@Transactional
public class SubContractorDataTool {

    private static final Log log = LogFactory.getLog(SubContractorDataTool.class);
    public boolean isAddressexists;

    public static void main(String... args) {
        SubContractorDataTool tool = new SubContractorDataTool();
        tool.migrateSubContractorData();
    }

    public void migrateSubContractorData() {
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
            isAddressexists = false;
            Row record = rowIterator.next();
            Subcontractor subContractor = new Subcontractor();
            Address address = new Address();
            if (record.getRowNum() == 0) {
                continue;
            }
            SubContractorRecord sr = new SubContractorRecord();
            sr.setSimilarity(new Double(getCellNumericValue(record, 5)));
            if (sr.getSimilarity() == 1.0000 || sr.getSimilarity() == 2.0000) {
                sr.setId(new Long(convertDcimalToWhole(getCellNumericValue(record, 1))));
                System.out.println("normal id: " + sr.getId());
                subContractor = SubcontractorDao.instance().findById(sr.getId());
            } else if (sr.getSimilarity() < 1.0000) {
                sr.setSubContractorName(getCellStringValue(record, 2));
                if (sr.getSubContractorName() != null && !sr.getSubContractorName().isEmpty()) {
                    sr.setSubContractorName(sr.getSubContractorName().replaceAll("[^a-zA-Z0-9\\s\\/]", ""));
                    subContractor.setName(sr.getSubContractorName());
                } else if (sr.getSubContractorName() == null || sr.getSubContractorName().isEmpty()) {
                    continue;
                }
            } else if (sr.getSimilarity() > 2.0000) {
                continue;
            }
            System.out.println("normal para: " + subContractor.getName());
            sr.setWebSite(getCellStringValue(record, 13));
            if (sr.getWebSite() != null && !sr.getWebSite().isEmpty()) {
                subContractor.setWebsite(sr.getWebSite().trim());
            }

            sr.setStreet(getCellStringValue(record, 6));
            sr.setState(getCellStringValue(record, 8));
            sr.setCity(getCellStringValue(record, 7));
            sr.setZipCode(convertDcimalToWhole(getCellStringOrNumericValue(record, 9)));

            if (sr.getZipCode() != null && !sr.getZipCode().isEmpty()) {
                int len = sr.getZipCode().length();
                if (len == 4) {
                    sr.setZipCode("0" + sr.getZipCode());
                } else if (len == 3) {
                    sr.setZipCode("00" + sr.getZipCode());
                } else if (len == 2) {
                    sr.setZipCode("000" + sr.getZipCode());
                } else if (len == 1) {
                    sr.setZipCode("0000" + sr.getZipCode());
                }
            }

            if (sr.getSimilarity() == 1.0000 || sr.getSimilarity() == 2.0000) {
                for (Address add : subContractor.getLocations()) {
                    if ((isAddressexists == false) && (add != null)) {
                        if ((sr.getState() != null && !sr.getState().isEmpty())
                                && (sr.getCity() != null && !sr.getCity().isEmpty())) {
                            if (sr.getStreet() != null && !sr.getStreet().isEmpty()) {
                                add.setStreet1(sr.getStreet());
                            }
                            add.setState(sr.getState().trim());
                            add.setCountry("USA");
                            add.setCity(sr.getCity().trim());
                            if (sr.getZipCode() != null && !sr.getZipCode().isEmpty()) {
                                add.setZip(sr.getZipCode().trim());
                            }
                            isAddressexists = true;
                        }
                    }
                }
            }

            if (isAddressexists == false) {
                if ((sr.getState() != null && !sr.getState().isEmpty())
                        && (sr.getCity() != null && !sr.getCity().isEmpty())) {
                    if (sr.getStreet() != null && !sr.getStreet().isEmpty()) {
                        address.setStreet1(sr.getStreet());
                    } else {
                        address.setStreet1(sr.getCity().trim());
                    }
                    address.setState(sr.getState().trim());
                    address.setCountry("USA");
                    address.setCity(sr.getCity().trim());
                    if (sr.getZipCode() != null && !sr.getZipCode().isEmpty()) {
                        address.setZip(sr.getZipCode().trim());
                    }
                    subContractor.getLocations().add(address);
                }
            }
           // SubcontractorDao.instance().getEntityManager().merge(subContractor);
        }
    }

    protected String getDataFileUrl() {
        //return "/Users/madhu.badiginchala/Desktop/BIS_ClientData.xlsx";
        return OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "BIS_SubContractorData.xlsx";
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

    public static SubContractorDataTool instance() {
        return SpringContext.getBean(SubContractorDataTool.class);
    }

}
