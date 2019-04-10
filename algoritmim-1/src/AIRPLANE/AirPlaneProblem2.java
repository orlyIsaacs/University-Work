package AIRPLANE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Vector;



public class AirPlaneProblem2 {


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


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////// airPlane 2!!! ////////////////////////////////////////


	public static int fillMat (Node [][] mat)
	{
		///// inishilizeation of first roe and colom
		mat[0][0].entry=0;
		for (int i=1; i<mat.length; i++)
			mat[i][0].entry= mat[i-1][0].entry+ mat[i-1][0].y;
		
		for (int i = 1; i < mat[0].length; i++) 
			mat[0][i].entry= mat[0][i-1].entry+ mat[0][i-1].x;
	

		///////// filling the mat

		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				 double a=mat[i-1][j].entry+mat[i-1][j].y;
				double b= mat[i][j-1].entry + mat[i][j-1].x;
				mat[i][j].entry= Math.min(a, b);
				if (a==b)
					mat[i][j].numOfPathes= mat[i-1][j].numOfPathes+ mat[i][j-1].numOfPathes;
				else if (a < b)
					mat[i][j].numOfPathes= mat[i-1][j].numOfPathes;
				else
					mat[i][j].numOfPathes= mat[i][j-1].numOfPathes;
					
					
			}
		}
		return (int) mat[mat.length-1][mat[0].length-1].entry;
	}

	////////////////////////////////////////// one path//////////////////////
	public static String Onepath (Node [][] mat)
	{
		String ans="";
		int i= mat.length-1;
		int j= mat.length-1;
		double up,left;
		while (i>0 && j>0)
		{
			up=mat[i-1][j].entry+mat[i-1][j].y;
			left= mat[i][j-1].entry+mat[i][j-1].x;
			if (up<left)
			{
				ans= '1'+ans; // up
				i--;
			}
			else{
				ans='0'+ans; // left
				j--;
			}
		}
		
		while (i>0){
			ans= '1'+ans;
			i--;
		}
		
		while (j>0){
			ans= '0'+ans;
			j--;
		}
		
		return ans;
	}
	
	/////////////////////////////////////// all pathes////////////////////////////////
	public static Vector<String> allPathes (Node [][] mat)
	{
		String ans="";
		Vector<String> tracs = new Vector<>();
		int i = mat.length-1;
		int j = mat.length-1;
		recTrack (mat,ans,i,j,tracs);
		return tracs;
	}
		

	private static void recTrack(Node [][] mat, String ans, int i, int j, Vector<String> tracs) {
		
		if (i==0)
		{
			while(j!=0){
				ans= '0'+ans;
				j--;
			}
			tracs.add(ans);
			return;
		}
		
		if (j==0)
		{
			while(i!=0)
			{
				ans= '1'+ans;
				i--;
			}
			tracs.add(ans);
			return;
		}
		
		double up = mat[i-1][j].entry+ mat[i-1][j].y;
		double left = mat[i][j-1].entry + mat[i][j-1].x;
		if (up<left)
			recTrack(mat, '1'+ans, i-1, j, tracs);
	
		else if (left<up)
		   recTrack(mat, '0'+ans, i, j-1, tracs);
		
		else // split rec if equal
		{
			recTrack(mat, '1'+ans,i-1, j, tracs);
			recTrack(mat, '0'+ans, i, j-1, tracs);
		}
		
	}
	
	////////////////////////////////// false Node //////////////////////////
	public static Vector<String> allPathes2 (Node [][] mat, int ifalse, int jfalse){
		
		mat[ifalse][jfalse].x= Double.POSITIVE_INFINITY;
		mat[ifalse][jfalse].y= Double.POSITIVE_INFINITY;
		int k= fillMat(mat);
		
		System.out.println();
		System.out.println("entrys");
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j].entry+",");
			}
			System.out.println();
		}
		
		
		String ans="";
		Vector<String> tracs = new Vector<>();
		if ((ifalse==0 && jfalse==0)|| (ifalse==mat.length-1 && jfalse==mat.length-1))
			return tracs;
		int i = mat.length-1;
		int j = mat.length-1;
		
		int sum=0;
		recTrack2 (mat,ans,i,j,tracs,sum);
		
		
		int k2= fillMat(mat);
		System.out.println("cost: "+k);
		mat[i][j].entry=0;
		int stam= fillMat(mat);
		
		return tracs;
	}
		



	////////////////////////////////// false ariea //////////////////////////
	public static Vector<String> allPathesFalseAriae (Node [][] mat, int i1, int j1, int i2, int j2){
		
		Vector<String> tracs = new Vector<>();;
	for (int m = i1; m <= i2; m++) {
		for (int n = j1; n <=j2; n++) {
			mat[m][n].entry= Double.POSITIVE_INFINITY;
			if((n==0 && m==0)|| (n== mat.length && m== mat[0].length))
				return tracs;
		}
		
	}
		String ans="";
		int i = mat.length-1;
		int j = mat.length-1;
		double sum=0;
		recTrack2 (mat,ans,i,j,tracs,sum);
		
		/////// back to normal
		for (int m = i1; m <= i2; m++) {
			for (int n = j1; n <=j2; n++) {
				mat[m][n].entry=0;;
			}
		}
			int stam= fillMat(mat);
		return tracs;
	}
		
		


	private static void recTrack2(Node [][] mat, String ans, int i, int j, Vector<String> tracs, double sum) {
		
		if(i==0 && j==0){
			tracs.add(ans);
			return;
		}
		if (i==0)
		{
			while(j!=0){
				if (mat[i][j].entry== Double.POSITIVE_INFINITY)
					return;
				ans= '0'+ans;
				sum= sum+ mat[i][j-1].x;
				j--;
			}
			tracs.add(ans);
			System.out.println("sum= "+sum);
			return;
		}
		
		if (j==0)
		{
			while(i!=0)
			{
				if (mat[i][j].entry== Double.POSITIVE_INFINITY)
					return;
				sum= sum+ mat[i-1][j].y;
				ans= '1'+ans;
				i--;
			}
			tracs.add(ans);
			System.out.println("sum= "+sum);
			return;
		}
		
		double up = mat[i-1][j].entry+ mat[i-1][j].y;
		double left = mat[i][j-1].entry + mat[i][j-1].x;
		if (up==Double.POSITIVE_INFINITY && left==Double.POSITIVE_INFINITY)
			return;
		if (up<left)
		{   sum= sum+mat[i-1][j].y;
			recTrack2(mat, '1'+ans, i-1, j, tracs,sum);
		}

		else if (left<up)	
		{ sum= sum+ mat[i][j-1].x;
		   recTrack2(mat, '0'+ans, i, j-1, tracs,sum);
		}
		
		else // split rec if equal
		{
			double t1=sum+mat[i-1][j].y;
			double t2=sum+mat[i][j-1].x;
			System.out.println(i + " " +j);
			 recTrack2(mat, '1'+ans,i-1, j,tracs,t1 );
			recTrack2(mat, '0'+ans, i, j-1,tracs, t2);
		}
	
		
	}
	
	
	//////////////////////////// if point is on best trace ////////////////////
	

	public static boolean isOnTrack (Node [][] mat, int i, int j)
	{
		int sumTotal = fillMat(mat);
		System.out.println("sum totl ="+sumTotal);
		System.out.println("entry at point= "+mat[i][j].entry);
		if (mat[i][j].entry>sumTotal) return false;
		
		Node [][] minor = new Node [mat.length-i][mat[0].length-j];
		for (int k = 0; k < minor.length; k++) {
			for (int k2 = 0; k2 < minor[0].length; k2++) {
				minor[k][k2]= new Node(mat[i+k][j+k2]);
			}
		}
		
		int sumMinor= fillMat(minor);
		System.out.println("sum minor= "+sumMinor);
		if ((mat[i][j].entry+ sumMinor)==sumTotal)
			return true;
		
		return false;
	}

	
	public static boolean isOnTrack (Node [][] mat, int[] cords)
	{
		boolean b= true;
		for (int i = 0; i < cords.length; i+=2) {
			b= isOnTrack(mat,cords[i], cords[i+1]);
			if (b==false) return false;
		}
		return true;
	}
	
	
	/////////////////////////////// most convinyent trace ///////////////////////////////////////
	 public static Vector<String> optimal (Node [][] mat)
	 {
		 Vector<String> getTracs= new Vector<>();
		 getTracs= allPathes(mat);
		 System.out.println(getTracs);
		 
		 Vector<String>ans = new Vector<>();
		 int countChange=0;
		 int minChange=100;
		 String cuurent="";
		 for (int i = 0; i < getTracs.size(); i++)
		 {
			 countChange=0;
			cuurent= getTracs.get(i);
			for (int j = 1; j < cuurent.length(); j++) {
				if (cuurent.charAt(j)!= cuurent.charAt(j-1))
					countChange++;
			}
			if (countChange<minChange)
			{
				minChange= countChange;
				ans.clear();
				ans.add(cuurent);
				
			}
			else if (countChange==minChange)
				ans.add(cuurent);
			
		 
		
		}
		 
		 return ans;
	 }
	

	
//////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////    TESTER   ////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {


		Node[][] plane = initMatOfNodes();
		
		System.out.println("cheapest price: "+ fillMat(plane));
		System.out.println();

		System.out.println("X'es");
		for (int i = 0; i < plane.length; i++) {
			for (int j = 0; j < plane.length; j++) {
				System.out.print(plane[i][j].x+",");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("Y'es");
		for (int i = 0; i < plane.length; i++) {
			for (int j = 0; j < plane.length; j++) {
				System.out.print(plane[i][j].y+",");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("entrys");
		for (int i = 0; i < plane.length; i++) {
			for (int j = 0; j < plane.length; j++) {
				System.out.print(plane[i][j].entry+",");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("num of pathes");
		for (int i = 0; i < plane.length; i++) {
			for (int j = 0; j < plane.length; j++) {
				System.out.print(plane[i][j].numOfPathes+",");
			}
			System.out.println();
		}
		
			

		
		System.out.println("path: "+ Onepath(plane));
		
		Vector<String> trace = allPathes(plane);
		System.out.println("all best paths!!!");
		System.out.println(trace.toString());
		
		
		System.out.println("all pathes withought (1,0) :");
		Vector<String> t2 = allPathes2(plane,1,0);
		System.out.println(t2.toString());
		
		System.out.println("all pathes withought (0,1) :");
		Vector<String> t1 = allPathes2(plane,0,1);
		System.out.println(t1.toString());


		
		System.out.println("all pathes withought (2,2) :");
		Vector<String> t6 = allPathes2(plane,2,2);
		System.out.println(t6.toString());

		
		

		System.out.println("all pathes without arae (1,0) ->(3,0) :");
		Vector<String> t3 =allPathesFalseAriae(plane,1,0,3,0);
		System.out.println(t3.toString());
		
		System.out.println("all pathes without arae (0,1) ->(0,2) :");
		Vector<String> t4 =allPathesFalseAriae(plane,0,1,plane.length-1, plane[0].length-1);
		System.out.println(t4.toString());
		
		
		System.out.println();
		System.out.println();	
		System.out.println();
		
		System.out.println("dous the point (1,2) go throw a best trace?  "+ isOnTrack(plane, 1, 2));
		System.out.println("dous the point (0,3) go throw a best trace?  "+ isOnTrack(plane, 0, 3));
		
		int [] cords= {0,1,1,0,1,3};
		System.out.println("are all points in cords on best track? "+ isOnTrack(plane, cords));

		System.out.println("eysyest traces");	
		Vector<String> optimals =optimal(plane);
		System.out.println("eysyest traces");
		System.out.println(optimals.toString());
		
		
	}





}

