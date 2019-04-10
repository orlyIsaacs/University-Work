package SMALL_PROBLEMS;

import java.lang.reflect.Array;
import java.util.Arrays;

/////////////////// בעיית הרוב O(N) ////////////////////////

public class megority {
	
	public static int isMegority (int [] arr)
	{
		int tryFind= arr[0];
		int counter =1;
		
		for (int i = 1; i < arr.length; i++) {
			
			if(arr[i] == tryFind)
				counter++;
			else counter--;
			
			if(counter==0)
			{
				tryFind=arr[i];
				counter=1;
			}
		}
		
		if(counter==0) return -1;
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==tryFind) sum++;
		}
		
		if (sum > (int)(arr.length/2))
			return tryFind;

		else return -1;
	}

	
	
	public static void main(String[] args) {
		
		int [] arr= {1,2,2,3,2,4,4,2,2};
		System.out.println(Arrays.toString(arr));
		System.out.println(isMegority(arr));
	}
}
