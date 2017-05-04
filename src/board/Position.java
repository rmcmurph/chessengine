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
	
	public boolean equals(Object other){
		if (other == null) return false; 
		if (other.getClass() != this.getClass()) return false; 
		Position otherPosition = (Position) other;  
		if (otherPosition.getRow() == this.getRow() && otherPosition.getColumn() == this.getColumn()){
			return true; 
		}
		
		return false; 
	}
	
	public String toString(){
		return "<" + row + " | " + column + ">"; 
	}
}