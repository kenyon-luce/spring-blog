package com.codeup.springblog.models;

import com.codeup.springblog.models.Ad;

import javax.persistence.*;

@Entity
@Table(name = "ad_images")
public class AdImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private String description;

    @ManyToOne()
    @JoinColumn(name="ad_id")//specify name of column
    private Ad ad;

    //add constructors for many to one
//    public AdImage(long id, String title, String description, ...){
//
//    }
//
//    public AdImage(){
//
//    }
}
