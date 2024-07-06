package com.se.Entities.patron.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UpdatePatronRequest {
    @NotNull(message = "Id must be valid.")
    private Long id;

    @NotNull(message = "FirstName must be valid.")
    private String firstName;

    @NotNull(message = "LastName must be valid.")
    private String lastName;

    @NotNull(message = "Debt must be valid.")
    private Integer debt;
}
