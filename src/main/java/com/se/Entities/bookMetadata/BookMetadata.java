package com.se.Entities.bookMetadata;

import com.se.Entities.book.Book;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
@Entity
public class BookMetadata {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * @see Book
     */
    @OneToMany(mappedBy = "metadata")
    @NonNull
    @Builder.Default
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
