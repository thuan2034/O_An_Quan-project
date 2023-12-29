package squares;


public abstract class Squares {
	
	
	private static int numberOfSquares = 1;
	protected int numberOfSmallGems = 0;
	protected int id = numberOfSquares;

	public Squares() {
		numberOfSquares++;
	}
	
	public abstract int getPoint();
	
	public void spreadGems() {
		numberOfSmallGems++;
	}
	
	public void resetNumberOfGems(){
		numberOfSmallGems = 0;
	}
	
	public int getId() {
		return id;
	}


    
}