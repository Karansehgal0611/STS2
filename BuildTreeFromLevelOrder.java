package STS2;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class BuildTreeFromLevelOrder {

    // Builds the binary tree from a level order input string
    public static TreeNode buildTree(String data) {
        if (data == null || data.isEmpty()) return null;

        String[] values = data.split("\\s+");
        if (values[0].equals("N")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            // Left child
            if (!values[i].equals("N")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                current.left = left;
                queue.offer(left);
            }
            i++;

            // Right child
            if (i < values.length && !values[i].equals("N")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                current.right = right;
                queue.offer(right);
            }
            i++;
        }

        return root;
    }

    // In-order traversal for checking the tree
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Test
    public static void main(String[] args) {
        String levelOrder = "1 2 3 N N 4 5"; // Example input
        TreeNode root = buildTree(levelOrder);

        System.out.print("In-order Traversal: ");
        inorder(root); // Should print: 2 1 4 3 5
    }
}

