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
        valid(day, month, year);
        this.month = (byte) month;
        this.day = (byte) day;
        this.year = (short) year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        valid(day, month, year);
        this.day = (byte) day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        valid(day, month, year);
        this.year = (short) year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        valid(day, month, year);
        this.month = (byte) month;
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
        valid(day, month, year);
        this.month = (byte) month;
        this.day = (byte) day;
        this.year = (short) year;
    }

    public static void leapYears() {
        for(int i = 1752; i <= 2020; i+=4) {
            if(i%100 == 0 && i%400 != 0) {
                continue;
            }
            System.out.println("The year " + i + " is a leap year");
        }
    }

    private void valid(int day, int month, int year) {
        try {
            if (day > 31 || day < 1 || month > 12 || month < 1 || year < 0) {
                throw new InvalidDateException("Attempting to create a non-valid date " + month + "/" + day + "/" + year);
            }
            switch (month) {
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day > 30)
                        throw new InvalidDateException(day + " is not a valid day for Month: " + month);
                case 2:
                    if (day > 28 && (year % 4 != 0 || day != 29))
                        throw new InvalidDateException(day + " is not a valid day for Month: " + month);
            }
        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }
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
