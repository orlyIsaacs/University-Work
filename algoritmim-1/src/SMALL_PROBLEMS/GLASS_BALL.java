package SMALL_PROBLEMS;

import java.util.Arrays;

public class GLASS_BALL {
	private static int midlle;

	//// if the ball douse not break at all, returns -1

	public static int getLevel (int arr[] , int numOfBalls, int ballStrength )
	{
		
		if (numOfBalls==1)
			return case1ball (arr , numOfBalls, ballStrength );

		if ( numOfBalls>=arr.length)
			return caseNballs (arr , numOfBalls, ballStrength );
		
		if (numOfBalls==2)
			return case2ballsSqrt (arr , numOfBalls, ballStrength );

		return -1; 
	}

	// o(n) - one ball
	private static int case1ball(int[] arr, int numOfBalls, int ballStrength) {
		for(int i=0; i<arr.length; i++)
			if (arr[i]>ballStrength)
			{
				numOfBalls--;
				System.out.println("number of balls: "+numOfBalls);
				return i;
			}
		return -1;
	}

	// o(log n) n balls - binary search
	private static int caseNballs(int[] arr, int numOfBalls, int ballStrength) {

		return caseNballsreco(arr,0, arr.length-1,numOfBalls, ballStrength);

	}

	private static int caseNballsreco (int[] arr,int start, int end, int numOfBalls, int ballStrength)
	{

		////// stop if
		if (end-start==1)
		{
			if (arr[start]>ballStrength)
			{
				System.out.println("num of balls left= "+numOfBalls);
				return start;
			}
			else{
				System.out.println("num of balls left= "+numOfBalls);
				return end;

			}
		}

		// if you need to re-check
		int midlle= (start+end )/2;
		if (arr[midlle]==ballStrength)
		{
			numOfBalls--;
			return midlle;
		}
		else if (arr[midlle]< ballStrength) // not break
			return caseNballsreco(arr, midlle+1, end, numOfBalls, ballStrength);

		else if (arr[midlle]> ballStrength) // break
		{
			numOfBalls--;
			return caseNballsreco(arr, start, midlle-1, numOfBalls, ballStrength);
		}

		return -1;
	}
	
	
	//////////////// 2 balls  sqrt ////////////////
	

	private static int case2ballsSqrt(int[] arr, int numOfBalls, int ballStrength) {
		
		int sqrt= (int)Math.sqrt(arr.length);
		
		for (int i =sqrt; i < arr.length; i+=sqrt) { // grow by the sqrt of the length
		
			if (arr[i]>ballStrength) // if breaks
			{
				numOfBalls--;
				for (int j = i-sqrt; j <= i; j++) // at max checks sqrt of arr.length levels
					if (arr[j]>ballStrength)
						{numOfBalls--;
						System.out.println("number of balls: "+numOfBalls);
						return j;
						}
			}
		}
		
		
		/////////// checking the upper levels if not divided by sqrt o(2 sqrt(n))///////////
		if (numOfBalls==2)
		{
			int edge= arr.length%sqrt;
			for (int i = edge*sqrt; i < arr.length; i++) {
				if (arr[i]>ballStrength)
				{
					numOfBalls--;
					System.out.println("number of balls: "+numOfBalls);
					return i;
				}
				
			}
		}
	
		return -1;
	}

	


	
	
	
	
	

	/////////////////////////tester/////////////////////

	public static void main(String[] args) {

		int[] a= {2,5,10,14,22,25,36,44,45,57,80};
		System.out.println(Arrays.toString(a));
		int numOfBalls= 2;
		int strength=79;

		System.out.println("ball strength is: "+strength+", number of balls is: "+numOfBalls);
		System.out.println();
		int levelBreak= getLevel(a, numOfBalls, strength);
		if (levelBreak==-1)
			System.out.println("the ball is stronger then all levels!!!");
		else System.out.println("the ball will break at levle "+levelBreak+ " at strength: "+a[levelBreak]);

	}
}
