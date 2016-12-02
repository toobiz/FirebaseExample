package com.example.mike.firebaseexample;

/**
 * Created by mike on 29.11.2016.
 */

public class User {
    //name and address string
    public String firstName;
    public String email;
    public String uid;
    public String about;
    public String oneSignalID;
    public String provider;
    public Boolean privacyAgreement;

    public User() {
    }

    public User(String firstName, String email, String about, String oneSignalID, String uid, String provider) {
        this.firstName = firstName;
        this.email = email;
        this.about = about;
        this.oneSignalID = oneSignalID;
        this.uid = uid;
        this.provider = provider;
    }
//
//    //Getters and setters
//    public String getfirstName() {
//        return firstName;
//    }
//
//    public void setfirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getUid() {
//        return uid;
//    }
//
//    public void setUid(String uid) {
//        this.uid = uid;
//    }
//
//    public String getEmail() { return email;}
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getAbout() { return about; }
//
//    public void setAbout(String about) {
//        this.about = about;
//    }
//
//    public String getOneSignalID() { return oneSignalID; }
//
//    public void setOneSignalID(String oneSignalID) {
//        this.oneSignalID = oneSignalID;
//    }
//
//    public Boolean getPrivacyAgreement() { return privacyAgreement; }
//
//    public void setPrivacyAgreement(Boolean privacyAgreement) {
//        this.privacyAgreement = privacyAgreement;
//    }



}
