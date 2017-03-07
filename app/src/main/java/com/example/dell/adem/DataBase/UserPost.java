package com.example.dell.adem.DataBase;

/**
 * Created by DELL on 2/26/2017.
 */

public class UserPost {
    String caption,emotion,location,hashtag,friendtag,listvideo,listimange;

    public UserPost() {
    }

    public UserPost(String caption, String emotion, String location, String hashtag, String friendtag, String listvideo, String listimange) {
        this.caption = caption;
        this.emotion = emotion;
        this.location = location;
        this.hashtag = hashtag;
        this.friendtag = friendtag;
        this.listvideo = listvideo;
        this.listimange = listimange;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public String getFriendtag() {
        return friendtag;
    }

    public void setFriendtag(String friendtag) {
        this.friendtag = friendtag;
    }

    public String getListvideo() {
        return listvideo;
    }

    public void setListvideo(String listvideo) {
        this.listvideo = listvideo;
    }

    public String getListimange() {
        return listimange;
    }

    public void setListimange(String listimange) {
        this.listimange = listimange;
    }
}
