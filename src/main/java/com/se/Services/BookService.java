package com.se.Services;

import com.se.Entities.book.Book;
import com.se.Entities.book.request.UpdateBookRequest;
import com.se.Entities.book.response.BookDto;
import com.se.Entities.book.request.CreateBookRequest;
import com.se.Mappers.BookMapper;
import com.se.Repositories.BookRepository;
import com.se.contracts.BookInterface;
import com.se.contracts.BookMetadataInterface;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.se.Mappers.BookMapper.toDto;
import static com.se.Mappers.BookMapper.updateEntity;
import static org.springframework.http.ResponseEntity.*;

@Service
public class BookService implements BookInterface {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMetadataInterface bookMetadataInterface;

    @Override
    public ResponseEntity<BookDto> create(CreateBookRequest request) {
        try {
            return ok(toDto(save(createBook(request))));
        } catch (Exception e) {
            return badRequest().build();
        }
    }

    @Override
    public ResponseEntity<BookDto> get(Long id) {
        try {
            return ok(toDto(getById(id)));
        } catch (Exception e) {
            return notFound().build();
        }
    }


    @Override
    public ResponseEntity<Long> delete(Long id) {
        try {
            return ok(deleteById(id));
        } catch (Exception e) {
            return badRequest().build();
        }
    }

    @Override
    public Long deleteById(Long id) {
        getById(id);
        bookRepository.deleteById(id);

        return id;
    }
    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    public ResponseEntity<BookDto> update(UpdateBookRequest request) {
        try {
            return ok(toDto(updateBook(request)));
        } catch (Exception e) {
            return badRequest().build();
        }
    }

    private Book updateBook(UpdateBookRequest request) {
        return updateEntity(
                getById(request.getId()), request, bookMetadataInterface.getById(request.getMetadataId())
        );
    }

    private Book createBook(CreateBookRequest request) {
        return BookMapper
                        .toEntity(request, bookMetadataInterface.getById(
                                request.getMetadataId()
                        ));
    }

    @Transactional
    public Book save(Book entity) {
        return bookRepository.save(entity);
    }
}
