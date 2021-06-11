package com.codeup.springblog;

import javax.persistence.*;

@Entity
@Table(name="ads") //creates table in adlister_db after running
public class Ad {

    @Id //tell it to be an id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generates and auto-incrementing id
    //https://stackoverflow.com/questions/33096466/generationtype-auto-vs-generationtype-identity-in-hibernate
    //^^check for more info on IDENTITY
    private long id;



}
