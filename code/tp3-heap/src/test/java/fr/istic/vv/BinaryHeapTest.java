package fr.istic.vv;

import java.util.Comparator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryHeapTest {

    private BinaryHeap<Integer> minHeap;

    @BeforeEach
    void setUp() {
        // Create a min-heap with a comparator
        minHeap = new BinaryHeap<Integer>(Comparator.naturalOrder());
    }

    @Test
    void testPushAndPeek() {
        minHeap.push(5);
        assertEquals(5, minHeap.peek(), "Peek should return the smallest element");

        minHeap.push(2);
        assertEquals(2, minHeap.peek(), "Peek should return the smallest element after pushing 2");
    }

    @Test
    void testPop() {
        minHeap.push(5);
        minHeap.push(2);
        minHeap.push(8);

        assertEquals(2, minHeap.pop(), "Pop should return the smallest element");
        assertEquals(5, minHeap.pop(), "Pop should return the next smallest element");
        assertEquals(8, minHeap.pop(), "Pop should return the last element");
    }

    @Test
    void testPopOnEmptyHeap() {
        assertThrows(NoSuchElementException.class, () -> minHeap.pop(), "Pop on empty heap should throw an exception");
    }

    @Test
    void testPeekOnEmptyHeap() {
        assertThrows(NoSuchElementException.class, () -> minHeap.peek(), "Peek on empty heap should throw an exception");
    }

    @Test
    void testCount() {
        assertEquals(0, minHeap.count(), "Count should be 0 for an empty heap");

        minHeap.push(5);
        assertEquals(1, minHeap.count(), "Count should be 1 after adding one element");

        minHeap.push(3);
        minHeap.push(8);
        assertEquals(3, minHeap.count(), "Count should be 3 after adding three elements");

        minHeap.pop();
        assertEquals(2, minHeap.count(), "Count should be 2 after popping one element");
    }

    @Test
    void testHeapPropertyAfterMultipleInserts() {
        minHeap.push(5);
        minHeap.push(2);
        minHeap.push(8);
        minHeap.push(1);
        minHeap.push(4);

        // Popping elements should return them in sorted order
        assertEquals(1, minHeap.pop(), "Pop should return elements in ascending order");
        assertEquals(2, minHeap.pop(), "Pop should return elements in ascending order");
        assertEquals(4, minHeap.pop(), "Pop should return elements in ascending order");
        assertEquals(5, minHeap.pop(), "Pop should return elements in ascending order");
        assertEquals(8, minHeap.pop(), "Pop should return elements in ascending order");
    }
}
