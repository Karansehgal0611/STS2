package STS2;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Map.Entry;

class Node {
    int data, hd;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
        this.hd = Integer.MAX_VALUE;
    }
}

class Main {
    static Node root;

    // Build tree from input
    static Node build(String[] s) {
        if (s[0].equals("N") || s.length == 0) {
            return null;
        }

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            Node curr = q.poll();

            // Left child
            if (!s[i].equals("N")) {
                curr.left = new Node(Integer.parseInt(s[i]));
                q.add(curr.left);
            }
            i++;

            if (i >= s.length) break;

            // Right child
            if (!s[i].equals("N")) {
                curr.right = new Node(Integer.parseInt(s[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    // Right View
    void rightview(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node curr = q.poll();
                if (i == n - 1) {
                    System.out.print(curr.data + " ");
                }
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
    }

    // Left View
    void leftview(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node curr = q.poll();
                if (i == 0) {
                    System.out.print(curr.data + " ");
                }
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
    }

    // Top View
    static void topview(Node root) {
        if (root == null) return;

        Queue<QueueObj> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new QueueObj(root, 0));

        while (!q.isEmpty()) {
            QueueObj temp = q.poll();
            if (!map.containsKey(temp.hd)) {
                map.put(temp.hd, temp.node.data);
            }
            if (temp.node.left != null) q.add(new QueueObj(temp.node.left, temp.hd - 1));
            if (temp.node.right != null) q.add(new QueueObj(temp.node.right, temp.hd + 1));
        }

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    // Bottom View
    static void bottomview(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        root.hd = 0;
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            map.put(temp.hd, temp.data);

            if (temp.left != null) {
                temp.left.hd = temp.hd - 1;
                q.add(temp.left);
            }
            if (temp.right != null) {
                temp.right.hd = temp.hd + 1;
                q.add(temp.right);
            }
        }

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    // Helper class for top view
    static class QueueObj {
        Node node;
        int hd;

        QueueObj(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}

public class LL2 extends Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main ob = new Main();  // Fixed incorrect Map reference

        String[] s = sc.nextLine().split(" ");
        root = build(s);

        ob.rightview(root);
        System.out.println();
        ob.leftview(root);
        System.out.println();
        topview(root);
        System.out.println();
        bottomview(root);
    }
}
