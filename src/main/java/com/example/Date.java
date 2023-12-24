package com.example;

public class Date implements Printable, Comparable<Date> {
    private static final int DAYS_IN_A_YEAR = 365;
    private static final int DAYS_IN_A_MONTH = 30;

    private int year;
    private int month;
    private int day;

    Date() {
        this(2023, 12, 23);
    }

    Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public void print() {
        System.out.print(this.getDay() + "/" + this.getMonth() + "/" + this.getYear());
    }

    public Date getCurrentDate() {
        return new Date(2023, 12, 23);
    }

    @Override
    public int compareTo(Date otherDate) {
        if (this == otherDate)
            return 0;

        return calcDateDiff(otherDate, otherDate);
    }

    private int calcDateDiff(Date date1, Date date2) {
        int yearDiff = (date1.getYear() - date2.getYear()) * DAYS_IN_A_YEAR;
        int monthDiff = (date1.getMonth() - date2.getMonth()) * DAYS_IN_A_MONTH;
        int dayDiff = (date1.getDay() - date2.getDay());

        return dayDiff + monthDiff + yearDiff;
    }
}
