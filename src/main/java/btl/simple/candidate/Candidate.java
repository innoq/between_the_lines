package btl.simple.candidate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

@Entity(name = "candidate")
public class Candidate {

    @Id
    private long id;

    private String name;

    private String address;

    private String postalCode;

    private String location;

    private String state;

    private String phoneNumbers;

    private String mail;

    private String website;

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", location='" + location + '\'' +
                ", state='" + state + '\'' +
                ", phoneNumbers='" + phoneNumbers + '\'' +
                ", mail='" + mail + '\'' +
                ", website='" + website + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return id == candidate.id &&
                Objects.equals(name, candidate.name) &&
                Objects.equals(address, candidate.address) &&
                Objects.equals(postalCode, candidate.postalCode) &&
                Objects.equals(location, candidate.location) &&
                Objects.equals(state, candidate.state) &&
                Objects.equals(phoneNumbers, candidate.phoneNumbers) &&
                Objects.equals(mail, candidate.mail) &&
                Objects.equals(website, candidate.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, postalCode, location, state, phoneNumbers, mail, website);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
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
