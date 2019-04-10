package SMALL_PROBLEMS2;

import java.util.Arrays;

public class MostUpsDowns {

	
	public static int[]  UpsDowns (int [] arr)
	{
		int [] ans= new int[arr.length];
		int k;
		ans[0]= arr[0];
		ans[1]= arr[1];
		k=2;
		boolean isUp=false;
		if (arr[1]>arr[0]) isUp=true;
		for (int i = 2; i < arr.length; i++) {
			
			if ((arr[i]>arr[i-1] && (isUp)) || (arr[i]<arr[i-1] && !(isUp))) // takes his place
			ans[k-1]=arr[i];
			
			else if ((arr[i]<arr[i-1] && (isUp)) || (arr[i]>arr[i-1] && !(isUp))) // changes the up/down
			{
				ans[k]= arr[i];
				k++;
				isUp= !(isUp);
			}
			
		}
		
		return Arrays.copyOf(ans, k);
	}
	
	
	public static void main(String[] args) {
		int [] a= {1,2,3,4,8,2,1,9};
		System.out.println("original: "+Arrays.toString(a));
		System.out.println("most ups and downs: "+Arrays.toString(UpsDowns(a)));
	}
	
	
	
}
