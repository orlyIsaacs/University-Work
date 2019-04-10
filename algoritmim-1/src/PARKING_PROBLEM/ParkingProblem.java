package PARKING_PROBLEM;


public class ParkingProblem {
	private static final int V=1;
	private static final int X=2;
	
	public static int parkingProblem(int[] park)
	{
	int counter=0; // ���� ���� �������
	int startPoint=(int) Math.random()*park.length; // ����� ���� �������� ������
	park[startPoint]=V; // �����
	boolean finnish=false;
	int i=(startPoint+1) % park.length;// �� ����� �� ����� ������
	while (!finnish)
	{
		if (park[i % park.length]==V)
		{
			park[i % park.length] =X;
		 
	    	if (park[(i-counter-1 )% park.length]== X)
	    	{
			finnish = true;
			return counter;
			
	    	}
		
		}

    	counter++;
		i++;
		
				
	}
	
	return counter;
	}
	

	

//
//public static int listLength (Node head)
//{
//	Node slow=head;
//	Node fast=head;
//}
//	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		 int test [] = {2,5,7,1,1,X,V,5};
		 System.out.println(parkingProblem(test));
	}
		
	}
	

	



