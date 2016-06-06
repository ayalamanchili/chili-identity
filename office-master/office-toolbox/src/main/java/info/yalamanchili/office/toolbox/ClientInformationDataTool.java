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
import info.yalamanchili.office.dao.client.ProjectDao;
import info.yalamanchili.office.dao.client.SubcontractorDao;
import info.yalamanchili.office.dao.client.VendorDao;
import info.yalamanchili.office.dao.practice.PracticeDao;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.InvoiceDeliveryMethod;
import info.yalamanchili.office.entity.client.InvoiceFrequency;
import info.yalamanchili.office.entity.client.Project;
import info.yalamanchili.office.entity.client.Subcontractor;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.BillingDuration;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.ClientInformationCompany;
import info.yalamanchili.office.entity.profile.ClientInformationStatus;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.toolbox.types.CPDRecord;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Component("clientInformationDataTool")
@Transactional
public class ClientInformationDataTool {

    private static final Log log = LogFactory.getLog(ClientInformationDataTool.class);

    public static void main(String... args) {
        ClientInformationDataTool tool = new ClientInformationDataTool();
        tool.bisCPDMigration();
    }

    public boolean is1099;
    public Long ven = 99999L;
    public boolean isClientonly;

    @Autowired
    protected ClientInformationDao clientInformationDao;

    public void bisCPDMigration() {
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
            is1099 = false;
            isClientonly = false;
            Employee emp = new Employee();
            ClientInformation clientInfo = new ClientInformation();
            String JobTitle = "   ";
            Vendor vendor = new Vendor();
            Vendor middleVendor = new Vendor();
            Project project = new Project();
            Client client = new Client();
            Address address = new Address();

            CPDRecord cpd = new CPDRecord();
            String EmployeeId = getCellNumericValue(record, 2);
            if (EmployeeId != null) {
                cpd.setEmployeeId(new Long(convertDcimalToWhole(getCellNumericValue(record, 2))));
                emp = EmployeeDao.instance().findById(cpd.getEmployeeId());
            } else {
                continue;
            }
            String ClientID = getCellNumericValue(record, 77);
            if (ClientID == null) {
                continue;
            }
            String ProjectID = getCellNumericValue(record, 3);
            System.out.println("Consultant Name >>>>>>>>>>>>>>>><<<<<<<<<<<<<<: " + emp.getFirstName() + " " + emp.getLastName());
            System.out.println("Project ID       >>>>>>>>>>>>>>>><<<<<<<<<<<<<<: " + ProjectID);
            cpd.setStartDate(convertToDate(getCellNumericValue(record, 4)));
            cpd.setEndDate(convertToDate(getCellNumericValue(record, 5)));
            if (cpd.getStartDate() != null) {
                clientInfo.setStartDate(cpd.getStartDate());
            }
            if (cpd.getEndDate() != null) {
                clientInfo.setEndDate(cpd.getEndDate());
            }
            cpd.setItemNum(convertDcimalToWhole(getCellStringOrNumericValue(record, 6)));
            if (cpd.getItemNum() != null) {
                clientInfo.setItemNumber(cpd.getItemNum());
            }
            cpd.setConsultantType(getCellStringOrNumericValue(record, 7));
            if (cpd.getConsultantType().equals("1099")) {
                is1099 = true;
            }
            String PayRate = getCellNumericValue(record, 8);
            if (PayRate != null) {
                cpd.setPayRate(new BigDecimal(getCellNumericValue(record, 8)));
                clientInfo.setBillingRate(cpd.getPayRate());
            }
            String OverTimePayrate = getCellNumericValue(record, 10);
            if (OverTimePayrate != null) {
                cpd.setOverTimePayrate(new BigDecimal(getCellNumericValue(record, 10)));
                clientInfo.setOverTimeBillingRate(cpd.getOverTimePayrate());
            }

            cpd.setBillingDuration((BillingDuration) convertEnum(BillingDuration.class, getCellStringValue(record, 11)));
            if (cpd.getBillingDuration() != null) {
                clientInfo.setBillingRateDuration(cpd.getBillingDuration());
            }
            cpd.setOverTimeDuration((BillingDuration) convertEnum(BillingDuration.class, getCellStringValue(record, 12)));
            if (cpd.getOverTimeDuration() != null) {
                clientInfo.setOverTimeRateDuration(cpd.getOverTimeDuration());
            }
            cpd.setJobTitle(getCellStringValue(record, 14));
            if (cpd.getJobTitle() != null) {
                clientInfo.setConsultantJobTitle(cpd.getJobTitle());
            } else {
                clientInfo.setConsultantJobTitle(JobTitle);
            }
            cpd.setInvoiceFrequency((InvoiceFrequency) convertEnum(InvoiceFrequency.class, getCellStringValue(record, 16)));
            if (cpd.getInvoiceFrequency() != null) {
                clientInfo.setInvoiceFrequency(cpd.getInvoiceFrequency());
            }
            cpd.setInvoiceDeliveryMethod((InvoiceDeliveryMethod) convertEnum(InvoiceDeliveryMethod.class, getCellStringValue(record, 17)));
            if (cpd.getInvoiceDeliveryMethod() != null) {
                clientInfo.setInvoiceDeliveryMethod(cpd.getInvoiceDeliveryMethod());
            }
            String RecID1 = getCellNumericValue(record, 19);
            if (RecID1 != null) {
                cpd.setRecID1(new Long(convertDcimalToWhole(getCellNumericValue(record, 19))));
                clientInfo.getRecruiters().add(EmployeeDao.instance().findById(cpd.getRecID1()));
            }
            String RecID2 = getCellNumericValue(record, 20);
            if (RecID2 != null) {
                cpd.setRecID2(new Long(convertDcimalToWhole(getCellNumericValue(record, 20))));
                clientInfo.getRecruiters().add(EmployeeDao.instance().findById(cpd.getRecID2()));
            }
            String RecID3 = getCellNumericValue(record, 21);
            if (RecID3 != null) {
                cpd.setRecID3(new Long(convertDcimalToWhole(getCellNumericValue(record, 21))));
                clientInfo.getRecruiters().add(EmployeeDao.instance().findById(cpd.getRecID3()));
            }
            String RecID4 = getCellNumericValue(record, 22);
            if (RecID4 != null) {
                cpd.setRecID4(new Long(convertDcimalToWhole(getCellNumericValue(record, 22))));
                clientInfo.getRecruiters().add(EmployeeDao.instance().findById(cpd.getRecID4()));
            }
            String SubContractorID = getCellNumericValue(record, 24);
            if (SubContractorID != null) {
                cpd.setSubContractorID(new Long(convertDcimalToWhole(getCellNumericValue(record, 24))));
                Subcontractor subcontractor = SubcontractorDao.instance().findById(cpd.getSubContractorID());
                clientInfo.setSubcontractor(subcontractor);
            }
            String SubContractorContactID = getCellNumericValue(record, 26);
            if (SubContractorContactID != null) {
                cpd.setSubContractorContactID(new Long(convertDcimalToWhole(getCellNumericValue(record, 26))));
                Contact contact = ContactDao.instance().findById(cpd.getSubContractorContactID());
                clientInfo.setSubcontractorContact(contact);
            }
            String SubContractorPayRate = getCellNumericValue(record, 27);
            if (SubContractorPayRate != null) {
                cpd.setSubContractorPayRate(new BigDecimal(getCellNumericValue(record, 27)));
                if (!is1099) {
                    clientInfo.setSubcontractorPayRate(cpd.getSubContractorPayRate());
                } else if (is1099) {
                    clientInfo.setPayRate1099(cpd.getSubContractorPayRate());
                }
            }

            cpd.setSubcontractorinvoiceFrequency((InvoiceFrequency) convertEnum(InvoiceFrequency.class, getCellStringValue(record, 29)));
            if (cpd.getSubcontractorinvoiceFrequency() != null) {
                if (!is1099) {
                    clientInfo.setSubcontractorinvoiceFrequency(cpd.getSubcontractorinvoiceFrequency());
                } else if (is1099) {
                    clientInfo.setInvoiceFrequency1099(cpd.getSubcontractorinvoiceFrequency());
                }
            }
            String SubContractorOverTimePayRate = getCellNumericValue(record, 30);
            if (SubContractorOverTimePayRate != null) {
                cpd.setSubContractorOverTimePayRate(new BigDecimal(getCellNumericValue(record, 30)));
                if (!is1099) {
                    clientInfo.setSubcontractorOvertimePayRate(cpd.getSubContractorOverTimePayRate());
                } else if (is1099) {
                    clientInfo.setOverTimePayrate1099(cpd.getSubContractorOverTimePayRate());
                }
            }

            cpd.setSubContractorPaymentTerms(getCellStringValue(record, 59));
            if (cpd.getSubContractorPaymentTerms() != null) {
                if (!is1099) {
                    clientInfo.setSubcontractorpaymentTerms(cpd.getSubContractorPaymentTerms());
                } else if (is1099) {
                    clientInfo.setPaymentTerms1099(cpd.getSubContractorPaymentTerms());
                }
            }
            if (ClientID != null) {
                cpd.setClientID(new Long(convertDcimalToWhole(getCellNumericValue(record, 77))));
                client = ClientDao.instance().findById(cpd.getClientID());
                clientInfo.setClient(client);
            }
            String VendorID = getCellNumericValue(record, 75);
            if (VendorID != null) {
                cpd.setVendorID(new Long(convertDcimalToWhole(getCellNumericValue(record, 75))));
                if (cpd.getVendorID().compareTo(ven) == 0) {
                    isClientonly = true;
                } else {
                    vendor = VendorDao.instance().findById(cpd.getVendorID());
                    clientInfo.setVendor(vendor);
                }
            }

            String VenAPID1 = getCellNumericValue(record, 34);
            if (VenAPID1 != null) {
                cpd.setVenAPID1(new Long(convertDcimalToWhole(getCellNumericValue(record, 34))));
                if (isClientonly) {
                    clientInfo.getClientAPContacts().add(ContactDao.instance().findById(cpd.getVenAPID1()));
                } else {
                    clientInfo.getVendorAPContacts().add(ContactDao.instance().findById(cpd.getVenAPID1()));
                }

            }
            String VenAPID2 = getCellNumericValue(record, 35);
            if (VenAPID2 != null) {
                cpd.setVenAPID2(new Long(convertDcimalToWhole(getCellNumericValue(record, 35))));
                if (isClientonly) {
                    clientInfo.getClientAPContacts().add(ContactDao.instance().findById(cpd.getVenAPID2()));
                } else {
                    clientInfo.getVendorAPContacts().add(ContactDao.instance().findById(cpd.getVenAPID2()));
                }

            }
            String VenAPID3 = getCellNumericValue(record, 36);
            if (VenAPID3 != null) {
                cpd.setVenAPID3(new Long(convertDcimalToWhole(getCellNumericValue(record, 36))));
                if (isClientonly) {
                    clientInfo.getClientAPContacts().add(ContactDao.instance().findById(cpd.getVenAPID3()));
                } else {
                    clientInfo.getVendorAPContacts().add(ContactDao.instance().findById(cpd.getVenAPID3()));
                }

            }

            cpd.setCompany((ClientInformationCompany) Enum.valueOf(ClientInformationCompany.class, getCellStringValue(record, 41)));
            if (cpd.getCompany() != null) {
                clientInfo.setCompany(cpd.getCompany());
            }
            String VenRECID1 = getCellNumericValue(record, 49);
            if (VenRECID1 != null) {
                cpd.setVenRECID1(new Long(convertDcimalToWhole(getCellNumericValue(record, 49))));
                if (isClientonly) {
                    clientInfo.setClientContact(ContactDao.instance().findById(cpd.getVenRECID1()));
                } else {
                    clientInfo.getVendorRecruiters().add(ContactDao.instance().findById(cpd.getVenRECID1()));
                }
            }
            String VenRECID2 = getCellNumericValue(record, 50);
            if (VenRECID2 != null) {
                cpd.setVenRECID2(new Long(convertDcimalToWhole(getCellNumericValue(record, 50))));
                clientInfo.getVendorRecruiters().add(ContactDao.instance().findById(cpd.getVenRECID2()));
            }
            String PracticeID = getCellNumericValue(record, 71);
            if (PracticeID != null) {
                cpd.setPracticeID(new Long(convertDcimalToWhole(getCellNumericValue(record, 71))));
                clientInfo.setPractice(PracticeDao.instance().findById(cpd.getPracticeID()));
            }

            cpd.setSectorsAndBUs(getCellStringValue(record, 72));
            if (cpd.getSectorsAndBUs() != null) {
                clientInfo.setSectorsAndBUs(cpd.getSectorsAndBUs());
            }

            String MiddleVendorID = getCellNumericValue(record, 83);
            if (MiddleVendorID != null) {
                cpd.setMiddleVendorID(new Long(convertDcimalToWhole(getCellNumericValue(record, 83))));
                middleVendor = VendorDao.instance().findById(cpd.getMiddleVendorID());
                clientInfo.setMiddleVendor(middleVendor);
            }
            String ClientLocationID = getCellNumericValue(record, 84);
            if (ClientLocationID != null) {
                cpd.setClientLocationID(new Long(convertDcimalToWhole(getCellNumericValue(record, 84))));
                clientInfo.setClientLocation(AddressDao.instance().findById(cpd.getClientLocationID()));
            }

            cpd.setTimeSheetRequirement(getCellStringValue(record, 43));
            if (cpd.getTimeSheetRequirement() != null) {
                clientInfo.setTimeSheetRequirement(cpd.getTimeSheetRequirement());
            }
            cpd.setSpecialInvoiceInstructions(getCellStringValue(record, 44));
            if (cpd.getSpecialInvoiceInstructions() != null) {
                clientInfo.setSpecialInvoiceInstructions(cpd.getSpecialInvoiceInstructions());
            }
            cpd.setVisaStatus(getCellStringValue(record, 46));
            if (cpd.getVisaStatus() != null) {
                clientInfo.setVisaStatus(cpd.getVisaStatus());
            }
            cpd.setTerminationNotic(getCellStringValue(record, 47));
            if (cpd.getTerminationNotic() != null) {
                clientInfo.setTerminationNotice(cpd.getTerminationNotic());
            }
            cpd.setSignedCopyOfWorkOrder(getCellStringValue(record, 56));
            if (cpd.getSignedCopyOfWorkOrder() != null) {
                if (cpd.getSignedCopyOfWorkOrder().equals("TRUE")) {
                    clientInfo.setSignedCopyOfWorkOrder(Boolean.TRUE);
                }
            }

            cpd.setSubcontractCOI(getCellStringValue(record, 57));
            if (cpd.getSubcontractCOI() != null) {
                if (cpd.getSubcontractCOI().equals("TRUE")) {
                    clientInfo.setSubcontractCOI(Boolean.TRUE);
                }
            }

            cpd.setSubcontractorW9Form(getCellStringValue(record, 58));
            if (cpd.getSubcontractorW9Form() != null) {
                if (cpd.getSubcontractorW9Form().equals("TRUE")) {
                    clientInfo.setSubcontractorw4Filled(Boolean.TRUE);
                }
            }

            cpd.setVendorPaymentTerms(getCellStringValue(record, 60));
            if (cpd.getVendorPaymentTerms() != null) {
                clientInfo.setVendorPaymentTerms(cpd.getVendorPaymentTerms());
            }
            cpd.setHrOrientation(getCellStringValue(record, 62));
            if (cpd.getHrOrientation() != null) {
                if (cpd.getHrOrientation().equals("TRUE")) {
                    clientInfo.setHrOrientation(Boolean.TRUE);
                }
            }

            cpd.setLogisticPreparation(getCellStringValue(record, 63));
            if (cpd.getLogisticPreparation() != null) {
                if (cpd.getLogisticPreparation().equals("TRUE")) {
                    clientInfo.setLogisticsPreparation(Boolean.TRUE);
                }
            }

            cpd.setI9Filled(getCellStringValue(record, 64));
            if (cpd.getI9Filled() != null) {
                if (cpd.getI9Filled().equals("TRUE")) {
                    clientInfo.setI9Filled(Boolean.TRUE);
                }
            }

            cpd.setW4Filled(getCellStringValue(record, 65));
            if (cpd.getW4Filled() != null) {
                if (cpd.getW4Filled().equals("TRUE")) {
                    clientInfo.setW4Filled(Boolean.TRUE);
                }
            }

            cpd.setProjectEndingForSure(getCellStringValue(record, 45));
            if (cpd.getProjectEndingForSure() != null) {
                if (cpd.getProjectEndingForSure().equals("TRUE")) {
                    clientInfo.setIsEndDateConfirmed(Boolean.TRUE);
                }
            }

            cpd.setJoiningReport(getCellStringValue(record, 66));
            if (cpd.getJoiningReport() != null) {
                clientInfo.setJoiningReport(cpd.getJoiningReport());
            }
            cpd.setContractComments(getCellStringValue(record, 61));
//            if (cpd.getContractComments() != null) {
//                clientInfo.setNotes(cpd.getContractComments());
//            }

            cpd.setProjectName(getCellStringValue(record, 73));
            if (cpd.getProjectName() != null) {
                project.setName(cpd.getProjectName());
            }
            cpd.setPurchaseOrderNo(getCellStringValue(record, 79));
            if (cpd.getPurchaseOrderNo() != null) {
                project.setPurchaseOrderNo(cpd.getPurchaseOrderNo());
            }
            cpd.setSubContractorWorkOrderNo(getCellStringValue(record, 80));
            if (cpd.getSubContractorWorkOrderNo() != null) {
                project.setSubContractorWorkOrderNo(cpd.getSubContractorWorkOrderNo());
            }
            if (VendorID != null) {
                if (!isClientonly) {
                    project.setVendor(vendor);
                    client.getVendors().add(vendor);
                    vendor.getClients().add(client);
                    VendorDao.instance().save(vendor);
                }
            }
            if (cpd.getStartDate() != null) {
                project.setStartDate(cpd.getStartDate());
            }
            if (cpd.getEndDate() != null) {
                project.setEndDate(cpd.getEndDate());
            }

            if (MiddleVendorID != null) {
                project.setMiddleVendor(middleVendor);
                VendorDao.instance().save(middleVendor);
            }

            project.setClient(client);
            ClientDao.instance().save(client);

            project = ProjectDao.instance().save(project);
            clientInfo.setClientProject(project);
            clientInfo = clientInformationDao.save(clientInfo);
            cpd.setHrComments(getCellStringValue(record, 67));
//            if (cpd.getHrComments() != null) {
//                CommentDao.instance().addComment(cpd.getHrComments(), clientInfo);
//            }
//            cpd.setSubContractorComments(getCellStringValue(record, 55));
//            if (cpd.getSubContractorComments() != null) {
//                CommentDao.instance().addComment(cpd.getSubContractorComments(), clientInfo);
//            }
//            cpd.setAccountingComments(getCellStringValue(record, 61));
//            if (cpd.getAccountingComments() != null) {
//                CommentDao.instance().addComment(cpd.getAccountingComments(), clientInfo);
//            }
//            cpd.setVacationDetails(getCellStringValue(record, 37));
//            if (cpd.getVacationDetails() != null) {
//                CommentDao.instance().addComment(cpd.getVacationDetails(), clientInfo);
//            }
            emp.addClientInformation(clientInfo);
            EmployeeDao.instance().getEntityManager().merge(emp);

        }
    }

    protected String getDataFileUrl() {
        return OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "BIS_CPDMapping.xlsx";
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

    public static ClientInformationDataTool instance() {
        return SpringContext.getBean(ClientInformationDataTool.class);
    }

}
