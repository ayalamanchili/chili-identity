/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.expense.expenserpt;

import info.chili.jpa.AbstractEntity;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Field;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Prasanthi.p
 */
@Entity
@Audited
@XmlRootElement
@XmlType
public class ExpenseItem extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    /*
     *
     */
    @Temporal(TemporalType.DATE)
    @NotNull(message = "{expenseitem.expenseDate.not.empty.msg}")
    private Date expenseDate;
    /*
     *
     */
    @Lob
    private String description;
    /*
     *
     */
    @Lob
    @NotEmpty(message = "{expenseitem.purpose.not.empty.msg}")
    private String purpose;
    /*
     *
     */
    @NotNull(message = "{expenseitem.amount.not.empty.msg}")
    @Min(1)
    private BigDecimal amount;
    /*
     *
     */
    @Min(2)
    protected BigDecimal expenseMiles;
    /*
     *
     */
    @Lob
    private String remark;
    /*
     *
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Expenses_Category")
    @NotNull(message = "{category.not.empty.msg}")
    private ExpenseCategory category;
    /*
     *
     */
    @Enumerated(EnumType.STRING)
    @Field
    @NotNull(message = "{expenseitem.paymentmode.not.empty.msg}")
    private ExpensePaymentMode expensePaymentMode;
    /**
     *
     * @return
     */
    @ManyToOne
    @ForeignKey(name = "FK_EXP_RPT_ITMS")
    protected ExpenseReport expenseReport;
    /*
     *   GETTERS and SETTERS
     */

    public Date getExpenseDate() {
        return expenseDate;
    }
    /*
     *
     */

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }
    /*
     *
     */

    public String getDescription() {
        return description;
    }
    /*
     *
     */

    public void setDescription(String description) {
        this.description = description;
    }
    /*
     *
     */

    public String getPurpose() {
        return purpose;
    }
    /*
     *
     */

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    /*
     *
     */

    public BigDecimal getAmount() {
        return amount;
    }
    /*
     *
     */

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    /*
     *
     */

    public String getRemark() {
        return remark;
    }
    /*
     *
     */

    public void setRemark(String remark) {
        this.remark = remark;
    }
    /*
     *
     */

    @XmlElement
    public ExpenseCategory getCategory() {
        return category;
    }
    /*
     *
     */

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }
    /*
     *
     */

    public ExpensePaymentMode getExpensePaymentMode() {
        return expensePaymentMode;
    }
    /*
     *
     */

    public void setExpensePaymentMode(ExpensePaymentMode expensePaymentMode) {
        this.expensePaymentMode = expensePaymentMode;
    }

    @XmlTransient
    public ExpenseReport getExpenseReport() {
        return expenseReport;
    }

    public void setExpenseReport(ExpenseReport expenseReport) {
        this.expenseReport = expenseReport;
    }
    /*
     *
     */
    public BigDecimal getExpenseMiles() {
        return expenseMiles;
    }

    public void setExpenseMiles(BigDecimal expenseMiles) {
        this.expenseMiles = expenseMiles;
    }
}
