package com.sisimpur.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisimpur.library.model.Book;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    
}
