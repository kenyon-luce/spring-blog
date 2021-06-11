package com.codeup.springblog;

import javax.persistence.*;

@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //name
    @Column(nullable = false, length=100)
    private String name;

    //age
    @Column(nullable = false)
    private int age;

    //species
    @Column(nullable = false)
    private String species;
}
