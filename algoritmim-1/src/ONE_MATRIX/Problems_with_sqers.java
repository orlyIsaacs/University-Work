package ONE_MATRIX;

import java.util.Arrays;

public class Problems_with_sqers {

	public static int numOfRecs (int [][] matrix)
	{
		int [][] newMatrix =new int[matrix.length+1][matrix[0].length+1];
		
		for (int i = 0; i < newMatrix.length; i++)
			newMatrix[i][0]=0;
		for (int i = 0; i < newMatrix[0].length; i++)
			newMatrix[0][i]=0;
		int counter=0;
			
			for (int i = 1; i < newMatrix.length; i++) {
				for (int j = 1; j < newMatrix[0].length; j++) {	
					newMatrix[i][j]=matrix[i-1][j-1];
					if (newMatrix[i][j]==1 && newMatrix[i-1][j]==0 && newMatrix[i][j-1]==0)
						counter++;
				}
		}
			
			for(int i=0; i<newMatrix.length; i++)
				System.out.println(Arrays.toString(newMatrix[i]));
			return counter;
	}
	
	/////////////////////////////// biggest rectangle  o(n^6)/////////////////////
	 /// start= [i1][j1] , end=[i2][j2]///
	public static int biggestRec (int [][] mat)
	{
		int maxRec=0;
		for (int i1 = 0; i1 < mat.length; i1++) { // point start
			for (int j1 = 0; j1 < mat[0].length; j1++) {
				for (int i2 = i1; i2 < mat.length; i2++) {  /// point end
					for (int j2 = j1; j2 < mat[0].length; j2++) {
						
						//// we have here a minor with point end to point start///
						boolean isOne= isFullOne (mat,i1,j1,i2,j2);
						if (isOne)
						{
							int len= ((j2-j1)+1) * ((i2-i1)+1) ; /// calculate the size
							if (len>maxRec)
								maxRec=len;
						}
					}
					
				}
				
			}
			
		}
		
	
		return maxRec;
	}
	
	
	
	private static boolean isFullOne(int[][] mat, int i1, int j1, int i2, int j2) {
		{
			for(int i=i1; i<=i2; i++)
				for (int j=j1; j<=j2; j++)
					if (mat[i][j]!=1) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int matrix[][] = {{1,1,0,0,0},{1,1,0,1,0},{0,0,0,1,0},{1,1,0,1,0}};
		System.out.println("original matrix-");
		for(int i=0; i<matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
		System.out.println();
		//System.out.println("number of rectangels: "+ numOfRecs(matrix));
		System.out.println("biggesr rec is in size: "+biggestRec(matrix));
		
		int matrix21 [][]= {{0,0,0,1},{0,0,0,1},{0,0,0,1},{1,1,1,1}};
		System.out.println("original matrix-");
		for(int i=0; i<matrix21.length; i++)
			System.out.println(Arrays.toString(matrix21[i]));
		System.out.println();
		System.out.println("biggesr rec is in size: "+biggestRec(matrix21));
		
		
		int matrix3 [][]= {{1,1,1,1,1},{1,1,1,1,1},{1,0,1,1,0},{1,0,0,0,0}};
		System.out.println("original matrix-");
		for(int i=0; i<matrix3.length; i++)
			System.out.println(Arrays.toString(matrix3[i]));
		System.out.println();
		System.out.println("biggesr rec is in size: "+biggestRec(matrix3));
		
		int matrix4 [][]= {{0,0,0},{0,0,0},{0,0,0}};
		System.out.println("original matrix-");
		for(int i=0; i<matrix4.length; i++)
			System.out.println(Arrays.toString(matrix4[i]));
		System.out.println();
		System.out.println("biggesr rec is in size: "+biggestRec(matrix4));
	}
	}

