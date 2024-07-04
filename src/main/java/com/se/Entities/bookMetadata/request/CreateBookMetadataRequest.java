package com.se.Entities.bookMetadata.request;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Builder
@Data
public class CreateBookMetadataRequest {
    private Long id;

    private String title;

    private String author;

    private ArrayList<String> secondaryAuthors;

    private String isbn;
}
