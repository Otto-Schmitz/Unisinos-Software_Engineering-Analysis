package com.se.Mappers;

import com.se.Entities.book.Book;
import com.se.Entities.patron.Patron;
import com.se.Entities.ticket.Ticket;
import com.se.Entities.ticket.request.CreateTicketRequest;
import com.se.Entities.ticket.response.TicketDto;

import lombok.NonNull;

public class TicketMapper {
    public static Ticket toEntity(CreateTicketRequest request, Patron patron, Book book) {
        return Ticket.builder()
                .loanDate(request.getLoanDate())
                .returnDate(request.getReturnDate())
                .patron(patron)
                .book(book)
                .build();
    }

    public static Ticket toEntity(TicketDto dto, Patron patron, Book book) {
        return Ticket.builder()
                .id(dto.getId())
                .loanDate(dto.getLoanDate())
                .returnDate(dto.getReturnDate())
                .patron(patron)
                .book(book)
                .build();
    }

    public static TicketDto toDto(Ticket entity) {
        return TicketDto.builder()
                .id(entity.getId())
                .loanDate(entity.getLoanDate())
                .returnDate(entity.getReturnDate())
                .patronId(PatronMapper.toId(entity.getPatron()))
                .bookId(BookMapper.toId(entity.getBook()))
                .build();
    }

    public static Long toId(@NonNull Patron patron) {
        return patron.getId();
    }
}
