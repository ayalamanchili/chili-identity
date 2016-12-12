/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.immigration;

import info.yalamanchili.office.entity.hr.ProspectStatus;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author prasanthi.p
 */
@XmlRootElement
@XmlType
public class LCAReportDto {

    protected ProspectStatus status;

    public ProspectStatus getStatus() {
        return status;
    }

    public void setStatus(ProspectStatus status) {
        this.status = status;
    }

}
