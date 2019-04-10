package SMALL_PROBLEMS;

import PARKING_PROBLEM.MainTest;

public class powLogN {

	
	///////////// Recourse/////////////////////////
  public static int powLogNRec (int x, int n)
  {
	  System.out.println(x+"^"+n+" = ");
	  if(n==0) return 1;
	  int ans=1;
	 return powLogNRec(x, n,ans);
  }

private static int powLogNRec(int x, int n, int ans) {
	{
		if (n==0) return ans;
		if (n%2==1) ans= 2*x; // if odd will double the answer by 2
		
			x=x*x;
			n=n/2;
		return powLogNRec(x, n, ans);
	}

}
	
	//////////////////// loop//////////////////////////////
	
	public static int powLogNLoop(int x, int n)
	{
		int ans=1;
		if (n==0) return 1;
		
		while (n>0)
		{
			if (n%2==1) ans= 2*x;
			x=x*x;
			n=n/2;
		}
	
		return ans;
	}

	
	
	
	
	
	
	
	
	///////////////////////////////// pow again ///////////////////////////////
	
	public static int powAgain (int x, int n)
	{
		if (n==0) return 1;
		
		int ans=1;
		while (n>0)
		{
			if (n%2 ==1) ans= 2*x;
			x=x *x;
			n= n/2;
		}
		
		return ans;
	}
	


public static void main(String[] args) {
	
	System.out.println("in recorsive :" +powLogNRec(2, 5));
	System.out.println("in loop: "+ powLogNLoop(2, 5));
	System.out.println("pow again: "+powAgain(2, 5));
}
}
