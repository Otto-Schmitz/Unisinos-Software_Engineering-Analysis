package com.se.Entities.patron.response;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PatronDto {
    private Long id;

    private String firstName;

    private String lastName;

    private Integer debt = 0;

    private Set<Long> borrowedBooks;
}
