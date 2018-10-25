package CircularLinkedList;

public class CircularList {
	Node head;
	
	static class Node{
		int data;
		Node link;
		
		Node(int value){
			data = value;
			link = null;
			
		}
	}
	
	public void printList(Node head) {
		Node temp = head;
		if(head == null) {
			System.out.println("Do not have any data");
			return;
		}
			
		do {
			System.out.println(temp.data);
			temp = temp.link;
		}
		while(temp != head); 
				
	}
	
	//Split circular Linked List into two halfs.
	
	public void splitList(Node head) {
		Node fastPointer = head;
		Node slowPointer = head;
		Node prevFastPointer = null;
		Node startSecondList = null;
		Node prevSlowPointer = null;
		
		do {
			
			prevFastPointer = fastPointer.link;
			fastPointer = fastPointer.link.link;
			
			prevSlowPointer = slowPointer;
			slowPointer = slowPointer.link;
				
		}
		
		while(fastPointer != head && fastPointer.link != head);
		
		if(fastPointer.link == head) {
			
			startSecondList = slowPointer.link;
			fastPointer.link = startSecondList;
			slowPointer.link = head;
			printList(startSecondList);
			printList(head);
				
		}
		else {
			startSecondList = slowPointer;
			prevSlowPointer.link = head;
			prevFastPointer.link = slowPointer;
			printList(startSecondList);
			printList(head);
	
		}
		
	}
	
	//Check If Linked List Is circular.
	
	public boolean checkList(Node head) {
		Node temp = head;
		if(temp == null)
			return true;
		
		temp = temp.link;
		
		while(temp != null && temp != head) {
			temp = temp.link;
		}
		
		System.out.println(temp.data);
		System.out.println(head.data);
		
		return (temp == head);
	}
	
	//insert Node at the beginning of the list.
	
	public void insertBeginning(int data) {
		Node insertStart = new Node(data);
		Node temp = head;
		Node prevTemp = null;
		temp = temp.link;
		while(temp != head) {
			prevTemp = temp;
			temp = temp.link;
			
		}
		
		insertStart.link = prevTemp.link;
		prevTemp.link = insertStart;
		
		printList(insertStart);
		
	}
	
	//insert Node at the last of the list.
	
	public void insertlast(int data) {
		Node insertLast = new Node(data);
		Node temp = head;
		Node prevTemp = null;
		temp = temp.link;
		while(temp != head) {
			prevTemp = temp;
			temp = temp.link;
			
		}
		
		prevTemp.link = insertLast;
		insertLast.link = head;
		printList(head);
		
	}
	
	//insert Node inBetween Node.
	
	public void insertAfter(int data, Node name) {
		Node insertLast = new Node(data);
		Node temp = head;

		temp = temp.link;
		
		while(temp != name) {
		
			temp = temp.link;
			
		}
		
		insertLast.link = temp.link;
		temp.link = insertLast;
		printList(head);
		
	}
	
	
	//Deleting Node from the linked list
	
	public void deleteNode(Node name) {
		Node temp = head;
		Node prevTemp = head;
		
		if(temp == null)
			return;
		
		if(name == head) {
			
			do {
				
				prevTemp = temp;
				temp = temp.link;
				
			}
			while(temp != head);
			
			prevTemp.link = head.link;
			head = head.link;
			printList(head);
			
			return;
		}
		
		
		temp = temp.link;
		while(temp != name && temp == head) {
			
			System.out.println("Third Item");
			prevTemp = temp;
			temp = temp.link;	
		}
		
		System.out.println("Third Item" + temp.data + "" + name.data);
		if(temp == name) {
			
			prevTemp.link = temp.link;
			temp = null;
			
			printList(head);	
		}else {
			
			printList(head);
		}		
	}
	
	public static void main(String[] args) {
		CircularList cl = new CircularList();
		cl.head = new Node(1);
		Node secondItem = new Node(2);
		Node thirdItem = new Node(3);
		Node fourthItem = new Node(4);
		Node fifthItem = new Node(5);
		Node sixthItem = new Node(6);
		
		cl.head.link = secondItem;
		secondItem.link = thirdItem;
		thirdItem.link = fourthItem;
		fourthItem.link = fifthItem;
		fifthItem.link = cl.head;
		//sixthItem.link = cl.head;
		
		
		//System.out.println("Content of the circular linked list:");
	//	cl.printList(cl.head);
		
		//cl.splitList(cl.head);
		
//		boolean b = cl.checkList(cl.head);
//		System.out.println(b);
		
		//cl.insertBeginning(20);
		
//		cl.insertlast(20);
		
		//cl.insertAfter(20, thirdItem);
		
		cl.deleteNode(thirdItem);
		
	}
	
}
