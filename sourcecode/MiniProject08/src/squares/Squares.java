package squares;



public abstract class Squares {
	private int point;
	private int id;
	private static int numberOfSquares = 0;
	private int numberOfSmallGems;


	public Squares() {
		this.id = numberOfSquares++;
	}
	
	public int getPoint() {
		return point;
	}
	
	public void spreadGems() {
		numberOfSmallGems++;
	}
	

}