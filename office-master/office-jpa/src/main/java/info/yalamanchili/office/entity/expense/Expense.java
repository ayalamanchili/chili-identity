/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.expense;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.profile.Employee;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author raghu
 */
@Entity
@Audited
@XmlRootElement
@XmlType
public class Expense extends AbstractEntity {
    /*
     * 
     */

    @NotEmpty(message = "{expense.not.empty.msg}")
    protected String name;
    /*
     * 
     */
    protected String description;
    /*
     * 
     */
    @NotNull(message = "{amount.not.empty.msg}")
    protected BigDecimal amount;
    /*
     * 
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "{expenseDate.not.empty.msg}")
    protected Date expenseDate;
    /*
     * 
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Employee_Expenses")
    @NotNull(message = "{employee.not.empty.msg}")
    protected Employee employee;
    /*
     * 
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @NotNull(message = "{category.not.empty.msg}")
    protected ExpenseCategory category;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    @XmlElement
    public Employee getEmployee() {
        return employee;
    }

    @XmlElement
    public ExpenseCategory getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Expense{" + "name=" + name + ", description=" + description + ", amount=" + amount + ", expenseDate=" + expenseDate + ", employee=" + employee + ", category=" + category + '}';
    }
}
