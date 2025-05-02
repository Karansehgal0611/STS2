package STS2;

import java.util.Arrays;
import java.util.Scanner;

public class WinnerTrees {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter number of elements: ");
       int n = scanner.nextInt();
       int[] arr = new int[n];
       System.out.println("Enter " + n + " elements:");
       for (int i = 0; i < n; i++) {
           arr[i] = scanner.nextInt();
       }
       Arrays.sort(arr); // Sort the array
       int min = arr[0], secondMin = arr[1];
       System.out.println("Minimum: " + min + ", Second Minimum: " + secondMin);
       scanner.close();
   }
}
