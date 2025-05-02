package STS2;

import java.util.*;
import java.util.LinkedList;

Class Node {
    int data;
    Node left,right;

    Node(int x){
        data = x;
        left = right = null;
    }
}

public class vot {

    Class Pair {
        Node node;
        int hd;
        Pair(Node n, int h){
            node = n;
            hd = h;
        }
    }

    public vois verticalOrder(Node root){
        if(root == null){
            return;
        }
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        Queue.offer(new Pair(root, 0))

        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            Node current = temp.node;
            int hd = temp.hd;

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(current.data);

            if(current.left != null){
                queue.offer(new Pair(current.left, hd - 1));
            }
            if(current.right != null){
                queue.offer(new Pair(current.right, hd + 1));
            }
        }

        System.out.println("Vertical Order Traversal:");
        for (List<Integer> level : map.values()) {
            for (int val : level)
                System.out.print(val + " ");
            System.out.println();
        }
    }



}
