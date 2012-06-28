package info.yalamanchili.office.dto.profile;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;

/**
 *
 * @author yalamanchili
 */
@XmlRootElement
@XmlType
public class ClientInformation {

    protected String firstName;
    protected String lastName;
    protected String middleInitial;
    protected String reportsToRole;
    protected String consultantJobTitle;
    protected boolean rtPrimary;
    protected String email;
    protected String phoneNumber;

    public ClientInformation() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
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

    public boolean isRtPrimary() {
        return rtPrimary;
    }

    public void setRtPrimary(boolean rtPrimary) {
        this.rtPrimary = rtPrimary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ClientInformation{" + "firstName=" + firstName + ", lastName=" + lastName + ", middleInitial=" + middleInitial + ", reportsToRole=" + reportsToRole + ", consultantJobTitle=" + consultantJobTitle + ", rtPrimary=" + rtPrimary + ", email=" + email + ", phoneNumber=" + phoneNumber + '}';
    }

    //TODO move this to seperate class?
    public static ClientInformation map(Mapper mapper, info.yalamanchili.office.entity.profile.ClientInformation entity) {
        ClientInformation reportsTo = mapper.map(entity, ClientInformation.class);
        mapper.map(entity.getContact(), reportsTo);
        if (entity.getContact().getPhones().size() > 0) {
            mapper.map(entity.getContact().getPhones().get(0), reportsTo);
        }
        if (entity.getContact().getPrimaryEmail() != null) {
            mapper.map(entity.getContact().getPrimaryEmail(), reportsTo);
        }
        return reportsTo;
    }
}
