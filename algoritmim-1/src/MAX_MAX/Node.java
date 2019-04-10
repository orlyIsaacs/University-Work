package MAX_MAX;

public class Node {
	
	int data;
	Node next;
	Node prev;
	int[] stack;
	int capacityStack=0;
	
	public Node(int data)
	{
		this.data=data;
		this.stack=new int[64];
		this.capacityStack=0;
	}
	
	public Node(Node n)
	{
		this.data=n.data;
		this.next=n.next;
		this.prev=n.prev;
		this.capacityStack=n.capacityStack;
		for (int i : stack)
		{
			this.stack[i]=n.stack[i];
		}
	}
	
	
	public void addToStack( Node n)
	{
	
		this.stack[this.capacityStack]=n.getData();
		this.capacityStack++;
	}

	public int getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	
	
	

}
