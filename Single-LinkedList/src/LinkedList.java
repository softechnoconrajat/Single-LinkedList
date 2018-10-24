
public class LinkedList {
	
	Node head;
	
	static class Node{
		int data;
		Node link;
		
		Node(int key){
			data =  key;
			link = null;
		}
	}
	
	public void printList() {
		
		Node n = head;
		
		
		while(n!=null) {
			System.out.println(n.data);
			n = n.link;
		}
	}
	
	//to Enter the node at the beginning of the linkedlist
	
	public void push(int key) {
		
		Node new_node = new  Node(key);
		
		new_node.link = head;
		
		 head = new_node;
		
	}
	
	public void insertAfter(Node pre_node, int new_node_data) {
		
		if(pre_node == null) {
			return;
		}
		
		Node new_node = new Node(new_node_data);
		
		new_node.link = pre_node.link;
		
		pre_node.link = new_node;
		
	}
	
	public void append(int new_data) {
		Node lastNode = new Node(new_data);
		
		if(head == null) {
			head = lastNode;
			return;
		}
		lastNode.link = null;
		
		Node last = head;
		while(last.link != null) {
			last = last.link;
		}
		
		last.link = lastNode;
		lastNode.link = null;	
		
	}
	
	
	//function to delete the node using the key value for the node.
	
	public void delete(int key) {
		
		Node temp, prev = null;
		temp = head;
		
		
		while(temp != null && temp.data != key ) {
			
			prev = temp;
			temp = temp.link;
				
		}
		
		temp = temp.link;
		prev.link = temp;
		
	}
	
	//function to delete a node at a given position.
	
	public void deleteNodeAtPostion(int pos) {
		Node temp, prev = null;
		temp = head;
		int count = 0;
		
		if(head == null) {
			System.out.println("Linked List is Empty");
			return;
			
		}
		else if(pos == 0) {
			
			temp = temp.link;
			head = temp;	
		}
		else if(pos > 0 ) {
			
			while(count != pos ) {
				prev = temp;
				temp = temp.link;
				count = count + 1;
				if (count == pos ) {
					temp = temp.link;
					prev.link = temp;
					return;
					
				}
				else if(temp == null || temp.link == null) {
					return;
				}
			}	
		}
	}
	
	//function to delete list
	
	public void deleteList() {
		head = null;
	}
	
	//function to count the linked list - iteratative 
	
	public void countList() {
		Node temp = head;
		int count = 0;
		while(temp!=null) {
			temp = temp.link;
			count = count+1;
		}
		
		System.out.println("Size of Linked List:" + count);	
		
	}
	
	// function to count the linked list - using recursion.
	
	 public int countNode(Node node) {
		 if(node == null) 
			 return 0;
		 
		 return 1 + countNode(node.link);
					 
	 }
	 
	 // Wrapper function for the above recursive function.
	 
	 public int wrapperCountNode() {
		 
		 return countNode(head);
	 }
	 
	 //Return type boolean search a Llist using key value 
	 
	 public boolean search(int key) {
		 Node temp = head;
		 while(temp!=null) {
			 if(temp.data == key) 
				return true;
			 
			 temp = temp.link;
		 }
		 
		 return false;
	 }
	 
	 // Return type boolean search a Llist using key value recursive function.
	 
	 public boolean searchRec(Node head, int key) {
		 
		if(head == null)
			return false;
		
		if(head.data == key)
			return true;
		
		return searchRec(head.link, key);
		
		 
	 }
	 
	 //function to get the nth node of the linked list
	 
	 public int nodeIndex(int index) {
		Node temp = head;
		int count = 0;
		
		while(temp!= null) {
			if(index == count+1)
				return temp.data;
			temp = temp.link;
			count = count + 1;
			
		}
		return 0;
		
		
	 }
	 
 //function to get the nth node of the linked list using recursion.
	 
	 public int nodeIndexRec(Node head, int indexToFind) {
		
		 int counter = 1;
		 
		 if(head == null)
			 return 0;
		 
		 if(indexToFind == counter) 
			 return head.data;
		 
		 
		
		 return nodeIndexRec(head.link, indexToFind-1 );
		
					
		
	 }
	 
	 //method for the nth node from the end.
	 
	 public int nodeFromEnd(int n) {
		 Node main = head;
		 Node ref = head;
		 for(int i=0 ; i<n ; i++) {
			 ref = ref.link;
		 }
		 while(ref!= null) {
			 main = main.link;
			 ref = ref.link;
		 }
		 return main.data;
	 }
	 
	 //method for the middle node of the linked list.
	 
	 public int middleNode() {
		 Node temp1 = head;
		 Node temp2 = head;
		 	while(temp2!=null && temp2.link !=null) {
		 		temp1 = temp1.link;
		 		temp2 = temp2.link.link;
		 	}
		 	return temp1.data;	 
	 }
	 
	 //method to count no. of times int occur in the linked list.
	 
	 public int countInt(int searchData) {
		 int counter = 0;
		 Node temp = head;
		 while(temp!=null) {
			 if(temp.data == searchData)
				 counter = counter + 1;
			 temp = temp.link;
				 
		 }
		 
		 
		 
		 return counter;
		 
	 }
	 
	 //above function using recursion
	 
	 int counter = 0;
	 public int countIntRecursion(Node head, int searchData) {
		 
		 if(head==null)
			 return counter;
		 if(head.data == searchData)
			 counter++;
		 return countIntRecursion(head.link, searchData);	
		 
	 }
	 
	 //Detect a Loop in a linked list. (Using floyd cycle finding algorithm.)

	 public int loopExistLinkedList() {
		 Node temp1 = head;
		 Node temp2 = head;
		 while(temp1 != null && temp1.link != null && temp2 != null) {
			 
			 temp1 = temp1.link.link;
			 temp2 = temp2.link;
			 
			 if(temp1 == temp2) 	 
				 return 1;		 
		 }
		 
		 return 0;
	 }
	 
	 //Find length of the loop in the linked list.
	 
	 public int loopLengthLinkedList() {
		 Node temp1 = head;
		 Node temp2 = head;
		 while(temp1 != null && temp1.link != null && temp2 != null) {
			 
			 temp1 = temp1.link.link;
			 temp2 = temp2.link;
			 
			 if(temp1 == temp2) {
				 int count = 1;
				 temp2 = temp2.link;
				 while(temp1 != temp2) {
					 temp2 = temp2.link;
					 count += 1; 
				 }
				 return count;
			 }
				 		 
		 }
		 
		 return 0;
	 }
	 
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList llist = new LinkedList();
		
		llist.head = new Node(1);
		
		Node second = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		
		llist.head.link = second;
		second.link = three;
		three.link = four;
		four.link = second;
		
	//	System.out.println("Successully created linked list");
		
		
//		llist.printList();
		
	//	llist.push(4);
		
	//	llist.insertAfter(second, 5);
		
	//	llist.append(767);
		
	//	llist.printList();
		
//		llist.delete(5);
//		
//		llist.printList();
//		
//		llist.deleteNodeAtPostion(20);
		
	//	llist.printList();
		
	//	llist.deleteList();
		
	//	System.out.println("deleting the list:");
		
	//	llist.countList();
		
		//llist.printList();
		
		//int x = llist.wrapperCountNode();
		
//		System.out.println(llist.search(13));
		
//		System.out.println(llist.searchRec(llist.head, 20));
		
		
//		System.out.println(llist.nodeIndex(1));
		
		
		
//		System.out.println(llist.nodeIndexRec(llist.head, 1 ));
		
	//	System.out.println(llist.nodeFromEnd(1));
		
		//System.out.println(llist.middleNode());
		
		//System.out.println("Counting: " + llist.countInt(2));
		
//		System.out.println("Counting: " + llist.countIntRecursion(llist.head, 2));
		
		//System.out.println(llist.loopExistLinkedList());
		
		
		System.out.println(llist.loopLengthLinkedList());
		
	}

}
