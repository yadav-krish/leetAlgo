/**
 * Heap Concepts in Java
 * Topics:
 * 1. Priority Queue using Binary Heap
 * 2. Min Heap and Max Heap Implementation
 * 3. Check if an array is a Min Heap
 * 4. Convert Min Heap to Max Heap
 */

import java.util.*;

public class HeapConcepts {

    /**
     * 1. Introduction to Priority Queue using Binary Heap (Min-Heap by default)
     */
    public static void demoPriorityQueue() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // Min-Heap by default
        pq.add(10);
        pq.add(2);
        pq.add(5);

        System.out.println("Priority Queue (Min-Heap) order:");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " "); // Output: 2 5 10
        }
        System.out.println("\n");
    }

    /**
     * 2. Check if an array represents a Min Heap
     */
    public static boolean isMinHeap(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= (n - 2) / 2; i++) {
            if (2*i + 1 < n && arr[i] > arr[2*i + 1]) return false;
            if (2*i + 2 < n && arr[i] > arr[2*i + 2]) return false;
        }
        return true;
    }

    /**
     * 3. Convert Min Heap to Max Heap using heapify
     */
    public static void convertToMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = (n - 2) / 2; i >= 0; i--) {
            maxHeapify(arr, i, n);
        }
    }

    private static void maxHeapify(int[] arr, int i, int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, largest, n);
        }
    }

    /**
     * Demo runner
     */
    public static void main(String[] args) {
        // 1. Priority Queue demo
        demoPriorityQueue();

        // 2. Check if an array is a Min Heap
        int[] minHeap = {1, 3, 5, 7, 9, 2};
        System.out.println("Is Min Heap: " + isMinHeap(minHeap));

        // 3. Convert Min Heap to Max Heap
        System.out.println("Original Min-Heap Array: " + Arrays.toString(minHeap));
        convertToMaxHeap(minHeap);
        System.out.println("Converted Max-Heap Array: " + Arrays.toString(minHeap));
    }
}
