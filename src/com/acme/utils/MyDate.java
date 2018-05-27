package com.acme.utils;

public class MyDate {
    private byte day;
    private short year;
    private byte month;

    {
        this.month = 1;
        this.day = 1;
        this.year = 2000;
    }

    public MyDate() {
        this(1, 1, 1900);
    }

    public MyDate(int month, int day, int year) {
        if(valid(day, month, year)){
            this.month = (byte) month;
            this.day = (byte) day;
            this.year = (short) year;
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if(valid(day, month, year)){
            this.day = (byte) day;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(valid(day, month, year)){
            this.year = (short) year;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(valid(day, month, year)){
            this.month = (byte) month;
        }
    }

    public String toString() {
        return this.month + "/" + this.day + "/" + this.year;
    }

    public void setDate(int month, int day, int year) {
        if(valid(day, month, year)) {
            this.month = (byte) month;
            this.day = (byte) day;
            this.year = (short) year;
        }
    }

    public static void leapYears() {
        for(int i = 1752; i <= 2020; i+=4) {
            if(i%100 == 0 && i%400 != 0) {
                continue;
            }
            System.out.println("The year " + i + " is a leap year");
        }
    }

    private boolean valid(int day, int month, int year) {
        if(day > 31 || day < 1 || month > 12 || month < 1 || year < 0) {
            System.out.println("Attempting to create a non-valid date " + month + "/" + day + "/" + year);
            return false;
        }
        switch(month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return day <= 30;
            case 2:
                return day <= 28 || (day == 29 && year %4 == 0);
        }
        return true;
    }

    public boolean equals(Object o) {
        if(o instanceof MyDate) {
            MyDate d = (MyDate) o;
            if(d.day == day && d.month == month && d.year == year) {
                return true;
            }
        }
        return false;
    }
}
