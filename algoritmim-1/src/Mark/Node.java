package Mark;

public class Node
{
	int x,y;
	double entry1,entry2;
	int numOfPath;
	
	
	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		numOfPath=1;
		this. entry1=0;
		this. entry2=0;
	}
	public Node(Node n) {
		super();
		this.x = n.x;
		this.y = n.y;
	}
	

}