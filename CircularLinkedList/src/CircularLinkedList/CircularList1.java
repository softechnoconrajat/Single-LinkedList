package CircularLinkedList;

public class CircularList1 {
	
	int data;
	CircularList1 link = null;

	static class Queue {
		
		CircularList1 front, rear;
		
	}
	
	//Function for enQueue.
	
	public void enQueue(Queue q, int value){
		
		CircularList1 temp = new CircularList1();
		
		temp.data = value;
		
		if(q.front == null) {
			q.front = temp;
			System.out.println(q.front.data);
			
		}
		else {
			q.rear.link = temp;
			System.out.println(temp.data);
		}
		
		q.rear = temp;
		q.rear.link = q.front;
			
	}
	
	

	
	//Function to delete element from the circular queue
	
	public int deQueue(Queue q) {
		if(q.front == null)
			return 0;
		
		//If this is the last node to be deleted.
		int value;
		if(q.front == q.rear) {
			
			value = q.front.data;
			q.front = null;
			q.rear = null;
			
		}
		else {
			CircularList1 temp = q.front;
			value = temp.data;
			q.front = q.front.link;
			q.rear.link = q.front;
			
		}
		
		System.out.println(value);
		return value;
	}
	
	public void printList(CircularList1 head){
		
		CircularList1 temp = head;
		
		do {
			
			System.out.println(temp);
			temp = temp.link;
			
		}
		while(temp.link != head);
		
	}
	
	
	
	 public static void main(String[] args) {
		
	Queue q = new Queue();
		
	q.front = null;
	q.rear = null;
		
	CircularList1 cl = new CircularList1();
		
	cl.enQueue(q, 2);
	cl.enQueue(q, 3);
	cl.enQueue(q, 4);
	
	cl.deQueue(q);
		
			
	}
	
		

}
