package com.se.Entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
class Patron {
    @Id
    @GeneratedValue
    public long id;

    private String firstName;
    private String lastName;
    /**
     * Valor devido a biblioteca
     */
    private int debt;

    /**
     * @see Book
     */
    @OneToMany(mappedBy = "borrower")
    private Set<Book> borrowedBooks = new HashSet<>();

    // TODO construtores
    //lembrar que a documentação tem esta nota sobre @Entity:
    //The class must have a public or protected, no-argument constructor. The class may have other constructors.

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDebt() {
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }

    public Set<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBorrowedBooks(Book borrowedBooks) {
        this.borrowedBooks.add(borrowedBooks);
    }
}
