package com.example.AuthorMS.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorRequest {
    private String name;

    @Min(10)
    private Integer age;

    @NotBlank(message = "Email should not be blank")
    private String emailId;

    @DecimalMin("0.0")
    @DecimalMax("10.0")
    private Double rating;

    private Integer total_books;
}
