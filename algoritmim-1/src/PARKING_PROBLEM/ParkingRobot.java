package PARKING_PROBLEM;
public class ParkingRobot extends CircleLinkedList {
	
	private static final int V=1;
	private static final int X=0;
	CircleLinkedList s;
	
	
	
	/**
	 * Constructor 
	 * @param cll the Circle LinkedList we want to check
	 */
	public ParkingRobot(CircleLinkedList cll) {
		 s=new CircleLinkedList(cll);
		
	}
	
	/**
	 * @return the numbers of cars in parking
	 */
	public int countCars(){
		
		if (s==null)
			return 0;
		if(s.getHead().getNext()==null)
			return 1;
		
		
		s.setHead(V);
		Node pointer = new Node(s.getHead());
		int counter=1;
		boolean finish=false;
		while (finish==false)
		{
			if (pointer.getData()==V)
			{
				pointer.setData(X);
				for(int i=counter; i>0; i++)
					pointer=pointer.getPrev();
				
				if( pointer.getData()== X)
				{
					finish=true;
					return counter;
				}
				else
					for(int i=counter; i>0; i++)
						pointer=pointer.getNext();
			}
					
				
					
			counter++;
			pointer=pointer.getNext();
		}
		
		return counter;
			
		
		
		
		
	}
	
	public String toString() {
	 String ans= super.toString();
	 ans=ans+ "/n number of cars is: "	+countCars();
	 return ans;
	
	
	}
}
