package PARKING_PROBLEM;

import org.omg.CORBA.Current;

public class CircleLinkedList <T> {

   private  Node head;
   private  Node tail;
   private int size;
    
	 class Iterator<T>
	{
		 Node current;
		 
		public T next()
		{
			current=current.getNext();
			return (T) current;
		}
		 
		public boolean hasNext()
		{
			if (current==tail) return false;
			return true;
		}
		
		//public void remove()
	
				
		}
	//}
	//region Constructors
	/**
	 * Constructor 
	 */
	public CircleLinkedList() {
		this.head=null;
		this.tail=null;
		this.size=0;
	}
	/**
	 * Copy Constructor 
	 * @param n the Node We want to copy
	 */
	public CircleLinkedList(CircleLinkedList cll) {
		this.head=cll.head;
		this.tail=cll.tail;
		this.size=cll.size;
	}
	//end-region Constructors
	
	//region GETTERS
	public Node getHead() {
		return this.head;
	}
	public Node getTail() {
	return this.tail;
	}
	
	public int getSize()
	{
		return this.size;
	}
	//end-region GETTERS
	
	//region SETTERS
	public void setHead(int data) {
	
		this.head.setData(data);
	}
	public void setTail(int data) {
		this.tail.setData(data);
	}
	//end-region SETTERS
	
	/**
	 * add new Node to the CircleLinkedList
	 * @param data the data of the new Node
	 */
	public void add(int data) {
		Node d= new Node(data);
		if (this.getSize()==0)
		{
			this.tail=d;
			this.head=d;
			this.size++;
			this.head.setNext(d);
			this.head.setPrev(d);
		}
		else{
			
		
		d.setNext(head);
		d.setPrev(tail);
		tail.setNext(d);
		this.tail=d;
		this.size++;
		this.head.setPrev(tail);
		
		}
		
	}
	
	@Override
	public String toString() {
		return "CircleLinkedList [head=" + head + ", tail=" + tail + ", size=" + size + "]";
	}
	/**
	 * @return the Real Size of the Circle LinkedList
	 */
	
}
