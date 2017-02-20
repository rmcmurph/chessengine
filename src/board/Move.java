package board;

public class Move {
	private int xDirection; 
	private int yDirection; 
	
	public Move(int x, int y){
		xDirection = x; 
		yDirection = y; 
	}
	
	public int getXDirection(){
		return xDirection; 
	}
	public int getYDirection(){
		return yDirection; 
	}

}
