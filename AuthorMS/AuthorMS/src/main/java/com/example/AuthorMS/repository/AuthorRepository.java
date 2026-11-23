package com.example.AuthorMS.repository;

import com.example.AuthorMS.models.Author;
import com.example.AuthorMS.projections.AuthorProjections;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

    @Query(value = """
            select a.name as name,
            a.age as age,
            a.emailId as emailId,
            a.rating as rating,
            a.total_books as total_books
            from Author a
            where a.id=:id
            """)
    AuthorProjections findAuthorProjectionById(@Param("id") Integer id);


    @Query("""
        SELECT 
            a.name AS name,
            a.age AS age,
            a.emailId AS emailId,
            a.rating AS rating,
            a.totalBooks AS totalBooks
        FROM Author a
    """)
    Page<AuthorProjections> findAllAuthor(Pageable pageable);
}
