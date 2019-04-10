package algoritmim2;

import java.util.ArrayList;

public class Vertex implements Comparable<Vertex> {
	
	int id; // שם הצלע
	double dist; //מרחק הנקודה מהקודקוד מקור 
	boolean visit; // סימון האם כבר בקרנו בקודקוד זה - כולם מאותחלים כ FALSE
	int pred; //   מי האבא של הקודקוד כלומר מי הקודקוד הקודם לי במסלול הקצר ביותר 
	ArrayList<Edge> nabers; // 
	
	
	public Vertex(int id, ArrayList<Edge> nabers) {
		super();
		this.id= id;
		this.dist =Double.POSITIVE_INFINITY;
		this.visit = false;
		this.pred = -1;
		this.nabers = nabers;
	}


	
	// קומפרטור שמשווה לי ה DISTכדי שהתור ידע באיזה אופן למיין
	@Override
	public int compareTo(Vertex o) {
		if (this.dist>o.dist) return 1;
		else if (this.dist==o.dist)	return 0;
		else return -1;
	
	}
	
	
	
	
	

}
