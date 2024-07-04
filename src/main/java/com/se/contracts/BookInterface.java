package com.se.contracts;

import com.se.Entities.book.BookDto;
import com.se.Entities.book.request.CreateBookRequest;
import org.springframework.http.ResponseEntity;

public interface BookInterface {
    ResponseEntity<BookDto> create(CreateBookRequest request);
}
