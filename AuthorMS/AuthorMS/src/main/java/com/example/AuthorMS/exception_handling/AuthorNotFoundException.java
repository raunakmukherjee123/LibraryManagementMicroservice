package com.example.AuthorMS.exception_handling;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(String message)
    {
        super(message);
    }
}
