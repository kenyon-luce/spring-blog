package com.codeup.springblog.models;

import com.codeup.springblog.models.User;

import javax.persistence.*;

@Entity
@Table(name="posts") //creates table in adlister_db after running
public class Post {

    @Id //tell it to be an id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100) //adds a column of title that is NOT NULL and varchar(100)
    private String title;

    @Column(nullable = false) //if we don't specify length, length defaults to 255
    private String body;

    @ManyToOne
    @JoinColumn (name = "user_id") //joined users with posts through a newly made column
    private User user;

    public Post(){
    }

    public Post(long id, String title, String body, User owner) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = owner;
    }

    public Post(String title, String body, User owner){
        this.title = title;
        this.body = body;
        this.user = owner;
    }

    public User getOwner(){
        return user;
    }

    public void setOwner(User owner){
        this.user = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
