package STS2;

import java.util.*;
import java.util.LinkedList;

class Node{
    int data;
    Node left,right;

    Node(int x){
        data = x;
        left = right = null;
    }
}

public class VerticalOrderPrac {
    // Pair to store <Node, height>
    static class Pair{
        Node node;
        int h;

        Pair(Node n, int height){
            node = n;
            h = height;
        }
    }

    static void Vertical(Node root){
        if(root == null){
            return;
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            Node curr = temp.node;
            int hd = temp.h;

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(curr.data);

            if(curr.left != null){
                queue.offer(new Pair(curr.left, hd - 1));
            }
            if(curr.right != null){
                queue.offer(new Pair(curr.right, hd + 1));
            }
        }

        System.out.println("Verical Order Traversal");
        for(List<Integer> list : map.values()){
            for(int val : list){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static Node buildTree(Integer[] levelOrder) {
        if (levelOrder.length == 0 || levelOrder[0] == null) return null;

        Node root = new Node(levelOrder[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < levelOrder.length) {
            Node current = queue.poll();

            if (levelOrder[i] != null) {
                current.left = new Node(levelOrder[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < levelOrder.length && levelOrder[i] != null) {
                current.right = new Node(levelOrder[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static Node buildExampleTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }

    public static void main(String[] args) {
        Node root = buildExampleTree();
        Vertical(root);
    }

    
}
