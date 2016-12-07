/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.immigration;

import info.yalamanchili.office.entity.immigration.AlienNumber;
import info.yalamanchili.office.entity.immigration.ConsulateInfo;
import info.yalamanchili.office.entity.immigration.EducationRecord;
import info.yalamanchili.office.entity.immigration.ExperienceSummary;
import info.yalamanchili.office.entity.immigration.ImmigrationCaseAdditionalDetails;
import info.yalamanchili.office.entity.immigration.MiscellaneousInfo;
import info.yalamanchili.office.entity.immigration.OtherNamesInfo;
import info.yalamanchili.office.entity.immigration.Passport;
import info.yalamanchili.office.entity.immigration.StayPeriodInfo;
import info.yalamanchili.office.entity.immigration.USEducationRecord;
import info.yalamanchili.office.entity.immigration.i94Record;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author radhika.mukkala
 */
@XmlRootElement
@XmlType
public class EmployeeH1BDetailsDto implements Serializable {

    private PersonalInfoDto empPersonalInfo;

    private EducationRecord eduRecord;

    private OtherNamesInfo otherNamesInfo;

    private AlienNumber alienNumber;

    private USEducationRecord usEducRec;

    private EducationDto eduDto;

    private Passport passport;

    private String currentOccupation;

    private i94Record i94Info;

    private MiscellaneousInfo misceInfo;

    private ExperienceSummary expSummary;

    private ImmigrationCaseAdditionalDetails caseAddtnDetails;

    private ConsulateInfo consulateInfo;

    private StayPeriodInfo stayPeriodInfo;

    public PersonalInfoDto getEmpPersonalInfo() {
        return empPersonalInfo;
    }

    public void setEmpPersonalInfo(PersonalInfoDto empPersonalInfo) {
        this.empPersonalInfo = empPersonalInfo;
    }

    public EducationRecord getEduRecord() {
        return eduRecord;
    }

    public void setEduRecord(EducationRecord eduRecord) {
        this.eduRecord = eduRecord;
    }

    public OtherNamesInfo getOtherNamesInfo() {
        return otherNamesInfo;
    }

    public void setOtherNamesInfo(OtherNamesInfo otherNamesInfo) {
        this.otherNamesInfo = otherNamesInfo;
    }

    public AlienNumber getAlienNumber() {
        return alienNumber;
    }

    public void setAlienNumber(AlienNumber alienNumber) {
        this.alienNumber = alienNumber;
    }

    public USEducationRecord getUsEducRec() {
        return usEducRec;
    }

    public void setUsEducRec(USEducationRecord usEducRec) {
        this.usEducRec = usEducRec;
    }

    public EducationDto getEduDto() {
        return eduDto;
    }

    public void setEduDto(EducationDto eduDto) {
        this.eduDto = eduDto;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public String getCurrentOccupation() {
        return currentOccupation;
    }

    public void setCurrentOccupation(String currentOccupation) {
        this.currentOccupation = currentOccupation;
    }

    public i94Record getI94Info() {
        return i94Info;
    }

    public void setI94Info(i94Record i94Info) {
        this.i94Info = i94Info;
    }

    public MiscellaneousInfo getMisceInfo() {
        return misceInfo;
    }

    public void setMisceInfo(MiscellaneousInfo misceInfo) {
        this.misceInfo = misceInfo;
    }

    public ExperienceSummary getExpSummary() {
        return expSummary;
    }

    public void setExpSummary(ExperienceSummary expSummary) {
        this.expSummary = expSummary;
    }

    public ImmigrationCaseAdditionalDetails getCaseAddtnDetails() {
        return caseAddtnDetails;
    }

    public void setCaseAddtnDetails(ImmigrationCaseAdditionalDetails caseAddtnDetails) {
        this.caseAddtnDetails = caseAddtnDetails;
    }

    public ConsulateInfo getConsulateInfo() {
        return consulateInfo;
    }

    public void setConsulateInfo(ConsulateInfo consulateInfo) {
        this.consulateInfo = consulateInfo;
    }

    public StayPeriodInfo getStayPeriodInfo() {
        return stayPeriodInfo;
    }

    public void setStayPeriodInfo(StayPeriodInfo stayPeriodInfo) {
        this.stayPeriodInfo = stayPeriodInfo;
    }
}
