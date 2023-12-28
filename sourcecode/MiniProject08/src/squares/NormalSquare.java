package squares;
import gem.*;

public class NormalSquare extends Squares{

	private int numberOfSmallGems = 5;
	
	public NormalSquare() {
		super();
	}
	
	public int getNumberOfSmallGems() {
		int tmp = numberOfSmallGems;
		return tmp;
	}

	@Override
	public int getPoint() {
		SmallGem smallGem = new SmallGem();
		return smallGem.getPoint()*numberOfSmallGems;
		
	}
}