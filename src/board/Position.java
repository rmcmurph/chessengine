package board;

public class Position {
	private int row; 
	private int column; 
	
	public Position(int r, int c){
		row = r; 
		column = c; 
	}
	
	public int getRow(){
		return row; 
	}
	public int getColumn(){
		return column; 
	}
	
	public static Position getNewPosition(Position current, Move m){
		return new Position(current.getRow() + m.getXDirection(), current.getColumn() + m.getYDirection()); 
	}
}
