package algoritmim2;

import java.util.ArrayList;

public class Vertex implements Comparable<Vertex> {
	
	int id; // �� ����
	double dist; //���� ������ �������� ���� 
	boolean visit; // ����� ��� ��� ����� ������� �� - ���� �������� � FALSE
	int pred; //   �� ���� �� ������� ����� �� ������� ����� �� ������ ���� ����� 
	ArrayList<Edge> nabers; // 
	
	
	public Vertex(int id, ArrayList<Edge> nabers) {
		super();
		this.id= id;
		this.dist =Double.POSITIVE_INFINITY;
		this.visit = false;
		this.pred = -1;
		this.nabers = nabers;
	}


	
	// �������� ������ �� � DIST��� ����� ��� ����� ���� �����
	@Override
	public int compareTo(Vertex o) {
		if (this.dist>o.dist) return 1;
		else if (this.dist==o.dist)	return 0;
		else return -1;
	
	}
	
	
	
	
	

}
