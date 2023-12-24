package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Library implements Printable, ILibrary {
    private static final Date CURRENT_DATE = new Date(23, 12, 2023);
    private static Scanner scanner = new Scanner(System.in);

    public ArrayList<Book> bookList;
    public ArrayList<Member> memberList;
    public ArrayList<Loan> loanList;

    public Library() {
        bookList = new ArrayList<Book>();
        memberList = new ArrayList<Member>();
        loanList = new ArrayList<Loan>();
    }

    public void addBook() {
        System.out.println("-------- Adding a book --------");
        System.out.println("Enter book title:");
        String title = scanner.next();

        System.out.println("Enter book author: ");
        String author = scanner.next();

        System.out.println("Enter book publisher: ");
        String publisher = scanner.next();

        System.out.println("Enter book genre: ");
        String genre = scanner.next();

        System.out.println("Enter number of pages: ");
        int pages = scanner.nextInt();

        Book book = new Book(title, author, publisher, genre, pages);

        bookList.add(book);
        System.out.println("-------- Book added --------");
        System.out.println();
    }

    public void addMember() {
        System.out.println("-------- Adding a member --------");
        System.out.println("Enter member name: ");
        String name = scanner.next();

        System.out.println("Enter member address: ");
        String address = scanner.next();

        System.out.println("Enter member phone number: ");
        String phone = scanner.next();

        System.out.println("Enter member email: ");
        String email = scanner.next();

        Member member = new Member(name, address, phone, email);

        memberList.add(member);
        System.out.println("-------- Member added --------");
        System.out.println();
    }

    public void checkOutBook() {
        System.out.println("-------- Checking out a book --------");
        System.out.println("Enter the book name: ");
        String bookName = scanner.next();
        Book book = findBook(bookName);

        if (book == null) {
            System.out.println("-------- Book not found --------");
            System.out.println();
            return;
        }

        System.out.println("Enter member name: ");
        String memberName = scanner.next();
        Member member = findMember(memberName);

        if (member == null) {
            System.out.println("-------- Member not found --------");
            System.out.println();
            return;
        }

        Loan loan = new Loan(book, member, new Date());

        loanList.add(loan);
        System.out.println("-------- Book checked out --------");
        System.out.println();
    }

    public void checkIn() {
        System.out.println("-------- Checking in a book --------");
        System.out.println("Enter the book name: ");
        String bookName = scanner.next();
        Book book = findBook(bookName);

        if (book == null) {
            System.out.println("-------- Book not found --------");
            System.out.println();
            return;
        }

        System.out.println("Enter member name: ");
        String memberName = scanner.next();
        Member member = findMember(memberName);

        if (member == null) {
            System.out.println("-------- Member not found --------");
            System.out.println();
            return;
        }

        for (Loan loan : loanList) {
            if (loan.book.getTitle().equals(book.getTitle()) && loan.member.getName().equals(member.getName())) {
                loanList.remove(loan);
                break;
            }
        }

        System.out.println("-------- Book checked in --------");
        System.out.println();
    }

    public void printBookList() {
        System.out.println("-------- Printing book list --------");
        if (bookList.size() == 0) {
            System.out.println("-------- No books yet --------");
            System.out.println();
            return;
        }

        System.out.println("Book list: ");
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println("Book " + (i + 1) + ": ");
            bookList.get(i).print();
        }

        System.out.println("-------- Book list printed --------");
        System.out.println();
    }

    public void printMemberList() {
        System.out.println("-------- Printing member list --------");
        if (memberList.size() == 0) {
            System.out.println("-------- No members yet --------");
            System.out.println();
            return;
        }

        System.out.println("Member list: ");
        for (int i = 0; i < memberList.size(); i++) {
            System.out.println("Member " + (i + 1) + ": ");
            memberList.get(i).print();
        }

        System.out.println("-------- Member list printed --------");
        System.out.println();
    }

    public void printLoanList() {
        System.out.println("-------- Printing the book list that have been checked out --------");
        if (loanList.size() == 0) {
            System.out.println("-------- No books have been checked out yet --------");
            System.out.println();
            return;
        }

        System.out.println("Loan list: ");
        for (int i = 0; i < loanList.size(); i++) {
            System.out.println("Loan " + (i + 1) + ": ");
            loanList.get(i).print();
        }

        System.out.println("-------- Checked out book list printed --------");
        System.out.println();
    }

    public void printOverDues() {
        System.out.println("-------- Printing the overdue books list --------");
        ArrayList<OverDue> overDues = calcOverDues();

        if (overDues.size() == 0) {
            System.out.println("-------- No overdues --------");
            System.out.println();
            return;
        }

        for (int i = 0; i < overDues.size(); i++) {
            System.out.println("Overdue " + (i + 1) + ": ");
            overDues.get(i).print();
        }

        System.out.println("-------- Overdue book list printed --------");
        System.out.println();
    }

    @Override
    public void print() {
        printBookList();
        printMemberList();
        printLoanList();
        printOverDues();

        System.out.println("-------- Printed the entire report ---------");
        System.out.println();
    }

    public void calcSingleMemberOverDues() {
        System.out.println("-------- Calculating the single member fine --------");
        System.out.println("Enter the membername: ");
        String name = scanner.next();

        int totalOverDues = calcOverDues(name);

        if (totalOverDues == -1) {
            System.out.println("-------- Member not found --------");
            System.out.println();
            return;
        }

        System.out.println("Total fine on " + name + " is " + totalOverDues);

        System.out.println("-------- Single member fine calculated --------");
        System.out.println();
    }

    private ArrayList<OverDue> calcOverDues() {
        ArrayList<OverDue> overDues = new ArrayList<OverDue>();

        for (Loan loan : loanList) {
            int overdueDays = loan.dueDate.compareTo(CURRENT_DATE);
            if (overdueDays <= 0) {
                OverDue overDue = new OverDue(loan, overdueDays);
                overDues.add(overDue);
            }
        }

        return overDues;
    }

    private int calcOverDues(String memberName) {
        int totalOverDues = -1;

        for (Loan loan : loanList) {
            if (loan.member.getName().equals(memberName)) {
                if (totalOverDues == -1)
                    totalOverDues = 0;

                int overdueDays = loan.dueDate.compareTo(CURRENT_DATE);
                if (overdueDays <= 0) {
                    totalOverDues += overdueDays * 20;
                }
            }

        }

        return totalOverDues;
    }

    private Book findBook(String bookName) {
        for (Book book : bookList) {
            if (book.getTitle().equals(bookName)) {
                return book;
            }
        }

        return null;
    }

    private Member findMember(String name) {
        for (Member member : memberList) {
            if (member.getName().equals(name)) {
                return member;
            }
        }

        return null;
    }
}
