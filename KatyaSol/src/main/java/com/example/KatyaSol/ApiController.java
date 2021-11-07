package com.example.KatyaSol;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {
    List<String> themes = new ArrayList<>();

// выдать список тем
    @GetMapping("themes")
    public List<String> getTheme() {
        List<String> themes = new Arraylist<>();
        for(Theme t : theme){
            themes.add(t.getName());
        }
        return themes;
    }
// создать тему
    @PostMapping("themes")
    public void addTheme(@RequestBody String text) {
        Theme t = new Theme(text);
        theme.add(t);
    }

    //выдать определенную тему
    @GetMapping("themes/{index}")
    public String getTheme(@PathVariable("index") Integer index) {
        return themes.get(index);
    }

//удалить тему
    @DeleteMapping("themes/{index}")
    public void deleteThemes(@PathVariable("index") Integer index) {
        themes.remove((int) index);
    }

//обновить тему
    @PutMapping("themes/{index}")
    public void updateTheme(
            @PathVariable("index") Integer i,
            @RequestBody String theme) {
        themes.remove((int) i);
        themes.add(i, theme);
    }

    //выдать количество тем
    @GetMapping("themes/count")
    public Integer getthemecount(){
        return theme.size();
    }

    //удалить все темы
    @DeleteMapping("theme")
    public void deleteText(){
        theme= new ArrayList<>();
    }

    //создать комментарий в определенной теме
    @PostMapping("themes/{index}/comment")
    public void addTheme(
            @PathVariable("index") Integer i,
            @RequestBody String comment) {
        Theme a = theme.get(i);
        Comment comm = new Comment(comment);
        a.addComment(comm);
    }

    //удалить комментарий
    @DeleteMapping("themes/{index}/comment")
    public void deleteText(
            @PathVariable("index") Integer i,
            @RequestBody String comment) {
        Theme a = theme.get(i);
        List<Comment> comm = a.getComments();
        int k=0;
        for(int i=0, i<comm.size(), i++){
            String h = comm.get(i).getName();
            if(h.equals(comment)){
                k=i;
                break;
            }
        }
        a.deleteComment(k);
    }

    //обновить комментарий в определенной теме
    @PutMapping("themes/{index}/comment/{indexComment}")
    public void updateComm(@PathVariable("index") Integer i,
                           @PathVariable("index") Integer n,
                           @RequestBody String comment){
        Theme a = theme.get(i);
        a.deleteComment(n);
        Comment comm = new Comment(comment);
        a.updateComment(n, comm);
    }

    //выдать список комментариев определенной темы
    @GetMapping("themes/{index}/comment")
    public List<Comment> getThemeComment(@PathVariable("index") Integer i){
        Theme a = theme.get(i);
        return a.listOfComments();
    }

    //создать комментарий
    @PostMapping("themes/{index}/comment")
    public void addCommUser( @PathVariable("index") Integer i,
                             @RequestBody String comment){
        Theme a = theme.get(i);
        a.addComment(comment);
    }

    //выдать список комментариев определенного пользователя
    @GetMapping("user")
        public List<Comment> getUserComments(@RequestBody String user){
            List<Comment> usersComm =new ArrayList<>();
            for(int i=0,i<theme.size(),i++){
                Theme a = theme.get(i);
                List<Comment> commentss=new ArrayList<>();
                commentss = a.listOfComments();
                for(int j=0,i<commentss.size(),j++){
                    Comment comm = comments.get(j);
                    String userCom = comm.getUser();
                    if(userCom.equals(user)){
                     usersComm.add(comm);
                    }
                }
            }
            return usersComm;
        }

        //обновить комментарий определенного пользователя в определенной теме
    @PutMapping("userUpd")
    public void updateComm(@RequestBody String userUpd){
        List<Comment> usersComm =new ArrayList<>();
        for(int i=0,i<theme.size(),i++){
            Theme a = theme.get(i);}
            List<Comment> commentss=new ArrayList<>();
            commentss = a.listOfComments();
            for(int j=0,j<commentss.size(),j++){
                Comment comm = comments.get(j);
                String userCom = comm.getUser();
                if(userCom.equals(user)){
                    numberOfComments.add(j);
                }
            }
            int k = numberOfComments.get(n);
            Comment comm = new Comment(comment);
            a.deleteComment(k);
            a.updateComment(k,comm);
    }

    //удалить все комментарии данного пользователя
    @DeleteMapping("userUpd")
    public void deleteText(@RequestBody String userDel){
        for(int i=0,i<theme.size(),i++){
            Theme a = theme.get(i);
            List<Comment> commentss = new ArrayList<>();
            commentss = a.listOfComments();
            for (int j = 0, i<commentss.size(), j++){
                Comment comm = commentss.get(j);
                String userCom = comm.getUser();
                if (userCom.equals(userDel)) {
                    a.deleteComment(j);
                }
            }
        }
    }


//curl -X POST http://localhost:8080/themes -H 'Content-Type: text/plain' -d 'hello'

    //curl -X DELETE http://localhost:8080/themes/2

    //curl -X DELETE http://localhost:8080/themes

}