package com.se.Entities.book.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateBookRequest {
    @NotNull(message = "MetadataId must be valid")
    private Long metadataId;

    @NotNull(message = "StorageLocation must be valid")
    private Long storageLocation;

    @NotNull(message = "Edition must be valid")
    private Integer edition;
}
