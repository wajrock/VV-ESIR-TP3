# Implementing and testing a binary heap

A [*binary heap*](https://en.wikipedia.org/wiki/Binary_heap) is a data structure that contains comparable objects and it is able to efficiently return the lowest element.
This data structure relies on a binary tree to keep the insertion and deletion operations efficient. It is the base of the [*Heapsort* algorithm](https://en.wikipedia.org/wiki/Heapsort).

Implement a `BinaryHeap` class with the following interface:

```java
class BinaryHeap<T> {

    public BinaryHeap(Comparator<T> comparator) { ... }

    public T pop() { ... }

    public T peek() { ... }

    public void push(T element) { ... }

    public int count() { ... }

}
```

A `BinaryHeap` instance is created using a `Comparator` object that represents the ordering criterion between the objects in the heap.
`pop` returns and removes the minimum object in the heap. If the heap is empty it throws a `NotSuchElementException`.
`peek` similar to `pop`, returns the minimum object but it does not remove it from the `BinaryHeap`.
`push` adds an element to the `BinaryHeap`.
`count` returns the number of elements in the `BinaryHeap`.

Design and implement a test suite for this `BinaryHeap` class.
Feel free to add any extra method you may need.

Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-heap](../code/tp3-heap) to complete this exercise.

## Answer


2. After designing the initial test cases using the ISP method, I evaluated the statement coverage. The initial test cases provided coverage for:

The basic operations of a heap with comparable elements.
Edge cases such as pushing and popping from an empty heap.

To increase the coverage we added folowing tests case :

- Added tests to cover the case of inserting a null element into the heap for push(), ensuring - that an exception is raised.
- Added tests for non-comparable elements being pushed into the heap, testing for exceptions.
- Added tests for peeking into an empty heap.
- Ensured that tests covered different sizes of the heap (empty, size = 1, size > 1).

3. We added new test cases to cover all possible combinations of conditions, including null elements, non-comparable elements, and comparable elements, ensuring that each true/false combination of interacting boolean conditions was tested at least once.

4. The mutation score from the PIT report shows that the test suite achieved 85% mutation coverage, with 28 out of 33 mutants killed. With a very high line coverage of 98% (43/44)