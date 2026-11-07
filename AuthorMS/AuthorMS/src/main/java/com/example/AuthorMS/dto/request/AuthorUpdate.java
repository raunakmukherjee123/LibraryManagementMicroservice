package com.example.AuthorMS.dto.request;

import lombok.Data;

@Data
public class AuthorUpdate {
    private Integer age;

    private String emailId;

    private Double rating;

    private Integer total_books;
}
