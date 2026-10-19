package com.example.AuthorMS.service;

import com.example.AuthorMS.dto.request.AuthorRequest;
import com.example.AuthorMS.dto.response.AuthorResponse;

public interface AuthorService {
    AuthorResponse add(AuthorRequest authorRequest);

    AuthorResponse findById(Integer id);
}
