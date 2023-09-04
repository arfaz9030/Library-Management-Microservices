package com.tcs.library.librarymanagementauthormicroservice.repository;

import com.tcs.library.librarymanagementauthormicroservice.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long> {
}
