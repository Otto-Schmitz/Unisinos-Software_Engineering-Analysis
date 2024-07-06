package com.se.Entities.ticket.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateTicketRequest {
    @NotNull(message = "ReturnDate must be valid")
    private LocalDateTime returnDate;

    @NotNull(message = "LoanDate must be valid")
    private LocalDateTime loanDate;

    @NotNull(message = "BookId must be valid")
    private Long bookId;

    @NotNull(message = "PatronId must be valid")
    private Long patronId;
}
