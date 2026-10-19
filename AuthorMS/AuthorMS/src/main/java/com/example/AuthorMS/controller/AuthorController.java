package com.example.AuthorMS.controller;

import com.example.AuthorMS.dto.request.AuthorRequest;
import com.example.AuthorMS.dto.response.APIResponse;
import com.example.AuthorMS.dto.response.AuthorResponse;
import com.example.AuthorMS.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/author")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity<?> addAuthor(@RequestBody AuthorRequest authorRequest)
    {
        AuthorResponse authorResponse=authorService.add(authorRequest);

        APIResponse apiResponse=APIResponse.builder()
                .code(HttpStatus.CREATED)
                .status(HttpStatus.CREATED.value())
                .message("Author has been added")
                .data(authorResponse)
                .success(true)
                .timestamp(Instant.now())
                .build();

        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable("id") Integer id)
    {
      AuthorResponse authorResponse=authorService.findById(id);

        APIResponse apiResponse=APIResponse.builder()
                .code(HttpStatus.CREATED)
                .status(HttpStatus.CREATED.value())
                .message("Author has been added")
                .data(authorResponse)
                .success(true)
                .timestamp(Instant.now())
                .build();

        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

}
