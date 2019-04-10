package algoritmim2;

import java.util.Arrays;

public class FW {

	public static int numOfComponents(boolean mat[][]) // returns how many "rechivay kshirut" are there in the graf
	{
		int[] kodkodim= new int[mat[0].length];
		int counter=0;
		for (int i = 0; i < kodkodim.length; i++) {
			while(kodkodim[i]!=0) 
				{i++;
				if (i==kodkodim.length)
				return counter;
				}
			counter++;
			for (int j = 0; j < kodkodim.length; j++) {
				if(mat[i][j]==true)
				{
					kodkodim[i]=counter;
					kodkodim[j]=counter;
				}
			}
			
		}
		
		return counter;
		
	}
	
	public static void FW (boolean mat[][]) // the fw boolean function that ditemends if there is a path from i to j
	{
		for (int k = 0; k < mat.length; k++) {
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat.length; j++) {
					
					mat[i][j]= (mat[i][j] || (mat[i][k]&&mat[k][j]));
				}
			}
		}
	}
	
	
	public static void lowCost(double mat[][])
	{
		for (int k = 0; k < mat.length; k++) {
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat.length; j++) {
						mat[i][j]= Math.min(mat[i][j], mat[i][k]+mat[k][j]);
				}
			}
		}
	}
	
	
	public static void paths (double mat[][]) // prints a matrix with the strings of best pathes
	{
		String [][] p= new String [mat[0].length][mat[0].length];
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p.length; j++) {
				if (mat[i][j]<Double.POSITIVE_INFINITY)
					p[i][j]=i+"->"+j+" ";
				else p[i][j]="point";
				
			}
		}
		
		for (int k = 0; k < p.length; k++) {
			for (int i = 0; i < p.length; i++) {
				for (int j = 0; j < p.length; j++) {
					if (p[i][j].equals("point"));
					else if(mat[i][j]>=mat[i][k]+mat[k][j])
						p[i][j]=p[i][k]+p[k][j];
				}
			}
		}
		
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p.length; j++) {
				System.out.print(p[i][j]+", ");
			}
			System.out.println();
		}
	}
	
	////////// printers//////////////
	public static void printMat(double mat[][])
	{
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
	}
	
	public static void printMat(boolean mat[][])
	{
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
	}
	
	public static void main(String[] args) {
		boolean mat1[][] = {
				{true,false,false,false,true,false},
				{false,true,true,true,false,false},
				{false,true,true,true,false,false},
				{false,true,true,true,false,false},
				{true,false,false,false,true,false},
				{false,false,false,false,false,false}};
		
		boolean mat2[][]={
				{false,true,false,false},
				{true,false,true,false},
				{false,true,false,true},
				{false, false, true, false}};
		
		double infinity= Double.POSITIVE_INFINITY;
		double mat3[][]={
				{infinity, 2,1,infinity},
				{2, infinity, 4,10},
				{1,4,infinity,3},
				{infinity,10,3,infinity}};
		
	////////////////////////////////////////////////////////////////////////
		
		System.out.println("num of companants in mat 1 is-" + numOfComponents(mat1));
		System.out.println("mat befor fw=");
	    printMat(mat2);
		System.out.println("mat after fw=");
		FW(mat2);
	    printMat(mat2);
	    System.out.println("number of components in mat 2="+ numOfComponents(mat2));
	    System.out.println();
		
	    System.out.println("conectinos at bigining= ");
	    printMat(mat3);
	    System.out.println("after fw lowCost=");
	    lowCost(mat3);
	    printMat(mat3);
	    System.out.println();
	    paths(mat3);
	    
	    
	}

	
	
	
	
}
