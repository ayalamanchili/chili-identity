/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.expense;

import info.chili.jpa.AbstractEntity;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

/**
 *
 * @author Madhu.Badiginchala
 */
@Entity
@Audited
@XmlRootElement
@XmlType
public class CheckRequisitionItem extends AbstractEntity {

    private static long serialVersionUID = 1L;
    /**
     *
     */
    @NotNull(message = "{itemName.not.empty.msg}")
    private String itemName;
    /**
     *
     */
    @NotNull(message = "{itemDesc.not.empty.msg}")
    private String itemDesc;
    /**
     *
     */
    @NotNull(message = "{itemAmount.not.empty.msg}")
    @Min(1)
    private BigDecimal amount;

    @ManyToOne
    @ForeignKey(name = "FK_IMMG_CHK_REQ_ITMS")
    protected ImmigrationCheckRequisition immigrationCheckRequisition;

    /**
     * GETTERS & SETTERS
     */
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public ImmigrationCheckRequisition getImmigrationCheckRequisition() {
        return immigrationCheckRequisition;
    }

    @XmlTransient
    public void setImmigrationCheckRequisition(ImmigrationCheckRequisition immigrationCheckRequisition) {
        this.immigrationCheckRequisition = immigrationCheckRequisition;
    }

    @Override
    public String toString() {
        return "CheckRequisitionItem{" + "itemName=" + itemName + ", itemDesc=" + itemDesc + ", amount=" + amount + '}';
    }

}
