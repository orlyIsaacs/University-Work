package MAX_MAX;

import java.util.Arrays;

/// scaning the Array in paeirs
public class MaxMax_1 {

	public static void main(String[] args) {
		

	 // dicleration on the array 
	int arr[]= new int[1000];
		
	for (int j=0; j<1000; j++)
	{
	arr[j]=(int)(Math.random()*1000);
	System.out.print(arr[j] +",");
	}
	
	System.out.println();
	// finding first max max
	int max1,max2;
	if (arr[0]>arr[1])
	{
		max1=arr[0];
		max2=arr[1];
	}
	else
	{
		max1=arr[1];
		max2=arr[0];
	}
	
	// scaning the array
	
	for (int i=2; i<1000; i+=2)
	{
		
		
		if (arr[i]>arr[i+1])
		{
				if (arr[i]>max1)
				{
					max2=max1;
					max1=arr[i];
					if (arr[i+1]>max2)
						max2=arr[i+1];
				}
				else if(arr[i]>max2)
					max2=arr[i];
		}
		else
		{
				if (arr[i+1]>max1)
				{
					max2=max1;
					max1=arr[i+1];
					if (arr[i]>max2)
						max2=arr[i+1];
				}
				else if(arr[i+1]>max2)
					max2=arr[i+1];
		}
				
		

	}
		
	Arrays.toString(arr);
	System.out.println("max1= "+max1);
	System.out.println("max2= "+max2);
	}

}






