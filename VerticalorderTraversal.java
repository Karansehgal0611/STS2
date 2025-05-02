package STS2;

import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class VerticalorderTraversal {

    // Pair to hold node and its horizontal distance
    static class Pair {
        Node node;
        int hd;
        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }

    static void verticalOrder(Node root) {
        if (root == null) return;

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            Node curr = temp.node;
            int hd = temp.hd;

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(curr.data);

            if (curr.left != null)
                queue.offer(new Pair(curr.left, hd - 1));
            if (curr.right != null)
                queue.offer(new Pair(curr.right, hd + 1));
        }

        System.out.println("Vertical Order Traversal:");
        for (List<Integer> level : map.values()) {
            for (int val : level)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    // Build example tree from image
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
        verticalOrder(root);
    }
}
