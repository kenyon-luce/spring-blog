package com.codeup.springblog;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ads") //creates table in adlister_db after running
public class Ad {

    @Id //tell it to be an id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generates and auto-incrementing id
    //https://stackoverflow.com/questions/33096466/generationtype-auto-vs-generationtype-identity-in-hibernate
    //^^check for more info on IDENTITY
    private long id;

    //All ads have an ad.title
    @Column(nullable = false, length = 100) //adds a column of title that is NOT NULL and varchar(100)
    private String title;

    //All ads have an ad.description
    @Column(nullable = false) //if we don't specify length, length defaults to 255
    private String description;

    // spring relationships lecture
    @OneToOne
    private User owner; //connects my user objects

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ad")
    private List<AdImage> images;
    //^^add this to constructors and make getters/setters

    public Ad(){
    }

//    public Ad(){
//        this.title = title;
//        this.description = description;
//        this.owner = owner
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

//    Mapping Properties and Fields
//    The @Column annotation is used to specify the details of the column to which a field or property will be mapped. Some of the details are schema related, and therefore apply only if the schema is generated from the annotated files.
//
//        You can customize the values of the following attributes:
//
//        --name allows us to specify the column name. The default value for a column would be the name of the property. You'll want to override the default behavior, for instance, when you have a column name last_name, but the property in your POJO is lastName.
//
//        --length permits the size of the column (particularly a string value) to be explicitly defined. The column size defaults to 255.
//
//        --nullable permits the column to be marked NOT NULL when the schema is generated. The default is that fields should be permitted to be null, ie nullable = true.
//
//        --unique permits the column to be marked as containing only unique values. This defaults to false.
