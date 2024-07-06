package com.se.Entities.bookMetadata.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Builder
@Data
public class UpdateBookMetadataRequest {
    @NotNull(message = "Id must be valid.")
    private Long id;

    @NotNull(message = "Title must be valid.")
    private String title;

    @NotNull(message = "Author must be valid.")
    private String author;

    @NotNull(message = "Secondary authors must be valid.")
    private ArrayList<String> secondaryAuthors;

    @NotNull(message = "Isbn must be valid.")
    private String isbn;
}
