package com.se.Mappers;

import com.se.Entities.patron.response.PatronDto;
import com.se.Entities.book.Book;
import com.se.Entities.patron.Patron;
import com.se.Entities.patron.request.CreatePatronRequest;
import com.se.Entities.patron.request.UpdatePatronRequest;

import java.util.Set;

import static com.se.Mappers.BookMapper.toIdSet;

public class PatronMapper {
    public static Patron toEntity(CreatePatronRequest request) {
        return Patron.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
    }

    public static Patron toEntity(PatronDto dto, Set<Book> borrowedBooks) {
        return Patron.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .debt(dto.getDebt())
                .borrowedBooks(borrowedBooks)
                .build();
    }

    public static PatronDto toDto(Patron entity) {
        return PatronDto.builder()
                .id(entity.getId())
                .debt(entity.getDebt())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .borrowedBooks(toIdSet(entity.getBorrowedBooks()))
                .build();
    }

    public static Long toId(Patron entity) {
        return entity.getId();
    }
    public static Patron updateEntity(Patron entity, UpdatePatronRequest request) {
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setDebt(request.getDebt());

        return entity;
    }
}
