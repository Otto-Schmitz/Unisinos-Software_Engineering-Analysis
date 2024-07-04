package com.se.contracts;

import com.se.Entities.bookMetadata.BookMetadata;
import com.se.Entities.bookMetadata.BookMetadataDto;
import com.se.Entities.bookMetadata.request.CreateBookMetadataRequest;
import org.springframework.http.ResponseEntity;

public interface BookMetadataInterface {
    ResponseEntity<BookMetadataDto> create(CreateBookMetadataRequest request);

    BookMetadata getObject(Long id);
}
