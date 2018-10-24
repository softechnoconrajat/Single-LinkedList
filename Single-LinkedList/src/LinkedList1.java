
public class LinkedList1 {
	Node head;
	
	static class Node{
		int data;
		Node link;
		
		Node(int value){
			data = value;
			link = null;
		}
		
		}
		
	public void printLinkedList(){
		
		
		while(head != null) {
			System.out.println(head.data);
			head = head.link;
			
		}
			
	}
	
	
	// function to reverse the linked list.
	
	public Node reverseList(Node pointer) {
		Node previous = null;
		Node next = pointer;
		Node current = pointer;
		
		while(next!=null) {
			next = next.link;
			current.link = previous;
			previous = current;
			current = next;
		}
		head = previous;
		
		return head;
		
	}
	
	
	//function to reverse the linkedlist using recursion.
	
	public void reverserecu(Node curr) {
		if(curr.link == null) {
			
			head = curr.link;
			System.out.println(curr.data);
			return;
				
		}
		
		reverserecu(curr.link);	
		
		Node pre = curr.link;
		pre.link = curr;
		curr.link = null;
		
		System.out.println(curr.data);
		
	}
	
	//Deleting the node.
	
	public void deleteNode(int data) {
		Node currentNode =  head;
		Node prevNode = currentNode;
		
		if(currentNode == null) 
			return;
		
		if(currentNode.link == null) {
			currentNode = null;
			
			return;
		}
		
		if(head.data == data)
			head = head.link;
		
		
		while(currentNode != null) {
			
			if(currentNode.data == data) {
				prevNode.link = currentNode.link;
				currentNode = currentNode.link;
				return;
			}
			else {
				prevNode = currentNode;
				currentNode = currentNode.link;
				
			}
		}
	}
	
	//comparing linked list within linked list.
	
	public void deleteDuplicate() {
		
		Node nextNode = null;
		Node currentNode = head;
		
		if(currentNode == null || currentNode.link == null)
			return;
		
		while(currentNode.link != null ){
			
			//System.out.println("Printing Linked List.");
			if(currentNode.data == currentNode.link.data) {
				nextNode = currentNode.link; 
				currentNode.link = nextNode.link;
				nextNode = null;
			}
			else {
				currentNode = currentNode.link;
				
			}
			
			
			
			
		}	
		
	}
	
	//delete duplicate node from the unsorted linked list.
	
	public void deleteUnsortedList() {
		Node headLoop = head;
		Node trailLoop = head.link;
		Node firstPointer;
		
		while(headLoop != null) {
			firstPointer = headLoop;
			trailLoop = headLoop.link;
			 
			
			while(trailLoop != null ) {
				if(firstPointer.data == trailLoop.data) {
					deleteNode(trailLoop);
				}
				
				
				
				
				trailLoop = trailLoop.link;
				
			}
			
			headLoop = headLoop.link;
		}
		
		
	}
	
	//delete Node
	
	public void deleteNode(Node node) {
		
		Node prevNode  = null;
		Node currentNode = head;
		
		if(currentNode==null)
			return;
		if(currentNode.link == null){
			node = null;
		}
		while(currentNode != null) {
			
			if(currentNode == node) {
				prevNode.link = currentNode.link;
				currentNode = null;
				currentNode = prevNode.link;
			}else {
				prevNode = currentNode;
				currentNode = currentNode.link;	
			}
					
		}
	}
	
	
	
	
	
	
	//shorting Linked List in descending order.
	
//	public void shortingList() {
//		Node currentNode = head;
//		Node nextNode = null;
//		Node prevNode = head;
//		Node headNode = head;
//		
//		if(currentNode == null || currentNode.link == null) 
//			return;
//		
//		while(headNode!= null && headNode.link != null) {
//			
//			nextNode = headNode.link;
//			
//			System.out.println("Outside Loop: " + nextNode.data);
//			System.out.println("Outside Loop: " + headNode.data);
//			
//			while(nextNode != null && nextNode.link !=null ) {
//				
//				if(headNode.data >=  nextNode.data) {
//					prevNode.link = nextNode.link;
//					nextNode.link = currentNode.link;
//					nextNode = prevNode;
//					System.out.println("IF Inside Loop: " );
//					
//				}
//				else {
//					 prevNode = nextNode;
//					 nextNode = nextNode.link;
//					 System.out.println("Else Inside Loop: " + nextNode.data + prevNode.data );
//				}
//				 
//				}
//					
//			
//			headNode = headNode.link;
//			
//		}
//			
//	}
//	
	
	
	
	public void palindrome() {
		Node headNode = head;
		Node slowPointer = head;
		Node fastPointer = head;
		Node preSlowPointer = null;
		Node midPointer = null;
		
		while(fastPointer != null && fastPointer.link != null) {
			fastPointer = fastPointer.link.link;
			preSlowPointer = slowPointer;
			slowPointer = slowPointer.link;
			
		}
		
		if(fastPointer == null) {
			midPointer = slowPointer;
			preSlowPointer.link = null;
			
		}else {
			midPointer = slowPointer.link;
			preSlowPointer.link = null;
			
		}
		
		Node head1 = reverseList(midPointer);
		
		
		
		boolean result = compareNode(head1, headNode);
		
		System.out.println(result);
	
	}
		
	public boolean compareNode(Node head1, Node head2) {
		
		Node temp1 = head1;
		Node temp2 = head2;
		
		while(temp1 != null && temp2 != null) {
			
			
			if(temp1.data == temp2.data) {
				temp1 = temp1.link;
				temp2 = temp2.link;
				
			
			}else {
				
				return false;
			}	
		}
		
		if(temp1 == null && temp2 == null) { 
			return true;
		}

		return false;
	}
	
	
	public static void main(String[] args) {
		
		LinkedList1 llist = new LinkedList1();
		
		llist.head = new Node(20);
		Node secondNode = new Node(20);
		Node thirdNode = new Node(20);
		Node fourthNode = new Node(20);
		Node fifthNode = new Node(20);
		
		//Linking the nodes here.
		
		llist.head.link = secondNode;
		secondNode.link = thirdNode;
		thirdNode.link = fourthNode;
		fourthNode.link = fifthNode;
		fifthNode.link = null;
		
		//System.out.println("Printing Linked List.");
		
		
		// llist.printLinkedList(llist.head);
		//llist.reverseList();
		//llist.printLinkedList(llist.head);
		
	//	llist.palindrome();
		
	//	llist.reverserecu(llist.head);
		
		//llist.deleteNode(3);
		//llist.printLinkedList();
		
	//	llist.shortingList();
		//llist.printLinkedList();
		
		//llist.deleteDuplicate();
		
		//llist.printLinkedList();
		
		llist.deleteUnsortedList();
		
		llist.printLinkedList();
		
		
	
		
	
		
	}
	

}
