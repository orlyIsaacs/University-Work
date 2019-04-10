package algoritmim2;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.omg.Messaging.SyncScopeHelper;

public class FWkodkodim {
	
	/// פונקציה שמקבלת מערך של עלויות קודקודים ומטריצה של עלויות על הצלעות ומחזריה מטריצה של שכלול עלות מינימלית מקודקוד לקודקוד תוך כדי הדפסות
	// כאשר עלות מקודקוד לקודקוד מחושבת ע"י סכום הקודקודים בקצוות ועוד הצלע
	public static double[][] FWkokodandTzela (double[][] w1, double[] w2)
	{
		double [][] d= new double[w1.length][w1.length];
		double infinity = Double.POSITIVE_INFINITY;
		System.out.println("data-");
		System.out.println("kodkodim=");
		System.out.println(Arrays.toString(w2));
		System.out.println("tzlaot waghits=");
		FW.printMat(w1);
		
		//// איתחול מטריצה D
			for (int i = 0; i < d.length; i++) {
				for (int j = 0; j < d.length; j++) {
					if (i==j) d[i][j] =w2[i];
					else if(w1[i][j]==0) d[i][j]= infinity;
					else d[i][j]= w2[i] + w2[j] + w1[i][j];
				}
			}
		
			System.out.println();
		System.out.println("after begining d=");
		FW.printMat(d);
		
		for (int k = 0; k < d.length; k++) {
			for (int i = 0; i < d.length; i++) {
				for (int j = 0; j < d.length; j++) {
					d[i][j]=Math.min(d[i][j], d[i][k]+d[k][j]-w2[k]);
				}
			}
		}
		
		System.out.println();
		System.out.println("after spetisal fw = ");
		FW.printMat(d);
		
		return d;
	}
	
	
	// מקבלת מטרייצה בלואנית של שכוניות ומערך עלות קודקודים ומחשבת את העלות המינמאלית בנוסחה שמעבר מקודקוד לאחר שווה לסכום קודקודי הקצוות 
	// כוללת הדפסות ומחזירה בסוף את המטריצה הסופית
	public static double[][] FWkodkod(boolean[][] g, double []w)
	{
		System.out.println("kodkodim whight=");
		System.out.println(Arrays.toString(w));
		System.out.println("nabers=");
		FW.printMat(g);
		System.out.println();
		
		
		double[][] d= new double[g.length][g.length];
		double infinity= Double.POSITIVE_INFINITY;
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d.length; j++) {
				if(i==j)d[i][j]=0;
				else if(g[i][j]==false) d[i][j]=infinity;
				else d[i][j]=w[i]+w[j];
			}
		}
		System.out.println("d befor fw");
		FW.printMat(d);
     	FW.lowCost(d);
     	System.out.println();
		System.out.println("after fw");
		FW.printMat(d);
		
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d.length; j++) {
				if(i==j) d[i][j]=w[i];
				else d[i][j]=(d[i][j]+w[i]+w[j])/2;
			}
		}
		
		System.out.println();
		System.out.println("after update by kodkodim =");
		FW.printMat(d);
		return d;
			
		}
	

	// a function that returns a matrix of the prices by the kodkodim 
	public static double[][] dKododim(double[][] h, double[] priceKodkod)
	{
		double [][] d = new double[h.length][h[0].length];
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d.length; j++) {
				d[i][j]=(h[i][j]+ priceKodkod[i]+ priceKodkod[j])/2;
			}
		}
		
		return d;
		
	}

	public static void main(String[] args) {
		
		double infinity= Double.POSITIVE_INFINITY;
		double[] priceKodkod= {1,2,3,4};
		double [][] h= {
				{0,3,4,infinity},
				{3,0,infinity,6},
				{4,infinity,0,7},
				{infinity,6,7,0}};
	
		System.out.println("prices=");
		System.out.println(Arrays.toString(priceKodkod));
		System.out.println();
		System.out.println("original h befor fw on kokodim start");
		FW.printMat(h);
		System.out.println();
		System.out.println("h after fw // low cost");
		FW.lowCost(h);
		FW.printMat(h);
		
		double [][] d= dKododim(h, priceKodkod);
		System.out.println();
		System.out.println("mat of clculate by kodkodim is-");
		FW.printMat(d);
		
		//////////////////////////////////// gil////////////////////////
		
		
		
		
		
		System.out.println();
		System.out.println();
		System.out.println("///////////////////////gil 1 ///////////////////");
		
		double [] w={5,3,2,4,1};
		boolean [][] g= {
				{false, true, true, true, false},
				{true, false, false, false, false},
				{true, false, false, true, true},
				{true, false, true, false, true},
				{false, false, true, true, false}};
		
	
	double [][] ans1=FWkodkod(g,w);
	
	System.out.println("///////////////////////gil 2 ///////////////////");
	
	double[]w2= {3,2,4,1,1};
	double [][] w1={
			{0,5,0,0,2},
			{5,0,4,7,1},
			{0,4,0,2,0},
			{0,7,2,0,0,},
			{2,1,0,0,0}};
	
	double [][] ans2= FWkokodandTzela(w1, w2);


	
		
		
		
		
		
		

		
	}
}
