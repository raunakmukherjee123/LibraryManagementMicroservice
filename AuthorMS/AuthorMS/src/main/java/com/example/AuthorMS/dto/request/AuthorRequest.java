package com.example.AuthorMS.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorRequest {
    private String name;

    private Integer age;

    private String emailId;

    private Double rating;

    private Integer total_books;
}
