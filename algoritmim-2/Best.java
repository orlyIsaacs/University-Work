package algoritmim2;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Best {
//*************************
	/// returns an arr with the answer of the most biggest part with the shortest length  
	// O(n) - one run!
	public static int[] best (int[] arr)
	{
		int [] ans= new int [3];
	// ans[0]= start, ans[1]= end, ans[2]= max
		int start=0;
		int end=1;
		int sum=0;
		int max=arr[0]; // maximum of all sums
		int ts=0; // temp start
		int size=0; // of the length of the part
		
		for ( int i = 0; i < arr.length; i++) {
			
			sum+=arr[i];
			if (sum>max)
			{
				max= sum;
				end=i+1;
				start=ts;
				size=end-start;
			}
			
			else if (sum==max) // we added this in order to give the shortest part
			{
				if(i+1-ts <size)
				{
					max= sum;
					end=i+1;
					start=ts;
					size=end-start;
				}
					
			}
			
			else if (sum<0)
			{
				ts=i+1;
				sum=0;
			}
		}
		
		ans[0]= start;
		ans[1]=end;
		ans[2]= max;
		return ans;
	}
	
	public static void allParts (int[] arr)
	{
		int maxSum= best(arr)[2];
		ArrayList<Integer>  ps = new ArrayList<>(); // ps= potential starts
		ps.add(0); // Obviously is potential
		int tempSum=0;
		for (int i = 0; i < arr.length; i++) {
			
			tempSum+=arr[i];
			
			if(tempSum==0) // add to ps
				ps.add(i+1);
			
			else if (tempSum==maxSum) // print all wase till now
			{
				for (Integer start : ps) {
					System.out.println(start+" - "+(i+1));
				}
			}
			
			else if (tempSum<0)
			{
				tempSum=0;
				ps.clear(); // not relevant any more
				ps.add(i+1); // adding the next potential
			}
				
				
		}
		
	}
	
	public static int[] circleBest (int[] arr)
	{
		int [] ans={0,0,0}; // [0]= start, [1]= end, [2]= max
		int[] bestArr =best(arr);
		int [] minus= new int[arr.length];
		int sumArr=0;
		
		for (int i = 0; i < arr.length; i++) {
			sumArr+= arr[i];
			minus[i]= -arr[i];
		}
		
		int[] bestMinusArr= best(minus);
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
	
	
	public static void main(String[] args) {
		
//		int[]  arr1={3,-5,2,3,-6,5};
//		int[]  arr2={-3,-5,-2,-3,-6,-5};
//		int[]  arr3={0,5,-2,2,0};
//		
//		System.out.println("arr1- ");
//		System.out.println(Arrays.toString(best(arr1)));
//		System.out.println("start| and| max sum");
//		System.out.println("all parts-");
//		allParts(arr1);
//		
//		System.out.println();
//		System.out.println("arr2- ");
//		System.out.println(Arrays.toString(best(arr2)));
//		System.out.println("start| and| max sum");
//		System.out.println("all parts-");
//		allParts(arr2);
//		
//		System.out.println();
//		System.out.println("arr3- ");
//		System.out.println(Arrays.toString(best(arr3)));
//		System.out.println("start| and| max sum");
//		System.out.println("all parts-");
//		allParts(arr3);
		
		
		//int[] arr={2,3,-6,1,-7,2};
		//System.out.println(Arrays.toString(circleBest(arr)));
	//	System.out.println(Arrays.toString(best(arr)));
		
		int[] arr5={1,-10,5,-4,1,-100};
		System.out.println(Arrays.toString(best(arr5)));
	}
	
	
}
