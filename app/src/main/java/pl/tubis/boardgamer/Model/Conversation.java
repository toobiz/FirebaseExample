package pl.tubis.boardgamer.Model;

/**
 * Created by mike on 29.11.2016.
 */

public class Conversation {
    //name and address string
    public String base64String;
    public String displayName;
    public String id;
    public Boolean isNew;
    public String oneSignalID;
    public String receiverId;


    public Conversation() {
    }

    public Conversation(String base64String, String displayName, String id, Boolean isNew, String oneSignalID, String receiverId) {
        this.base64String = base64String;
        this.displayName = displayName;
        this.id = id;
        this.isNew = isNew;
        this.oneSignalID = oneSignalID;
        this.receiverId = receiverId;
    }
//
//    //Getters and setters
    public String getBase64String() {
        return base64String;
    }

    public void setBase64String(String base64String) {
        this.base64String = base64String;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsNew() { return isNew;}

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public String getOneSignalID() { return oneSignalID; }

    public void setOneSignalID(String oneSignalID) {
        this.oneSignalID = oneSignalID;
    }

    public String getReceiverId() { return receiverId; }

    public void set(String receiverId) {
        this.receiverId = receiverId;
    }



}
