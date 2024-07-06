package com.se.contracts;

import com.se.Entities.patron.Patron;
import com.se.Entities.patron.request.CreatePatronRequest;
import com.se.Entities.patron.request.UpdatePatronRequest;
import com.se.Entities.patron.response.PatronDto;

import org.springframework.http.ResponseEntity;

public interface PatronInterface {
    ResponseEntity<PatronDto> create(CreatePatronRequest request);

    ResponseEntity<PatronDto> get(Long id);

    Patron getById(Long id);

    ResponseEntity<Long> delete(Long id);

    Long deleteById(Long id);

    ResponseEntity<PatronDto> update(UpdatePatronRequest request);
}
