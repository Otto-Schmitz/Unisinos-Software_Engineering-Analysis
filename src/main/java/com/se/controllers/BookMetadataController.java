package com.se.controllers;

import com.se.Entities.bookMetadata.request.UpdateBookMetadataRequest;
import com.se.Entities.bookMetadata.response.BookMetadataDto;
import com.se.Entities.bookMetadata.request.CreateBookMetadataRequest;
import com.se.contracts.BookMetadataInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metadatas")
public class BookMetadataController {

    @Autowired
    private BookMetadataInterface bookMetadataInterface;

    @PostMapping
    private ResponseEntity<BookMetadataDto> create(CreateBookMetadataRequest request) {
        return bookMetadataInterface.create(request);
    }

    @GetMapping("/{id}")
    private ResponseEntity<BookMetadataDto> get(@PathVariable Long id) {
        return bookMetadataInterface.get(id);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Long> delete(@PathVariable Long id) {
        return bookMetadataInterface.delete(id);
    }

    @PutMapping
    private ResponseEntity<BookMetadataDto> update(UpdateBookMetadataRequest request) {
        return bookMetadataInterface.update(request);
    }
}
