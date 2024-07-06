package com.se.contracts;

import com.se.Entities.ticket.Ticket;
import com.se.Entities.ticket.request.CreateTicketRequest;
import com.se.Entities.ticket.response.TicketDto;

import org.springframework.http.ResponseEntity;

public interface TicketInterface {
    ResponseEntity<TicketDto> create(CreateTicketRequest request);

    ResponseEntity<TicketDto> get(Long id);

    Ticket getById(Long id);

    ResponseEntity<Long> delete(Long id);

    Long deleteById(Long id);
}
