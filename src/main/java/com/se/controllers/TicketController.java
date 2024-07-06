package com.se.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.Entities.patron.request.CreatePatronRequest;
import com.se.Entities.patron.request.UpdatePatronRequest;
import com.se.Entities.patron.response.PatronDto;
import com.se.Entities.ticket.request.CreateTicketRequest;
import com.se.Entities.ticket.response.TicketDto;
import com.se.contracts.TicketInterface;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketInterface ticketInterface;

    @PostMapping
    private ResponseEntity<TicketDto> create(CreateTicketRequest request) {
        return ticketInterface.create(request);
    }
    @GetMapping("/{id}")
    private ResponseEntity<TicketDto> get(@PathVariable Long id) {
        return ticketInterface.get(id);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Long> delete(@PathVariable Long id) {
        return ticketInterface.delete(id);
    }
}
