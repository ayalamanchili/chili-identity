/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.expense.chkreq;

import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.expense.CheckRequisitionItem;
import info.yalamanchili.office.entity.expense.ImmigrationCheckRequisition;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
@XmlType
public class ImmigrationCheckRequisitionSaveDto extends ImmigrationCheckRequisition {

    protected List<CheckRequisitionItem> items;

    protected Company company;

    @XmlElement
    @Override
    @Size(min = 1, message = "{checkitem.min.size.msg}")
    @Valid
    public List<CheckRequisitionItem> getItems() {
        if (this.items == null) {
            this.items = new ArrayList();
        }
        return items;
    }

    @Override
    public void setItems(List<CheckRequisitionItem> items) {
        this.items = items;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
