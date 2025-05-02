package STS2;
import java.util.*;

public class towerHanoi {
    
    public static void moveDisks(int n, int src, int dest, int aux){
        if(n==1){
            System.out.println("rod " + src + " to rod " + dest);
            return;
        }
        moveDisks(n-1, src, aux, dest);
        System.out.println("rod " + src + " to rod " + dest);
        moveDisks(n-1, aux, dest, src);
    }
    public static void main(String[] args) {
        int n = 3; // Number of disks
        moveDisks(n, 1, 3, 2); // Move disks from rod 1 to rod 3 using rod 2 as auxiliary

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(10);
        pq.add(5);
        pq.add(20);

        System.out.println("PriorityQueue:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());  // Removes and returns the smallest element
        }
    }
}
