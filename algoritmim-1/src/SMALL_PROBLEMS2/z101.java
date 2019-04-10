package SMALL_PROBLEMS2;

import java.util.Arrays;
import java.util.Vector;

//////////////////////////  שאלה מהמבחן  במועד ב' לרשום את הרצף הארוך ביותר של 11100000011111 בצורה שיש 101 ממערך באו של אן

public class z101 {
	
	
	public static int longest101 (int[] a)
	{
		Vector<Integer> ans= new Vector<>();
		int counter=1;
		int j=0;
		while (a[j]==0)
			j++;
		int index=0;
		for (int i=j; i < a.length-1; i++) {
		
			if (a[i]==a[i+1])
				counter++;
			else
			{
				ans.add(counter);
				counter=1;
			}
		 	
		}
		if (a[a.length-1]==a[a.length-2])
			ans.set(ans.size()-1, ans.get(ans.size()-1)+1);
		else
			ans.add(1);
		System.out.println(ans);
		int max=0;
		if (a[a.length-1]==0)
			ans.remove(ans.size()-1);
		int tempsum=0;
		for (int i = 0; i < ans.size()-2; i+=2) {
		
			tempsum=ans.get(i)+ ans.get(i+1) +ans.get(i+2);
			if (tempsum > max)
				max= tempsum;
		}
		
		return max;
	}
	
	
	
	public static void main(String[] args) {
		
		int[] a= {0,0,1,1,0,1,1,1,0,0,1,1,0,1,0};
		System.out.println("longest 101 is- "+longest101(a));
	}
	

}
