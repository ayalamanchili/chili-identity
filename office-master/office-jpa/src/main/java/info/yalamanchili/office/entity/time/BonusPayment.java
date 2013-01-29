/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.time;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Employee;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;

/**
 *
 * @author raghu
 */
@Entity
@XmlRootElement
@XmlType
@Audited
public class BonusPayment extends AbstractEntity{
    
    protected BigDecimal paidRate;

    @NotNull(message = "{paidHours.not.empty.msg}")
    @Digits(integer = 3, fraction = 2, message = "{bonuspayment.hours.format.invalid.msg}")
    protected BigDecimal paidHours;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date paidDate;
    
    @Lob
    protected String paymentInfo;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @NotNull(message = "{employee.not.empty.msg}")
    protected Employee employee;
    
    public void setPaidRate(BigDecimal paidRate) {
        this.paidRate = paidRate;
    }

    public void setPaidHours(BigDecimal paidHours) {
        this.paidHours = paidHours;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public BigDecimal getPaidRate() {
        return paidRate;
    }

    public BigDecimal getPaidHours() {
        return paidHours;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public Employee getEmployee() {
        return employee;
    }
}
