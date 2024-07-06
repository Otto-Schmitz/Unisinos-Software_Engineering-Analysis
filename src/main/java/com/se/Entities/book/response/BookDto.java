package com.se.Entities.book.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BookDto {
    private Long id;

    private Long metadataId;

    private Long storageLocation;

    private Integer edition;

    private Boolean borrowed;
}
