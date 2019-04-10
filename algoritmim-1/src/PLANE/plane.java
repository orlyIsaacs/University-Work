package PLANE;

import java.util.Arrays;

import PLANE.Node;

public class plane {


	public static Node[][] initMatOfNodes(){ // n = 4
		int n=4;
		Node mat[][] = new Node[n][n];
		//the 1-st row
		mat[0][0] = new Node(1,3);
		mat[0][1] = new Node(8,4);
		mat[0][2] = new Node(3,8);
		mat[0][3] = new Node(0,4);
		//the 2-nd row
		mat[1][0] = new Node(2,5);
		mat[1][1] = new Node(5,11);
		mat[1][2] = new Node(3,1);
		mat[1][3] = new Node(0,2);
		//the 3-d row
		mat[2][0] = new Node(4,10);
		mat[2][1] = new Node(3,1);
		mat[2][2] = new Node(1,4);
		mat[2][3] = new Node(0,8);
		//the 4-th row
		mat[3][0] = new Node(2,0);
		mat[3][1] = new Node(3,0);
		mat[3][2] = new Node(5,0);
		mat[3][3] = new Node(0,0);
		return mat;

	}

	
	public static void fillmat (Node [][] mat) {
		
		mat[0][0].entry1=0;
		mat[0][0].entry2=0;
		
		for (int i = 1; i < mat.length; i++) {
			mat[i][0].entry1= mat[i-1][0].entry1+ mat[i-1][0].y;
			mat[i][0].entry2= mat[i-1][0].entry2+ mat[i-1][0].y;
		}
		
		for (int i = 1; i < mat[0].length; i++) {
			mat[0][i].entry1= mat[0][i-1].entry1 +mat[0][i-1].x;
			mat[0][i].entry2= mat[0][i-1].entry2 +mat[0][i-1].x;
		}
		
		
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat.length; j++) {
				
				double x1= mat[i][j-1].entry1+ mat[i][j-1].x;
				double y1= mat[i-1][j].entry1+ mat[i-1][j].y;
				double x2= mat[i][j-1].entry2+ mat[i][j-1].x;
				double y2= mat[i-1][j].entry2+ mat[i-1][j].y;
				
				double [] options = {x1,x2,y1,y2};
				Arrays.sort(options);
				
				mat[i][j].entry1= options[0];
				if (options[1]> options[0])
					mat[i][j].entry2=options[1];
				else if (options[2]> options[0])
					mat[i][j].entry2=options[2];
				else
					mat[i][j].entry2=options[3];
			}
		}
		
		System.out.println("x");
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j].x+", ");
			}
			System.out.println();
		}
	
		System.out.println("y");
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j].y+", ");
			}
			System.out.println();
		}
	
		System.out.println("entry1");
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j].entry1+", ");
			}
			System.out.println();
		}
		
		System.out.println("entry2");
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j].entry2+", ");
			}
			System.out.println();
		}
	
	
	}
	
	public static void falsePoint (Node [][] mat, int i,int j)
	{
		
		System.out.println("false point");
		Node [][] copy= copyMat(mat);
		copy[i][j].x=Double.POSITIVE_INFINITY;
		copy[i][j].y = Double.POSITIVE_INFINITY;
		copy[i][j].entry1 = Double.POSITIVE_INFINITY;
		fillmat(copy);
		
	}
	
	
	public static void mustGoThrewRec (Node [][] mat, int i1,int j1, int i2, int j2)
	{
		Node [][] copy= copyMat(mat);
		
		
		for(int j=0; j<j1; j++){
			mat[i2][j].y= Double.POSITIVE_INFINITY;
			System.out.println(i1+1+" , "+j);}
		
		
		for (int i=0; i<i1; i++){
			mat[i][j2].x= Double.POSITIVE_INFINITY;
			System.out.println(i+" , "+j2+1);}
			
		System.out.println("not alwed ");
		fillmat(copy);
		
		
		
		
	}
	
	
	private static Node[][] copyMat(Node[][] mat) {
		Node [][] copy= new Node[mat.length][mat[0].length];
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy.length; j++) {
				copy[i][j]= mat[i][j];
			}
		}
		return copy;
	}


	public static void main(String[] args) {
		Node [][] plane = initMatOfNodes();
		fillmat(plane);
		System.out.println();
		falsePoint(plane, 2,2);
		System.out.println();
		mustGoThrewRec(plane,3, 0, 3, 1);
	}
}
