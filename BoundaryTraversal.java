package STS2;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BoundaryTraversal {

    // Build tree from level order input using nulls for missing nodes
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

    public static void printBoundary(Node root) {
        if (root == null) return;

        System.out.print("Boundary Traversal: ");
        System.out.print(root.data + " ");

        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
        System.out.println();
    }

    // Left boundary (excluding leaves)
    private static void printLeftBoundary(Node node) {
        while (node != null) {
            if (!isLeaf(node)) System.out.print(node.data + " ");
            node = (node.left != null) ? node.left : node.right;
        }
    }

    // Leaf nodes (in-order)
    private static void printLeaves(Node node) {
        if (node == null) return;
        printLeaves(node.left);
        if (isLeaf(node)) System.out.print(node.data + " ");
        printLeaves(node.right);
    }

    // Right boundary (excluding leaves, reverse order)
    private static void printRightBoundary(Node node) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (!isLeaf(node)) stack.push(node.data);
            node = (node.right != null) ? node.right : node.left;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    // Main function
    public static void main(String[] args) {
        // Example tree: [1, 2, 3, 4, 5, null, 7, null, null, 6]
        Integer[] levelOrder = {1, 2, 3, 4, 5, null, 7, null, null, 6};
        Node root = buildTree(levelOrder);

        printBoundary(root);
x    }
}
