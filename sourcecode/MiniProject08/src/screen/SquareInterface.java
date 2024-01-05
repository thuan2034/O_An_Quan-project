package screen;

public interface SquareInterface {
	
	//reset lại color của square về mặc định
	public void resetToDefault();
	
	//set màu của square khi rải đá vào ô
	public void isSpreaded();
	
	//thêm 1 circle (gem) và set lại point
	public void spreadGems();
	
	//clear flow pane và set lại point của square sau khi get gems
	public void resetAfterGetG();
	 
}
