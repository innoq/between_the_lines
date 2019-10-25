package btl.simple.candidate;

import java.io.IOException;

public interface Candidate {
    String contentPresent();

    boolean hasContent();

    long getId();

    void setId(long id);

    String getName();

    void setName(String name);

    String getAddress();

    void setAddress(String address);

    String getPostalCode();

    void setPostalCode(String postalCode);

    String getLocation();

    void setLocation(String location);

    String getState();

    void setState(String state);

    String getPhoneNumbers();

    void setPhoneNumbers(String phoneNumbers);

    String getMail();

    void setMail(String mail);

    String getWebsite();

    void setWebsite(String website);

    String getWebcontent() throws IOException;

    void setWebcontent(String webcontent);
}
