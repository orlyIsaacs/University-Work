package algoritmim2;

import java.util.Arrays;

public class PetrolStation {
	
	

	public static int[] circleBest (int[] arr)
	{
		int [] ans={0,0,0}; // [0]= start, [1]= end, [2]= max
		int[] bestArr =Best.best(arr);
		int [] minus= new int[arr.length];
		int sumArr=0;
		
		for (int i = 0; i < arr.length; i++) {
			sumArr+= arr[i];
			minus[i]= -arr[i];
		}
		
		int[] bestMinusArr= Best.best(minus);
		if (bestArr[2]>sumArr+bestMinusArr[2])
			return bestArr;
		else
		{
			ans[0]=bestMinusArr[1];
			ans[1]= bestMinusArr[0];
			ans[2]=sumArr+bestMinusArr[2];
			
			return ans;
		}
	}
		
		
	// return an arr that= ans[0]= start point of the ride, ans[1]= petrol at the end of the way
		public static int[] ps(int[]petrolAtStation, int[]costToNext)
		{
			int [] ans= {0,0};
			int [] hefresh= new int[petrolAtStation.length];
			int sumHefresh=0;
			for (int i = 0; i < hefresh.length; i++) {
				hefresh[i]= petrolAtStation[i]-costToNext[i];
				sumHefresh+=hefresh[i];
			}
			
			if (sumHefresh<0)
			{
				System.out.println("can not go the whole way!");
				return ans;
			}
			
			else
			{
				int[] temp= Best.circleBest(hefresh);
				ans[0]=temp[0]; // start point
				ans[1]= sumHefresh;
				return ans;
			}
		
		
	}
		
		public static void main(String[] args) {
			int []a= {1,4,8,2,9};
			int [] b= {5,3,2,6,2};
			System.out.println(Arrays.toString(ps(a,b)));
		}
	
	
	

}
