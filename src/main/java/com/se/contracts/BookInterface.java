package com.se.contracts;

import com.se.Entities.book.Book;
import com.se.Entities.book.request.CreateBookRequest;
import com.se.Entities.book.request.UpdateBookRequest;
import com.se.Entities.book.response.BookDto;
import org.springframework.http.ResponseEntity;

public interface BookInterface {
    ResponseEntity<BookDto> create(CreateBookRequest request);

    ResponseEntity<BookDto> get(Long id);

    Book getById(Long id);

    ResponseEntity<Long> delete(Long id);

    Long deleteById(Long id);

    ResponseEntity<BookDto> update(UpdateBookRequest request);

}
