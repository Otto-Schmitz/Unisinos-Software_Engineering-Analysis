package com.se.controllers;

import com.se.Entities.book.request.CreateBookRequest;
import com.se.Entities.book.request.UpdateBookRequest;
import com.se.Entities.book.response.BookDto;
import com.se.contracts.BookInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookInterface bookInterface;

    @PostMapping
    private ResponseEntity<BookDto> create(CreateBookRequest request) {
        return bookInterface.create(request);
    }

    @GetMapping("/{id}")
    private ResponseEntity<BookDto> get(@PathVariable Long id) {
        return bookInterface.get(id);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Long> delete(@PathVariable Long id) {
        return bookInterface.delete(id);
    }

    @PutMapping
    private ResponseEntity<BookDto> update(UpdateBookRequest request) {
        return bookInterface.update(request);
    }
}
