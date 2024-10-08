# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer


1. The assertion `assertTrue(3 * .4 == 1.2)` fails due to the fact that the float management in computing is not optimal. The operation 3* .4 don't return 1.2 exactly. To fix that, we can use assertEquals(value,expected,delta) where delta is the difference tolerance which allows a small margin for errorbetween the two values.

2. 
assertEquals() compares the values of objects using the equals() method. Which means that if two objects are different in memory but their content is considered equivalent, assertEquals will pass. 
Otherwise asserSame() compares the identity of objects, which means that whether the two objects refer to the exact same memory location. It uses the (==) operator to check if both references point to the same instance, without comparing their content.

-Scenario where they produce the same result:

-->we are going to take the case of two variables point to the same string in memory 

String str1 = "hello";
String str2 = "hello";
assertEquals(str1, str2);  //  values are equal
assertSame(str1, str2);    // it references point to the same instance

-Scenario where they produce different results:

--> in this case, we are creating new objects each time so they refer to two distinct objects in memory. Since we are creation new objects, they are stored at different memory locations. that's wht the assertSame will fail.

String str1 = new String("hello");
String str2 = new String("hello");

assertEquals(str1, str2);  // Passes, values are equal
assertSame(str1, str2);    // the references are different

3. 'fail' can be used in many cases for example :
-->To indicate unimplemented features or test cases:
use case: You're writing tests for a feature that is still under development, and you want to leave a placeholder for the future implementation.

@Test
public void testNewFeature() {
    // This test is not implemented yet
    fail("Feature not yet implemented.");
}

-->if you want that specific sections of code to never be executed.
use case: You're testing a method that should never reach a specific branch of a  loop.

@Test
public void testConditionLogic() {
    int value = 5;
    
    if (value < 0) {
        fail("Negative values should not be possible in this scenario.");
    }
}

-->To check pre-conditions before continuing with a test
use case:A test is dependent on certain data being initialized.

@Test
public void testWithPrecondition() {
    String data = loadData();
    
    if (data == null) {
        fail("Data must be initialized before the test can continue.");
    }
    
    // Proceed with the test if the pre-condition is satisfied
}

4.  JUnit 5 introduces assertThrows to explicitly test for exceptions. This method is more flexible and readable than the @Test approach in JUnit 4. In fact it allows precise testing of where the exception occurs and enables you to inspect the thrown exception for further validation. 











