package MAX_MAX;

public class NodeList {
	
	Node head;
	Node tail;
	int length;
	
	public NodeList (int data)
	{
		Node n=new Node(data);
		this.head=n;
		this.tail=n;
		this.length=1;
	}
	
	public void addNode (Node n)
	{
		if (head==null)
		{
			head=n;
			tail=n;
			this.length++;
		}
		else{
		tail.setNext(n);
		n.setPrev(tail);
		tail=n;
		this.length++;
		}
	}
	
	public void removeNode (Node n)
	{
		if (n==head)
		{
			head=n.getNext();
			n.getNext().prev=null;
			n.setNext(null);
			this.length--;
		}
		else if (n==tail)
		{
			tail=n.prev;
			n.prev.setNext(null);
			tail.next=null;
			this.length--;
		}
		else
		{
			n.prev.setNext(n.next);
			n.next.setPrev(n.prev);
			this.length--;
		}
	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	public int getLength() {
		return length;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public void setLength(int length) {
		this.length = length;
	}
	

}
