package com.example;

public interface ILibrary {
    public void addBook();

    public void addMember();

    public void checkOutBook();

    public void checkIn();

    public void printBookList();

    public void printMemberList();

    public void printLoanList();

    public void printOverDues();

    public void calcSingleMemberOverDues();
}
