package com.se.Mappers;

import com.se.Entities.book.Book;
import com.se.Entities.bookMetadata.BookMetadata;
import com.se.Entities.bookMetadata.request.UpdateBookMetadataRequest;
import com.se.Entities.bookMetadata.response.BookMetadataDto;
import com.se.Entities.bookMetadata.request.CreateBookMetadataRequest;

import java.util.Set;

import static com.se.Mappers.BookMapper.toIdSet;

public class BookMetadataMapper {
    public static BookMetadata toEntity(CreateBookMetadataRequest request, Set<Book> copies) {
        return BookMetadata.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .copies(copies)
                .secondaryAuthors(request.getSecondaryAuthors())
                .build();
    }

    public static BookMetadata updateEntity(BookMetadata entity, UpdateBookMetadataRequest request) {
        entity.setAuthor(request.getAuthor());
        entity.setTitle(request.getTitle());
        entity.setIsbn(request.getIsbn());
        entity.setSecondaryAuthors(request.getSecondaryAuthors());

        return entity;
    }

    public static BookMetadataDto toDto(BookMetadata entity) {
        return BookMetadataDto.builder()
                .id(entity.getId())
                .author(entity.getAuthor())
                .isbn(entity.getIsbn())
                .secondaryAuthors(entity.getSecondaryAuthors())
                .title(entity.getTitle())
                .copies(toIdSet(entity.getCopies()))
                .build();
    }
}
