package com.tcs.library.librarymanagementauthormicroservice.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;

//    @OneToMany(mappedBy = "author")
//    private List<Book> books = new ArrayList<>();

}