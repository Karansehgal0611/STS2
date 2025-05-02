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

public class BoundaryTraversalPrac {
    //Build tree from level order input
    public static Node buildTree(Integer[] input){
        if(input.length == 0 || input[0] == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(input[0]);
        queue.offer(root);

        int i = 1;
        while(!queue.isEmpty() && i < input.length){
            Node current = queue.poll();
            if(input[i]!= null){
                current.left = new Node(input[i]);
                queue.offer(current.left);
            }
            i++;

            if(i < input.length &&  input[i]!=null){
                current.right = new Node(input[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static void printBoundary(Node root){
        if(root == null){
            return;
        }
        System.out.println("Boundary traversal: ");
        System.out.println(root.data + " ");
        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
    }

    public static void printLeftBoundary(Node root){
        while(root != null){
            if(!isLeaf(root)){
                System.out.println(root.data + " ");
            }
            root = (root.left != null) ? root.left : root.right;
        }
    }

    public static void printRightBoundary(Node root){
        Stack<Integer> stack = new Stack<>();
        while(root != null){
            if(!isLeaf(root)){
                stack.push(root.data);
            }
            root = (root.right != null) ? root.right : root.left;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }
    }
    //inorder traversal
    public static void printLeaves(Node root){
        if (root == null) {
            return;
        }
        printLeaves(root.left);
        if (isLeaf(root)) System.out.print(root.data + " ");
        printLeaves(root.right);
    }

    public static boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }
    public static void main(String[] args) {
        // Example tree: [1, 2, 3, 4, 5, null, 7, null, null, 6]
        Integer[] levelOrder = {1, 2, 3, 4, 5, null, 7, null, null, 6};
        Node root = buildTree(levelOrder);

        printBoundary(root);
    }

}

