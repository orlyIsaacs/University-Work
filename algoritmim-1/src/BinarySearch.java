import java.util.Arrays;

import org.hamcrest.DiagnosingMatcher;

public class BinarySearch {
	public static int binarySearchBetween(int[] arr, int end, int v) {
		int i = Arrays.binarySearch(arr, 0, end, v);
		if(i >= 0) return i;
		return -(i+1);
	}
	
	public static int lis(int[] arr) {
		int [] len= new int [arr.length];
		int insert;
		len[0]= arr[0];
		int depth=1;
		for (int i = 0; i < arr.length; i++) {
			
			insert= Arrays.binarySearch(len, 0, depth, arr[i]);
			if (insert<0)
				insert= -(insert+1);
			len[insert]=arr[i];
			if (insert==depth)
				depth++;
		}
		
		return depth;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int[] lis2 (int [] arr)
	{
		int [] diagonal=new int [arr.length];
		int [][] mat= new int [arr.length][arr.length];
		mat[0][0]= arr[0];
		diagonal[0]=arr[0];
		int insert;
		int depth=1;
		
		for (int i = 1; i < arr.length; i++) {
			
			insert= Arrays.binarySearch(diagonal, 0, depth, arr[i]);
			if (insert<0)
				insert=-(insert+1);
			diagonal[insert]=arr[i];
			
			mat[insert][insert]=arr[i];
			for (int j = 0; j < insert; j++) {
				mat[insert][j]= mat[insert-1][j];
				
			}
			if (insert==depth)
				depth++;
			
		}
	
		return mat[depth-1];
	}
	
	
	
	public static int sptialLisPow (int [] arr)
	{
		int [] shoPow = new int[arr.length];
		int pow;
		int counter;
		for (int i = 0; i < arr.length; i++) {
			pow=arr[i];
			counter=1;
			for (int j = i+1; j < shoPow.length; j++) {
				
				if (arr[j]== pow*pow)
				{
					pow=pow*pow;
					counter++;
				}
			}
			
			shoPow[i]=counter;
		}
		
		int max=0;
		for (int i = 0; i < shoPow.length; i++) {
			 if (shoPow[i]>max)
			 max= shoPow[i];
			 
		}
		System.out.println(Arrays.toString(shoPow));
		return max;
	}
	
	
	
	
	
	
	

	
	
	public static void main(String[] args) {
		int [] a={1,4,2,3,6,8};
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(lis2(a)));
		
		int [] b = {2,4,16,3,9,12,256,81};
		System.out.println();
		System.out.println(Arrays.toString(b));
		System.out.println(sptialLisPow(b));
		
	}
}

