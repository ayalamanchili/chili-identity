/**
 * Automanage Copyright (C) 2011 yalamanchili.info
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class ClientInformation extends AbstractEntity {

    @Transient
    private static final long serialVersionUID = 11L;
    @Field
    protected String reportsToRole;
    @Field
    protected String consultantJobTitle;
    @Field(index = Index.UN_TOKENIZED)
    protected Boolean rtPrimary;
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Employee_ClientInformations")
    protected Employee employee;
    @ManyToOne(cascade = CascadeType.ALL)
    @ForeignKey(name = "FK_Contact_ClientInformations")
    @Valid
    protected Contact contact;

    public ClientInformation() {
        super();
    }

    public String getReportsToRole() {
        return reportsToRole;
    }

    public void setReportsToRole(String reportsToRole) {
        this.reportsToRole = reportsToRole;
    }

    public String getConsultantJobTitle() {
        return consultantJobTitle;
    }

    public void setConsultantJobTitle(String consultantJobTitle) {
        this.consultantJobTitle = consultantJobTitle;
    }

    public Boolean getRtPrimary() {
        return rtPrimary;
    }

    public void setRtPrimary(Boolean rtPrimary) {
        this.rtPrimary = rtPrimary;
    }

    @XmlElement
    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @XmlElement
    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "ClientInformation{" + "reportsToRole=" + reportsToRole + ", consultantJobTitle=" + consultantJobTitle + ", rtPrimary=" + rtPrimary + '}';
    }
}
