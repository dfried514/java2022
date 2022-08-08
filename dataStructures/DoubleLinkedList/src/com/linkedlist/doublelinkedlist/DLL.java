package com.linkedlist.doublelinkedlist;

public class DLL {
    public Node head;
    public Node tail;
    
    public DLL() {
        this.head = null;
        this.tail = null;
    }
    
    // the push method will add a new node to the end of the list
    public void push(Node newNode) {
	// if there is no head in the list, aka, an empty list, we set the newNode to be the head and tail of the list
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        
        // first find the lastNode in the list
        // then, set the lastNode's next to be the newNode;
        // then, we have to set the previous of the lastNode to the lastNode that we found previously.
        // finally, set the list's tail to be the node that we have added
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
    }
    
	public void printValuesForward() {
        // find the first node, aka head.
        Node current = this.head;
        
        // while the current node exists...
        while(current != null) {
            // print its value
            System.out.println(current.value);
            // and move on to its next node.
            current = current.next;
        }
    }
	
	public void printValuesBackward() {
		String output = "";
		Node ptr = this.tail;
		while (ptr != null) {
			output += ptr.value;
			output += " --> ";
			ptr = ptr.previous;
		}
		output += "null";
		System.out.println(output);
	}
	
	public Node pop() {
		if (this.head == null) 
			return null;
		Node result = this.tail;
		if (this.head == this.tail) {
			this.head = null;
			this.tail = null;
			return result;
		}
		this.tail = this.tail.previous;
		this.tail.next = null;
		result.previous = null;
		return result;
	}
	
	public boolean contains(Integer value) {
		Node ptr = this.head;
		while (ptr != null) {
			if (ptr.value == value) 
				return true;
			ptr = ptr.next;
		}
		return false;
	}
	
	public int size() {
		int count = 0;
		Node ptr = this.head;
		while (ptr != null) {
			count++;
			ptr = ptr.next;
		}
		return count;
	}
	
	public void insertAt(Node newNode, int index) {
		if (index == 0) {
			newNode.next = this.head;
			this.head.previous = newNode;
			this.head = newNode;
			return;
		}
		int count = 0;
		Node ptr = this.head;
		while (ptr != null && count < index - 1) {
			ptr = ptr.next;
			count++;
		}
		if (ptr == null) return;
		if (ptr.next != null) {
			newNode.next = ptr.next;
			ptr.next.previous = newNode;
		}
		newNode.previous = ptr;
		ptr.next = newNode;
	}
	
	public void removeAt(int index) {
		if (index == 0) {
			this.head = this.head.next;
			this.head.previous = null;
			return;
		}
		int count = 0;
		Node ptr = this.head;
		while (ptr != null && count < index - 1) {
			ptr = ptr.next;
			count++;
		}
		if (ptr == null || ptr.next == null) return;
		ptr.next = ptr.next.next;
		if (ptr.next != null) 
			ptr.next.previous = ptr;
	}
	
	public boolean isPalindrome() {
		if (this.head == null) 
			return true;
		Node front = this.head;
		Node back = this.tail;
		while (front != back) {
			if (front.value != back.value)
				return false;
			front = front.next;
			back = back.previous;
		}
		return true;
	}
}


