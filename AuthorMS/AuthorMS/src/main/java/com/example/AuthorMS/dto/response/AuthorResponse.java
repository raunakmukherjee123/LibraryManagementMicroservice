package com.example.AuthorMS.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorResponse {

    private String name;

    private Integer age;

    private String emailId;

    private Double rating;

    private Integer total_books;
}
