package screen;

import javafx.scene.layout.AnchorPane;

public abstract class SquareScreen extends AnchorPane{
	//reset lại color của square về mặc định
	public abstract void resetToDefault();
			
	//set màu của square khi rải đá vào ô
	public abstract void isSpreaded();
			
	//thêm 1 circle (gem) và set lại point
	public abstract void spreadGems();
		
	//clear flow pane và set lại point của square sau khi get gems
	public abstract void resetAfterGetG();
}
