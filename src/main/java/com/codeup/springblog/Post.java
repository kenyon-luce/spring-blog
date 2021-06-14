package com.codeup.springblog;

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

    public Post(){
    }

//    public Post(String title, String body) {
//        this.title = title;
//        this.body = body;
//    }

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
