/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.expense.travelauthorization;

import info.chili.commons.DateUtils;
import info.chili.commons.pdf.PDFUtils;
import info.chili.commons.pdf.PdfDocumentData;
import info.chili.security.Signature;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.chili.bpm.types.Task;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.dao.expense.travelauthorization.TravelAuthorizationDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelAccommodation;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelAuthorization;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelAuthorizationStatus;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelFood;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelRentalVehicleJustification;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelTransportation;
import static info.yalamanchili.office.entity.expense.travelauthorization.TravelTransportationType.OTHER;
import static info.yalamanchili.office.entity.expense.travelauthorization.TravelTransportationType.RAILWAY;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.security.AccessCheck;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author prasanthi.p
 */
@Component
@Scope("request")
public class TravelAuthorizationService {
    
    @Autowired
    protected TravelAuthorizationDao travelAuthorizationDao;
    
    public void submitTravelAuthorization(TravelAuthorization entity) {
        Map<String, Object> vars = new HashMap<>();
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        entity.setEmployee(emp);
        entity.setDateRequested(new Date());
        entity.setStatus(TravelAuthorizationStatus.PENDING_MANAGER_APPROVAL);
        vars.put("entity", entity);
        vars.put("currentEmployee", emp);
        entity=travelAuthorizationDao.save(entity);
        vars.put("entityId", entity.getId());
        String processId = OfficeBPMService.instance().startProcess("travel_authorization_process", vars);
        entity.setBpmProcessId(processId);
    }
    
    protected Task getTaskForTicket(TravelAuthorization travelExpenseRequisition) {
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        List<Task> tasks = taskService.getTasksForProcessId(travelExpenseRequisition.getBpmProcessId());
        if (tasks.size() > 0) {
            return tasks.get(0);
        } else {
            return null;
        }
    }
    
    public void delete(Long id) {
        TravelAuthorization ticket = travelAuthorizationDao.findById(id);
        OfficeBPMTaskService.instance().deleteAllTasksForProcessId(ticket.getBpmProcessId(), true);
        travelAuthorizationDao.delete(id);
    }
    
    @AccessCheck(employeePropertyName = "employee", companyContacts = {"Perf_Eval_Manager", "Reports_To"}, roles = {"ROLE_ADMIN"})
    public Response getReport(TravelAuthorization entity) {
        PdfDocumentData data = new PdfDocumentData();
        data.setTemplateUrl("/templates/pdf/travel-authorization-template.pdf");
        EmployeeDao employeeDao = EmployeeDao.instance();
        OfficeSecurityConfiguration securityConfiguration = OfficeSecurityConfiguration.instance();
        data.setKeyStoreName(securityConfiguration.getKeyStoreName());
        Employee preparedBy = entity.getEmployee();
        String prepareByStr = preparedBy.getLastName() + ", " + preparedBy.getFirstName();
        data.getData().put("employeeName", prepareByStr);
        data.getData().put("departureDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getDepartureDate()));
        data.getData().put("returnDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getReturnDate()));
        data.getData().put("department", entity.getDepartment());
        data.getData().put("travelDestination", entity.getTravelDestination());
        data.getData().put("reasonForTravel", entity.getReasonForTravel());
//        Signature preparedBysignature = new Signature(preparedBy.getEmployeeId(), preparedBy.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "employeeSignature", DateUtils.dateToCalendar(entity.getDateRequested()), employeeDao.getPrimaryEmail(preparedBy), null);
//        data.getSignatures().add(preparedBysignature);
        //Travel type Information
        switch (entity.getTravelType()) {
            case IN_STATE:
                data.getData().put("travelTypeInState", "true");
                break;
            case OUT_OF_STATE:
                data.getData().put("travelTypeOutOfState", "true");
                break;
            case INTERNATIONAL:
                data.getData().put("travelTypeInternational", "true");
                break;
        }
        //TravelTransportation info
        TravelTransportation travelTransportation = entity.getTravelTransportation();
        if (travelTransportation != null) {
            //TravelTransportationType info
            switch (travelTransportation.getTravelTransportationType()) {
                case AIR:
                    data.getData().put("travelTransportationTypeAir", "true");
                    break;
                case BUS:
                    data.getData().put("travelTransportationTypeBus", "true");
                    break;
                case RAILWAY:
                    data.getData().put("travelTransportationTypeRailWay", "true");
                    break;
                case OTHER:
                    data.getData().put("travelTransportationTypeOther", "true");
                    break;
                case COMPANY_VEHICLE:
                    data.getData().put("travelTransportationTypeCpmapny", "true");
                    break;
                case PRIVATE_VEHICLE:
                    data.getData().put("travelTransportationTypePrivate", "true");
                    break;
                case RENTAL_VEHICLE:
                    data.getData().put("travelTransportationTypeRental", "true");
                    break;
            }
            //ExpensePaymentType info
            switch (travelTransportation.getExpensePaymentType()) {
                case EMPLOYEE_EXPENSE:
                    data.getData().put("expenseTransPaymentExp", "true");
                    break;
                case PO:
                    data.getData().put("expenseTransPaymentPo", "true");
                    break;
                case PURCHASING_CARD:
                    data.getData().put("expenseTransPaymentPurchasingCard", "true");
                    break;
            }
            if (travelTransportation.getCostPerMile() != null) {
                data.getData().put("costPerMile", travelTransportation.getCostPerMile().setScale(2, BigDecimal.ROUND_UP).toString());
            }
            if (travelTransportation.getTotalMiles() != null) {
                data.getData().put("totalMiles", travelTransportation.getTotalMiles().setScale(2, BigDecimal.ROUND_UP).toString());
            }
            if (travelTransportation.getTotalTransportationCost() != null) {
                data.getData().put("totalTransportationCost", travelTransportation.getTotalTransportationCost().setScale(2, BigDecimal.ROUND_UP).toString());
            }
            if (travelTransportation.getTravelRentalVehicleJustification() != null) {
                //TravelRentalVehicleJustification Information
                TravelRentalVehicleJustification justification = travelTransportation.getTravelRentalVehicleJustification();
                data.getData().put("rentalVehicleJustification", justification.getRentalVehicleJustification());
                data.getData().put("otherVehicleTypeJustification", justification.getOtherVehicleTypeJustification());
                if (justification.getEstimatedCostOfOtherTransportation() != null) {
                    data.getData().put("estimatedCostOfOtherTransportation", justification.getEstimatedCostOfOtherTransportation().setScale(2, BigDecimal.ROUND_UP).toString());
                }
                //TravelRentalVehicleType info
                switch (justification.getTravelRentalVehicleType()) {
                    case MID_SIZE:
                        data.getData().put("travelRentalVehicleMidSize", "true");
                        break;
                    case COMPACT:
                        data.getData().put("travelRentalVehicleCompact", "true");
                        break;
                    case OTHER:
                        data.getData().put("travelRentalVehicleOther", "true");
                        break;
                }
            }
        }
        //TravelAccommodation Information
        TravelAccommodation travelAccommodation = entity.getTravelAccommodation();
        if (travelAccommodation != null) {
            //ExpensePaymentType info
            switch (travelAccommodation.getExpenseAccommodationPaymentType()) {
                case EMPLOYEE_EXPENSE:
                    data.getData().put("expenseTransPaymentExp", "true");
                    break;
                case PO:
                    data.getData().put("expenseTransPaymentPo", "true");
                    break;
                case PURCHASING_CARD:
                    data.getData().put("expenseTransPaymentPurchasingCard", "true");
                    break;
            }
            if (travelAccommodation.getLodgingCostPerNight() != null) {
                data.getData().put("lodgingCostPerNight", travelAccommodation.getLodgingCostPerNight().setScale(2, BigDecimal.ROUND_UP).toString());
            }
            if (travelAccommodation.getNumberOfLodgingNights() != null) {
                data.getData().put("numberOfLodgingNights", travelAccommodation.getNumberOfLodgingNights().setScale(2, BigDecimal.ROUND_UP).toString());
            }
            if (travelAccommodation.getTotalLodgingCost() != null) {
                data.getData().put("totalLodgingCost", travelAccommodation.getTotalLodgingCost().setScale(2, BigDecimal.ROUND_UP).toString());
            }
        }
        //TravelFood Information
        TravelFood travelFood = entity.getTravelFood();
        if (travelFood != null) {
            if (travelFood.getConferenceFee() != null) {
                data.getData().put("conferenceFee", travelFood.getConferenceFee().setScale(2, BigDecimal.ROUND_UP).toString());
            }
            if (travelFood.getOtherExpences() != null) {
                data.getData().put("otherExpences", travelFood.getOtherExpences().setScale(2, BigDecimal.ROUND_UP).toString());
            }
            if (travelFood.getTotalCostOfBanquet() != null) {
                data.getData().put("totalCostOfBanquet", travelFood.getTotalCostOfBanquet().setScale(2, BigDecimal.ROUND_UP).toString());
            }
            //ExpensePaymentType info
            if (travelFood.getFoodExpensePaymentMode() != null) {
                switch (travelFood.getFoodExpensePaymentMode()) {
                    case EMPLOYEE_EXPENSE:
                        data.getData().put("expenseTransPaymentExp", "true");
                        break;
                    case PO:
                        data.getData().put("expenseTransPaymentPo", "true");
                        break;
                    case PURCHASING_CARD:
                        data.getData().put("expenseTransPaymentPurchasingCard", "true");
                        break;
                }
            }
            if (travelFood.getConferenceExpensePaymentMode() != null) {
                switch (travelFood.getConferenceExpensePaymentMode()) {
                    case EMPLOYEE_EXPENSE:
                        data.getData().put("expenseTransPaymentExp", "true");
                        break;
                    case PO:
                        data.getData().put("expenseTransPaymentPo", "true");
                        break;
                    case PURCHASING_CARD:
                        data.getData().put("expenseTransPaymentPurchasingCard", "true");
                        break;
                }
            }
            if (travelFood.getBanquetExpensePaymentMode() != null) {
                switch (travelFood.getBanquetExpensePaymentMode()) {
                    case EMPLOYEE_EXPENSE:
                        data.getData().put("expenseTransPaymentExp", "true");
                        break;
                    case PO:
                        data.getData().put("expenseTransPaymentPo", "true");
                        break;
                    case PURCHASING_CARD:
                        data.getData().put("expenseTransPaymentPurchasingCard", "true");
                        break;
                }
            }
            if (travelFood.getOtherExpensePaymentMode() != null) {
                switch (travelFood.getOtherExpensePaymentMode()) {
                    case EMPLOYEE_EXPENSE:
                        data.getData().put("expenseTransPaymentExp", "true");
                        break;
                    case PO:
                        data.getData().put("expenseTransPaymentPo", "true");
                        break;
                    case PURCHASING_CARD:
                        data.getData().put("expenseTransPaymentPurchasingCard", "true");
                        break;
                }
            }
        }
        if (entity.getCeoApprovalBy() != null) {
            Employee approver = employeeDao.findEmployeWithEmpId(entity.getCeoApprovalBy());
            if (approver != null) {
                Signature approvedBysignature = new Signature(approver.getEmployeeId(), approver.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "approverSignature", DateUtils.dateToCalendar(entity.getCeoApprovalDate()), employeeDao.getPrimaryEmail(approver), null);
                data.getSignatures().add(approvedBysignature);
                data.getData().put("ceoApprovalDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getCeoApprovalDate()));
            }
        }
        if (entity.getManagerApprovalBy() != null) {
            Employee approver = employeeDao.findEmployeWithEmpId(entity.getManagerApprovalBy());
            if (approver != null) {
                Signature approvedBysignature = new Signature(approver.getEmployeeId(), approver.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "approverSignature", DateUtils.dateToCalendar(entity.getManaerApprovalDate()), employeeDao.getPrimaryEmail(approver), null);
                data.getSignatures().add(approvedBysignature);
                data.getData().put("manaerApprovalDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getManaerApprovalDate()));
            }
        }
        
        byte[] pdf = PDFUtils.generatePdf(data);
        return Response.ok(pdf)
                .header("content-disposition", "filename = travel-authorization.pdf")
                .header("Content-Length", pdf)
                .build();
    }
    
    public static TravelAuthorizationService instance() {
        return SpringContext.getBean(TravelAuthorizationService.class);
    }
}
