# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

### DetachedTestCase

``` java
public void testConcatenateEmptyArguments() {
713         final double[] x = new double[] {0, 1, 2};
714         final double[] y = new double[] {3};
715         final double[] z = new double[] {};
716         final double[] u = new double[] {0, 1, 2, 3};
717         Assert.assertArrayEquals(u,  MathArrays.concatenate(x, z, y), 0);
718         Assert.assertArrayEquals(u,  MathArrays.concatenate(x, y, z), 0);
719         Assert.assertArrayEquals(u,  MathArrays.concatenate(z, x, y), 0);
720         Assert.assertEquals(0,  MathArrays.concatenate(z, z, z).length);
721     }

```

This example is a detached Test because it don't have @Test tag or annotation. The good version of this test would be 


``` java
@Test
public void testConcatenateEmptyArguments() {
713         final double[] x = new double[] {0, 1, 2};
714         final double[] y = new double[] {3};
715         final double[] z = new double[] {};
716         final double[] u = new double[] {0, 1, 2, 3};
717         Assert.assertArrayEquals(u,  MathArrays.concatenate(x, z, y), 0);
718         Assert.assertArrayEquals(u,  MathArrays.concatenate(x, y, z), 0);
719         Assert.assertArrayEquals(u,  MathArrays.concatenate(z, x, y), 0);
720         Assert.assertEquals(0,  MathArrays.concatenate(z, z, z).length);
721     }


### JUnitUseExpected

```java
        @Test
     public void testIteratorZeroElement() {
         final int start = 1;
         final int max = 1;
         final int step = 1;

         final IntegerSequence.Incrementor inc
             = IntegerSequence.Incrementor.create()
             .withStart(start)
             .withMaximalCount(max)
             .withIncrement(step);

         Assert.assertFalse(inc.hasNext());
         try {
             inc.increment();
             Assert.fail("exception expected");
         } catch (MaxCountExceededException e) {
             // Expected.
         }
     }
```

```java
        @Test(expected=Exception.class)
     public void testIteratorZeroElement() {
         final int start = 1;
         final int max = 1;
         final int step = 1;

         final IntegerSequence.Incrementor inc
             = IntegerSequence.Incrementor.create()
             .withStart(start)
             .withMaximalCount(max)
             .withIncrement(step);

         Assert.assertFalse(inc.hasNext());
         inc.increment();
     }
```

The use of try catch block in the test is not optimal. To optimize this we would use @Test(expected=Exception.class)



```java


# JUnitTestsShouldIncludeAssert

@Test
     public void testParabaloid() {
         final int numberOfElements = 10;
         final double minimumX = -10;
         final double maximumX = 10;
         final double minimumY = -10;
         final double maximumY = 10;
         final int numberOfSamples = 100;

         final double interpolationTolerance = 1e-13;
         final double maxTolerance = 6e-14;

         // Function values
         BivariateFunction f = new BivariateFunction() {
                 @Override
                 public double value(double x, double y) {
                     return 2 * x * x - 3 * y * y + 4 * x * y - 5;
                 }
             };

         testInterpolation(minimumX,
                           maximumX,
                           minimumY,
                           maximumY,
                           numberOfElements,
                           numberOfSamples,
                           f,
                           interpolationTolerance,
                           maxTolerance);
     }


```

```java

@Test
     public void testParabaloid() {
         final int numberOfElements = 10;
         final double minimumX = -10;
         final double maximumX = 10;
         final double minimumY = -10;
         final double maximumY = 10;
         final int numberOfSamples = 100;

         final double interpolationTolerance = 1e-13;
         final double maxTolerance = 6e-14;

         // Function values
         BivariateFunction f = new BivariateFunction() {
                 @Override
                 public double value(double x, double y) {
                     return 2 * x * x - 3 * y * y + 4 * x * y - 5;
                 }
             };

        assertTrue(Double.valueOf(f))

         testInterpolation(minimumX,
                           maximumX,
                           minimumY,
                           maximumY,
                           numberOfElements,
                           numberOfSamples,
                           f,
                           interpolationTolerance,
                           maxTolerance);
     }


```

In this text, we don't have any asserts and it's not recommended. So we can implement an assert to verify that BivariateFunction f return a double type value
