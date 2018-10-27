package CircularLinkedList;

public class DoubleLinkedList {
	Node head;
	
	
	static class Node{	
		int data = 0;
		Node llink = null;
		Node rlink= null;
		
		Node(int value){
			
			data = value;
			
		}
		
	}
	
	public void printList(Node head) {
		while(head != null) {
			
			System.out.println(head.data);
			head = head.rlink;
		}
		
	}
	
	//Insert Node in front of Linked List
	
	public void frontInsertion(int data) {
		
		Node frontNode = new Node(data);
		
		if(head == null) {
			
			head = frontNode;
			printList(head);
			return;
			
		}
			
			
		
		frontNode.rlink = head;
		frontNode.llink = null;
		head.llink = frontNode;
		
		head = frontNode;
		
	//	printList(head);
		
		
	}
	
	//Add a node before given Node.
public void beforeInsertion(Node before, int data) {
	
		
		
		Node temp = head;
		Node prevTemp;
		Node beforeNode = new Node(data);
		beforeNode.llink = null;
		beforeNode.rlink = null;
		
		if(before == head) {
			frontInsertion(data);
			printList(head);
			return;
		}
		
		if(temp == null) {
			head = beforeNode;
			return;
		}
		
		while(temp != null) {
			if(temp == before) {
				prevTemp = temp.llink;
				beforeNode.llink = prevTemp;
				prevTemp.rlink = beforeNode;
				beforeNode.rlink = temp;
				temp.llink = beforeNode;
				
				printList(head);
				return;
				
			}
			
			temp = temp.rlink;
			
		}
		
		
		
	}

//Delete a node in doubly LinkedList

public void deleteNode(Node tobeDeleted) {
	Node temp = head;
	Node leftNode = null;
	Node rightNode = null;
	
	if(head == null)
		return;
	
	//If temp is a header
	if(temp == tobeDeleted) {
		head = head.rlink;
		head.llink = null;
		return;
	}
	
	
	while(temp != null ) {
		
		if(temp == tobeDeleted && temp.rlink != null  ) {
			leftNode = temp.llink;
			rightNode = temp.rlink;
			
			leftNode.rlink = rightNode;
			rightNode.llink = leftNode;
			
			return;
			
		}
		else if(temp.rlink == null)
		{
			
			leftNode = temp.llink;
			leftNode.rlink = null;
			return;
		 	
		}
		
		else {
			
			temp = temp.rlink;
			
		}
			
	}
	
	
}

//Reverse a double LinkedList

public void reverseList() {
	Node temp = head;
	Node tempPrev = null;
	
	if(temp == null){
		return;
	}
	
	if(temp.rlink == null) {
		printList(head);
		return;
		
	}
	
	while(temp != null) {
		if(temp == head) {
			temp.llink = temp.rlink;
			temp.rlink = null;			
		}
		
		else if(temp.rlink == null) {
			
			temp.llink = temp.rlink;
			temp.rlink = tempPrev;
			
			head = temp;
			printList(head);	
		}
		else {
			
			temp.llink = temp.rlink;
			temp.rlink = tempPrev;	
		}
		
		tempPrev = temp;
		temp = temp.llink;
	}
}


	
	public static void main(String[] args) {
		DoubleLinkedList dl = new DoubleLinkedList();
		
		
		
		dl.head = new Node(1);
		Node secondNode = new Node(2);
		Node thirdNode = new Node(3);
		Node fourthNode = new Node(4);
		
		dl.head.llink = null;
		dl.head.rlink = secondNode;
		
		secondNode.llink = dl.head;
		secondNode.rlink = thirdNode;
		
		thirdNode.llink = secondNode;
		thirdNode.rlink = fourthNode;
		
		fourthNode.llink = thirdNode;
		fourthNode.rlink = null;
		
//		dl.printList(dl.head);
		
	//	dl.frontInsertion(5);
		
		//dl.beforeInsertion(dl.head, 99);
		
//		dl.deleteNode(fourthNode);
//		dl.printList(dl.head);
		
		dl.reverseList();
	}
	

}
