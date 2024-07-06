package com.se.controllers;

import com.se.Entities.bookMetadata.response.BookMetadataDto;
import com.se.Entities.bookMetadata.request.CreateBookMetadataRequest;
import com.se.contracts.BookMetadataInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metadata")
public class BookMetadataController {

    @Autowired
    private BookMetadataInterface bookMetadataInterface;

    @PostMapping
    private ResponseEntity<BookMetadataDto> create(CreateBookMetadataRequest request) {
        return bookMetadataInterface.create(request);
    }
}
