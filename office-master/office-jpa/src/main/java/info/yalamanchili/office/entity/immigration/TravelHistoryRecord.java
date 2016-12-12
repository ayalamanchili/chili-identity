/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.immigration;

import info.chili.jpa.AbstractHandleEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author prasanthi.p
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class TravelHistoryRecord extends AbstractHandleEntity {

    private static final long serialVersionUID = 11L;
    @NotEmpty(message = "{typeOfVisa.not.empty.msg}")
    protected String typeOfVisa;

    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{arrivalDate.not.empty.msg}")
    protected Date arrivalDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{departureDate.not.empty.msg}")
    protected Date departureDate;

    public String getTypeOfVisa() {
        return typeOfVisa;
    }

    public void setTypeOfVisa(String typeOfVisa) {
        this.typeOfVisa = typeOfVisa;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public String toString() {
        return "TravelHistroyFrom{" + "typeOfVisa=" + typeOfVisa + ", arrivalDate=" + arrivalDate + ", departureDate=" + departureDate + '}';
    }
}
