package com.example.AuthorMS.repository;

import com.example.AuthorMS.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
