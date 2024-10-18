# Test the Date class

Implement a class `Date` with the interface shown below:

```java
class Date implements Comparable<Date> {

    public Date(int day, int month, int year) { ... }

    public static boolean isValidDate(int day, int month, int year) { ... }

    public static boolean isLeapYear(int year) { ... }

    public Date nextDate() { ... }

    public Date previousDate { ... }

    public int compareTo(Date other) { ... }

}
```

The constructor throws an exception if the three given integers do not form a valid date.

`isValidDate` returns `true` if the three integers form a valid year, otherwise `false`.

`isLeapYear` says if the given integer is a leap year.

`nextDate` returns a new `Date` instance representing the date of the following day.

`previousDate` returns a new `Date` instance representing the date of the previous day.

`compareTo` follows the `Comparable` convention:

* `date.compareTo(other)` returns a positive integer if `date` is posterior to `other`
* `date.compareTo(other)` returns a negative integer if `date` is anterior to `other`
* `date.compareTo(other)` returns `0` if `date` and `other` represent the same date.
* the method throws a `NullPointerException` if `other` is `null` 

Design and implement a test suite for this `Date` class.
You may use the test cases discussed in classes as a starting point. 
Also, feel free to add any extra method you may need to the `Date` class.


Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-date](../code/tp3-date) to complete this exercise.

## Answer

1. For the Date class, Input Space Partitioning helped identify different categories of inputs. The constructor tests include valid and invalid dates, leap years, and boundary dates, such as the 31st of a month with only 30 days. The isValidDate method checks both valid and invalid dates, while isLeapYear focuses on leap years. The nextDate and previousDate methods verify correct transitions between dates, including month and year changes. Lastly, compareTo tests for equal, earlier, and later date comparisons.

2. After designing the tests, we evaluated the statement coverage. Additional tests were added to cover edge cases, such as transitions between months and years, and end-of-month dates. This ensured that all lines of code were covered.

3. To check Base Choice Coverage (BCC), we analyzed predicates with multiple boolean operators, particularly in the isLeapYear method. We added test cases for all possible combinations of boolean conditions (divisibility by 4, 100, and 400) to ensure all logical options were covered.

4. After using PIT to evaluate the test suite, the mutation score reached 81%, with 47 mutants killed out of 58. Some mutants survived, indicating that additional tests are needed to cover specific edge cases involving month and year transitions. Adding tests for boundary dates, such as the last day of February or the end of a year, could further improve this score.