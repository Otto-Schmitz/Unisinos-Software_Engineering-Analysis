package com.se.Services;

import com.se.Entities.bookMetadata.BookMetadata;
import com.se.Entities.bookMetadata.BookMetadataDto;
import com.se.Entities.bookMetadata.request.CreateBookMetadataRequest;
import com.se.Mappers.BookMetadataMapper;
import com.se.Repositories.BookMetadataRepository;
import com.se.contracts.BookMetadataInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

import static com.se.Mappers.BookMetadataMapper.toEntity;


public class BookMetadataService implements BookMetadataInterface {

    @Autowired
    private BookMetadataRepository bookMetadataRepository;

    @Override
    public ResponseEntity<BookMetadataDto> create(CreateBookMetadataRequest request) {
        try {
            return ResponseEntity.ok(
                    BookMetadataMapper
                            .toDto(createBookMetadata(request))
            );
        } catch (Exception e) {

            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public BookMetadata getObject(Long id) {
        return getObjectBookMetadata(id);
    }

    @Transactional
    private BookMetadata createBookMetadata(CreateBookMetadataRequest request) {
        return bookMetadataRepository.save(toEntity(request, new HashSet<>()));
    }

    private BookMetadata getObjectBookMetadata(Long id) {
        return bookMetadataRepository.findById(id).orElseThrow();
    }
}
