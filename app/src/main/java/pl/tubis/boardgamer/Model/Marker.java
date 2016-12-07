package pl.tubis.boardgamer.Model;

/**
 * Created by mike on 07.12.2016.
 */

public class Marker {

    public Double latitude;
    public Double longitude;
    public String uid;

    public Marker() {
    }

//    public Marker(String firstName, String email, String about, String oneSignalID, String uid, String provider) {
//        this.firstName = firstName;
//        this.email = email;
//        this.about = about;
//        this.oneSignalID = oneSignalID;
//        this.uid = uid;
//        this.provider = provider;
//    }

    //    //Getters and setters
    public Double getLat() {
        return latitude;
    }

    public void setLat(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLon() {
        return longitude;
    }

    public void setLon(Double longitude) {
        this.longitude = longitude;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


}
