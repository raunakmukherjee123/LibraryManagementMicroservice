package com.example.AuthorMS.service;

import com.example.AuthorMS.dto.request.AuthorRequest;
import com.example.AuthorMS.dto.request.AuthorUpdate;
import com.example.AuthorMS.dto.response.AuthorResponse;

public interface AuthorService {
    AuthorResponse add(AuthorRequest authorRequest);

    AuthorResponse findById(Integer id);

    AuthorResponse deleteAuthorById(Integer id);

    void updateById(AuthorUpdate authorUpdate, Integer id);
}
