package com.example.AuthorMS.service.service_impl;

import com.example.AuthorMS.dto.request.AuthorRequest;
import com.example.AuthorMS.dto.response.AuthorResponse;
import com.example.AuthorMS.models.Author;
import com.example.AuthorMS.repository.AuthorRepository;
import com.example.AuthorMS.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorResponse add(AuthorRequest authorRequest) {
        Author author=new Author();

        author.setAge(authorRequest.getAge());
    }
}
