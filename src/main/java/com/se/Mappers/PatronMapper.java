package com.se.Mappers;

import com.se.Entities.patron.response.PatronDto;
import com.se.Entities.book.Book;
import com.se.Entities.patron.Patron;
import com.se.Entities.patron.request.CreatePatronRequest;

import java.util.Set;
import java.util.stream.Collectors;

import static com.se.Mappers.BookMapper.toIdSet;

public class PatronMapper {
    public static Patron toEntity(CreatePatronRequest request) {
        return Patron.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
    }

    public static Patron toEntity(PatronDto dto) {
        return Patron.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .debt(dto.getDebt())
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
}
