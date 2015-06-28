/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.expense.travelauthorization;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
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
public class TravelAuthorization extends AbstractEntity {

    private static long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    /**
     *
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{travel.expense.requisition.type.not.empty.msg}")
    protected TravelType travelType;
    /**
     *
     *
     */
    @ManyToOne
    @ForeignKey(name = "FK_Emp_TravelAuths")
    protected Employee employee;
    /**
     *
     *
     */
    protected String department;
    /**
     *
     *
     */
    protected String phoneNumber;
    /**
     *
     *
     */
    @NotNull(message = "{travel.destination.not.empty.msg}")
    protected String travelDestination;
    /**
     *
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date departureDate;
    /**
     *
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date returnDate;
    /**
     *
     *
     */
    @Lob
    protected String reasonForTravel;
    /**
     *
     *
     */
    @Embedded
    protected TravelTransportation travelTransportation;
    /**
     *
     *
     */
    @Embedded
    protected TravelAccommodation travelAccommodation;
    /**
     *
     *
     */
    @Embedded
    protected TravelFood travelFood;
    /**
     *
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    protected TravelAuthorizationStatus travelExpenseRequisitionStatus;
    /**
     *
     *
     */
    protected String bpmProcessId;
    /**
     *
     */
    protected String managerApprovalBy;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date manaerApprovalDate;
    /**
     *
     */
    protected String ceoApprovalBy;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date ceoApprovalDate;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date dateRequested;

    /**
     *
     */
    public TravelAuthorization() {
    }

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

    public TravelAuthorizationStatus getTravelExpenseRequisitionStatus() {
        return travelExpenseRequisitionStatus;
    }

    public void setTravelExpenseRequisitionStatus(TravelAuthorizationStatus travelExpenseRequisitionStatus) {
        this.travelExpenseRequisitionStatus = travelExpenseRequisitionStatus;
    }

    /**
     * @return the bpmProcessId
     */
    public String getBpmProcessId() {
        return bpmProcessId;
    }

    /**
     * @param bpmProcessId the bpmProcessId to set
     */
    public void setBpmProcessId(String bpmProcessId) {
        this.bpmProcessId = bpmProcessId;
    }

    /**
     * @return the approvedBy
     */
    public String getManagerApprovalBy() {
        return managerApprovalBy;
    }

    /**
     * @param managerApprovalBy the approvedBy to set
     */
    public void setManagerApprovalBy(String managerApprovalBy) {
        this.managerApprovalBy = managerApprovalBy;
    }

    /**
     * @return the manaerApprovalDate
     */
    public Date getManaerApprovalDate() {
        return manaerApprovalDate;
    }

    /**
     * @param manaerApprovalDate the manaerApprovalDate to set
     */
    public void setManaerApprovalDate(Date manaerApprovalDate) {
        this.manaerApprovalDate = manaerApprovalDate;
    }

    public String getCeoApprovalBy() {
        return ceoApprovalBy;
    }

    public void setCeoApprovalBy(String ceoApprovalBy) {
        this.ceoApprovalBy = ceoApprovalBy;
    }

    public Date getCeoApprovalDate() {
        return ceoApprovalDate;
    }

    public void setCeoApprovalDate(Date ceoApprovalDate) {
        this.ceoApprovalDate = ceoApprovalDate;
    }

    /**
     * @return the dateRequested
     */
    public Date getDateRequested() {
        return dateRequested;
    }

    /**
     * @param dateRequested the dateRequested to set
     */
    public void setDateRequested(Date dateRequested) {
        this.dateRequested = dateRequested;
    }

    @Override
    public String toString() {
        return "TravelExpenseRequisition{" + "travelType=" + travelType + ", employee=" + employee + ", department=" + department + ", phoneNumber=" + phoneNumber + ", travelDestination=" + travelDestination + ", departureDate=" + departureDate + ", returnDate=" + returnDate + ", reasonForTravel=" + reasonForTravel + ", travelTransportation=" + travelTransportation + ", travelAccommodation=" + travelAccommodation + ", travelFood=" + travelFood + ", travelExpenseRequisitionStatus=" + travelExpenseRequisitionStatus + '}';
    }
}
