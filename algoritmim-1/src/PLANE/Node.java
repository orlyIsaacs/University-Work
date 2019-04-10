package PLANE;

public class Node {


	double x,y,entry1,entry2;
	int numOfPath;

	public Node (int x,int y){
		this.x=x;
		this.y=y;
		this.numOfPath=1;
		this.entry2=0;
		this.entry1=0;
	}


	public Node (Node n){
		this.x=n.x;
		this.y=n.y;

	}
}
