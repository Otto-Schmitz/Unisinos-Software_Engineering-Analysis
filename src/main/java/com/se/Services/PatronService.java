package com.se.Services;

import static com.se.Mappers.PatronMapper.toDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.se.Entities.patron.Patron;
import com.se.Entities.patron.request.CreatePatronRequest;
import com.se.Entities.patron.request.UpdatePatronRequest;
import com.se.Entities.patron.response.PatronDto;
import com.se.Mappers.PatronMapper;
import com.se.Repositories.PatronRepository;
import com.se.contracts.PatronInterface;

import jakarta.transaction.Transactional;

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

    @Override
    public ResponseEntity<PatronDto> get(Long id) {
        try {
            return ResponseEntity.ok(toDto(getById(id)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public Patron getById(Long id) {
        return patronRepository.findById(id).orElseThrow();
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
    public ResponseEntity<PatronDto> update(UpdatePatronRequest request) {
        try {
            return ResponseEntity.ok(toDto(updateBookMetadata(request)));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    @Transactional
    public Long deleteById(Long id) {
        getById(id);
        patronRepository.deleteById(id);

        return id;
    }

    private Patron updateBookMetadata(UpdatePatronRequest request) {
        return save(getById(request.getId()));
    }

    @Transactional
    private Patron save(Patron entity) {
        return patronRepository.save(entity);
    }
}
