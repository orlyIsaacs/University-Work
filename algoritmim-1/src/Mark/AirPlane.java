package Mark;

import java.util.Arrays;

import AIRPLANE.PlaneNode;

public class AirPlane {

	
	
	public static void fillMat (Node [][] mat){
		
		mat[0][0].entry1=0;
		mat[0][0].entry2=0;
		
		for (int i = 1; i < mat.length; i++) {
			mat[i][0].entry1= mat[i-1][0].entry1+mat[i-1][0].y;
			mat[i][0].entry2= mat[i-1][0].entry2+mat[i-1][0].y;
		}
		for (int j = 1; j < mat[0].length; j++) {
			mat[0][j].entry1= mat[0][j-1].entry1+ mat[0][j-1].x;
			mat[0][j].entry2= mat[0][j-1].entry2+ mat[0][j-1].x;
		}
		
		 /// fill the test
		
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				
				double a= mat[i-1][j].entry1 +mat[i-1][j].y;
				double b= mat[i][j-1].entry1 +mat[i][j-1].x;
				double c= mat[i-1][j].entry2 +mat[i-1][j].y;
				double d= mat[i][j-1].entry2+ mat[i][j-1].x;
			
				double [] arr= {a,b,c,d};
				Arrays.sort(arr);
				mat[i][j].entry1= arr[0];
				if (arr[1]>arr[0])
					mat[i][j].entry2= arr[1];
				else if (arr[2]>arr[0])
					mat[i][j].entry2= arr[2];
				else
					mat[i][j].entry2= arr[3];
				
				if (a==b)
				mat[i][j].numOfPath= mat[i-1][j].numOfPath + mat[i][j-1].numOfPath;
				else if (a<b)
					mat[i][j].numOfPath= mat[i-1][j].numOfPath;
				else
					mat[i][j].numOfPath= mat[i][j-1].numOfPath; // b<a
				
			}
		}
		
	}
	
    public static Node [][] FillInMatrix (){
    	Node [][] mat = new Node[3][4];
	mat[0][0] = new Node (4,8);
	mat[0][1] = new Node (2,3);
	mat[0][2] = new Node (0,4);
	mat[0][3] = new Node (3,5);
	
	mat[1][0] = new Node (2,5);
	mat[1][1] = new Node (3,8);
	mat[1][2] = new Node (1,2);
	mat[1][3] = new Node (0,2);
	
	mat[2][0] = new Node (3,3);
	mat[2][1] = new Node (5,2);
	mat[2][2] = new Node (2,3);
	mat[2][3] = new Node (3,3);

return mat;

}
	
	public static void main(String[] args) {
	
		
		Node [][]plane = FillInMatrix();
		fillMat(plane);
		System.out.println("entry1 "+plane[plane.length-1][plane[0].length-1].entry1);
		System.out.println("entry2= "+plane[plane.length-1][plane[0].length-1].entry2);
		System.out.println("num of pathes= "+plane[plane.length-1][plane[0].length-1].numOfPath);
		
		System.out.println("X'es");
		for (int i = 0; i < plane.length; i++) {
			for (int j = 0; j < plane[0].length; j++) {
				System.out.print(plane[i][j].x+",");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("Y'es");
		for (int i = 0; i < plane.length; i++) {
			for (int j = 0; j < plane[0].length; j++) {
				System.out.print(plane[i][j].y+",");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("entrys1");
		for (int i = 0; i < plane.length; i++) {
			for (int j = 0; j < plane[0].length; j++) {
				System.out.print(plane[i][j].entry1+",");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("entrys2");
		for (int i = 0; i < plane.length; i++) {
			for (int j = 0; j < plane[0].length; j++) {
				System.out.print(plane[i][j].entry2+",");
			}
			System.out.println();
		}


		System.out.println();
		System.out.println("num of pathes");
		for (int i = 0; i < plane.length; i++) {
			for (int j = 0; j < plane[0].length; j++) {
				System.out.print(plane[i][j].numOfPath+",");
			}
			System.out.println();
		}
		
		
		
	}

}
