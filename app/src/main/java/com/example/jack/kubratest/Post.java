package com.example.jack.kubratest;

public class Post {
    private int userID;
    private int postID;
    private String title;
    private String body;

    public Post() {}

    public Post(int userID, int postID, String title, String body) {
        this.userID = userID;
        this.postID = postID;
        this.title = title;
        this. body = body;
    }

    public int getUserID() { return userID; }

    public void setUserID(int userID) { this.userID = userID; }

    public int getPostID() { return postID; }

    public void setPostID(int postID) { this.postID = postID; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }
}
