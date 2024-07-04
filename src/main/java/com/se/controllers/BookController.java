package com.se.controllers;

import com.se.Entities.book.BookDto;
import com.se.Entities.book.request.CreateBookRequest;
import com.se.contracts.BookInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookInterface bookInterface;

    @PostMapping
    private ResponseEntity<BookDto> create(CreateBookRequest request) {
        return null;
    }
}
