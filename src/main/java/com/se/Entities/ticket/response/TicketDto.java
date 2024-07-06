package com.se.Entities.ticket.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TicketDto {
    private Long id;

    private LocalDateTime returnDate;

    private LocalDateTime loanDate;

    private Long patronId;

    private Long bookId;
}
