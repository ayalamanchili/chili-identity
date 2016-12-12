/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.expense.travelauthorization;

import com.google.common.base.Strings;
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
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.Company;
import static info.yalamanchili.office.entity.expense.travelauthorization.ExpensePaymentType.EMPLOYEE_EXPENSE;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelAccommodation;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelAuthorization;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelAuthorizationStatus;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelFood;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelRentalVehicleJustification;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelRentalVehicleType;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelTransportation;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelTransportationType;
import static info.yalamanchili.office.entity.expense.travelauthorization.TravelTransportationType.OTHER;
import static info.yalamanchili.office.entity.expense.travelauthorization.TravelTransportationType.RAILWAY;
import info.yalamanchili.office.entity.ext.Comment;
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
        String notes = entity.getAdditionalComments();
        entity = travelAuthorizationDao.save(entity);
        CommentDao.instance().addComment(notes, entity);
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
        Employee emp = entity.getEmployee();
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
        data.getData().put("travelOrigin", entity.getTravelOrigin());
        if (entity.getTotalEstimatedTripExpences() != null) {
            data.getData().put("totalEstimatedTripExpences", entity.getTotalEstimatedTripExpences().setScale(2, BigDecimal.ROUND_UP).toString());
        }
        Signature preparedBysignature = new Signature(preparedBy.getEmployeeId(), preparedBy.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "employeeSignature", DateUtils.dateToCalendar(entity.getDateRequested()), employeeDao.getPrimaryEmail(preparedBy), null);
        data.getSignatures().add(preparedBysignature);
        data.getData().put("dateRequested", new SimpleDateFormat("MM-dd-yyyy").format(entity.getDateRequested()));

////        Travel type Information
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
            if (travelTransportation.getTravelTransportationType() != null) {
                switch (travelTransportation.getTravelTransportationType()) {
                    case AIR:
                        data.getData().put("travelTransportationTypeAir", "true");
                        break;
                    case BUS:
                        data.getData().put("travelTransportationTypeBus", "true");
                        break;
                    case RAILWAY:
                        data.getData().put("travelTransportationTypeRailway", "true");
                        break;
                    case OTHER:
                        data.getData().put("travelTransportationTypeOther", "true");
                        break;
                    case COMPANY_VEHICLE:
                        data.getData().put("travelTransportationTypeCompany", "true");
                        break;
                    case PRIVATE_VEHICLE:
                        data.getData().put("travelTransportationTypePrivate", "true");
                        break;
                    case RENTAL_VEHICLE:
                        data.getData().put("travelTransportationTypeRental", "true");
                        break;
                }
            }
            if (travelTransportation.getExpensePaymentType() != null) {
                switch (travelTransportation.getExpensePaymentType()) {
                    case EMPLOYEE_EXPENSE:
                        data.getData().put("travelTransportationPaymentType-EE", "true");
                        break;
                    case PURCHASING_CARD:
                        data.getData().put("travelTransportationPaymentType-PC", "true");
                        break;
                    case PO:
                        data.getData().put("travelTransportationPaymentType-PO", "true");
                        break;

                }
            }
            if (entity.getTravelTransportation().getTravelTransportationType() != null) {
                if (entity.getTravelTransportation().getTravelTransportationType().equals(TravelTransportationType.AIR)) {
                    if (travelTransportation.getTotalTransportationCost() != null) {
                        data.getData().put("totalTransportationCost", travelTransportation.getTotalTransportationCost().setScale(2, BigDecimal.ROUND_UP).toString());
                    }
                }
                if (entity.getTravelTransportation().getTravelTransportationType().equals(TravelTransportationType.BUS)) {
                    if (travelTransportation.getTotalTransportationCost() != null) {
                        data.getData().put("totalTransportationCost", travelTransportation.getTotalTransportationCost().setScale(2, BigDecimal.ROUND_UP).toString());
                    }
                }
                if (entity.getTravelTransportation().getTravelTransportationType().equals(TravelTransportationType.RAILWAY)) {
                    if (travelTransportation.getTotalTransportationCost() != null) {
                        data.getData().put("totalTransportationCost", travelTransportation.getTotalTransportationCost().setScale(2, BigDecimal.ROUND_UP).toString());
                    }
                }
                if (entity.getTravelTransportation().getTravelTransportationType().equals(TravelTransportationType.OTHER)) {
                    if (travelTransportation.getTotalTransportationCost() != null) {
                        data.getData().put("totalTransportationCost", travelTransportation.getTotalTransportationCost().setScale(2, BigDecimal.ROUND_UP).toString());
                    }
                }
                if (entity.getTravelTransportation().getTravelTransportationType().equals(TravelTransportationType.COMPANY_VEHICLE)) {
                    if (travelTransportation.getCostPerMile() != null) {
                        data.getData().put("companyVehicleCostPerMile", travelTransportation.getCostPerMile().setScale(2, BigDecimal.ROUND_UP).toString());
                    }
                    if (travelTransportation.getTotalMiles() != null) {
                        data.getData().put("companyVehicleMiles", travelTransportation.getTotalMiles().setScale(2, BigDecimal.ROUND_UP).toString());
                    }
                    if (travelTransportation.getTotalTransportationCost() != null) {
                        data.getData().put("totalTransportationCostCompanyVehicle", travelTransportation.getTotalTransportationCost().setScale(2, BigDecimal.ROUND_UP).toString());
                    }
                }
                if (entity.getTravelTransportation().getTravelTransportationType().equals(TravelTransportationType.PRIVATE_VEHICLE)) {
                    if (travelTransportation.getCostPerMile() != null) {
                        data.getData().put("privateVehicleMiles", travelTransportation.getCostPerMile().setScale(2, BigDecimal.ROUND_UP).toString());
                    }
                    if (travelTransportation.getTotalMiles() != null) {
                        data.getData().put("privateVehicleCostPerMile", travelTransportation.getTotalMiles().setScale(2, BigDecimal.ROUND_UP).toString());
                    }
                    if (travelTransportation.getTotalTransportationCost() != null) {
                        data.getData().put("totalTransportationCostPrivateVehicle", travelTransportation.getTotalTransportationCost().setScale(2, BigDecimal.ROUND_UP).toString());
                    }
                    if (travelTransportation.getExpensePaymentType() != null) {
                        switch (travelTransportation.getExpensePaymentType()) {
                            case EMPLOYEE_EXPENSE:
                                data.getData().put("rentalVehiclePaymentType-EE", "true");
                                break;
                            case PURCHASING_CARD:
                                data.getData().put("rentalVehiclePaymentType-PC", "true");
                                break;
                            case PO:
                                data.getData().put("rentalVehiclePaymentType-PO", "true");
                                break;
                        }
                    }
                }
            }
            if (travelTransportation.getTravelRentalVehicleJustification() != null) {
                //TravelRentalVehicleJustification Information
                TravelRentalVehicleJustification justification = travelTransportation.getTravelRentalVehicleJustification();
                if (!Strings.isNullOrEmpty(justification.getRentalVehicleJustification())) {
                    data.getData().put("rentalVehicleJustification", justification.getRentalVehicleJustification());
                }
                if (justification.getTravelRentalVehicleType() != null) {
                    if (justification.getTravelRentalVehicleType().equals(TravelRentalVehicleType.OTHER)) {
                        data.getData().put("otherVehicleTypeJustification", justification.getOtherVehicleTypeJustification());
                    }
                }
                if (justification.getEstimatedCostOfOtherTransportation() != null) {
                    data.getData().put("estimatedCostOfOtherTransportation", justification.getEstimatedCostOfOtherTransportation().setScale(2, BigDecimal.ROUND_UP).toString());
                }
                if (travelTransportation.getTotalTransportationCost() != null) {
                    if (travelTransportation.getTotalTransportationCost().equals(TravelTransportationType.PRIVATE_VEHICLE)) {
                        data.getData().put("totalTransportationCostRentalVehicle", travelTransportation.getTotalTransportationCost().setScale(2, BigDecimal.ROUND_UP).toString());
                    }
                }
                //TravelRentalVehicleType info
                if (justification.getExpenseRentalPaymentType() != null) {
                    switch (justification.getExpenseRentalPaymentType()) {
                        case EMPLOYEE_EXPENSE:
                            data.getData().put("rentalVehiclePaymentType-EE", "true");
                            break;
                        case PURCHASING_CARD:
                            data.getData().put("rentalVehiclePaymentType-PC", "true");
                            break;
                        case PO:
                            data.getData().put("rentalVehiclePaymentType-PO", "true");
                            break;
                    }
                }
                //TravelRentalVehicleType info
                if (justification.getTravelRentalVehicleType() != null) {
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
        }
        //TravelAccommodation Information
        TravelAccommodation travelAccommodation = entity.getTravelAccommodation();
        if (travelAccommodation != null) {
            //ExpensePaymentType info
            if (travelAccommodation.getExpenseAccommodationPaymentType() != null) {
                switch (travelAccommodation.getExpenseAccommodationPaymentType()) {
                    case EMPLOYEE_EXPENSE:
                        data.getData().put("accommodationPaymentType-EE", "true");
                        break;
                    case PO:
                        data.getData().put("accommodationPaymentType-PO", "true");
                        break;
                    case PURCHASING_CARD:
                        data.getData().put("accommodationPaymentType-PC", "true");
                        break;
                }
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
            if (travelFood.getTotalCostOfFood() != null) {
                data.getData().put("totalCostOfFood", travelFood.getTotalCostOfFood().setScale(2, BigDecimal.ROUND_UP).toString());
            }
            //ExpensePaymentType info
            if (travelFood.getFoodExpensePaymentMode() != null) {
                switch (travelFood.getFoodExpensePaymentMode()) {
                    case EMPLOYEE_EXPENSE:
                        data.getData().put("travelFoodexpenseTransPaymentExp", "true");
                        break;
                }
            }
            if (travelFood.getConferenceExpensePaymentMode() != null) {
                switch (travelFood.getConferenceExpensePaymentMode()) {
                    case EMPLOYEE_EXPENSE:
                        data.getData().put("conferencePaymentType-EE", "true");
                        break;
                    case PO:
                        data.getData().put("conferencePaymentType-PO", "true");
                        break;
                    case PURCHASING_CARD:
                        data.getData().put("conferencePaymentType-PC", "true");
                        break;
                }
            }
            if (travelFood.getBanquetExpensePaymentMode() != null) {
                switch (travelFood.getBanquetExpensePaymentMode()) {
                    case EMPLOYEE_EXPENSE:
                        data.getData().put("banquetExpensePaymentType-EE", "true");
                        break;
                    case PO:
                        data.getData().put("banquetExpensePaymentType-PO", "true");
                        break;
                    case PURCHASING_CARD:
                        data.getData().put("banquetExpensePaymentType-PC", "true");
                        break;
                }
            }
            if (travelFood.getOtherExpensePaymentMode() != null) {
                switch (travelFood.getOtherExpensePaymentMode()) {
                    case EMPLOYEE_EXPENSE:
                        data.getData().put("foodOtherExpensePaymentType-EE", "true");
                        break;
                    case PO:
                        data.getData().put("foodOtherExpensePaymentType-PO", "true");
                        break;
                    case PURCHASING_CARD:
                        data.getData().put("foodOtherExpensePaymentType-PC", "true");
                        break;
                }
            }
        }
        List<Comment> cmnts = CommentDao.instance().findAll(entity.getId(), entity.getClass().getCanonicalName());
        if (cmnts.size() > 0) {
            Comment additionalCmt = cmnts.get(0);
            data.getData().put("additionalComments", additionalCmt.getComment());
        }
        if (entity.getManagerApprovalBy() != null) {
            Employee manager = employeeDao.findEmployeWithEmpId(entity.getManagerApprovalBy());
            if (manager != null) {
                Signature approvedBysignature = new Signature(manager.getEmployeeId(), manager.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "managerApprovalBy", DateUtils.dateToCalendar(entity.getManaerApprovalDate()), employeeDao.getPrimaryEmail(manager), null);
                data.getSignatures().add(approvedBysignature);
                data.getData().put("managerapprovalDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getManaerApprovalDate()));
            }
        }
        if (entity.getCeoApprovalBy() != null) {
            Employee ceo = employeeDao.findEmployeWithEmpId(entity.getCeoApprovalBy());
            if (ceo != null) {
                Signature approvedsignature = new Signature(ceo.getEmployeeId(), ceo.getEmployeeId(), securityConfiguration.getKeyStorePassword(), true, "ceoApprovalBy", DateUtils.dateToCalendar(entity.getCeoApprovalDate()), employeeDao.getPrimaryEmail(ceo), null);
                data.getSignatures().add(approvedsignature);
                data.getData().put("ceoApprovalDate", new SimpleDateFormat("MM-dd-yyyy").format(entity.getCeoApprovalDate()));
            }
        }
        String empCompanyLogo = "";
        if (emp.getCompany() != null) {
            empCompanyLogo = emp.getCompany().getLogoURL().replace("entityId", emp.getCompany().getId().toString());
        } else {
            Company company = CompanyDao.instance().findByCompanyName(Company.SSTECH_LLC);
            empCompanyLogo = company.getLogoURL().replace("entityId", company.getId().toString());
        }
        byte[] pdf = PDFUtils.generatePdf(data, empCompanyLogo);
        return Response.ok(pdf)
                .header("content-disposition", "filename = Travel-Authorization.pdf")
                .header("Content-Length", pdf.length)
                .build();
    }

    public static TravelAuthorizationService instance() {
        return SpringContext.getBean(TravelAuthorizationService.class);
    }
}
