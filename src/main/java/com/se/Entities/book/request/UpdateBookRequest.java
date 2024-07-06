package com.se.Entities.book.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UpdateBookRequest {
    @NotNull(message = "Id must be valid.")
    private Long id;

    @NotNull(message = "StorageLocation must be valid.")
    private Long storageLocation;

    @NotNull(message = "Edition must be valid.")
    private Integer edition;

    @NotNull(message = "Borrowed must be valid.")
    private Boolean borrowed;

    @NotNull(message = "MetadataId must be valid.")
    private Long metadataId;
}
