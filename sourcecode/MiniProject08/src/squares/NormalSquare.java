package squares;
import gem.*;

public class NormalSquare extends Squares{

	private int numberOfSmallGems = 5;
	
	public NormalSquare() {
		super();
	}
	
	public int getNumberOfSmallGems() {
		int tmp = numberOfSmallGems;
		numberOfSmallGems = 0;
		return tmp;
	}
	
	public int getPoint() {
		int tmp = numberOfSmallGems;
		SmallGem smallGem = new SmallGem();
		int point = smallGem.getPoint()*numberOfSmallGems;
		numberOfSmallGems = 0;
		return point * tmp;
	}
}