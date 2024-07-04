package com.se.Entities.book;

import com.se.Entities.BookMetadata;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BookDto {
    private Long id;

    private BookMetadata metadata;

    private Long storageLocation;

    private Integer edition;

    private Boolean borrowed;
}
