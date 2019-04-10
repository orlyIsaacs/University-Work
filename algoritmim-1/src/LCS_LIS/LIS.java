package LCS_LIS;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LIS {

	public static int [] lis (int [] arr)
	{
		int mat[][] =new int[arr.length][arr.length];
		mat[0][0]= arr[0];
		int depth=1;
		for( int i=1; i<arr.length; i++)
		{
			int key= findPlaceInDiagonal(mat, arr[i], depth);
			mat[key][key]=arr[i];
			if (key==depth) depth+=1;
				for(int j=0; j<key; j++)
					mat[key][j]= mat[key-1][j];
				
			
			}
		
		int[] ans= new int[depth];
		for (int i = 0; i < depth; i++) {
			ans[i]= mat[depth-1][i];
		}
		
		return ans;
		}

	
	/// Fiends where the next number needs to enter the diagonal
	public static int findPlaceInDiagonal(int mat[][], int num, int depth)
	{	
	
	  if (num<mat[0][0]) return 0;
	  else{
		  for(int i=1; i<=depth; i++)
		  {
			  if (num<mat[i][i]) return i;
		  }
	  }
	  return depth;
	}
	
	///////////////////// LDS/////////////////////////
	
	public static int[] lds(int[] arr)
	{
		int [] flip= flipArr(arr);
		 return flipArr((lis(flip)));
		 
	}

	
	///////////////////////////// up Dowen///////////////
	
	public static int upDowen(int[] arr)
	{
		int[] up= new int[arr.length];
		int[] down= new int[arr.length];
		int[] sum= new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			up[i]=lis(arr,i);
			down[i]= lds(arr,i);
			sum[i]= up[i]+down[i] -1;
		}
		
		System.out.println("up:   "+Arrays.toString(up));
		System.out.println("down: "+Arrays.toString(down));
		System.out.println("sum:  "+Arrays.toString(sum));
		
	
		int max=0;
		for (int i = 0; i < sum.length; i++) {
			if (sum[i]>max)
				max= sum[i];
		}
		return max;
	}
	
	
	public static int lis(int [] arr, int i)
	{
		int [] temp= new int[i+1];
		for (int j = 0; j <i+1; j++) {
			temp[j]=arr[j];
		}
		int[]ans= lis(temp);
		return ans.length;
	}
	
	public static int lds(int [] arr, int i)
	{
		int [] temp= new int[arr.length-i];
		for (int j = i; j <arr.length; j++) {
			temp[j-i]=arr[j];
		}
		int[] ans= lds(temp);
		return ans.length;
	}
	
//////////////////////////// flips//////////////////////////////////
	private static String flip (String s)
	{
		String ans="";
		for(int i=0; i<s.length(); i++)
			ans= s.charAt(i)+ans;
		return ans;
	} 
	
	private static int[] flipArr(int [] arr){
		int [] flip = new int[arr.length];
		for (int i = 0; i < flip.length; i++) {
			flip[i]= arr[arr.length-1-i];
		}
		return flip;
		
		
		
		
		
		//////////////////////////////tester/////////////////////////////////
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int []numbers={70,80,90,1,2,3,4,5};
		System.out.println(Arrays.toString(numbers));
		System.out.println("lis is-");
		System.out.println(Arrays.toString(lis (numbers)));
		
		System.out.println();
		System.out.println();
		System.out.println("lds is-");
		System.out.println(Arrays.toString(lds (numbers)));
		
		System.out.println();
		System.out.println();
		System.out.println("up dowen longest string is in length: "+upDowen(numbers));
		
	
	
	}

}
