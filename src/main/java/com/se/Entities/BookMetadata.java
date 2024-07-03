package com.se.Entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;

@Entity
class BookMetadata {
    @Id
    @GeneratedValue
    public long id;   
    /**
     * @see Book
     */
    @OneToMany(mappedBy = "metadata")
    private Set<Book> copies = new HashSet<>();
    // TODO Adicionar limites de tamanho da string?
    private String title;
    // TODO Adicionar limites de tamanho da string?
    private String author;
    // TODO Adicionar limites de tamanho da string?
    private ArrayList<String> secondaryAuthors = new ArrayList<>();
    @Pattern(regexp = "\\d{10}(\\d{3})?", message = "{invalid.ISBN}")
    private String ISBN;

    //TODO Usaremos construtores ou um builder?
    //lembrar que a documentação tem esta nota sobre @Entity:
    //The class must have a public or protected, no-argument constructor. The class may have other constructors.

    public Set<Book> getCopies() {
        return this.copies;
    }
    public void addCopy(Book book) {
        this.copies.add(book);
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public ArrayList<String> getSecondaryAuthors() {
        return this.secondaryAuthors;
    }
    public String getISBN() {
        return this.ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
