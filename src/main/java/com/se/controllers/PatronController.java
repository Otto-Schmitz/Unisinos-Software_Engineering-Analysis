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
import com.se.contracts.PatronInterface;

@RestController
@RequestMapping("/patrons")
public class PatronController {

    @Autowired
    private PatronInterface patronInterface;

    @PostMapping
    private ResponseEntity<PatronDto> create(CreatePatronRequest request) {
        return patronInterface.create(request);
    }
    @GetMapping("/{id}")
    private ResponseEntity<PatronDto> get(@PathVariable Long id) {
        return patronInterface.get(id);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Long> delete(@PathVariable Long id) {
        return patronInterface.delete(id);
    }

    @PutMapping
    private ResponseEntity<PatronDto> update(UpdatePatronRequest request) {
        return patronInterface.update(request);
    }
}
