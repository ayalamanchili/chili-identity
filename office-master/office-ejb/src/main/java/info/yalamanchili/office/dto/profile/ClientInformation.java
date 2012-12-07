package info.yalamanchili.office.dto.profile;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.entity.profile.Sex;
import java.io.Serializable;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author yalamanchili
 */
@XmlRootElement
@XmlType
public class ClientInformation implements Serializable {

    protected Long id;
    @NotEmpty(message = "{firstName.not.empty.msg}")
    protected String firstName;
    @NotEmpty(message = "{lastName.not.empty.msg}")
    protected String lastName;
    protected String middleInitial;
    protected Sex sex;
    protected String reportsToRole;
    protected String consultantJobTitle;
    protected boolean rtPrimary;
    @org.hibernate.validator.constraints.Email(message = "Enter a valid email address ")
    @NotEmpty(message = "{clientinformation.email.not.empty.msg}")
    protected String email;
    @Size(min = 10, max = 10, message = "{clientinformation.phoneNumber.length.invalid.msg}")
    @NotEmpty(message = "{clientinformation.phoneNumber.not.empty.msg}")
    protected String phoneNumber;
    @Size(min = 0, max = 4, message = "{clientinformation.extension.length.invalid.msg}")
    protected String extension;
    @Size(min = 0, max = 4, message = "{clientinformation.countryCode.length.invalid.msg}")
    protected String countryCode;

    public ClientInformation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "ClientInformation{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleInitial=" + middleInitial + ", sex=" + sex + ", reportsToRole=" + reportsToRole + ", consultantJobTitle=" + consultantJobTitle + ", rtPrimary=" + rtPrimary + ", extension=" + extension + ", phoneNumber=" + phoneNumber + ", email=" + email + ", countryCode=" + countryCode + '}';
    }

    //TODO move this to seperate class?
    public static ClientInformation map(Mapper mapper, info.yalamanchili.office.entity.profile.ClientInformation entity) {
        ClientInformation reportsTo = mapper.map(entity, ClientInformation.class);
        mapper.map(entity.getContact(), reportsTo);
        if (entity.getContact().getPhones().size() > 0) {
            Phone phone = entity.getContact().getPhones().get(0);
            mapper.map(phone, reportsTo);
            mapper.map(entity.getContact().getPhones().get(0), reportsTo);
        }
        if (entity.getContact().getPrimaryEmail() != null) {
            mapper.map(entity.getContact().getPrimaryEmail(), reportsTo);
        }
        reportsTo.setId(entity.getId());
        return reportsTo;
    }
}
