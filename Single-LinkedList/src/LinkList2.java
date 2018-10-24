public class LinkList2 {
	Node head;
	
	static class Node {
		int data;
		Node link;
		
		Node(int value){
			
			data = value;
			
		}
	}
	
	public void printList(Node head) {
		while(head != null) {
			System.out.println(head.data);
			head = head.link;
		}
	}
	
	
	//Pairwise swap element of the linked list.
	
	public void pairSwap() {
		
		Node temp1 = head;
		int temp = 0;
		
		
		if(temp1 == null || temp1.link == null) 
			return;
		
		while(temp1 != null && temp1.link != null){
			temp = temp1.data;
			temp1.data = temp1.link.data;
			temp1.link.data = temp;
			temp1 = temp1.link.link;
			
		}
		
	}
	
	//Move last element to front of a given Linked List
	
	public void lastElementFirst() {
		Node lastElement = head;
		Node prevElement = null;
		
		
		while(lastElement != null) {
			if(lastElement.link == null) {
				
				
				
				prevElement.link = null;
				lastElement.link = head;
				head = lastElement;
				
				return;
			}
			
			
			
			
			prevElement = lastElement;
			lastElement = lastElement.link;
			
		}
		
		
	}
	
	//join function for the linked list.
	
	public LinkList2 joinOperation(Node head1, Node head2) {
		
		Node counter1 = head1;
		Node counter2 = head2;
		
		//System.out.println(counter1.data + "" + counter2.data);
		LinkList2 LL2 = new LinkList2();
		LL2.head = null;
		int count = 0;
		
		if(counter1 == null || counter2 == null)
			return LL2;
			
		
		while(counter1 != null) {
			
			
			while(counter2 != null) {
				

				
				if(counter1.data == counter2.data) {
					
					if(count == 0) {
						LL2.head = counter1;
						System.out.println( LL2.head.data);
//						
						LL2.head = LL2.head.link;
						count = count + 1;
					
					}else {
						LL2.head= counter1;
						System.out.println(LL2.head.data);
//						
						LL2.head = LL2.head.link;
						count = count + 1;
					}
					
					
					
				}	
				counter2 = counter2.link;
			
			}
			counter1 = counter1.link;
			counter2 = head2;
		}
		
		return LL2;
		
	}
	
	public Node intersectionNode(Node head1, Node head2) {
		
		Node intersectionNode = null;
		Node startHead2 = head2;
		if(head1 == null || head2 == null)
			return intersectionNode;
		
		while(head1 != null) {
			while(head2 != null) {
				if(head1 == head2) {
					intersectionNode = head2;
					return intersectionNode;
				}
	
				head2 = head2.link;
			}
			
			
			head2 = startHead2;
			head1 = head1.link;
			
		}
		
		return intersectionNode;
	}
	
	//Segregate Odd and Even Linked List.
	
	public void segregateOddEven(Node head) {
		Node startNode = head;
		Node evenStart = null;
		Node evenEnd = null;
		Node oddStart = null;
		Node oddEnd = null;
		
		
		

		
		if (startNode == null)
			return;
		
		while(startNode != null) {
		
			if(startNode.data % 2 == 0) {
				
				
				if(evenStart == null) {
					
					evenStart = startNode;
					evenEnd = evenStart;
					//System.out.println(evenEnd.data);
					
					
				}else {
					
					evenEnd.link = startNode;
					evenEnd = evenEnd.link;
					//System.out.println(evenEnd.data);
				}
				
				
			}
			else {
				
				if(oddStart == null) {
					
					oddStart = startNode;
					oddEnd = oddStart;
					
//					System.out.println(oddEnd.data);
					
				}
				else {
					
					oddEnd.link = startNode;
					oddEnd = oddEnd.link;
//					System.out.println(oddEnd.data);
					
				}
			}
			
			startNode = startNode.link;
			
		}
	
		evenEnd.link = oddStart;
		oddEnd.link = null;
		head = evenStart;
		
//		System.out.println(evenEnd.data);
//		System.out.println(oddEnd.data);
//		System.out.println(evenStart.data);
		
//		System.out.println(head);
//		System.out.println(oddEnd);
//		System.out.println(evenEnd);
		
		printList(head);	
	}
	
	public void reverseList(Node head) {
		
		Node prev = null;
		Node curr = head;
		Node next = null;
		
		if(curr == null)
			return;
		
		if(curr.link == null)
			printList(curr);
		
		while(curr !=  null) {
			next = curr.link;
			curr.link = prev;
			prev = curr;
			curr = next;	
		}
		
		Node newHead = prev;
		printList(newHead);	
	}
	
	

	public static void main(String[] args) {
		LinkList2 llist = new LinkList2();
//		LinkList2 llist2 = new LinkList2();
		
		llist.head = new Node(17);
		Node secondNode = new Node(15);
		Node thirdNode = new Node(8);
		Node fourthNode = new Node(12);
		Node fifthNode = new Node(10);
		Node sixthNode = new Node(5);
		Node seventhNode = new Node(4);
		Node eighthNode = new Node(1);
		Node ninthNode = new Node(7);
		Node tenthNode = new Node(6);
		
		llist.head.link = secondNode;
		secondNode.link = thirdNode;
		thirdNode.link = fourthNode;
		fourthNode.link = fifthNode;
		fifthNode.link = sixthNode;
		sixthNode.link = seventhNode;
		seventhNode.link = eighthNode;
		eighthNode.link = ninthNode;
		ninthNode.link = tenthNode;
		tenthNode.link = null;
		
//		llist2.head = new Node(10);
//		Node secondNode2 = new Node(20);
//		Node thirdNode2 = new Node(30);
//		Node fourthNode2 = new Node(40);
//		Node fifthNode2 = new Node(5);
		
//		llist2.head.link = fourthNode;
//		secondNode2.link = thirdNode2;
//		thirdNode2.link = fourthNode2;
//		fourthNode2.link = fifthNode2;
//		fifthNode2.link = null;
		
		
		
		//llist.printList();
		//llist.pairSwap();
		//llist.printList();
		
		//llist.lastElementFirst();
//		llist.printList(llist.head);
//		llist2.printList(llist2.head);
//		Node node1 = llist.head;
//		Node node2 = llist2.head ;
//		
//			
//		
//		LinkList2 l2 = llist.joinOperation(node1, node2);
		
//		Node N2 = llist.intersectionNode(llist.head, llist2.head);
//		System.out.println(N2.data);
			
//		llist.printList(llist.head);
		
//		llist.segregateOddEven(llist.head);
		
		llist.reverseList(llist.head);
		
		
	}
	
}
