package squares;
import java.util.*;
import gem.*;

public abstract class Squares {
	private int id;
	public static final int MAX_POINTS = 60;
	private ArrayList<Gem> squares = new ArrayList<Gem>();
	
	public Squares(int id) {
		this.id = id;
	}
	
	public int getPosition() {
		while (id < 0) {
			id += 12;
		}
		return id % 12;
	}

	public int getPoint() {
		int sum = 0;
		for (Gem gem:squares) {
			sum += gem.getPoint();
		}
		return sum;
	}
	
	public void addGem(Gem gem) {
		squares.add(gem);
	}
	public void removeGem() {
		while (squares.size() !=0) {
			squares.remove(0);
		}
	}
}