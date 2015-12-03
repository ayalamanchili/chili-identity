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
import info.yalamanchili.office.dao.client.ClientDao;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.toolbox.types.ClientRecord;
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
@Component("clientDataTool")
@Transactional
public class ClientDataTool {

    private static final Log log = LogFactory.getLog(ClientDataTool.class);

    public static void main(String... args) {
        ClientDataTool tool = new ClientDataTool();
        tool.migrateClientData();
    }

    public void migrateClientData() {
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
            Client client = new Client();
            Address address = new Address();
            if (record.getRowNum() == 0) {
                continue;
            }
            ClientRecord cr = new ClientRecord();
            cr.setSimilarity(new Double(getCellNumericValue(record, 5)));
            if (cr.getSimilarity() == 1.0000 || cr.getSimilarity() == 2.0000) {
                cr.setId(new Long(convertDcimalToWhole(getCellNumericValue(record, 1))));
                System.out.println("normal id: " + cr.getId());
                client = ClientDao.instance().findById(cr.getId());
            } else if (cr.getSimilarity() < 1.0000) {
                cr.setClientName(getCellStringValue(record, 2));
                if (cr.getClientName() != null && !cr.getClientName().isEmpty()) {
                    cr.setClientName(cr.getClientName().replaceAll("[^a-zA-Z0-9\\s\\/]", ""));
                    client.setName(cr.getClientName());
                } else if (cr.getClientName() == null || cr.getClientName().isEmpty()) {
                    continue;
                }
            } else if (cr.getSimilarity() > 2.0000) {
                continue;
            }
            System.out.println("normal para: " + client.getName());
            cr.setInvoiceFrequency((InvoiceFrequency) convertEnum(InvoiceFrequency.class, getCellStringValue(record, 14)));
            if (cr.getInvoiceFrequency() != null) {
                client.setClientinvFrequency(cr.getInvoiceFrequency());
            }
            cr.setWebSite(getCellStringValue(record, 13));
            if (cr.getWebSite() != null && !cr.getWebSite().isEmpty()) {
                client.setWebsite(cr.getWebSite().trim());
            }
            cr.setStreet(getCellStringValue(record, 6));
            cr.setState(getCellStringValue(record, 8));
            cr.setCity(getCellStringValue(record, 7));
            cr.setZipCode(convertDcimalToWhole(getCellStringOrNumericValue(record, 9)));

            if (cr.getZipCode() != null && !cr.getZipCode().isEmpty()) {
                int len = cr.getZipCode().length();
                if (len == 4) {
                    cr.setZipCode("0" + cr.getZipCode());
                } else if (len == 3) {
                    cr.setZipCode("00" + cr.getZipCode());
                } else if (len == 2) {
                    cr.setZipCode("000" + cr.getZipCode());
                } else if (len == 1) {
                    cr.setZipCode("0000" + cr.getZipCode());
                }
            }

            if ((cr.getState() != null && !cr.getState().isEmpty())
                    && (cr.getCity() != null && !cr.getCity().isEmpty())) {
                if (cr.getStreet() != null && !cr.getStreet().isEmpty()) {
                    address.setStreet1(cr.getStreet());
                } else {
                    address.setStreet1(cr.getCity().trim());
                }
                address.setState(cr.getState().trim());
                address.setCountry("USA");
                address.setCity(cr.getCity().trim());
                if (cr.getZipCode() != null && !cr.getZipCode().isEmpty()) {
                    address.setZip(cr.getZipCode().trim());
                }
                client.getLocations().add(address);
            }
           // ClientDao.instance().getEntityManager().merge(client);
        }
    }

    protected String getDataFileUrl() {
        //return "/Users/madhu.badiginchala/Desktop/BIS_ClientData.xlsx";
        return OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "BIS_ClientData.xlsx";
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

    public static ClientDataTool instance() {
        return SpringContext.getBean(ClientDataTool.class);
    }

}
