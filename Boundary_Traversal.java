package STS2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
   int data;
   Node left, right;

   Node(int x) {
       data = x;
       left = right = null;
   }
}

class Boundary_Traversal {

   static boolean isLeaf(Node node) {
       return node != null && node.left == null && node.right == null;
   }

   // Function to collect left boundary nodes (top-down)
   static void collectBoundaryLeft(Node root, ArrayList<Integer> res) {
       if (root == null || isLeaf(root))
           return;

       res.add(root.data);
       if (root.left != null)
           collectBoundaryLeft(root.left, res);
       else if (root.right != null)
           collectBoundaryLeft(root.right, res);
   }

   // Function to collect all leaf nodes
   static void collectLeaves(Node root, ArrayList<Integer> res) {
       if (root == null)
           return;

       if (isLeaf(root)) {
           res.add(root.data);
           return;
       }

       collectLeaves(root.left, res);
       collectLeaves(root.right, res);
   }

   // Function to collect right boundary nodes (bottom-up)
   static void collectBoundaryRight(Node root, ArrayList<Integer> res) {
       if (root == null || isLeaf(root))
           return;

       if (root.right != null)
           collectBoundaryRight(root.right, res);
       else if (root.left != null)
           collectBoundaryRight(root.left, res);

       res.add(root.data);
   }

   // Function to perform Boundary Traversal
   static ArrayList<Integer> boundaryTraversal(Node root) {
       ArrayList<Integer> res = new ArrayList<>();

       if (root == null)
           return res;

       // Add root if it's not a leaf
       if (!isLeaf(root))
           res.add(root.data);

       // Collect left boundary
       collectBoundaryLeft(root.left, res);

       // Collect leaf nodes
       collectLeaves(root, res);

       // Collect right boundary
       collectBoundaryRight(root.right, res);

       return res;
   }

   // Function to build tree level-wise using input (-1 represents null)
   static Node buildTree(Scanner sc) {
       System.out.println("Enter root value:");
       int rootVal = sc.nextInt();

       if (rootVal == -1)
           return null;

       Node root = new Node(rootVal);
       Queue<Node> queue = new LinkedList<>();
       queue.offer(root);

       while (!queue.isEmpty()) {
           Node current = queue.poll();

           System.out.println("Enter left child of " + current.data + " (-1 for NULL):");
           int leftVal = sc.nextInt();
           if (leftVal != -1) {
               current.left = new Node(leftVal);
               queue.offer(current.left);
           }

           System.out.println("Enter right child of " + current.data + " (-1 for NULL):");
           int rightVal = sc.nextInt();
           if (rightVal != -1) {
               current.right = new Node(rightVal);
               queue.offer(current.right);
           }
       }
       return root;
   }

   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       // Build tree using user input
       Node root = buildTree(sc);

       // Perform Boundary Traversal
       ArrayList<Integer> boundary = boundaryTraversal(root);

       // Print the boundary traversal output
       System.out.println("Boundary Traversal:");
       for (int x : boundary)
           System.out.print(x + " ");

       sc.close();
   }
}
