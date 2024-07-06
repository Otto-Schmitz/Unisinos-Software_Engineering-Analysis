package com.se.contracts;

import com.se.Entities.patron.request.CreatePatronRequest;
import com.se.Entities.patron.response.PatronDto;

import org.springframework.http.ResponseEntity;

public interface PatronInterface {
    ResponseEntity<PatronDto> create(CreatePatronRequest request);
}
