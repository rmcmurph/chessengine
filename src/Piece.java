import java.util.ArrayList;
import java.util.List;

public class Piece {
	private char identifier; 
	private int materialValue; 
	private int[][] positionValues; 
	private boolean isWhite; 
	
	public Piece(char id, int value, int[][] posValues, boolean white){
		identifier = id; 
		materialValue = value; 
		positionValues = posValues; 
		isWhite = white; 
		
	}
	
	public static Piece createPawn(boolean isWhite){
		return new Piece('p', ChessSpecs.PAWN_VALUE, ChessSpecs.PAWN_TABLE, isWhite); 
	}
	public static Piece createBishop(boolean isWhite){
		return new Piece('b', ChessSpecs.BISHOP_VALUE, ChessSpecs.BISHOP_TABLE, isWhite); 
	}
	public static Piece createKnight(boolean isWhite){
		return new Piece('n', ChessSpecs.NIGHT_VALUE, ChessSpecs.KNIGHT_TABLE, isWhite); 
	}
	public static Piece createRook(boolean isWhite){
		return new Piece('r', ChessSpecs.ROOK_VALUE, ChessSpecs.ROOK_TABLE, isWhite); 
	}
	public static Piece createQueen(boolean isWhite){
		return new Piece('q', ChessSpecs.QUEEN_VALUE, ChessSpecs.QUEEN_TABLE, isWhite); 
	}
	public static Piece createKing(boolean isWhite){
		return new Piece('k', ChessSpecs.KING_VALUE, ChessSpecs.KING_TABLE, isWhite); 
	}
	
	public String getIdentifier(){
		if (isWhite) return "W"+identifier; 
		return "B" + identifier; 
	}
	
	public int getMaterialValue(){
		return materialValue; 
	}
	
	public int getPositionValue(Position p){
		return positionValues[p.getRow()][p.getColumn()]; 
	}
	
	public boolean pieceIsWhite(){
		return isWhite; 
	}
	
	public Piece copy(){
		Piece newPiece = new Piece(identifier, materialValue, positionValues, isWhite); 
		return newPiece; 
	}
	
	
}
