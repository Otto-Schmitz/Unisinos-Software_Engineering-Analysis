package com.se.Entities;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @see BookMetadata
*/
@Entity
@Table(name = "book")
class Book {
    /**
     * Identifica ema cópia física de um livro.
     */
    @Id
    @GeneratedValue
    private long copyID;
    /**
     * Relaciona com o {@link BookMetadata}.
     */
    @ManyToOne(optional = false)
    private BookMetadata metadata;

    /**
     * Identificador do local em que o livro esta armazenado. 
     * <p>
     * Equivalente ao call number na biblioteca da Unisinos.
     */
    private long storageLocation;

    private int edition;
    
    /**
     * @see Patron
     */
    @ManyToOne
    private Patron borrower;

    private Date borrowedUntil;

    //TODO Usaremos construtores ou um builder?
    //lembrar que a documentação tem esta nota sobre @Entity:
    //The class must have a public or protected, no-argument constructor. The class may have other constructors.

    public long getStorageLocation() {
        return this.storageLocation;
    }
    public void setStorageLocation(long storageLocation) {
        this.storageLocation = storageLocation;
    }
    public int getEdition() {
        return this.edition;
    }
    public void setEdition(int edition) {
        this.edition = edition;
    }
    public Patron getBorrower() {
        return this.borrower;
    }
    public void setBorrower(Patron borrower) {
        this.borrower = borrower;
    }
    public boolean isBorrowed() {
        return this.borrower == null;
    }
    public Date getBorrowedUntil() {
        return this.borrowedUntil;
    }
    public void setBorrowedUntil(Date borrowedUntil) {
        this.borrowedUntil = borrowedUntil;
    }
}
