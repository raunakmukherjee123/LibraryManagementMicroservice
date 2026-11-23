package com.example.AuthorMS.service.service_impl;

import com.example.AuthorMS.dto.request.AuthorRequest;
import com.example.AuthorMS.dto.request.AuthorUpdate;
import com.example.AuthorMS.dto.response.AuthorResponse;
import com.example.AuthorMS.dto.response.PageResponse;
import com.example.AuthorMS.exception_handling.AuthorNotFoundException;
import com.example.AuthorMS.models.Author;
import com.example.AuthorMS.projections.AuthorProjections;
import com.example.AuthorMS.repository.AuthorRepository;
import com.example.AuthorMS.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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
        AuthorProjections authorProjections=authorRepository.findAuthorProjectionById(id);

        if(authorProjections==null) {
            throw new AuthorNotFoundException("No author found");
        }

        return AuthorResponse.builder()
                .total_books(authorProjections.getTotal_books())
                .age(authorProjections.getAge())
                .rating(authorProjections.getRating())
                .name(authorProjections.getName())
                .emailId(authorProjections.getEmailId())
                .build();
    }

    @Override
    public AuthorResponse deleteAuthorById(Integer id) {
        Author author=authorRepository.findById(id)
                .orElseThrow(()->new AuthorNotFoundException("No author of id= "+id+" found to be deleted"));

        authorRepository.delete(author);

        AuthorResponse authorResponse=AuthorResponse.builder()
                .name(author.getName())
                .age(author.getAge())
                .build();

        return authorResponse;
    }

    @Override
    public AuthorResponse updateById(AuthorUpdate authorUpdate, Integer id) {
        Author author=authorRepository.findById(id)
                .orElseThrow(()->new AuthorNotFoundException("Author of id = "+id+" not found to be updated"));

      author.setAge(authorUpdate.getAge());
      author.setEmailId(authorUpdate.getEmailId());
      author.setRating(authorUpdate.getRating());
      author.setTotal_books(authorUpdate.getTotal_books());

      Author savedAuthor=authorRepository.save(author);

      AuthorResponse authorResponse=AuthorResponse.builder()
              .age(savedAuthor.getAge())
              .name(savedAuthor.getName())
              .emailId(savedAuthor.getEmailId())
              .rating(savedAuthor.getRating())
              .total_books(savedAuthor.getTotal_books())
              .build();

      return authorResponse;
    }

    @Override
    public PageResponse<?> getAllAuthors(int pageNo, int pageSize, String sortBy) {
        Pageable pageable= PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
        Page<AuthorProjections> authorPage=authorRepository.findAllAuthor(pageable);
        List<AuthorProjections> authorList=authorPage.getContent();


        List<AuthorResponse> authorResponseList=authorList.stream().
                map(author ->
                   mapToAuthorResponse(author))
                .collect(Collectors.toList());

        return PageResponse.builder()
                .content(authorResponseList)
                .isLastPage(authorPage.isLast())
                .pageNumber(authorPage.getNumber())
                .totalPages(authorPage.getTotalPages())
                .pageSize(authorPage.getSize())
                .build();
    }

    private AuthorResponse mapToAuthorResponse(AuthorProjections authorProjections) {
        return AuthorResponse.builder()
                .total_books(authorProjections.getTotal_books())
                .rating(authorProjections.getRating())
                .emailId(authorProjections.getEmailId())
                .age(authorProjections.getAge())
                .name(authorProjections.getName())
                .build();
    }
}
