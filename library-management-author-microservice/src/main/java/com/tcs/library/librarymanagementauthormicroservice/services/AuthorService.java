package com.tcs.library.librarymanagementauthormicroservice.services;

import com.tcs.library.librarymanagementauthormicroservice.entities.Author;

import java.util.List;

public interface AuthorService {
    Author createAuthor(Author author);
    List<Author> getAuthors();

    Author getAuthorById(Long id);
    Author updateAuthorById(Author author,Long id);

    void deleteAuthorById(Long id);

}
