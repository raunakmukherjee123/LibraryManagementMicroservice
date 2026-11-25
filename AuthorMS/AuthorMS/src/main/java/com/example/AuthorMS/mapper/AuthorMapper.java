package com.example.AuthorMS.mapper;

import com.example.AuthorMS.dto.response.AuthorResponse;
import com.example.AuthorMS.projections.AuthorProjections;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    public AuthorResponse AuthorProjectionToAuthorResponse(AuthorProjections authorProjections)
    {
        return AuthorResponse.builder()
                .name(authorProjections.getName())
                .age(authorProjections.getAge())
                .emailId(authorProjections.getEmailId())
                .rating(authorProjections.getRating())
                .total_books(authorProjections.getTotal_books())
                .build();
    }
}
