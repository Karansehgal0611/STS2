package STS2;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BitonicDLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer>  arr = new ArrayList<>();

        while(true){
            int x = sc.nextInt();
            if(x == -1){
                break;
            }
            arr.add(x);
        }
        int k[] = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            k[i] = arr.get(i);
        }
        Arrays.sort(k);
        for(int num : k){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
