package com.acme.utils;

public class MyDate {
    public int day;
    public int year;
    public int month;

    {
        this.month = 1;
        this.day = 1;
        this.year = 2000;
    }

    public MyDate() { }

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String toString() {
        return this.month + "/" + this.day + "/" + this.year;
    }

    public void setDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }
}
