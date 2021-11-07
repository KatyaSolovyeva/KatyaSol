package com.example.KatyaSol;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class Theme{
    private List<comment> comments = new ArrayList<>();
    private String name;


    public Theme(String name) {
        this.comments = new ArrayList<>();
        this.name = name;
    }

    public void addComment(Comment a) {
        comments.add(a);
    }

    public void updateComment(int i,Comment a) {
        comments.remove(i);
        comments.add(i,a);
    }

    public void deleteComment(Comment a) {
        comments.remove(a);
    }

    public void deleteComment(int i) {
        comments.remove(i);
    }

    public List<comment> listOfComments() {
        return this.comments;
    }
}