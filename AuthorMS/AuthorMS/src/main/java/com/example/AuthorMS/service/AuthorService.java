package com.example.AuthorMS.service;

import com.example.AuthorMS.dto.request.AuthorRequest;
import com.example.AuthorMS.dto.request.AuthorUpdate;
import com.example.AuthorMS.dto.response.AuthorResponse;
import com.example.AuthorMS.dto.response.PageResponse;

public interface AuthorService {
    AuthorResponse add(AuthorRequest authorRequest);

    AuthorResponse findById(Integer id);

    AuthorResponse deleteAuthorById(Integer id);

    AuthorResponse updateById(AuthorUpdate authorUpdate, Integer id);

    PageResponse<?> getAllAuthors(int pageNo, int pageSize, String sortBy);

    void updateEmailById(Integer id);
}
