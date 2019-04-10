package SMALL_PROBLEMS;

import java.util.Arrays;

public class Prisiners {
	
	
	//// true= has the right to turn of the lamp, false= has already turned it of
	public static void solvePrisiners (boolean [] p)
	{
		boolean lamp= true;
		int counter=0;
		int numOfEntreys=0;
		
		// everybody has the right
		for (int i=0; i<p.length; i++)
			p[i]=true;
		
		/// declotation- p[0] -is the counter- only he can tuern the light off.
		
		while (counter!= p.length-1)
		{
			int rand= (int)(Math.random()*p.length); // chous a random presiner
			numOfEntreys++;
			System.out.println("p["+rand+"] is in");
			if (rand==1)
			{
				if (lamp==false)
				{
					lamp=true;
					counter++;
				}
			}
			else if (p[rand]==true && lamp== true)
			{
				lamp=false;
				p[rand]=false;
			}
			
			
		}
		System.out.println("number of entries: "+numOfEntreys);
		System.out.println(" all "+(counter+1) +" prisiners where in the room!!!");
		Arrays.toString(p);
		
	}
	
	
	public static void main(String[] args) {
		
		boolean [] prisiners = new boolean[10];
		solvePrisiners(prisiners);
	}

}
