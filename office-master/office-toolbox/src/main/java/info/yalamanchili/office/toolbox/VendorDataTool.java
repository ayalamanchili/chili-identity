/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox;

import static info.chili.docs.ExcelUtils.getCellNumericValue;
import static info.chili.docs.ExcelUtils.getCellStringValue;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.client.VendorDao;
import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.toolbox.types.VendorRecord;
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
@Component("vendorDataTool")
@Transactional
public class VendorDataTool {

    private static final Log log = LogFactory.getLog(VendorDataTool.class);

    public static void main(String... args) {
        VendorDataTool tool = new VendorDataTool();
        tool.migrateVendorData();
    }

    public void migrateVendorData() {
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
            Address address = new Address();
            if (record.getRowNum() == 0) {
                continue;
            }
            VendorRecord vr = new VendorRecord();
            vr.setSimilarity(new Double(getCellNumericValue(record, 5)));
            if (vr.getSimilarity() == 1.0000 || vr.getSimilarity() == 2.0000) {
                vr.setId(new Long(convertDcimalToWhole(getCellNumericValue(record, 1))));
                System.out.println("normal id: " + vr.getId());
                vendor = VendorDao.instance().findById(vr.getId());
            } else if (vr.getSimilarity() < 1.0000) {
                vr.setVendorName(getCellStringValue(record, 2));
                if (vr.getVendorName() != null && !vr.getVendorName().isEmpty()) {
                    vr.setVendorName(vr.getVendorName().replaceAll("[^\\w!?&,]", ""));
                    vendor.setName(vr.getVendorName());
                } else if (vr.getVendorName() == null || vr.getVendorName().isEmpty()) {
                    continue;
                }
            } else if (vr.getSimilarity() > 2.0000) {
                continue;
            }
            System.out.println("normal para: " + vendor.getName());
            vr.setInvoiceFrequency((InvoiceFrequency) convertEnum(InvoiceFrequency.class, getCellStringValue(record, 14)));
            if (vr.getInvoiceFrequency() != null) {
                vendor.setVendorinvFrequency(vr.getInvoiceFrequency());
            }
            vr.setWebSite(getCellStringValue(record, 13));
            if (vr.getWebSite() != null && !vr.getWebSite().isEmpty()) {
                vendor.setWebsite(vr.getWebSite().trim());
            }
            vr.setPaymentTerms(getCellStringValue(record, 15));
            if (vr.getPaymentTerms() != null && !vr.getPaymentTerms().isEmpty()) {
                vendor.setPaymentTerms(vr.getPaymentTerms().trim());
            }
            vr.setStreet(getCellStringValue(record, 6));
            vr.setState(getCellStringValue(record, 9));
            vr.setCity(getCellStringValue(record, 7));
            vr.setZipCode(getCellStringValue(record, 10));

            if ((vr.getState() != null && !vr.getState().isEmpty())
                    && (vr.getCity() != null && !vr.getCity().isEmpty())) {
                if (vr.getStreet() != null && !vr.getStreet().isEmpty()) {
                    address.setStreet1(vr.getStreet());
                } else {
                    address.setStreet1(vr.getCity().trim());
                }
                address.setState(vr.getState().trim());
                address.setCountry("USA");
                address.setCity(vr.getCity().trim());
                if (vr.getZipCode() != null && !vr.getZipCode().isEmpty()) {
                    address.setZip(vr.getZipCode().trim());
                }
                vendor.getLocations().add(address);
            }
            VendorDao.instance().getEntityManager().merge(vendor);
        }
    }

    protected String getDataFileUrl() {
        //return "/Users/madhu.badiginchala/Desktop/BIS_ClientData.xlsx";
        return OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "BIS_VendorData.xlsx";
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

    public static VendorDataTool instance() {
        return SpringContext.getBean(VendorDataTool.class);
    }

}
