package algoritmim2;

import java.nio.charset.MalformedInputException;
import java.util.Arrays;

public class BestMat_N3 {
	
	
	/// returns a matrix that contains the sums by colom
	public static int[][] sumsOfMat (int [][] a)
	{
		int sums[][] = new int [a.length][a[0].length];
		for (int i = 0; i < sums.length; i++) {
			for (int j = 0; j < sums[0].length; j++) {
				if(i==0)
				sums[i][j]=a[i][j];
				else
					sums[i][j]= sums[i-1][j] +a[i][j];
			}
		}
		return sums;		
	}
	
	// returns an array with data about the max minor 
	public static int[] bestMatN3 (int [][] mat)
	{
		int ans[] = new int[5]; // [0]= i start, [1]= i end, [2] = j start, [3]= j end, [4]= sumMax
		int [][] sums= sumsOfMat(mat);
		int [] temp= new int[mat[0].length];
		int max= mat[0][0];
		
		for (int i_start = 0; i_start < sums.length; i_start++) {
			for (int i_end = i_start; i_end < sums.length; i_end++) {  // O(n^2) full search on combinations of rows
				
				
				// another O(n) for filling temp[] "sqoshes" the rowes in to an arr temp and the sends to best
				if (i_start==0) // can not decrece if i is 0 there will be an error
					for (int k = 0; k < sums[0].length; k++) // size of coloms
						temp[k]= sums[i_end][k];
				else
					for (int k = 0; k < sums[0].length; k++) { // size of coloms
						temp[k]= sums[i_end][k] - sums[i_start-1][k];
					}
				
				//System.out.print(Arrays.toString(temp));
				int [] bestTemp= Best.best(temp);
				//System.out.println(Arrays.toString(bestTemp));
				if (bestTemp[2]>max)
				{
					ans[0]= i_start;
					ans[1]= i_end;
					ans[2]= bestTemp[0];
					ans[3]= bestTemp[1]-1;
					ans[4]= bestTemp[2];
					max= ans[4];
				}
					
				}
				
			}
		
		
		return ans;
	}
	
	
	public static void main(String[] args) {
		
		int [][] mat = {{5, -3 , 2, -7 , -1},
						{-5, 3,  -9 ,10  ,4},
						{2,  4,   2, -8, -5},
						{-1, 6,   3,  2, -8},
						{2, -6,   -1, 3,  3}};
		
		
		System.out.println("original matrix-");
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
		System.out.println();
		
		System.out.println("sums matrix-");
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(sumsOfMat(mat)[i]));
		}
		
		System.out.println();
		
	
	       System.out.println("final ans in O(n^3)");
			System.out.println(Arrays.toString(bestMatN3(mat)));
		
		}
	
	
						
	

}
