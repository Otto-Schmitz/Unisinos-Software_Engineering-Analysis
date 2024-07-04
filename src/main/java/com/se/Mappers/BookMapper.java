package com.se.Mappers;

import com.se.Entities.book.Book;
import com.se.Entities.book.BookDto;
import com.se.Entities.book.request.CreateBookRequest;

public class BookMapper {
    public static Book toEntity(CreateBookRequest dto) {
        return Book.builder()
                .storageLocation(dto.getStorageLocation())
                .edition(dto.getEdition())
                .build();
    }

    public static Book toEntity(BookDto dto) {
        return Book.builder()
                .id(dto.getId())
                .edition(dto.getEdition())
                .metadata(dto.getMetadata())
                .borrowed(dto.getBorrowed())
                .storageLocation(dto.getStorageLocation())
                .build();
    }

    public static BookDto toDto(Book entity) {
        return BookDto.builder()
                .id(entity.getId())
                .metadata(entity.getMetadata())
                .edition(entity.getEdition())
                .storageLocation(entity.getStorageLocation())
                .borrowed(entity.getBorrowed())
                .build();
    }
}
