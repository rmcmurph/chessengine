import java.util.ArrayList;
import java.util.List;

public class ChessBoard {
	private Piece[][] board = new Piece[ChessSpecs.ROWS][ChessSpecs.COLUMNS]; 

	public ChessBoard(){}; 
	public ChessBoard(String setup){}; 
	
	public void addPiece(Position pos, Piece pc){
		board[pos.getRow()][pos.getColumn()] = pc; 
	}
	public void movePiece(Position currentPosition, Position futurePosition){
		board[futurePosition.getRow()][futurePosition.getColumn()] = board[currentPosition.getRow()][currentPosition.getColumn()];
		board[currentPosition.getRow()][currentPosition.getColumn()] = null; 
	}
	
//	public ChessBoard performMove(Position currentPosition, Position futurePosition){
//		
//		ChessBoard newBoard = 
//	}
	
	public List<ChessBoard> getPossibleMoves(Position p){
		return ChessMoveGenerator.getPossiblePositions(p, this); 
	}
	
	public Piece getPiece(Position p){
		return board[p.getRow()][p.getColumn()]; 
	}
	
	public boolean isWhiteOccupied(Position p){
		if (board[p.getRow()][p.getColumn()] == null) return false; 
		return board[p.getRow()][p.getColumn()].pieceIsWhite(); 
	}
	
	
	public String toString(){
		StringBuilder s = new StringBuilder(); 
		for (int r = 0; r < board.length; r++){
			for (int c = 0; c < board[0].length; c++){
				if (board[r][c] == null) s.append("-  "); 
				else s.append(board[r][c].getIdentifier() + " "); 
			}
			s.append("\n"); 
		}
		return s.toString(); 
	}
	
	public ChessBoard copy(){
		ChessBoard newBoard = new ChessBoard(); 
		for (int r = 0; r<board.length; r++){
			for (int c = 0; c<board[0].length; c++){
				if (board[r][c]!=null) newBoard.addPiece(new Position(r, c), board[r][c]);
			}
		}
		return newBoard; 
	}
	
	
	
	private void checkPosition(int row, int column){
		if (row<0 || row>=ChessSpecs.ROWS) throw new IllegalArgumentException("row number not valid"); 
		if (column<0 || column>=ChessSpecs.ROWS) throw new IllegalArgumentException("column number not valid"); 
	}
	private void checkSpotOccupation(Position p){
		if (isOccupied(p)) throw new IllegalArgumentException("board spot is already occupied, can't move piece there"); 
	}
	public boolean isOccupied(Position p){
		//checkPosition(row, column); 
		if (board[p.getRow()][p.getColumn()] == null) return false; 
		return true; 
	}
}
