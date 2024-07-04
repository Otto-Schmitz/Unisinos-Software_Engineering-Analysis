package com.se.Services;

import com.se.contracts.BookInterface;
import com.se.Entities.book.BookDto;
import com.se.Entities.book.request.CreateBookRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookService implements BookInterface  {

    @Override
    public ResponseEntity<BookDto> create(CreateBookRequest request) {
        try {
            return ResponseEntity.ok(createBook(request));
        } catch (Exception e) {
            //rate errors
            return ResponseEntity.badRequest().build();
        }
    }

    private BookDto createBook(CreateBookRequest request) {
        return null;
    }
}
