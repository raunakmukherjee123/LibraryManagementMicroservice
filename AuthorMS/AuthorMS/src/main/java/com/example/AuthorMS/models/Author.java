package com.example.AuthorMS.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //.IDENTITY increase counter at level of tables, but.AUTO increase counter at database level
    private Integer authorid;

    private String name;

    private Integer age;

    private String emailId;

    private Double rating;

    private Integer total_books;
}
