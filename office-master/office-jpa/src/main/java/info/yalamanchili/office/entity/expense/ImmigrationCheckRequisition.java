/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.expense;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.profile.Employee;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.envers.Audited;

/**
 *
 * @author Madhu.Badiginchala
 */
@Entity
@Audited
@XmlRootElement
@XmlType
public class ImmigrationCheckRequisition extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Date requestedDate;
    /**
     *
     */
    private Date neededByDate;
    /**
     *
     */
    private BigDecimal amount;
    /**
     *
     */
    private String mailingAddress;
    /**
     *
     */
    private String caseType;
    /**
     *
     */
    @Lob
    private String purpose;
    /**
     *
     */
    private String requestorName;
    /**
     *
     */
    private String hrName;
    /**
     *
     */
    private String approvedBy;
    /**
     *
     */
    private Date approvedDate;
    /**
     *
     */
    private String accountedBy;
    /**
     *
     */
    private Date checkIssuedDate;
    /**
     *
     */
    private Date accountDeptReceivedDate;
    /**
     *
     */
    @ManyToOne
    private Company company;
    /**
     *
     */
    @ManyToOne
    private Employee employee;
    /**
     *
     */
    @OneToMany
    private List<CheckRequisitionItem> items;

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public Date getNeededByDate() {
        return neededByDate;
    }

    public void setNeededByDate(Date neededByDate) {
        this.neededByDate = neededByDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getRequestorName() {
        return requestorName;
    }

    public void setRequestorName(String requestorName) {
        this.requestorName = requestorName;
    }

    public String getHrName() {
        return hrName;
    }

    public void setHrName(String hrName) {
        this.hrName = hrName;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getAccountedBy() {
        return accountedBy;
    }

    public void setAccountedBy(String accountedBy) {
        this.accountedBy = accountedBy;
    }

    public Date getCheckIssuedDate() {
        return checkIssuedDate;
    }

    public void setCheckIssuedDate(Date checkIssuedDate) {
        this.checkIssuedDate = checkIssuedDate;
    }

    public Date getAccountDeptReceivedDate() {
        return accountDeptReceivedDate;
    }

    public void setAccountDeptReceivedDate(Date accountDeptReceivedDate) {
        this.accountDeptReceivedDate = accountDeptReceivedDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<CheckRequisitionItem> getItems() {
        return items;
    }

    public void setItems(List<CheckRequisitionItem> items) {
        this.items = items;
    }
    
}
