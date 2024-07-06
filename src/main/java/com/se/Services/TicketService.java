package com.se.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.se.Entities.book.Book;
import com.se.Entities.patron.Patron;
import com.se.Entities.ticket.Ticket;
import com.se.Entities.ticket.request.CreateTicketRequest;
import com.se.Entities.ticket.response.TicketDto;
import com.se.Mappers.TicketMapper;
import com.se.Repositories.TicketRepository;
import com.se.contracts.BookInterface;
import com.se.contracts.PatronInterface;
import com.se.contracts.TicketInterface;

import jakarta.transaction.Transactional;

@Service
public class TicketService implements TicketInterface  {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private PatronInterface patronInterface;

    @Autowired
    private BookInterface bookInterface;

    @Override
    public ResponseEntity<TicketDto> create(CreateTicketRequest request) {
        try {
            return ResponseEntity.ok(TicketMapper.toDto(createTicket(request)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    private Ticket createTicket(CreateTicketRequest request) {
        Patron patron = patronInterface.getById(request.getPatronId());
        Book book = bookInterface.getById(request.getBookId());
        return ticketRepository.save(TicketMapper.toEntity(request, patron, book));
    }

    @Override
    public ResponseEntity<TicketDto> get(Long id) {
        try {
            return ResponseEntity.ok(TicketMapper.toDto(getById(id)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public Ticket getById(Long id) {
        return ticketRepository.findById(id).orElseThrow();
    }

    @Override
    public ResponseEntity<Long> delete(Long id) {
        try {
            return ResponseEntity.ok(deleteById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    @Transactional
    public Long deleteById(Long id) {
        getById(id);
        ticketRepository.deleteById(id);

        return id;
    }

    @Transactional
    private Ticket save(Ticket entity) {
        return ticketRepository.save(entity);
    }
}
