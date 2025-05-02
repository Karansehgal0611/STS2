package STS2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);


       // Take input for number of elements
       System.out.print("Enter number of elements: ");
       int n = scanner.nextInt();


       // Create an ArrayList to store the elements
       List<Integer> numbers = new ArrayList<>();
       System.out.println("Enter " + n + " numbers:");
       for (int i = 0; i < n; i++) {
           numbers.add(scanner.nextInt());
       }


       // Sort the list using Collections.sort()
       Collections.sort(numbers);


       // Print the sorted list
       System.out.println("Sorted Numbers: " + numbers);
   }

}
