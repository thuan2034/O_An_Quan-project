package squares;


public abstract class Squares {
	
	
	private static int numberOfSquares = 0;
	private int numberOfSmallGems = 0;


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