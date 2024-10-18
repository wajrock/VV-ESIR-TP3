package fr.istic.vv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

class BinaryHeap<T> {

    private List<T> heap;
    private Comparator<T> comparator;

    public BinaryHeap(Comparator<T> comparator) {
        this.comparator = comparator;
        this.heap = new ArrayList<>();
    }

    public T pop() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        T min = heap.get(0); // The root contains the minimum element
        T last = heap.remove(heap.size() - 1); // Remove the last element
        
        if (!heap.isEmpty()) {
            heap.set(0, last); // Place the last element at the root
            heapifyDown(0); // Reheapify from the root
        }
        return min;
    }

    public T peek() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap.get(0); // Return the root element without removing it
    }

    public void push(T element) {
        heap.add(element); // Add the element at the end
        heapifyUp(heap.size() - 1); // Reheapify from the added element's position
    }

    public int count() {
        return heap.size(); // Return the size of the heap
    }

    // Helper method to maintain the heap property when adding a new element
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (comparator.compare(heap.get(index), heap.get(parent)) < 0) {
                // Swap if the current element is smaller than its parent
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    // Helper method to maintain the heap property when removing an element
    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallest = index;

            if (leftChild < size && comparator.compare(heap.get(leftChild), heap.get(smallest)) < 0) {
                smallest = leftChild;
            }

            if (rightChild < size && comparator.compare(heap.get(rightChild), heap.get(smallest)) < 0) {
                smallest = rightChild;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
