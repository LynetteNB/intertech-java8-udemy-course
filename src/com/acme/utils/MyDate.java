package com.acme.utils;

public class MyDate {
    private byte day;
    private short year;
    private byte month;
    private static MyDate[] holidays;

    {
        this.month = 1;
        this.day = 1;
        this.year = 2000;
    }

    static {
        holidays = new MyDate[6];
        holidays[0] = new MyDate(1, 1, 2016);
        holidays[1] = new MyDate(5, 30, 2016);
        holidays[2] = new MyDate(7, 4, 2016);
        holidays[3] = new MyDate(9, 5, 2016);
        holidays[4] = new MyDate(11, 24, 2016);
        holidays[5] = new MyDate(12, 25, 2016);
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

    public static MyDate[] getHolidays() {
        return holidays;
    }

    public static void setHolidays(MyDate[] holidays) {
        MyDate.holidays = holidays;
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

    public static void listHolidays() {
        System.out.println("The Holidays Are:");
        for(MyDate holiday: holidays) {
            System.out.println(holiday);
        }
    }
}
