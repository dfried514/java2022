package com.linkedlist.singlelinkedlist;

public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        // your code here
    	this.head = null;
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }    
    public void remove() {
    	if (this.head == null)
    		return;
    	if (this.head.next == null) {
    		this.head = null;
    		return;
    	}
    	Node ptr = this.head;
    	while (ptr.next.next != null) {
    		ptr = ptr.next;
    	}
    	ptr.next = null;
    }
    public void printValues() {
    	String output = "";
    	Node ptr = this.head;
    	while (ptr != null) {
    		output += ptr.value;
    		output += " --> ";
    		ptr = ptr.next;
    	}
    	output += "null";
    	System.out.println(output);
    }
    public Node find(int value) {
    	if (head == null) 
    		return null;
    	Node ptr = head;
    	while (ptr != null) {
    		if (ptr.value == value) 
    			return ptr;
    		ptr = ptr.next;
    	}
    	return null;
    }
    public void removeAt(int n) {
    	if (head == null) 
    		return;
    	if (n == 0) {
    		head = head.next;
    		return;
    	}
    	int count = 0;
    	Node ptr = head;
    	while (ptr != null && count < n - 1) {
    		ptr = ptr.next;
    		count++;
    	}
    	if (ptr != null && ptr.next != null) 
    		ptr.next = ptr.next.next;
    }
}

