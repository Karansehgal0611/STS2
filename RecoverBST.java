package STS2;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class RecoverBST {
    TreeNode first = null, middle = null, last = null, prev = null;

    public void recoverTree(TreeNode root) {
        // Step 1: Perform in-order traversal to find the two swapped nodes
        inorderTraversal(root);

        // Step 2: Fix the swapped nodes
        if (first != null && last != null) {
            // Non-adjacent nodes swapped
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && middle != null) {
            // Adjacent nodes swapped
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;

        inorderTraversal(root.left);

        // Detect swapped nodes
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                // First violation
                first = prev;
                middle = root;
            } else {
                // Second violation
                last = root;
            }
        }
        prev = root;

        inorderTraversal(root.right);
    }

    // Helper to print in-order traversal
    public void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    // Driver code to test
    public static void main(String[] args) {
        /*
              3
             / \
            1   4
               /
              2
        Expected BST: 1 2 3 4 (nodes 2 and 3 are swapped)
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        RecoverBST bst = new RecoverBST();
        System.out.print("Before fix (in-order): ");
        bst.printInOrder(root);
        System.out.println();

        bst.recoverTree(root);

        System.out.print("After fix (in-order): ");
        bst.printInOrder(root);
        System.out.println();
    }
}
