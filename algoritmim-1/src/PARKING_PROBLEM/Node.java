package PARKING_PROBLEM;
public class Node {

	private int data;
	private Node next;
	private Node prev;
	// your code... Bone variables
	
	//region Constructors
	
	
	/**
	 * Constructor 
	 * @param data data of the Node
	 */
	public Node(int data) {
		this.data=data;
		
	}
	/**
	 * Copy Constructor 
	 * @param n the Node We want to copy
	 */
	public Node(Node n) {
		this.data=n.data;
		this.next=n.next;
		this.prev=n.prev;
				
		
	}
	
	
	
	
	//region GETTERS
	public Node getNext() {
		if (this.next==null)
			return null;
		return this.next;
	}
	public Node getPrev() {
		if (this.prev==null)
			return null;
		return this.prev;
	
	}
	public int getData() {
		return this.getData();
	
	}


	
	//region SETTERS
	public void setNext(Node n) {
		this.next=n;
		n.prev=this;
	}
	public void setPrev(Node n) {
		this.prev=n;
		n.next=this;
	}
	public void setData(int data) {
		this.data=data;
	}
	//end-region SETTERS
	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + ", prev=" + prev + "]";
	}
}
