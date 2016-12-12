package pl.tubis.boardgamer.Model;

import static pl.tubis.boardgamer.Fragments.MyProfileFragment.uid;

/**
 * Created by mike on 29.11.2016.
 */

public class Game {
    public String gameTitle;
    public String gameID;
    public String yearPublished;
    public String age;
    public String playingTime;
    public String minPlayers;
    public String maxPlayers;
    public String thumbnailURL;

    public Game() {
    }

    public Game(String gameTitle, String gameID, String yearPublished, String age, String playingTime, String minPlayers, String maxPlayers,
                String thumbnailURL) {
        this.gameTitle = gameTitle;
        this.gameID = gameID;
        this.yearPublished = yearPublished;
        this.age = age;
        this.playingTime = playingTime;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.thumbnailURL = thumbnailURL;
    }
//
//    //Getters and setters
    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getGameID() {
        return gameID;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public String getAge() {
        return age;
    }

    public String getPlayingTime() {
        return playingTime;
    }

    public String getMinPlayers() {
        return minPlayers;
    }

    public String getMaxPLayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(String maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }
}
