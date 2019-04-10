package PARKING_PROBLEM;
public class MainTest {
	
	public static void main(String[] args) {
	
		Node n1=new Node(0);
		Node n2=new Node(1);
		Node n3=new Node(2);
		Node n4=new Node(3);
		Node n5=new Node(1);
		Node n6=new Node(4);
		
		CircleLinkedList check=new CircleLinkedList();
		check.add(1);
		check.add(2);
		check.add(3);
		check.add(2);
		check.add(14);
		
		check.toString();
		
		
	}
}
