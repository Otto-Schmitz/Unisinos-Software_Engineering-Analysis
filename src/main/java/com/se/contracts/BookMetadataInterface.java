package com.se.contracts;

import com.se.Entities.bookMetadata.BookMetadata;
import com.se.Entities.bookMetadata.response.BookMetadataDto;
import com.se.Entities.bookMetadata.request.CreateBookMetadataRequest;
import com.se.Entities.bookMetadata.request.UpdateBookMetadataRequest;
import org.springframework.http.ResponseEntity;

public interface BookMetadataInterface {
    ResponseEntity<BookMetadataDto> create(CreateBookMetadataRequest request);

    BookMetadata getObject(Long id);

    ResponseEntity<Long> delete(Long id);

    ResponseEntity<BookMetadataDto> update(UpdateBookMetadataRequest request);
}
