package com.se.Services;

import com.se.Entities.book.Book;
import com.se.Entities.book.response.BookDto;
import com.se.Entities.book.request.CreateBookRequest;
import com.se.Mappers.BookMapper;
import com.se.Repositories.BookRepository;
import com.se.contracts.BookInterface;
import com.se.contracts.BookMetadataInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.se.Mappers.BookMapper.toDto;
import static org.springframework.http.ResponseEntity.badRequest;

@Service
public class BookService implements BookInterface  {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMetadataInterface bookMetadataInterface;

    @Override
    public ResponseEntity<BookDto> create(CreateBookRequest request) {
        try {
            return ResponseEntity.ok(toDto(createBook(request)));
        } catch (Exception e) {
            return badRequest().build();
        }
    }

    private Book createBook(CreateBookRequest request) {
        return bookRepository.save(
                BookMapper
                        .toEntity(request, bookMetadataInterface.getObject(
                                request.getMetadataId()
                        ))
        );
    }
}
