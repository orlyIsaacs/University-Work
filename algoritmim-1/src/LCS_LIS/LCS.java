package LCS_LIS;

import java.util.Arrays;

public class LCS {

	public static String  lcs (String s1, String s2) // gets 2 strings and returns one of the longest sequence string
	{
		System.out.println(s1+ "  s1.length is: : "+s1.length());
		System.out.println(s2+ "  s2.length is: : "+s2.length());
		int m,n; // for the arr
		String ans="";
		// Initializing +1 for a zero start in first row and calm
		m=s1.length()+1;
		n=s2.length()+1;

		int arr[][]= new int[m][n];

		// filling the arr edges with 0

		for (int i=0; i<m; i++)
			arr[i][0]=0;

		for (int j=0; j<n; j++)
			arr[0][j]=0;

		// filing the arr with the algorithm. look in notebook

		for (int i=1; i<m; i++)
			for (int j=1; j<n; j++)
			{
				if (s1.charAt(i-1)==s2.charAt(j-1)) // if eqal
					arr[i][j]= arr[i-1][j-1] +1; // diagonal +1 
				else
					arr[i][j]= Math.max(arr[i-1][j], arr[i][j-1]); // if not eqal then take man lcs up to now
			}
			

		

		// printing the arr

		for(int i=0; i<m; i++){
			for (int j = 0; j <n; j++) 
				System.out.print( arr[i][j]+", ");
			System.out.println();
		}

		// returning the new lcs
		int i=m-1;
		int j=n-1;
		while (arr[i][j]!=0) // if not finished. keep on checking if small string is inside long string
		{
			if (s1.charAt(i-1)==s2.charAt(j-1))/// checking the strings!!!!
			{
				ans+= s1.charAt(i-1); // add to ans and go in diagonal 
				i--;
				j--;
			}
			else
			{//// Checking in the arr !!! and going to the most potenchial longest string
				if (arr[i-1][j]>arr[i][j-1])
					i--;
				else
					j--;
					
			}
		}

		// revers the ans
		String flip="";
		for (int k=ans.length()-1; k>=0; k--)
			flip+= ans.charAt(k);
		System.out.println("lcs length is: "+(flip.length()+1));

		return flip;
	}

	public static void main(String[] args) {

		System.out.println(lcs("chleeeeeeeen","chen"));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(lcs("chengg","chleeen"));
		System.out.println();
		System.out.println();
		System.out.println();
		
		String s1= "1 10 12 11 20 18 19";
		String s2= "1 10 11 12 18 19 20";
		System.out.println(lcs(s1,s2));
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		System.out.println(lcs("abdcgef","abcdefg"));
	}
}

