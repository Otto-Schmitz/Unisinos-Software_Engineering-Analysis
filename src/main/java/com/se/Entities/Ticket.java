package com.se.Entities;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.EqualsAndHashCode;

@Entity
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
@Table(name = "ticket")
class Ticket {
    /**
     *
     */
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private LocalDateTime returnDate;
    @NonNull
    private LocalDateTime loanDate;
    @ManyToOne
    @NonNull
    private Patron patron;
    @OneToOne
    @NonNull
    private Book book;
}
