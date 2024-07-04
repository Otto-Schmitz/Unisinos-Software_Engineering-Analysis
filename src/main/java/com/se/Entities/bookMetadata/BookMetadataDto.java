package com.se.Entities.bookMetadata;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Set;

@Builder
@Data
public class BookMetadataDto {
    private Long id;

    private Set<Long> copies;

    private String title;

    private String author;

    private ArrayList<String> secondaryAuthors;

    private String isbn;
}
