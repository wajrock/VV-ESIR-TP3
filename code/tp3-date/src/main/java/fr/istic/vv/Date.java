package fr.istic.vv;

import java.util.Arrays;

class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        if (!isValidDate(day,month,year)){
            throw new IllegalArgumentException("Invalid date");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay(){
        return this.day;
    }

    public int getMonth(){
        return this.month;
    }
    public int getYear(){
        return this.year;
    }

    public static boolean isValidDate(int day, int month, int year) {
        return (day >= 1 && day <= getDaysInMonth(month, year) && (month >= 1 && month <= 12)) && year > 0;
    }

    public static int getDaysInMonth(int month, int year) {
        int[] monthsWith31Days = {1, 3, 5, 7, 8, 10, 12};
        int[] monthsWith30Days = {4, 6, 9, 11};

        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        } else if (Arrays.stream(monthsWith31Days).anyMatch(num -> num == month)) {
            return 31;
        } else if (Arrays.stream(monthsWith30Days).anyMatch(num -> num == month)) {
            return 30;
        }
        return 0;
    }

    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    public Date nextDate() {
        int maxDaysInMonth = getDaysInMonth(this.month, this.year);
        int newDay = this.day;
        int newMonth = this.month;
        int newYear = this.year;

        if (this.day == maxDaysInMonth){
            newDay = 1;
            newMonth = this.month + 1;

        } else {
            newDay = this.day + 1;
        }

        if (this.month == 12){
            newMonth = 1;
            newYear = this.year + 1;
        } else {
            newMonth = this.month + 1;
        }

        return new Date(newDay,newMonth,newYear);
    }

    public Date previousDate() {
        int newDay = this.day;
        int newMonth = this.month;
        int newYear = this.year;

        if (this.day == 1){
            if (this.month == 1){
                newMonth = 12;
                newYear = this.year - 1;
            } else {
                newMonth = this.month - 1;
            }
            newDay = getDaysInMonth(newMonth, newYear);
          
        } else {
            newDay = this.day - 1;
        }

        return new Date(newDay,newMonth,newYear);
    }

    @Override
    public int compareTo(Date other) {
        if (other == null) {
            throw new NullPointerException("The other date is null.");
        }

        if (this.year != other.year){
            return this.year - other.year;
        }

        if (this.month != other.month){
            return this.month = other.month;
        }

        return this.day - other.day;
    }

    @Override
    public String toString(){
        return (this.day <= 9 ? "0" : "")+this.day+"/"+(this.month <= 9 ? "0" : "")+ this.month +"/"+this.year;
    }

    public static void main(String[] args) {
        // Test the nextDate method for a leap year
        Date date = new Date(28, 2, 2024);  // Leap year
        System.out.println("Current Date: " + date);
        System.out.println("Next Date: " + date.nextDate());
    }

}
