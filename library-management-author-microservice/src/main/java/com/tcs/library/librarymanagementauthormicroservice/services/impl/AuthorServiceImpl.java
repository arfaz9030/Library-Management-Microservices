package com.tcs.library.librarymanagementauthormicroservice.services.impl;

import com.tcs.library.librarymanagementauthormicroservice.entities.Author;
import com.tcs.library.librarymanagementauthormicroservice.exceptions.ResourceNotFoundException;
import com.tcs.library.librarymanagementauthormicroservice.repository.AuthorRepo;
import com.tcs.library.librarymanagementauthormicroservice.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepo authorRepo;
    @Override
    public Author createAuthor(Author author) {

        return this.authorRepo.save(author);
    }

    @Override
    public List<Author> getAuthors() {
        return this.authorRepo.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        return this.authorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", " Id ", id));
    }

    @Override
    public Author updateAuthorById( Author author,Long id) {
              author= this.authorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", " Id ", id));
                author.setName(author.getName());
                author.setCountry(author.getCountry());
//                author.setBooks(author.getBooks());
        return this.authorRepo.save(author);

    }

    @Override
    public void deleteAuthorById(Long id) {

        Author author= this.authorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", " Id ", id));
        this.authorRepo.delete(author);
    }
}
