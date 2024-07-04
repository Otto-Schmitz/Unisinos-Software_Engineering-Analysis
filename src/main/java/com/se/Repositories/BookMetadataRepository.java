package com.se.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.se.Entities.BookMetadata;

public interface BookMetadataRepository extends JpaRepository<BookMetadata, Long> {
}
