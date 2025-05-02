package STS2;

import java.util.PriorityQueue;

public class KaryHeapUsingPriorityQueue {
    PriorityQueue<Integer> pq;

    // Constructor
    public KaryHeapUsingPriorityQueue() {
        pq = new PriorityQueue<>();
    }

    // Insert function (add to heap)
    public void insert(int val) {
        pq.offer(val);  // Same as add(), but returns false on failure instead of exception
        System.out.println(val + " inserted into the heap.");
    }

    // Extract-min function (remove and return min element)
    public int extractMin() {
        if (pq.isEmpty()) {
            throw new IllegalStateException("Heap is empty.");
        }
        int min = pq.poll();  // Removes and returns the smallest element
        System.out.println("Extracted min: " + min);
        return min;
    }

    // Optional: Peek at the min without removing
    public int getMin() {
        if (pq.isEmpty()) {
            throw new IllegalStateException("Heap is empty.");
        }
        return pq.peek();  // Returns smallest element without removing it
    }

    public static void main(String[] args) {
        KaryHeapUsingPriorityQueue heap = new KaryHeapUsingPriorityQueue();

        heap.insert(10);
        heap.insert(4);
        heap.insert(15);
        heap.insert(2);

        heap.extractMin(); // Should return 2
        heap.extractMin(); // Should return 4
    }
}
