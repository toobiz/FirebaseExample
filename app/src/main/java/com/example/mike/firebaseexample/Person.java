package com.example.mike.firebaseexample;

/**
 * Created by mike on 29.11.2016.
 */

public class Person {
    //name and address string
    private String firstName;
    private String address;
    private String uid;
    private String email;
    private String about;
    private String oneSignalID;
    private Boolean privacyAgreement;

    public Person() {
      /*Blank default constructor essential for Firebase*/
    }
    //Getters and setters
    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() { return email;}

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() { return about; }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getOneSignalID() { return oneSignalID; }

    public void setOneSignalID(String oneSignalID) {
        this.oneSignalID = oneSignalID;
    }

    public Boolean getPrivacyAgreement() { return privacyAgreement; }

    public void setPrivacyAgreement(Boolean privacyAgreement) {
        this.privacyAgreement = privacyAgreement;
    }
}
