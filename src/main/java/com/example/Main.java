package com.example;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to library management system");

        Library library = new Library();

        int option;

        do {
            System.out.println("-----------------------------------");
            System.out.println("1: Add book to library");
            System.out.println("2: Add member to library");
            System.out.println("3: Checkout a book");
            System.out.println("4: Check in a book");
            System.out.println("5: Print the book list");
            System.out.println("6: Print the member list");
            System.out.println("7: Print the book list that have been checked out");
            System.out.println("8: Print the overdue book list");
            System.out.println("9: Print the entire library report");
            System.out.println("10: Get the total fine for a particular member");
            System.out.println("0: Exit");
            System.out.println("--------------------------------------");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    library.addBook();
                    break;

                case 2:
                    library.addMember();
                    break;

                case 3:
                    library.checkOutBook();
                    break;

                case 4:
                    library.checkIn();
                    break;

                case 5:
                    library.printBookList();
                    break;

                case 6:
                    library.printMemberList();
                    break;

                case 7:
                    library.printLoanList();
                    break;

                case 8:
                    library.printOverDues();
                    break;

                case 9:
                    library.print();
                    break;

                case 10:
                    library.calcSingleMemberOverDues();
                    break;

                default:
                    break;
            }
        } while (option != 0);
    }
}