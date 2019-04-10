package algoritmim2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class BFS {

	ArrayList<Integer>[] g; // graf of nabers
	int n; // length= number of nabers
	int dist[]; // distans of every dot from the start point
	int color[]; // color of every dot at a current moment. 0= not touched, 1= dealing with it 2= finished
	int pred[]; // who is the dots parent. who discovered it
	ArrayBlockingQueue<Integer> q; // a que of dots to deal with

	public BFS(ArrayList<Integer>[] g, int s)
	{
		// Initialization
		this.g=g;
		n=g.length;
		dist= new int[n];
		color= new int[n];
		pred= new int[n];
		Arrays.fill(pred, -1);
		q = new ArrayBlockingQueue<Integer>(n);
		q.add(s);
		dist[s]=0;
		color[s]=1;
	}

	// 
	public void bfsAlgo()
	{

		while (!(q.isEmpty()))
		{
			int cur= q.poll(); // מורידה את הקודקוד שאני עוברת עליו
			for (int i = 0; i < g[cur].size(); i++) { // רצה על השכנים שלו
				int naber= g[cur].get(i); // שולפת שכן
				if (color[naber]==0) // אם אני לא עובדת כרגע על השכן- כלומר הצבע שלו הוא 0 והוא לא בתור
				{
					q.add(naber);  // תוסיף אותו לתור
					color[naber]=1; // תצבע אותו ל1 
					pred[naber]=cur; // תגיד לי מי האבא של אותו קודקוד
					dist[naber]=dist[cur]+1; // תעדכן את המרחק מהקודקוד מקור
				}
			}//end for
			color[cur]=2;
		}
		
		System.out.println("color  "+Arrays.toString(color));
		System.out.println("pred  "+Arrays.toString(pred));
		System.out.println("dist  "+Arrays.toString(dist));

	}
	
	
	
	public static void main(String[] args) {
		
		//// בדיקה דרך אותו גרף שיש לי בסוף המחברת
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
		
		BFS graf= new BFS(g,0);
		graf.bfsAlgo();
		
	}
	
	
}
