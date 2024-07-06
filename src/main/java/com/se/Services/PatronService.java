package com.se.Services;

import static com.se.Mappers.PatronMapper.toDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.se.Entities.patron.Patron;
import com.se.Entities.patron.request.CreatePatronRequest;
import com.se.Entities.patron.response.PatronDto;
import com.se.Mappers.PatronMapper;
import com.se.Repositories.PatronRepository;
import com.se.contracts.PatronInterface;

@Service
public class PatronService implements PatronInterface  {

    @Autowired
    private PatronRepository patronRepository;

    @Override
    public ResponseEntity<PatronDto> create(CreatePatronRequest request) {
        try {
            return ResponseEntity.ok(toDto(createPatron(request)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    private Patron createPatron(CreatePatronRequest request) {
        return patronRepository.save(PatronMapper.toEntity(request));
    }
}
