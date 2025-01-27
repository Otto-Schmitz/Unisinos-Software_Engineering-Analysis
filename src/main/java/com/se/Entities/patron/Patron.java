package com.se.Entities.patron;

import java.util.HashSet;
import java.util.Set;

import com.se.Entities.book.Book;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Patron {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    /**
     * Valor devido a biblioteca
     */
    @NonNull
    @Builder.Default
    private Integer debt = 0;

    /**
     * @see Book
     */
    @OneToMany
    @NonNull
    @Builder.Default 
    final private Set<Book> borrowedBooks = new HashSet<>();

    public void addBorrowedBooks(Book borrowedBooks) {
        this.borrowedBooks.add(borrowedBooks);
    }
}
