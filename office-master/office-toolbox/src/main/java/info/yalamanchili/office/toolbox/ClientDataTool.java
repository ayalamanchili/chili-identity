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
import static info.chili.docs.ExcelUtils.getCellStringValue;
import info.chili.spring.SpringContext;
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
        tool.readClientData();
    }

    public void readClientData() {
        Client client = new Client();
        Address address = new Address();
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
            ClientRecord cr = new ClientRecord();
            cr.setSimilarity(new Double(getCellNumericValue(record, 5)));
            if (cr.getSimilarity() == 1.0000 || cr.getSimilarity() == 2.0000) {
                cr.setId(new Long(convertDcimalToWhole(getCellNumericValue(record, 1))));
                client = ClientDao.instance().findById(cr.getId());
            } else if (cr.getSimilarity() < 1.0000) {
                cr.setClientName(getCellStringValue(record, 2));
                if (cr.getClientName() != null) {
                    client.setName(cr.getClientName());
                } else if (cr.getClientName() == null || cr.getClientName().isEmpty()) {
                    continue;
                }
            } else if (cr.getSimilarity() > 2.0000) {
                continue;
            }
                cr.setInvoiceFrequency((InvoiceFrequency) convertEnum(InvoiceFrequency.class, getCellStringValue(record, 14)));
                if (cr.getInvoiceFrequency() != null) {
                    client.setClientinvFrequency(cr.getInvoiceFrequency());
                }
                cr.setWebSite(getCellStringValue(record, 13));
                if (cr.getWebSite() != null) {
                    client.setWebsite(cr.getWebSite().trim());
                }
                cr.setStreet(getCellStringValue(record, 6));
                if (cr.getStreet() != null) {
                    address.setStreet1(cr.getStreet().trim());
                }
                cr.setState(getCellStringValue(record, 9));
                if (cr.getState() != null) {
                    address.setState(cr.getState().trim());
                    address.setCountry("USA");
                }
                cr.setCity(getCellStringValue(record, 7));
                if (cr.getCity() != null) {
                    address.setCity(cr.getCity().trim());
                }
                cr.setZipCode(getCellStringValue(record, 10));
                if (cr.getZipCode() != null) {
                    address.setZip(cr.getZipCode().trim());
                }
                client.getLocations().add(address);
                ClientDao.instance().getEntityManager().merge(client);
            }
    }

    protected String getDataFileUrl() {
        return "/Users/madhu.badiginchala/Desktop/BIS_ClientData.xlsx";
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
