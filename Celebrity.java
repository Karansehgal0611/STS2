package STS2;

import java.util.*;

public class Celebrity {
    public static void main(String[] args) {
        int[][] arr = {
            {0, 1, 0},
            {0, 0, 0},
            {1, 1, 0}
        };
        System.out.println(findCelebrity(arr));
    }

    static int findCelebrity(int[][] arr) {
        int n = arr.length;
        int candidate = 0;

        // Find a candidate
        for (int i = 1; i < n; i++) {
            if (arr[candidate][i] == 1) {
                candidate = i;
            }
        }

        // Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate && (arr[candidate][i] == 1 || arr[i][candidate] == 0)) {
                return -1; // No celebrity found
            }
        }
        return candidate; // Celebrity found
    }
}
