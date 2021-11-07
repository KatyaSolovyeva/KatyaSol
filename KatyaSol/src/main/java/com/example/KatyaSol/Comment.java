package com.example.KatyaSol;

public class Comment {
    public String name;
    public String user;

    public Comment(String name,String user) {
        this.user = user;
        this.name = name;
    }
    public Comment(String name) {
        this.user = null;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUser() {
        return user;
    }
}