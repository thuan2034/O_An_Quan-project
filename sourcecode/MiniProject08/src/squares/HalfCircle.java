package squares;
import gem.*;
public class HalfCircle extends Squares{
	private int numberOfBigGems = 1;	
	private int numberOfSmallGems = 0;	
	public HalfCircle(int id) {
		super(id);
	}
	
	public int getPoint() {
		BigGem bigGem = new BigGem();
		SmallGem smallGem = new SmallGem();
		int point = numberOfBigGems*bigGem.getPoint() +
				numberOfSmallGems*smallGem.getPoint();
		numberOfBigGems = 0;	
		numberOfSmallGems = 0;	
		return point;
	}
	
	
}
