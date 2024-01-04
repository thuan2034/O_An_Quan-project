package player;

import javafx.beans.property.SimpleIntegerProperty;

public class Player {
private SimpleIntegerProperty score = new SimpleIntegerProperty(0);
private int playerID;
	public Player(int playerID) {
		this.playerID=playerID;
	}
    public void increScore(int point) {
    	this.score.set(this.score.get()+point);
    }
    public void decreScore(int point) {
    	this.score.set(this.score.get()-point);
    }
    public SimpleIntegerProperty getScore() {
    	return this.score;
    }
}
