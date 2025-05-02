package STS2;

public class Detect_loop_inLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    // Function to add a new node at the beginning of the linked list
    void push(int x){
        Node nn = new Node(x);
        nn.next = head;
        head = nn;
    }
    boolean detectLoop() {
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true; // Loop detected
            }
        }
        return false; // No loop
    }

    boolean detectLoopUsingHashing() {
        HashSet<Node> visitedNodes = new HashSet<>();
        Node temp = head;
        while (temp != null) {
            if (visitedNodes.contains(temp)) {
                return true; // Loop detected
            }
            visitedNodes.add(temp);
            temp = temp.next;
        }
        return false; // No loop
    }
    // Function to create a loop in the linked list
    void createLoop(int x) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node loopNode = head;
        for (int i = 0; i < x; i++) {
            loopNode = loopNode.next;
        }
        temp.next = loopNode; // Create the loop
    }
    // Function to remove the loop from the linked list
    void removeLoop() {
        Node slow = head;
        Node fast = head;
        boolean loopExists = false;

        // Detect loop
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                loopExists = true;
                break;
            }
        }

        // If loop exists, remove it
        if (loopExists) {
            slow = head;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null; // Remove the loop
        }
    }
    // Function to print the linked list
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    // Function to get the length of the linked list
    int getLength() {
        Node temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
    public static void main(String[] args) {
        Detect_loop_inLL list = new Detect_loop_inLL();
        
        // Adding elements to the linked list
        list.push(50);
        list.push(40);
        list.push(30);
        list.push(20);
        list.push(10);

        System.out.println("Original Linked List:");
        list.printList();

        // Creating a loop for testing
        list.createLoop(2); // Creates a loop at the 3rd node (0-based index)

        // Detecting loop
        if (list.detectLoop()) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected.");
        }
        // Removing the loop
        list.removeLoop();

        // Detecting loop again after removal
        if (list.detectLoop()) {
            System.out.println("Loop still exists.");
        } else {
            System.out.println("Loop removed successfully.");
        }

        // Printing the linked list after loop removal
        System.out.println("Linked List after removing the loop:");
        list.printList();

        // Getting the length of the linked list
        System.out.println("Length of the linked list: " + list.getLength());
    }
}
