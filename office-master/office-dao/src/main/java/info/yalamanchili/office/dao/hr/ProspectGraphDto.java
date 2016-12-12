/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.hr;

import info.yalamanchili.office.entity.hr.PetitionFor;
import info.yalamanchili.office.entity.hr.PlacedBy;
import info.yalamanchili.office.entity.hr.TransferEmployeeType;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
@XmlType
public class ProspectGraphDto {

    protected Map<PetitionFor, Integer> petetionFor;
    protected Map<TransferEmployeeType, Integer> transferType;
    protected Map<PlacedBy, Integer> placedBy;

    public ProspectGraphDto() {
    }

    public Map<PetitionFor, Integer> getPetetionFor() {
        if (petetionFor == null) {
            this.petetionFor = new HashMap<>();
        }
        return petetionFor;
    }

    public void setPetetionFor(Map<PetitionFor, Integer> petetionFor) {
        this.petetionFor = petetionFor;
    }

    public Map<TransferEmployeeType, Integer> getTransferType() {
        if (transferType == null) {
            this.transferType = new HashMap<>();
        }
        return transferType;
    }

    public void setTransferType(Map<TransferEmployeeType, Integer> transferType) {
        this.transferType = transferType;
    }

    public Map<PlacedBy, Integer> getPlacedBy() {
        if (placedBy == null) {
            this.placedBy = new HashMap<>();
        }
        return placedBy;
    }

    public void setPlacedBy(Map<PlacedBy, Integer> placedBy) {
        this.placedBy = placedBy;
    }

}
