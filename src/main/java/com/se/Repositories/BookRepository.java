package com.se.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.se.Entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}