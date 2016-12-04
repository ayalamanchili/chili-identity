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
import info.yalamanchili.office.entity.immigration.EducationRecord;
import info.yalamanchili.office.entity.immigration.OtherNamesInfo;
import info.yalamanchili.office.entity.immigration.Passport;
import info.yalamanchili.office.entity.immigration.USEducationRecord;
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
}
