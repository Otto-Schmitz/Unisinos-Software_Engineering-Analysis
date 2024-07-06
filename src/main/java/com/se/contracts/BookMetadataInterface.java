package com.se.contracts;

import com.se.Entities.bookMetadata.BookMetadata;
import com.se.Entities.bookMetadata.request.CreateBookMetadataRequest;
import com.se.Entities.bookMetadata.request.UpdateBookMetadataRequest;
import com.se.Entities.bookMetadata.response.BookMetadataDto;
import org.springframework.http.ResponseEntity;

public interface BookMetadataInterface {
    ResponseEntity<BookMetadataDto> create(CreateBookMetadataRequest request);

    ResponseEntity<BookMetadataDto> get(Long id);

    BookMetadata getById(Long id);

    ResponseEntity<Long> delete(Long id);

    Long deleteById(Long id);

    ResponseEntity<BookMetadataDto> update(UpdateBookMetadataRequest request);
}
