package squares;

import gem.*;

public abstract class Squares {
	public int point;
	private int id;
	private int numberOfSmallGems;


	public Squares(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id % 12;
	}
	public int getPoint() {
		return point;
	}
	
	public void spreadGems() {
		numberOfSmallGems++;
	}
	

}