package in.stackroute.contactservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Contact {
    @Id
    private String contactId;
    private String name;
    private String email;
    private int mobile;
    private String category;
    private String userEmail;


    public Contact() {
    }

    public Contact(String contactId, String name, String email, int mobile, String category, String userEmail) {
        this.contactId = contactId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.category = category;
        this.userEmail = userEmail;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
