/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox;

/**
 *
 * @author ayalamanchili
 */
public class ADPEmployeeRecord {

    protected String firstName;
    protected String lastName;
    protected String ssn;
    protected String email;
    protected String status;
    protected String celluar;
    protected String phone;
    protected String dob;
    protected String street1;
    protected String street2;
    protected String city;
    protected String state;
    protected String zip;

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

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCelluar() {
        return celluar;
    }

    public void setCelluar(String celluar) {
        this.celluar = celluar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "ADPEmployeeRecord{" + "firstName=" + firstName + ", lastName=" + lastName + ", ssn=" + ssn + ", email=" + email + ", status=" + status + ", celluar=" + celluar + ", phone=" + phone + ", dob=" + dob + ", street1=" + street1 + ", street2=" + street2 + ", city=" + city + ", state=" + state + ", zip=" + zip + '}';
    }
}
