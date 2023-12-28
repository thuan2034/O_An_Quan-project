package squares;


public abstract class Squares {
	
	
	private static int numberOfSquares = 0;
	protected int numberOfSmallGems;
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

}