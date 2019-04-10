package algoritmim2;

import java.util.Arrays;

// ************************************************
public class bottles {
	
	
	// return the index in the of a row/ col depending on the inner indexes i and j
	public static int index( int i, int j, int cols)
	{
		return (i*cols +j) ;
	}
	// returns a matrix according to the capacities given (a,b) of legal operations in one step
	public static boolean[][] bottles (int a, int b)
	{
		int size= (a+1)*(b+1);
		boolean [][] ans= new boolean[size][size];
		int p,q;
		
		// Running all options of capacities of the bottles
		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				
				p= index(i,j,b+1);
				// case 1 (i,j)-> (0,j)
				q= index(0,j,b+1);
				ans[p][q]=true;
				
				// case 2 (i,j)-> (i,0)
				q= index (i,0,b+1);
				ans[p][q]= true;
				
				// case 3 (i,j)-> (i,b)
				q= index(i,b,b+1);
				ans[p][q]=true;
			
				// case 4 (i,j)-> (a,j)
				q= index(a,j,b+1);
				ans[p][q]=true;
				
				// case 5 (i,j)->? (i+j,0) || (a,i+j-a)
				if ((i+j) <=a)
				{
					q= index(i+j, 0, b+1);
					ans[p][q]= true;
				}
				else
				{
					q= index(a,i+j-a, b+1);
					ans[p][q]= true;
				}
				
				// case 6 (i,j)->? (0, i+j) || (i+j-b, b)
				if ((i+j)<=b)
				{
					q= index(0, i+j, b+1);
					ans[p][q]= true;
				}
				else{
					q= index(i+j-b, b, b+1);
					ans[p][q]=true;
				}
				
				
			}
		}
		
		return ans;
	}
	
	
	public static void main(String[] args) {
		 boolean [][] ans= bottles(1, 2);
		 System.out.println("bottels sizes = 3,2");
		 for (int i = 0; i < ans.length; i++) {
			System.out.println(Arrays.toString(ans[i]));
		 }
			
			System.out.println();
			System.out.println("after fw to see if legal path");
			FW.FW(ans);
			FW.printMat(ans);
			System.out.println();
		
			
			
		}
	}


