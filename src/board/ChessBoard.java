package board;
import java.util.ArrayList;
import java.util.List;

public class ChessBoard {
	private Piece[][] board = new Piece[ChessSpecs.ROWS][ChessSpecs.COLUMNS]; 
	private boolean isWhitesTurn = true; 

	public ChessBoard(){}; 
	public ChessBoard(String setup){}; 

	public void addPiece(Position pos, Piece pc){
		board[pos.getRow()][pos.getColumn()] = pc; 
	}
	public void movePiece(Position currentPosition, Position futurePosition){
		if (board[currentPosition.getRow()][currentPosition.getColumn()] != null){
				board[futurePosition.getRow()][futurePosition.getColumn()] = board[currentPosition.getRow()][currentPosition.getColumn()];
				board[currentPosition.getRow()][currentPosition.getColumn()] = null; 
		}
	}
	
	
	
	public boolean checkMove(Position currentPosition, Position futurePosition){
		if (currentPosition==null) return false; 
		
		List<ChessBoard> validMoves = ChessMoveGenerator.getPossiblePositions(currentPosition, this); 
		
		ChessBoard attemptedBoard = this.copy(); 
		attemptedBoard.movePiece(currentPosition, futurePosition);
		
		if (validMoves.contains(attemptedBoard)) return true; 
		return false; 
	}
	
	public List<Position> getValidPositions(Position p){
		List<ChessBoard> boards = ChessMoveGenerator.getPossiblePositions(p, this); 
		ArrayList<Position> positions = new ArrayList<Position>(); 
		for (ChessBoard board : boards){
			//System.out.println(this.getIdentifierAt(p));
			positions.add(ChessMoveGenerator.newPiecePosition(this, board)); 
		}
		System.out.println(positions);
		return positions; 
		
		
		//return ChessMoveGenerator.getPossiblePositions(p, this);
	}
	

	public int getBoardEvaluation(){
		int eval = 0; 
		for (int r = 0; r<ChessSpecs.ROWS; r++){
			for (int c = 0; c<ChessSpecs.COLUMNS; c++){
				if (board[r][c] != null){
					Piece p = board[r][c]; 
					int materialValue = p.getMaterialValue(); 
					if (p.pieceIsWhite() == isWhitesTurn) eval = eval + materialValue; 
					else eval = eval - materialValue; 
					if (p.pieceIsWhite() == isWhitesTurn){
						if (p.getIdentifier().charAt(1) == 'p') eval = eval + ChessSpecs.PAWN_TABLE[r][c] + ChessSpecs.PAWN_ADJUSTMENT; 
						if (p.getIdentifier().charAt(1) == 'n') eval = eval + ChessSpecs.KNIGHT_TABLE[r][c] + ChessSpecs.KNIGHT_ADJUSTMENT; 
						if (p.getIdentifier().charAt(1) == 'b') eval = eval + ChessSpecs.BISHOP_TABLE[r][c] + ChessSpecs.BISHOP_ADJUSTMENT; 
						if (p.getIdentifier().charAt(1) == 'k') eval = eval + ChessSpecs.KING_TABLE[r][c] + ChessSpecs.KING_ADJUSTMENT; 
					}
					
				}
			}
		}
		return eval; 
	}
	
	public List<ChessBoard> getPossibleMoves(Position p){
		List<ChessBoard> boards = ChessMoveGenerator.getPossiblePositions(p, this); 
		return ChessMoveGenerator.getPossiblePositions(p, this); 
	}
	
	public List<ChessBoard> getAllPossibleMoves(){
		List<ChessBoard> allPossibleConfigurations = new ArrayList<ChessBoard>(); 
		for (int r = 0; r<ChessSpecs.ROWS; r++){
			for (int c = 0; c<ChessSpecs.COLUMNS; c++){
				List<ChessBoard> possibleConfigurations = this.getPossibleMoves(new Position(r,c)); 
				allPossibleConfigurations.addAll(possibleConfigurations); 
			}
		}
		return allPossibleConfigurations; 
	}
	
	public ChessBoard getFlippedBoard(){
		ChessBoard newBoard = new ChessBoard(); 
		for (int r = 0; r<board.length; r++){
			for (int c = 0; c<board[0].length; c++){
				if (board[r][c]!=null) newBoard.addPiece(new Position(ChessSpecs.ROWS - 1 -r, c), board[r][c]);
			}
		}
		newBoard.setIsWhitesTurn(isWhitesTurn);
		newBoard.switchTurns();
		return newBoard; 
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
		s.append("   0  1  2  3  4  5  6  7\n"); 
		
		for (int r = 0; r < board.length; r++){
			s.append(r + " "); 
			for (int c = 0; c < board[0].length; c++){
				if (board[r][c] == null) s.append("-  "); 
				else s.append(board[r][c].getIdentifier() + " "); 
			}
			s.append("" + r + "\n"); 
		}
		
		s.append("   0  1  2  3  4  5  6  7\n"); 
		return s.toString(); 
	}
	
	public String getIdentifierAt(Position p){
		if (board[p.getRow()][p.getColumn()] == null) return "-"; 
		return board[p.getRow()][p.getColumn()].getIdentifier(); 
	}
	public Position getIdentifierPosition(String id){
		for (int r = 0; r<board.length; r++){
			for (int c = 0; c<board[0].length; c++){
				//if (board[r][c]!=null) newBoard.addPiece(new Position(r, c), board[r][c].copy());
				if (board[r][c] != null){
					if (board[r][c].getIdentifier().equals(id)){
						return new Position(r, c); 
					}
				}
			}
		}
		return null; 
	}
	
	public ChessBoard copy(){
		ChessBoard newBoard = new ChessBoard(); 
		for (int r = 0; r<board.length; r++){
			for (int c = 0; c<board[0].length; c++){
				if (board[r][c]!=null) newBoard.addPiece(new Position(r, c), board[r][c].copy());
			}
		}
		newBoard.setIsWhitesTurn(isWhitesTurn);
		
		return newBoard; 
	}
	
	public boolean isWhitesTurn(){
		return isWhitesTurn; 
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
	public void setIsWhitesTurn(boolean b){
		isWhitesTurn = b; 
	}
	public boolean getIsWhitesTurn(){
		return isWhitesTurn; 
	}
	public void switchTurns(){
		isWhitesTurn = !isWhitesTurn; 
	}
	
	
	public boolean equals(Object other){
		if (other == null) return false; 
		if (other.getClass() != this.getClass()) return false; 
		ChessBoard otherBoard = (ChessBoard) other;  
		for (int r = 0; r<ChessSpecs.ROWS; r++){
			for (int c = 0; c<ChessSpecs.COLUMNS; c++){
				if (this.getPiece(new Position(r,c)) != null && otherBoard.getPiece(new Position(r,c)) != null){
					if (!this.getPiece(new Position(r,c)).getIdentifier().equals(otherBoard.getPiece(new Position(r,c)).getIdentifier())) return false; 
				}
				if (this.getPiece(new Position(r,c)) == null && otherBoard.getPiece(new Position(r,c)) != null) return false; 
				if (this.getPiece(new Position(r,c)) != null && otherBoard.getPiece(new Position(r,c)) == null) return false; 
			}
		}
		return true; 
	}
	
	public static ChessBoard InitialBoard(){
		ChessBoard b = new ChessBoard(); 
		b.addPiece(new Position(0,0), Piece.createRook(false));
		b.addPiece(new Position(0,1), Piece.createKnight(false));
		b.addPiece(new Position(0,2), Piece.createBishop(false));
		b.addPiece(new Position(0,4), Piece.createKing(false));
		b.addPiece(new Position(0,3), Piece.createQueen(false));
		b.addPiece(new Position(0,5), Piece.createBishop(false));
		b.addPiece(new Position(0,6), Piece.createKnight(false));
		b.addPiece(new Position(0,7), Piece.createRook(false));
		for (int c = 0; c<ChessSpecs.COLUMNS; c++){
			b.addPiece(new Position(1, c), Piece.createPawn(false));
		}
		
		b.addPiece(new Position(7,0), Piece.createRook(true));
		b.addPiece(new Position(7,1), Piece.createKnight(true));
		b.addPiece(new Position(7,2), Piece.createBishop(true));
		b.addPiece(new Position(7,4), Piece.createKing(true));
		b.addPiece(new Position(7,3), Piece.createQueen(true));
		b.addPiece(new Position(7,5), Piece.createBishop(true));
		b.addPiece(new Position(7,6), Piece.createKnight(true));
		b.addPiece(new Position(7,7), Piece.createRook(true));
		for (int c = 0; c<ChessSpecs.COLUMNS; c++){
			b.addPiece(new Position(6, c), Piece.createPawn(true));
		}
		
		
		return b; 
		
	}
}