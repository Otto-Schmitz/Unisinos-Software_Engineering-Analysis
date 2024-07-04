package com.se.Entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
@Entity
class BookMetadata {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;   
    /**
     * @see Book
     */
    @OneToMany(mappedBy = "metadata")
    @NonNull
    private Set<Book> copies = new HashSet<>();
    @NonNull
    private String title;
    @NonNull
    private String author;
    @NonNull
    private ArrayList<String> secondaryAuthors = new ArrayList<>();
    @Pattern(regexp = "\\d{10}(\\d{3})?", message = "{invalid.ISBN}")
    @NonNull
    private String isbn;

    public void addCopy(Book book) {
        this.copies.add(book);
    }
}
