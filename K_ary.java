package STS2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class K_ary {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();

       PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

       for (int i = 0; i < n; i++) {
           maxHeap.add(sc.nextInt());
       }

       System.out.println("insert element: ");
       maxHeap.add(sc.nextInt());

       if (!maxHeap.isEmpty()) {
           System.out.println("Top Element: " + maxHeap.poll());
       } else {
           System.out.println("Heap is empty");
       }

       for (int num : maxHeap) {
           System.out.print(num + " ");
       }

   }
}
