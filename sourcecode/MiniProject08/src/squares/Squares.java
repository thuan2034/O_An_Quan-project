package squares;


public abstract class Squares {
	
	private static int numberOfSquares = 0;
	protected int numberOfSmallGems = 0;
	protected int id = numberOfSquares;

	public Squares() {
		if(numberOfSquares < 11) numberOfSquares++;
		else numberOfSquares = 0;
	}
	
	public abstract int getPoint();
	
	public void spreadGems() {
		numberOfSmallGems++;
	}
	
	public void resetNumberOfGems(){
		numberOfSmallGems = 0;
	}
	

	public int getNumberOfSmallGems() {
		return numberOfSmallGems;
	}
    
	public int getId() {
		return this.id;
	}
}