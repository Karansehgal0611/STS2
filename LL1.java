package STS2;

import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
    
}

class LinkedList{
    Node head;
    void addatend(int val){
        Node newnode = new Node(val);
        if(head== null){
            head=newnode;
        }
        else{
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next=newnode;
            
        }
        
    }
    void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data +"-->");
            temp = temp.next;
        }
        System.out.print("Null");
        
    }
}


public class LL1 {
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    LinkedList list = new LinkedList();
	    int n = sc.nextInt();
	    for(int i=0;i<n;i++){
	        int val = sc.nextInt();
	       list.addatend(val); 
	    }
		list.display();
	}
    
}
