package com.se.Mappers;

import com.se.Entities.book.Book;
import com.se.Entities.book.request.UpdateBookRequest;
import com.se.Entities.book.response.BookDto;
import com.se.Entities.book.request.CreateBookRequest;
import com.se.Entities.bookMetadata.BookMetadata;

import java.util.Set;
import java.util.stream.Collectors;

public class BookMapper {
    public static Book toEntity(CreateBookRequest dto, BookMetadata bookMetadata) {
        return Book.builder()
                .metadata(bookMetadata)
                .storageLocation(dto.getStorageLocation())
                .edition(dto.getEdition())
                .borrowed(false)
                .build();
    }

    public static Book toEntity(BookDto dto, BookMetadata bookMetadata) {
        return Book.builder()
                .id(dto.getId())
                .edition(dto.getEdition())
                .metadata(bookMetadata)
                .borrowed(dto.getBorrowed())
                .storageLocation(dto.getStorageLocation())
                .build();
    }

    public static Book updateEntity(Book entity, UpdateBookRequest request, BookMetadata bookMetadata) {
        entity.setBorrowed(request.getBorrowed());
        entity.setEdition(request.getEdition());
        entity.setStorageLocation(request.getStorageLocation());
        entity.setMetadata(bookMetadata);

        return entity;
    }

    public static BookDto toDto(Book entity) {
        return BookDto.builder()
                .id(entity.getId())
                .metadataId(entity.getMetadata().getId())
                .edition(entity.getEdition())
                .storageLocation(entity.getStorageLocation())
                .borrowed(entity.getBorrowed())
                .build();
    }

    public static Long toId(Book entity) {
        return entity.getId();
    }

    public static Set<Long> toIdSet(Set<Book> entities) {
        return entities.stream()
                .map(BookMapper::toId)
                .collect(Collectors.toSet());
    }
}
