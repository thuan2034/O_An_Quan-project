package squares;


public abstract class Squares {
	
	
	private static int numberOfSquares = 0;
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
	

	public int getNumberOfSmallGems() {
		return numberOfSmallGems;
	}
    
	public int getId() {
		if(this.id >= 1 && this.id <= 5) {
			return 1;
		} 
		else if(this.id >= 7 && this.id <= 11) {
			return 2;
		}
		return this.id;
	}
}