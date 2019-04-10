package algoritmim2;

import java.util.Arrays;

public class BestMat {
	
	
	// return an array with the data about the biggest minor
	public static int[] bestMat (int[][] mat)
	{
		int[] ans= {0,0,0,0,0}; // ans[0]= i start, ans[1] j start
								//ans[2]= i end ,  ans[3]= j end, ans[4]= total sum
		
		int[][] sums= new int[mat.length][mat[0].length];
		fillSumMat(mat, sums);
		int maxSum=sums[0][0];
		int tempSum=0; // for every square in the mat
		
		for (int i = 0; i < sums.length; i++) {
			for (int j = 0; j < sums[0].length; j++) {
				for (int i2 = i; i2 < sums.length; i2++) {
					for (int j2 = j; j2 < sums[0].length; j2++) {
						
						// Calculating the sum from every start point to enery end point
						//while checking that we can reduce with a shorted if 
						//so we don't get out of bound
						tempSum= sums[i2][j2]-(i>0 ? sums[i-1][j2] : 0)
								 -(j>0? sums[i2][j-1]: 0)
								 +(j>0&&i>0 ? sums[i-1][j-1] :0 );
						if(tempSum>maxSum)
						{
							maxSum=tempSum;
							ans[0]=i;
							ans[1]=j;
							ans[2]=i2;
							ans[3]=j2;
							ans[4]=maxSum;
						}
						//// adding the term that if their are 2 minors with the same sum,
						// the function will return the smallest area minor
						else if (tempSum==maxSum)
						{
							int tempErae= (j2-j)*(i2-i);
							int curErea= (ans[3]-ans[1])*(ans[2]-ans[0]);
							if (tempErae<curErea)
							{
								maxSum=tempSum;
								ans[0]=i;
								ans[1]=j;
								ans[2]=i2;
								ans[3]=j2;
								ans[4]=maxSum;
							}
								
						}
					}
				}
			}
		}
		
	
		return ans;
	}
	// a function that calcs the sums from 0,0 point to every other point in the mat
	// and fills sum
	
	private static void fillSumMat(int[][] mat, int[][] sums) {
		sums[0][0]= mat[0][0]; 
		// colom0
		for (int i = 1; i < sums.length; i++) {
			sums[i][0]= sums[i-1][0]+ mat[i][0];
		}
		 // row 0
		for (int i = 1; i < sums[0].length; i++) {
			sums[0][i]= sums[0][i-1]+ mat[0][i];
		}
		 // all the rest
		for (int i = 1; i < sums.length; i++) {
			for (int j = 1; j < sums[0].length; j++) {
				sums[i][j]= sums[i][j-1]+sums[i-1][j]- sums[i-1][j-1]+mat[i][j];
			}
		}
		// prints sum
		System.out.println("sums=");
		for (int i = 0; i < sums.length; i++) {
			System.out.println(Arrays.toString(sums[i]));
		}
		
	}
	
	public static void main(String[] args) {
		
		int mat[][]= {{3,5,-2,-7,10},{-8,1,3,2,0},{7,-1,4,-2,-8}};
		System.out.println("mat=");
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
		System.out.println();
		int []ans= bestMat(mat);
		System.out.println();
		System.out.println(Arrays.toString(ans));
	}

}
