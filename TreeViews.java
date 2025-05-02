package STS2;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class TreeViews {

    // Build Tree from Level Order String
    public static TreeNode buildTree(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] values = data.split("\\s+");

        if (values[0].equals("N")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode curr = queue.poll();

            // Left child
            if (!values[i].equals("N")) {
                curr.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(curr.left);
            }
            i++;

            // Right child
            if (i < values.length && !values[i].equals("N")) {
                curr.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(curr.right);
            }
            i++;
        }

        return root;
    }

    // 1. Top View
    public static void topView(TreeNode root) {
        if (root == null) return;

        class Pair {
            TreeNode node;
            int hd;
            Pair(TreeNode n, int h) { node = n; hd = h; }
        }

        Map<Integer, Integer> topMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if (!topMap.containsKey(p.hd)) {
                topMap.put(p.hd, p.node.val);
            }
            if (p.node.left != null) queue.offer(new Pair(p.node.left, p.hd - 1));
            if (p.node.right != null) queue.offer(new Pair(p.node.right, p.hd + 1));
        }

        System.out.print("Top View: ");
        for (int val : topMap.values()) System.out.print(val + " ");
        System.out.println();
    }

    // 2. Bottom View
    public static void bottomView(TreeNode root) {
        if (root == null) return;

        class Pair {
            TreeNode node;
            int hd;
            Pair(TreeNode n, int h) { node = n; hd = h; }
        }

        Map<Integer, Integer> bottomMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            bottomMap.put(p.hd, p.node.val); // overwrite
            if (p.node.left != null) queue.offer(new Pair(p.node.left, p.hd - 1));
            if (p.node.right != null) queue.offer(new Pair(p.node.right, p.hd + 1));
        }

        System.out.print("Bottom View: ");
        for (int val : bottomMap.values()) System.out.print(val + " ");
        System.out.println();
    }

    // 3. Left View
    public static void leftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        leftViewUtil(root, result, 0);
        System.out.print("Left View: ");
        for (int val : result) System.out.print(val + " ");
        System.out.println();
    }

    private static void leftViewUtil(TreeNode node, List<Integer> result, int level) {
        if (node == null) return;
        if (level == result.size()) result.add(node.val);
        leftViewUtil(node.left, result, level + 1);
        leftViewUtil(node.right, result, level + 1);
    }

    // 4. Right View
    public static void rightView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightViewUtil(root, result, 0);
        System.out.print("Right View: ");
        for (int val : result) System.out.print(val + " ");
        System.out.println();
    }

    private static void rightViewUtil(TreeNode node, List<Integer> result, int level) {
        if (node == null) return;
        if (level == result.size()) result.add(node.val);
        rightViewUtil(node.right, result, level + 1);
        rightViewUtil(node.left, result, level + 1);
    }

    // 5. Boundary View
    public static void boundaryView(TreeNode root) {
        if (root == null) return;

        List<Integer> result = new ArrayList<>();
        result.add(root.val);

        // Left Boundary
        printLeftBoundary(root.left, result);

        // Leaves
        printLeaves(root.left, result);
        printLeaves(root.right, result);

        // Right Boundary
        List<Integer> rightBoundary = new ArrayList<>();
        printRightBoundary(root.right, rightBoundary);
        Collections.reverse(rightBoundary);
        result.addAll(rightBoundary);

        System.out.print("Boundary View: ");
        for (int val : result) System.out.print(val + " ");
        System.out.println();
    }

    private static void printLeftBoundary(TreeNode node, List<Integer> result) {
        while (node != null) {
            if (!(node.left == null && node.right == null)) result.add(node.val);
            node = (node.left != null) ? node.left : node.right;
        }
    }

    private static void printRightBoundary(TreeNode node, List<Integer> result) {
        while (node != null) {
            if (!(node.left == null && node.right == null)) result.add(node.val);
            node = (node.right != null) ? node.right : node.left;
        }
    }

    private static void printLeaves(TreeNode node, List<Integer> result) {
        if (node == null) return;
        printLeaves(node.left, result);
        if (node.left == null && node.right == null) result.add(node.val);
        printLeaves(node.right, result);
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter level-order traversal (use 'N' for nulls):");
        String input = sc.nextLine();
        TreeNode root = buildTree(input);

        topView(root);
        bottomView(root);
        leftView(root);
        rightView(root);
        boundaryView(root);
    }
}
