package AIRPLANE;

import junit.runner.BaseTestRunner;

public class AirPlaneProblem {



	public static void fillMat (int[][] xCost, int [][] yCost)
	{
		int row=xCost.length;
		int colom= xCost[0].length;
		PlaneNode mat [][] = new PlaneNode [row][colom];
		mat[0][0]= new PlaneNode(xCost[0][0], yCost[0][0], 0, 1);
	
		 for(int j=1; j<colom; j++) // מלוי שורה ראשונה
		 {
			 mat[0][j]= new PlaneNode(xCost[0][j], yCost[0][j], 0,1);
			 mat[0][j].entry=mat[0][j-1].entry+ mat[0][j-1].x;
		 }
		 
		 for(int i=1; i<row; i++ ) // מילוי עמודה ראשונה
		 {
			 mat[i][0]= new PlaneNode(xCost[i][0], yCost[i][0], 0,1);
			 mat[i][0].entry=mat[i-1][0].entry+ mat[i-1][0].y;
		 }
		 
		 
		
		
		for (int i=1; i<row; i++) // מילוי שאר המטריצה
		{
			for( int j=1; j<colom; j++)
			{
				mat[i][j]= new PlaneNode(xCost[i][j], yCost[i][j], 0, 0);
				mat[i][j].entry= Math.min(mat[i][j-1].entry+ mat[i][j-1].x, mat[i-1][j].entry+mat[i-1][j].y );
				mat[i][j].numOfPaths= mat[i-1][j].numOfPaths+ mat[i][j-1].numOfPaths;
			}
		}
	
		 /////////////// ending fill the matrix
	
		
		
		/////////////// printing////////////////
		System.out.println("entreys-");

		for (int i=0; i<row; i++) // print מטריצה
		{
			for( int j=0; j<colom; j++)
			System.out.print(mat[i][j].entry+" ");
			System.out.println();
		}
		
		System.out.println();
		System.out.println("number of pathes-");
	
		for (int i=0; i<row; i++) // print מטריצה
		{
			for( int j=0; j<colom; j++)
			System.out.print(mat[i][j].numOfPaths+" ");
			System.out.println();
		}
		
//		///////////////end printing////////////////
		
		
		 int cheapestPrice = mat[row-1][colom-1].entry;
		 System.out.println();
		 System.out.println("min cost is: "+cheapestPrice);
		 
		 System.out.println("all best traces: ");
		 getAllTrace(mat);
		 
		
		 ////////////// best trace///////////////
		 
		 String bestTrace="";
		 int i=mat.length-1;
		 int j= mat[0].length-1;
		 
		 while(i>0 && j>0)
		 {
			 int up= mat[i-1][j].entry+ mat[i-1][j].y;
			 int left= mat[i][j-1].entry+ mat[i][j-1].x;
			 if (up<left)
			 {
				 bestTrace= "1"+bestTrace;
				 i--;
			 }
			 else
			 {
				 bestTrace= "0"+bestTrace;
				 j--;
			 }
		 }
		 
		 while (i>0)
		 {
			 bestTrace= "1"+bestTrace;
			 i--; 
		 }
		 
		 while (j>0)
		 {
			 bestTrace= "0"+bestTrace;
			 j--;
		 }
		 
		 System.out.println("best trac: "+bestTrace);
	
		
	}
	
	/////////////////////// all traces//////////////////////
	
	public static void getAllTrace(PlaneNode[][] mat)
	{
		String ans="";
		getAllTrace(mat,ans,mat.length-1, mat[0].length-1);
	}
	
	
	public static void getAllTrace( PlaneNode[][] mat, String ans, int i, int j)
	{
		if (i==0 && j==0)
			System.out.println(ans);
		
		else if (j==0 && i!=0)
		{
			while(i!=0)
			{
				ans= "1"+ans;
				i--;
			}
			System.out.println(ans);
		}

		else if (i==0 && j!=0)
		{
			while(j!=0)
			{
				ans= "0"+ans;
				j--;
			}
			System.out.println(ans);
		}
		
		else if (mat[i-1][j].entry+ mat[i-1][j].y ==mat[i][j-1].entry+ mat[i][j-1].x)
		{
			String ansUp="1"+ ans;
			getAllTrace(mat, ansUp, i-1, j);
			String ansLeft= "0"+ans;
			getAllTrace(mat, ansLeft, i, j-1);
		}
		
		else if (mat[i-1][j].entry+ mat[i-1][j].y > mat[i][j-1].entry+ mat[i][j-1].x)
			getAllTrace(mat, "0"+ans, i, j-1);
		else
			getAllTrace(mat, "1"+ans, i-1, j);
			
			
	}
	
	
	/////////////// ip point is in the trace//////////////////
	
	public static boolean ifIsOnTrace( PlaneNode p)
	{
				
		
		
		return false;
	}
	/////////////////// tester//////////////////////////////
	
	public static void main(String[] args) {
		//int x[][]= {{7,4,10,0},{5,6,9,0},{10,1,3,0},{3,4,8,0}};
		//int y[][] ={{8,4,4,7},{3,8,13,9},{7,4,3,1},{0,0,0,0,}};
		
		int x[][]= {{7,8,18,0},{10,4,7,0},{4,6,3,0},{3,3,1,0}};
		int y[][]={{1,5,3,1},{9,3,6,8},{5,1,5,9},{0,0,0,0}};
		
		System.out.println("X'es");
		for(int i=0; i<x.length; i++){
			for(int j=0; j<x[0].length; j++)
				System.out.print(x[i][j]+" ");
			System.out.println();
		}
			
		System.out.println();
	
		System.out.println("Y'es");
		for(int i=0; i<y.length; i++){
			for(int j=0; j<y[0].length; j++)
				System.out.print(y[i][j]+" ");
			System.out.println();
		}

		System.out.println();
	
		fillMat(x, y);
	
		
}
}