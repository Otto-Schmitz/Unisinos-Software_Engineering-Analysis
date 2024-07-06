package com.se.Entities.ticket;


import java.time.LocalDateTime;

import com.se.Entities.book.Book;
import com.se.Entities.patron.Patron;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Ticket {
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
    @ManyToOne
    @NonNull
    private Book book;
}
