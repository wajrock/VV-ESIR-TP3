package fr.istic.vv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class DateTest {
    @Test
    public void testValidDate() {
        Date date = new Date(15, 6, 2022);
        
        assertEquals("15/06/2022", date.toString());
        assertTrue(Date.isValidDate(date.getDay(),date.getMonth(),date.getYear()));
        assertFalse(Date.isValidDate(45,6,2022));
        assertFalse(Date.isValidDate(0,6,2022));
        assertFalse(Date.isValidDate(30,15,2022));
        assertFalse(Date.isValidDate(30,0,2022));
        assertFalse(Date.isValidDate(30,8,-14));
    }   

    @Test
    public void testLeapYear() {
        Date date = new Date(29, 2, 2024);  // Leap year
        assertTrue(Date.isLeapYear(2024));
        assertFalse(Date.isLeapYear(1900));
        assertTrue(Date.isLeapYear(2000));
    }

    @Test
    public void testInvalidDayForMonth() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Date(30, 2, 2023);  // Invalid: February has only 28/29 days
        });
    }

    @Test
    public void testNegativeDay() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Date(-1, 3, 2023);  // Invalid: Negative day
        });
    }

    @Test
    public void testInvalidMonth() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Date(15, 13, 2023);  // Invalid: Month 13 doesn't exist
        });
    }

    @Test
    public void testInvalidYear() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Date(15, 6, -100);  // Invalid: Negative year
        });
    }

    // Additional test case for Base Choice Coverage: century year not leap
    @Test
    public void testNonLeapYearCentury() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Date(29, 2, 1900);  // Invalid: 1900 is not a leap year
        });
    }

    @Test
    public void testPreviousDate() {
        Date date = new Date(1, 1, 2022);
        Date date1 = new Date(1, 5, 2022);
        assertEquals(date.previousDate().toString(), new Date(31,12,2021).toString());
        assertEquals(date1.previousDate().toString(), new Date(30,4,2022).toString());
    }

    // Test cases for compareTo method
    @Test
    public void testCompareToLaterDate() {
        Date date1 = new Date(15, 6, 2022);
        Date date2 = new Date(12, 6, 2022);
        assertTrue(date1.compareTo(date2) > 0);  // date1 is later
    }

    @Test
    public void testCompareToEarlierDate() {
        Date date1 = new Date(12, 6, 2022);
        Date date2 = new Date(15, 6, 2022);
        assertTrue(date1.compareTo(date2) < 0);  // date1 is earlier
    }

    @Test
    public void testCompareToEqualDate() {
        Date date1 = new Date(15, 6, 2022);
        Date date2 = new Date(15, 6, 2022);
        assertEquals(0, date1.compareTo(date2));  // dates are equal
    }

    @Test
    public void testCompareToNull() {
        Date date = new Date(15, 6, 2022);
        assertThrows(NullPointerException.class, () -> {
            date.compareTo(null);  // Should throw NullPointerException
        });
    }

    @Test
    public void testCompareToLeapYear() {
        Date date1 = new Date(29, 2, 2024);  // Leap year
        Date date2 = new Date(28, 2, 2024);  // Day before leap day
        assertTrue(date1.compareTo(date2) > 0);  // date1 is later
    }

    @Test
    public void testCompareToNonLeapYear() {
        Date date1 = new Date(28, 2, 2023);  // Non-leap year
        Date date2 = new Date(29, 2, 2024);  // Leap year
        Date date3 = new Date(22, 4, 2023);
        assertTrue(date1.compareTo(date2) < 0);  // date1 is earlier
        assertTrue(date1.compareTo(date3) > 0);
    }


}