package com.example;

public class Book implements Printable {
    private String title;
    private String author;
    private String publisher;
    private String genre;
    private int numberOfPages;

    public Book(String title, String author, String publisher, String genre, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getGenre() {
        return genre;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public void print() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + publisher);
        System.out.println("Genre: " + genre);
        System.out.println("Number of pages: " + numberOfPages);
        System.out.println();
    }
}
