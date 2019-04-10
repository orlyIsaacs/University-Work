package ONE_MATRIX;

import java.util.Arrays;

public class OneMatrix {
	
	//////////////////// with arr[]//////////////////
	public static int[] longest1sec (int [] arr)
	{
		int [] helpCount = new int[arr.length];
		if (arr[0]==1)
			helpCount[0]=1;
		else helpCount[0]=0;
		
		for(int i=1; i<arr.length; i++)
		{
			if (arr[i]==0) helpCount[i]=0; //////// 0
			else if (arr[i]==1)
				helpCount[i]= helpCount[i-1]+1; //////////////1
		}
		
		////////// finding the max
		int max1= 0;
		for(int i=0; i<helpCount.length; i++)
			if (helpCount[i]>max1) max1= helpCount[i];
		
		///////// creating the answer
		String ans="";
		for(int i=0; i<max1; i++)
			ans+='1';
		
//		System.out.print("the arr:                    ");
//		System.out.println(Arrays.toString(arr));
//		System.out.print("the help secuence Counter:  ");
//		System.out.println(Arrays.toString(helpCount));
//		
//		System.out.println("longes secuence of '1' in arr is at size "+max1);
//		System.out.println(ans);
		
		return helpCount;
			
	}

	
	
	//////////////////////// biggest square in matrix//////////////
	public static int findMaxSqere (int [][] matrix)
	{
		int row=matrix.length;
		int colom=matrix[0].length;
	 	int [][] seqwences = new int [row][colom];
	 	
	 	for (int i=0; i<row; i++) ///// fill the first colom
	 		seqwences[i][0]= matrix[i][0];
	 	
	 	for (int j = 0; j < colom; j++)  ///////// fill the first row
	 		seqwences[0][j]= matrix[0][j];
	 	
	 	System.out.println(Arrays.toString(seqwences[0]));
	 	///// fill the rest- and find max///////////////
	 	int max=0;
	 	
	 	for (int i = 1; i <row; i++){
	 		for (int j = 1; j <colom; j++) {
	 			
	 			if (matrix[i][j]==0) seqwences[i][j]=0;
	 			else 
	 				seqwences[i][j]= Math.min(Math.min(seqwences[i-1][j-1], seqwences[i][j-1]),seqwences[i-1][j])+1;
	 			if (seqwences[i][j]>max)
	 				max=seqwences[i][j];
			}
	 		System.out.println(Arrays.toString(seqwences[i]));
	 	}
	 	return max;
	}
	
	

	//////////////////////////////tester///////////////////////////////
	public static void main(String[] args) {
		int []a= {0,0,1,1,0,0,1,1,1,0,0,1,0,1};
		//longest1sec(a);
		
		int matrix[][] = {{1,1,0,0,1,1,},{1,1,1,1,1,0},{0,1,1,1,1,1},{0,0,1,1,1,1},{0,1,0,1,0,1}};
		System.out.println("original matrix-");
		for(int i=0; i<matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
		System.out.println();
		System.out.println("biggest sqer is in size: "+findMaxSqere(matrix) );
		
	}
}
