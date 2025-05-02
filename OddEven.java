package STS2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> oddlist = new ArrayList<>();
        List<Integer> evenlist = new ArrayList<>();

        while(true){
            int x = sc.nextInt();
            if(x == -1){
                break;
            }
            if(x % 2 == 0){
                evenlist.add(x);
            } else {
                oddlist.add(x);
            }
        }

        oddlist.addAll(evenlist);

        for(int i = 0; i < oddlist.size(); i++){
            System.out.print(oddlist.get(i) + " ");
        }
        System.out.println();
    }

}
