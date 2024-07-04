package com.se.Entities.book;


import com.se.Entities.BookMetadata;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @see BookMetadata
*/
@Entity
@Data
@NoArgsConstructor(force = true)
@Builder
@AllArgsConstructor
@Table(name = "book")
public class Book {
    /**
     * Identifica ema cópia física de um livro.
     */
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Relaciona com o {@link BookMetadata}.
     */
    @ManyToOne(optional = false)
    @NonNull
    private BookMetadata metadata;

    /**
     * Identificador do local em que o livro esta armazenado. 
     * <p>
     * Equivalente ao call number na biblioteca da Unisinos.
     */
    private Long storageLocation;

    private Integer edition;
    
    private Boolean borrowed;
}
