package fr.istic.vv;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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
        assertTrue(Date.isValidDate(date.getDay(), date.getMonth(), date.getYear()));
        assertFalse(Date.isValidDate(45, 6, 2022));
        assertFalse(Date.isValidDate(0, 6, 2022));
        assertFalse(Date.isValidDate(30, 15, 2022));
        assertFalse(Date.isValidDate(30, 0, 2022));
        assertFalse(Date.isValidDate(30, 8, -14));
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

    // Test for boundary dates in each month
    @Test
    public void testBoundaryDates() {
        // Test the first and last day of the months
        assertEquals("01/01/2022", new Date(1, 1, 2022).toString());
        assertEquals("31/01/2022", new Date(31, 1, 2022).toString());
        assertEquals("28/02/2022", new Date(28, 2, 2022).toString());  // Non-leap year
        assertEquals("29/02/2024", new Date(29, 2, 2024).toString());  // Leap year
        assertEquals("30/04/2022", new Date(30, 4, 2022).toString());
        assertEquals("31/12/2022", new Date(31, 12, 2022).toString());
    }

    @Test
    public void testNextDate() {
        Date date = new Date(28, 2, 2024);  // Leap year
        assertEquals("29/03/2024", date.nextDate().toString());  // Next day should be 29th Feb
        date = new Date(31, 12, 2023);
        assertEquals("01/01/2024", date.nextDate().toString());  // Next day should be 1st Jan 2024
    }

    @Test
    public void testPreviousDate() {
        Date date = new Date(1, 1, 2022);
        Date date1 = new Date(1, 5, 2022);
        assertEquals(date.previousDate().toString(), new Date(31, 12, 2021).toString());
        assertEquals(date1.previousDate().toString(), new Date(30, 4, 2022).toString());
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

    // Edge case: Minimum and Maximum possible dates (extreme year cases)
    @Test
    public void testMinMaxYear() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Date(31, 12, 0);  // Year 0 is invalid
        });
        assertDoesNotThrow(() -> {
            new Date(31, 12, 9999);  // Maximum valid year (arbitrary upper limit)
        });
    }
}
