package NUMBER_GAME;

import java.util.Arrays;

public class SpetialLIS {
	
	public static int[] simpleLis (int [] arr)
	{
		int [] ans;
		int [][] mat= new int[arr.length][arr.length];
		mat[0][0]= arr[0];
		int entry=0;
		int depth=1;
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i]<mat[0][0])
				entry=0;
			else if (arr[i]>mat[depth-1][depth-1])
			{
				entry= depth;
				depth++;
			}
			else	entry= binSearch(mat, arr[i],0, depth-1);
			
			mat[entry][entry]=arr[i];
			// copy
			for (int j = 0; j <entry; j++) 
				mat[entry][j]= mat[entry-1][j];	
			
		}
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
		ans= mat[depth-1];
		return (int[]) Arrays.copyOf(mat[depth-1], depth);
	}

	private static int binSearch(int[][] mat, int number, int start, int end) {
		
		if (end==start)return start;
		if (end-start ==1)
			if (number<mat[start][start]) return start;
			else if (number>= mat[end][end]) return end;
		
		
		int middle = (start+end)/2;
		if (mat[middle][middle]== number) return middle;
		else if (mat[middle][middle]<number) // right
			return binSearch(mat, number, middle+1, end);
		else return binSearch(mat, number, start, middle-1); // left 
		
	}
	
	
	
	//////////////////////////////spetial lis /////////////////////////////////////////////
	public static int SptialLisPow (int [] arr)
	{
		int [] numOfPows = new int[arr.length];
		int checkPow=0;
		int counter=0;
		for (int i = 0; i < arr.length; i++) {
			checkPow=arr[i];
			 counter=1;
			for (int j = i+1; j < numOfPows.length; j++) {
				
				if (arr[j] == (checkPow*checkPow))
				{	counter++;
					checkPow=checkPow* checkPow;}
			}
			numOfPows[i]=counter;
		}
		// finding the max
		System.out.println(Arrays.toString(numOfPows));
		int max=numOfPows[0];
		for (int i = 0; i < numOfPows.length; i++) {
			if (numOfPows[i]>max)
				max= numOfPows[i];
			}
	 return max;
	}
	

	public static void main(String[] args) {
		
		int [] arr={1,2,5,1,4,7,8,2,3};
		System.out.println("lis is: ");
		int []lis=simpleLis(arr);
		System.out.println(Arrays.toString(lis));
		System.out.println();
		
		int [] arr2= {2,3,9,4,81,16,6561,25,256};
		System.out.println(Arrays.toString(arr2));
		System.out.println("longest pow row is: "+SptialLisPow(arr2));
		
		
			}
}
