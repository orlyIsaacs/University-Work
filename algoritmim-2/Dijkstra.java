package algoritmim2;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra { // ������ ������ ������ ������
	
	Vertex [] kodkodim; // ���� �� �� ��������� ����
	Vertex s; // ��� ��� ������
	
	
	public Dijkstra(int s, Vertex [] kodkodim) {
		
		this.kodkodim= kodkodim; 
		PriorityQueue<Vertex> q=new PriorityQueue<>() ;
		kodkodim[s].dist=0; // ����� ������ ������ ����� 0 ����� ���
		q.add(kodkodim[s]); // ����� ��� ����
		Vertex cur;
		
		while (!q.isEmpty()) // �� ��� ���� �� ���
		{
			cur= q.poll(); // ����� ����� �� ��������
			Vertex u; // ������ �����
			for (int i = 0; i < cur.nabers.size(); i++) { // ��� �� �� �����
				
				u=kodkodim[cur.nabers.get(i).vertex2]; // ����� �� ��� ���� I
				if((u.visit==false) // �� �� ������ ����� ��� ���� ���
					&&(u.dist> (cur.dist+ cur.nabers.get(i).price))) // ��� ������ ������
				{
					u.pred= cur.id; // ����� �� ������ ����� ���� ���
					u.dist=cur.dist+ cur.nabers.get(i).price; // ����� �� �����
					q.add(u); // ����� ���� ����
				
				}
					
			}
			
			
			cur.visit=true; // ����� ������ ������� ���
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
