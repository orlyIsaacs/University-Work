package algoritmim2;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.transform.Templates;


//// יש לי את הדף קישקושים על האלגוריתם במחברת מאחורה ממורקר בצהוב
public class burnLeef {
	
	public static void BL (ArrayList<Integer> [] g){
		int centers[] = new int [2];
		int [] nabers= new int[g.length]; // saving the degree every turn
		ArrayList<Integer> leafs= new ArrayList<>(); // a list of current leafs at this turn
		int counter=0; // of the -> radius
		int dots= g.length;
		
		
		// first time
		for (int i = 0; i < nabers.length; i++) {
			nabers[i]= g[i].size();
			if (nabers[i]== 1)
				leafs.add(i);
		}
		System.out.println(Arrays.toString(nabers));
		
		
		
		while(dots>2)
		{
			ArrayList<Integer> templeaf= new ArrayList<>(); 
			for (int l = 0; l < leafs.size(); l++) { //רצים על כל העלים
				int index= leafs.get(l);
				nabers[index]=0; // not exist any more so has no nabers
				for (int i = 0; i < g[index].size(); i++) {
					int who2dec= g[index].get(i); // from what to update the nabers DARGA
					nabers[who2dec]--;
					if (nabers[who2dec]==1)
						templeaf.add(who2dec); // for the next run
				}
			}
				
			dots=dots-leafs.size();
			leafs=templeaf;
			counter+=1;
			
			//System.out.println("nabers= "+Arrays.toString(nabers));
			//System.out.println("who fell=  "+Arrays.toString(allFallLeaf));
				
			
		
		}
		System.out.println(leafs);
		

		
	
		
		int coter= 0;
		if (leafs.size()==1)
			coter= counter+counter;
		if (leafs.size()==2)
			coter= counter+counter+1;
		
			
		
		System.out.println("radious= "+counter);
		System.out.println("coter= "+ coter);

		System.out.println("if number of centers is 1, egnor the right side senter");
		System.out.println("ceners are- "+leafs);		
		

	}
	
	public static void main(String[] args) {
		ArrayList<Integer> [] g= new ArrayList [9] ;
		g[0]= new ArrayList<>();
		g[1]= new ArrayList<>();
		g[2]= new ArrayList<>();
		g[3]= new ArrayList<>();
		g[4]= new ArrayList<>();
		g[5]= new ArrayList<>();
		g[6]= new ArrayList<>();
		g[7]= new ArrayList<>();
		g[8]= new ArrayList<>();
	
		g[0].add(1);
		g[1].add(0);
		g[1].add(2);
		g[2].add(1);
		g[2].add(3);
		g[2].add(6);
		g[3].add(2);
		g[3].add(4);
		g[3].add(5);
		g[4].add(3);
		g[5].add(3);
		g[6].add(2);
		g[6].add(7);
		g[7].add(6);
		g[7].add(8);
		g[8].add(7);
		
		
		BL(g);
		
		
		
		
	}

}
