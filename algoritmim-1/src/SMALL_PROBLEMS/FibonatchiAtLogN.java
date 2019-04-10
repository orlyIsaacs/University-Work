package SMALL_PROBLEMS;

import java.util.Vector;

public class FibonatchiAtLogN {
	
	
	////////////////////////// o(n) ////////////////////////
	public static int finedFibo (int index)
	{
		if (index ==0) 
		{
			System.out.println(" not a good number, not is seree");
			return 0;
		}
		if (index==1 || index==2) return 1;
		int [] fibo = new int[500];
		fibo[0]=0;
		fibo[1]=1;
		fibo[2]=1;
		int i=3;
		while (i<=index)
		{
			fibo[i]= fibo[i-1]+fibo[i-2];
			if (index==i)
				return fibo[i];
			else
				i++;
			
			
		}
		 return 0;	
	}
	
	
	
	/////////////////////////////// o(log(n))///////////////////
	public static int fiboLogN (int n)
	{
		System.out.println("finding now fibonatcci number "+n+ " in log n");
		if (n==1|| n==2) return 1;
		n=n-2;
		int matAns[][]={{1,1},{1,1}};
		int helpCala[][] ={{1,1},{1,0}};
		while (n>0)
		{
			if (n>0)
			{
				if (n%2==1) matAns=multiplyMatrix2on2(matAns, helpCala);
				helpCala= multiplyMatrix2on2(helpCala, helpCala);
				n=n/2;
			}
		}
		
		return matAns[0][0];
		
	}
	
	private static int[][] multiplyMatrix2on2 (int [][]a, int[][]b) /// Multiply mat a by mat b
	{
		int ans[][]= new int[2][2];
		ans[0][0]= a[0][0]* b[0][0] + a[0][1]* b[1][0];
		ans[0][1]= a[0][0]* b[0][1] + a[0][1]* b[1][1];
		ans[1][0]= a[1][0]* b[0][1] + a[1][1]* b[1][0];
		ans[1][1]= a[1][0]* b[0][1] + a[1][1]* b[1][1];
		
		return ans;
		
	}
	
	public static void main(String[] args) {
		System.out.println(" fibonatchi number 5 is: "+ finedFibo(5));
		System.out.println(fiboLogN(5));
	}

}
