package MAX_MAX;

public class MaxMax_2 {

	
	public static void main(String[] args) {
		
		NodeList list= new NodeList(5);
		for (int i=0; i<10; i++)
		{
			Node n=new Node ((int)(Math.random()*100));
			System.out.print(n.getData()+",");
			list.addNode(n);
		}
		System.out.println();
		
		
		// fineding max1
		 while (list.length!=1)
		 {
			 Node start=list.getHead();
			 for (int i=0; i<(list.length/2); i++)// times of compearing on each cut
			 {
				 if (start.getData()>start.next.getData())
				 {
					 start.addToStack(start.next);
					 list.removeNode(start.next);
					 start=start.next;
				 }
				 else
				 {
					 start.next.addToStack(start);
					 start=start.next;
					 list.removeNode(start.prev);
					 start=start.next;
				 }
			 }
			 
			 
		 }
		
		 int max1= list.head.getData();
		 int max2=list.head.stack[0];
		 for (int i=1; i<list.head.capacityStack; i++)
			 if (list.head.stack[i]>max2)
				 max2=list.head.stack[i];
		 
			System.out.println("max1= "+ max1 + " max2= "+ max2);
			 	
			
	}
}
