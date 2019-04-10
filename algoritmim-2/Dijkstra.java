package algoritmim2;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra { // בדוגמא שהרצתי מופיעה במחברת
	
	Vertex [] kodkodim; // מערך של כל הקודקודים בגרף
	Vertex s; // קוד קוד התחלתי
	
	
	public Dijkstra(int s, Vertex [] kodkodim) {
		
		this.kodkodim= kodkodim; 
		PriorityQueue<Vertex> q=new PriorityQueue<>() ;
		kodkodim[s].dist=0; // בחירת קודקוד התחלתי והשמת 0 במרחק שלו
		q.add(kodkodim[s]); // דחיפה שלו לתור
		Vertex cur;
		
		while (!q.isEmpty()) // כל עוד התור לא ריק
		{
			cur= q.poll(); // שולפת מהתור את המינמאלי
			Vertex u; // לסימון שכנים
			for (int i = 0; i < cur.nabers.size(); i++) { // רצה על כל השנים
				
				u=kodkodim[cur.nabers.get(i).vertex2]; // שליפה של שכן מספר I
				if((u.visit==false) // אם לא בקירתי עדיין אצל השכן הזה
					&&(u.dist> (cur.dist+ cur.nabers.get(i).price))) // וגם והמחיר מתעדכן
				{
					u.pred= cur.id; // תעדכן את הנוכחי להיות האבא שלו
					u.dist=cur.dist+ cur.nabers.get(i).price; // תעדכן את המחיר
					q.add(u); // תוסיף אותו לתור
				
				}
					
			}
			
			
			cur.visit=true; // סימון שהיינו בקודקוד הזה
		}
		
		for (int i = 0; i < kodkodim.length; i++) {
			System.out.println((i)+" ,distans from s = "+kodkodim[i].dist);
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		ArrayList<Edge> n0 =new ArrayList<>();
		n0.add(new Edge(0,1,10));
		n0.add(new Edge(0,3,5));
		Vertex v0= new Vertex(0,n0 );
		
		ArrayList<Edge> n1 =new ArrayList<>();
		n1.add(new Edge(1,3,2));
		n1.add(new Edge(1,2,1));
		Vertex v1= new Vertex(1,n1 );
		
		ArrayList<Edge> n2 =new ArrayList<>();
		n2.add(new Edge(2,4,4));
		Vertex v2= new Vertex(2,n2 );
		
		ArrayList<Edge> n3 =new ArrayList<>();
		n3.add(new Edge(3,1,3));
		n3.add(new Edge(3,2,9));
		n3.add(new Edge(3,4,2));
		Vertex v3= new Vertex(3,n3 );
		
		ArrayList<Edge> n4 =new ArrayList<>();
		n4.add(new Edge(4,2,6));
		n4.add(new Edge(4,0,7));
		Vertex v4= new Vertex(4,n4 );
		
		
		Vertex [] kodkodim= {v0,v1,v2,v3,v4};
		Dijkstra test= new Dijkstra(0, kodkodim);
		
	}
	

	
	
	

}
