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
        author.setName(authorRequest.getName());
        author.setEmailId(authorRequest.getEmailId());
        author.setTotal_books(author.getTotal_books());
        author.setRating(author.getRating());

        Author savedAuthor=authorRepository.save(author);

        return AuthorResponse.builder()
                .age(savedAuthor.getAge())
                .emailId(savedAuthor.getEmailId())
                .name(savedAuthor.getName())
                .rating(savedAuthor.getRating())
                .total_books(savedAuthor.getTotal_books())
                .build();
    }

    @Override
    public AuthorResponse findById(Integer id) {
        Author author=authorRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No author found"));

        return AuthorResponse.builder()
                .total_books(author.getTotal_books())
                .age(author.getAge())
                .rating(author.getRating())
                .name(author.getName())
                .emailId(author.getEmailId())
                .build();
    }
}
