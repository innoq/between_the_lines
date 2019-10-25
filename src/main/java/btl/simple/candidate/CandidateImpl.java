package btl.simple.candidate;

import com.google.common.base.Splitter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Entity(name = "candidate")
class CandidateImpl implements Candidate {

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

  @Transient
  private String webcontent;

  @Transient
  private Scraper scraper;

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
        ", webcontent='" + contentPresent() + '\'' +
    '}';
  }

  @Override
  public String contentPresent() {
    return this.hasContent() ? "present" : "absent";
  }

  @Override
  public boolean hasContent() {
    return (null != this.webcontent);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CandidateImpl candidate = (CandidateImpl) o;
    return id == candidate.id &&
        Objects.equals(name, candidate.name) &&
        Objects.equals(address, candidate.address) &&
        Objects.equals(postalCode, candidate.postalCode) &&
        Objects.equals(location, candidate.location) &&
        Objects.equals(state, candidate.state) &&
        Objects.equals(phoneNumbers, candidate.phoneNumbers) &&
        Objects.equals(mail, candidate.mail) &&
        Objects.equals(webcontent, candidate.webcontent) &&
        Objects.equals(website, candidate.website);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, address, postalCode, location, state, phoneNumbers, mail, website, webcontent);
  }

  @Override
  public long getId() {
    return id;
  }

  @Override
  public void setId(long id) {
    this.id = id;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getAddress() {
    return address;
  }

  @Override
  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String getPostalCode() {
    return postalCode;
  }

  @Override
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  @Override
  public String getLocation() {
    return location;
  }

  @Override
  public void setLocation(String location) {
    this.location = location;
  }

  @Override
  public String getState() {
    return state;
  }

  @Override
  public void setState(String state) {
    this.state = state;
  }

  @Override
  public String getPhoneNumbers() {
    return phoneNumbers;
  }

  @Override
  public void setPhoneNumbers(String phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
  }

  @Override
  public String getMail() {
    return mail;
  }

  @Override
  public void setMail(String mail) {
    this.mail = mail;
  }

  @Override
  public String getWebsite() {
    return website;
  }

  @Override
  public void setWebsite(String website) {
    this.website = website;
  }

  public Scraper getScraper() {
    return scraper;
  }

  public void setScraper(Scraper scraper) {
    this.scraper = scraper;
  }

  @Override
  public String getWebcontent() throws IOException {
    if (!hasContent()) {
      this.webcontent = scraper.getText(this.getWebsite());
    }
    return webcontent;
  }

  @Override
  public void setWebcontent(String webcontent) { this.webcontent = webcontent; }

  public static CandidateImpl fromTabCsv(String candidateAsCsv) {
    List<String> attributes = Splitter.on("\t").splitToList(candidateAsCsv);
    CandidateImpl candidate = new CandidateImpl();
    candidate.setName(attributes.get(0));
    candidate.setAddress(attributes.get(1));
    candidate.setPostalCode(attributes.get(2));
    candidate.setLocation(attributes.get(3));
    candidate.setState(attributes.get(4));
    candidate.setPhoneNumbers(attributes.get(5));
    candidate.setMail(attributes.get(6));
    candidate.setWebsite(attributes.get(7));
    return candidate;
  }

  public CandidateImpl(String name, String address, String postalCode, String location, String state, String phoneNumbers, String mail, String website) {
    this.name = name;
    this.address = address;
    this.postalCode = postalCode;
    this.location = location;
    this.state = state;
    this.phoneNumbers = phoneNumbers;
    this.mail = mail;
    this.website = website;
  }

  public CandidateImpl() {
    super();
  }

}
