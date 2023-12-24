package com.example;

public class Loan implements Printable {
    Book book;
    Member member;
    Date dueDate;

    Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.dueDate = new Date(2023, 12, 31);
    }

    Loan(Book book, Member member, Date dueDate) {
        this.book = book;
        this.member = member;
        this.dueDate = dueDate;
    }

    @Override
    public void print() {
        System.out.println("Book: " + book.getTitle());
        System.out.println("Member: " + member.getName());
        System.out.print("Due date: ");
        dueDate.print();
        System.out.println();
    }
}
