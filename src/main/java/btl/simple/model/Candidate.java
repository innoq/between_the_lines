package btl.simple.model;

import java.util.List;
import java.util.Objects;

public class Candidate {

    private String name;

    private String address;

    private String postalCode;

    private String location;

    private String state;

    private List<String> phoneNumber;

    private String mail;

    private String website;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(name, candidate.name) &&
                Objects.equals(address, candidate.address) &&
                Objects.equals(postalCode, candidate.postalCode) &&
                Objects.equals(location, candidate.location) &&
                Objects.equals(state, candidate.state) &&
                Objects.equals(phoneNumber, candidate.phoneNumber) &&
                Objects.equals(mail, candidate.mail) &&
                Objects.equals(website, candidate.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, postalCode, location, state, phoneNumber, mail, website);
    }

    @Override
    public String toString() {
        return "Candidate{" +
            "name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", postalCode='" + postalCode + '\'' +
            ", location='" + location + '\'' +
            ", state='" + state + '\'' +
            ", phoneNumber=" + phoneNumber +
            ", mail='" + mail + '\'' +
            ", website='" + website + '\'' +
            '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
