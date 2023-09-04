package com.tcs.library.librarymanagementauthormicroservice.controllers;

import com.tcs.library.librarymanagementauthormicroservice.entities.Author;
import com.tcs.library.librarymanagementauthormicroservice.payloads.ApiResponse;
import com.tcs.library.librarymanagementauthormicroservice.services.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AuthorController {
    @Autowired
    public AuthorService authorService;

    //Get all authors
    @GetMapping("/get-authors")
    public ResponseEntity<List<Author>> getAuthors() {
        List<Author> getAuthor = authorService.getAuthors();
        return ResponseEntity.ok(getAuthor);
    }
    // GET - author get
    @GetMapping("get-authors/{authorId}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long authorId) {
        return ResponseEntity.ok(this.authorService.getAuthorById(authorId));
    }
    // POST-create author
    @PostMapping("/add-author")
    public ResponseEntity<Author> createAuthor( @RequestBody Author authorDto) {
        Author createAuthor= this.authorService.createAuthor(authorDto);
        return new ResponseEntity<>(createAuthor, HttpStatus.CREATED);
    }
    @PutMapping("/update-author/{authorId}")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author authorDto, @PathVariable("authorId") Long uid) {
        Author updatedAuthor = this.authorService.updateAuthorById(authorDto, uid);
        return ResponseEntity.ok(updatedAuthor);
    }
    //Delete map
    @DeleteMapping("delete/{authorId}")
    public ResponseEntity<ApiResponse> deleteAuthor(@PathVariable("authorId") Long uid) {
//     ResponseEntity<?> can be used above line for return type
        this.authorService.deleteAuthorById(uid);
        return new ResponseEntity<>( new ApiResponse("Author deleted Successfully",true), HttpStatus.OK);
    }
}
