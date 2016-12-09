package pl.tubis.boardgamer.Model;

/**
 * Created by mike on 07.12.2016.
 */

public class NewMarker {

    public Double latitude;
    public Double longitude;
    public String uid;

    public NewMarker() {
    }

    public NewMarker(Double latitude, Double longitude, String uid) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.uid = uid;
    }

    //    //Getters and setters
    public Double getLatitude() {
        return latitude;
    }

    public void setLat(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
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
