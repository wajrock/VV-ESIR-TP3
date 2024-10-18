# Balanced strings

A string containing grouping symbols `{}[]()` is said to be balanced if every open symbol `{[(` has a matching closed symbol `)]}` and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.

For example: `{[][]}({})` is balanced, while `][`, `([)]`, `{`, `{(}{}` are not.

Implement the following method:

```java
public static boolean isBalanced(String str) {
    ...
}
```

`isBalanced` returns `true` if `str` is balanced according to the rules explained above. Otherwise, it returns `false`.

Use the coverage criteria studied in classes as follows:

1. Use input space partitioning to design an initial set of inputs. Explain below the characteristics and partition blocks you identified.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators, check if the test cases written so far satisfy *Base Choice Coverage*. If needed, add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Write below the actions you took on each step and the results you obtained.
Use the project in [tp3-balanced-strings](../code/tp3-balanced-strings) to complete this exercise.

## Answer

1. There is a lot of partition identified. 
Empty string, unique pair which can be separed in two cases balanced ones () for  and unbalanced (, multiple pairs for example "({[]})", "{[()]}", mismatched symbols ([{]}), unmatched symboles with opening ones ([{ and closing ones ])}}.
Initialisation for each case:

2. In our case we are using the method isBalanced() to test the coverage of our test cases. This method checks if a  if a string containing grouping symbols is balanced.
First we use  a stack to store the opening symbols encountered while traversing the string. We are looking for opening symbols. If we encounter one, it is pushed onto the stack; if it's a closing symbol, we checks the basic case first which is  when stack don't contain any openings symbols, if it's the case we return `False`.  Then we verifies if the closing symbol matches the last opening symbol on the top of the stack. otherwise the method returns `false`. 
At the end  if the stack is empty, all opening symbols have been matched correctly, and the method returns `true`. Otherwise, it returns `false`, indicating that there are unmatched opening symbols left.

3.In the method  isBalanced,there is some predicate cases which use booloeans to evaluate conditions. We can find then in the method isMatching pair which uses more that two booleans.

