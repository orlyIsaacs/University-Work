package AIRPLANE;

public class Node {

	    double x, y;
		double entry=0;
		double entry2=0;
		int numOfPathes=1;
		
		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}


			public Node(Node n) {
				this.x = n.x;
				this.y = n.y;
			}


}
