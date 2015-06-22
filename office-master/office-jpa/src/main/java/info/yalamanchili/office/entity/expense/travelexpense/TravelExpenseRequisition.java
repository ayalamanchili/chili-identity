/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.expense.travelexpense;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;

/**
 *
 * @author Madhu.Badiginchala
 */
@Entity
@Audited
@XmlRootElement
@XmlType
public class TravelExpenseRequisition extends AbstractEntity {
    
    private static long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{travel.expense.requisition.type.not.empty.msg}")
    private TravelType travelType;
    
    @NotNull(message = "{travel.expense.requisition.employee.not.empty.msg}")
    private Employee employee;
    
    private String department;
    private String phoneNumber;
    private String travelDestination;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date departureDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date returnDate;
    @Lob
    private String reasonForTravel;
    
    private TravelTransportation travelTransportation;
    
    private TravelAccommodation travelAccommodation;
    
    private TravelFood travelFood;
    
    @Enumerated(EnumType.STRING)
    @Field
    private TravelExpenseRequisitionStatus travelExpenseRequisitionStatus;

    public TravelType getTravelType() {
        return travelType;
    }

    public void setTravelType(TravelType travelType) {
        this.travelType = travelType;
    }



    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTravelDestination() {
        return travelDestination;
    }

    public void setTravelDestination(String travelDestination) {
        this.travelDestination = travelDestination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getReasonForTravel() {
        return reasonForTravel;
    }

    public void setReasonForTravel(String reasonForTravel) {
        this.reasonForTravel = reasonForTravel;
    }

    public TravelTransportation getTravelTransportation() {
        return travelTransportation;
    }

    public void setTravelTransportation(TravelTransportation travelTransportation) {
        this.travelTransportation = travelTransportation;
    }

    public TravelAccommodation getTravelAccommodation() {
        return travelAccommodation;
    }

    public void setTravelAccommodation(TravelAccommodation travelAccommodation) {
        this.travelAccommodation = travelAccommodation;
    }

    public TravelFood getTravelFood() {
        return travelFood;
    }

    public void setTravelFood(TravelFood travelFood) {
        this.travelFood = travelFood;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public TravelExpenseRequisitionStatus getTravelExpenseRequisitionStatus() {
        return travelExpenseRequisitionStatus;
    }

    public void setTravelExpenseRequisitionStatus(TravelExpenseRequisitionStatus travelExpenseRequisitionStatus) {
        this.travelExpenseRequisitionStatus = travelExpenseRequisitionStatus;
    }
    
}
