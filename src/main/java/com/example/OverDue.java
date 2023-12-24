package com.example;

public class OverDue implements Printable {
    private static final int FINE_PER_DAY = 10;

    Loan loan;
    int overdueDays;
    int fine;

    OverDue(Loan loan, int overdueDays) {
        this.loan = loan;
        this.overdueDays = overdueDays;
        this.fine = overdueDays * (-1) * FINE_PER_DAY;
    }

    @Override
    public void print() {
        System.out.println("Book: " + loan.book.getTitle());
        System.out.println("Member: " + loan.member.getName());
        System.out.println("Date: ");
        loan.dueDate.print();
        System.out.println();
        System.out.println("Overdue by: " + overdueDays);
        System.out.println("Fine: " + fine);
        System.out.println();
    }
}
