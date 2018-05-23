public class MyDate {
    int day;
    int year;
    int month;

    {
        this.month = 1;
        this.day = 1;
        this.year = 2000;
    }

    MyDate() { }

    MyDate(int month, int day, int year) {
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
