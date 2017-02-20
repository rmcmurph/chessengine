import java.util.ArrayList;
import java.util.List;

public class ChessMoveGenerator {
	
	public static List<ChessBoard> getPossiblePositions(Position current, ChessBoard b){
		if (!b.isOccupied(current)) return new ArrayList<ChessBoard>(); 
		Piece p = b.getPiece(current); 
		if (p.getIdentifier().equals("Bb") || p.getIdentifier().equals("Wb")) return getBishopPositions(current, b); 
		if (p.getIdentifier().equals("Br") || p.getIdentifier().equals("Wr")) return getRookPositions(current, b); 
		if (p.getIdentifier().equals("Bn") || p.getIdentifier().equals("Wn")) return getKnightPositions(current, b); 
		if (p.getIdentifier().equals("Bp") || p.getIdentifier().equals("Wp")) return getPawnPositions(current, b);
		if (p.getIdentifier().equals("Bk") || p.getIdentifier().equals("Wk")) return getKingPositions(current, b); 
		if (p.getIdentifier().equals("Bq") || p.getIdentifier().equals("Wq")){
			List<ChessBoard> boards = new ArrayList<ChessBoard>(); 
			boards.addAll(getBishopPositions(current, b)); 
			boards.addAll(getRookPositions(current, b)); 
			return boards; 
		}
		

		
		return new ArrayList<ChessBoard>(); 
	}
	
	private static List<ChessBoard> getBishopPositions(Position current, ChessBoard b){
		Piece currentPiece = b.getPiece(current); 
		List<ChessBoard> possibleConfigurations = new ArrayList<ChessBoard>();
		
		//radiate northwest
		int i = 1; 
		while (true){
			Position temp = new Position(current.getRow() - i, current.getColumn() - i); 
			if (isOnBoard(temp)){
				boolean occupied = b.isOccupied(temp); 
				if (!occupied) possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
				else{
					if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
						possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
					}
					break; 
				}
			}else break; 
			i++; 
		}
		
		//radiate northeast
		i = 1; 
		while (true){
			Position temp = new Position(current.getRow() - i, current.getColumn() + i); 
			if (isOnBoard(temp)){
				boolean occupied = b.isOccupied(temp); 
				if (!occupied) possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
				else{
					if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
						possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
					}
					break; 
				}
			}else break; 
			i++; 
		}
		
		//radiate southwest
		i = 1; 
		while (true){
			Position temp = new Position(current.getRow() + i, current.getColumn() - i); 
			if (isOnBoard(temp)){
				boolean occupied = b.isOccupied(temp); 
				if (!occupied) possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
				else{
					if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
						possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
					}
					break; 
				}
			}else break; 
			i++; 
		}
		
		//radiate southeast
		i = 1; 
		while (true){
			Position temp = new Position(current.getRow() + i, current.getColumn() + i); 
			if (isOnBoard(temp)){
				boolean occupied = b.isOccupied(temp); 
				if (!occupied) possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
				else{
					if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
						possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
					}
					break; 
				}
			}else break; 
			i++; 
		}


		return possibleConfigurations; 
		
		
	}
	
	
	
	private static List<ChessBoard> getRookPositions(Position current, ChessBoard b){
		Piece currentPiece = b.getPiece(current); 
		List<ChessBoard> possibleConfigurations = new ArrayList<ChessBoard>();
		
		//radiate north
		int i = 1; 
		while (true){
			Position temp = new Position(current.getRow() - i, current.getColumn()); 
			if (isOnBoard(temp)){
				boolean occupied = b.isOccupied(temp); 
				if (!occupied) possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
				else{
					if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
						possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
					}
					break; 
				}
			}else break; 
			i++; 
		}
		
		//radiate south
		i = 1; 
		while (true){
			Position temp = new Position(current.getRow() + i, current.getColumn()); 
			if (isOnBoard(temp)){
				boolean occupied = b.isOccupied(temp); 
				if (!occupied) possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
				else{
					if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
						possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
					}
					break; 
				}
			}else break; 
			i++; 
		}
		
		//radiate west
		i = 1; 
		while (true){
			Position temp = new Position(current.getRow(), current.getColumn() - i); 
			if (isOnBoard(temp)){
				boolean occupied = b.isOccupied(temp); 
				if (!occupied) possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
				else{
					if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
						possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
					}
					break; 
				}
			}else break; 
			i++; 
		}
		
		//radiate east
		i = 1; 
		while (true){
			Position temp = new Position(current.getRow(), current.getColumn() + i); 
			if (isOnBoard(temp)){
				boolean occupied = b.isOccupied(temp); 
				if (!occupied) possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
				else{
					if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
						possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
					}
					break; 
				}
			}else break; 
			i++; 
		}
		return possibleConfigurations; 
	}
	
	private static List<ChessBoard> getKnightPositions(Position current, ChessBoard b){
		Piece currentPiece = b.getPiece(current); 
		List<ChessBoard> possibleConfigurations = new ArrayList<ChessBoard>();
		
		//northwest
		Position temp = new Position(current.getRow() - 2, current.getColumn() - 1); 
		if (isOnBoard(temp)){
			if (!b.isOccupied(temp)){
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}else if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
					possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}
		}
		
		temp = new Position(current.getRow() - 1, current.getColumn() - 2); 
		if (isOnBoard(temp)){
			if (!b.isOccupied(temp)){
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}else if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
					possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}
		}
		

		//southwest
		temp = new Position(current.getRow() - 2, current.getColumn() + 1); 
		if (isOnBoard(temp)){
			if (!b.isOccupied(temp)){
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}else if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}
		}

		temp = new Position(current.getRow() - 1, current.getColumn() + 2); 
		if (isOnBoard(temp)){
			if (!b.isOccupied(temp)){
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}else if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}
		}
		

		//northeast
		temp = new Position(current.getRow() + 2, current.getColumn() - 1); 
		if (isOnBoard(temp)){
			if (!b.isOccupied(temp)){
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}else if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}
		}

		temp = new Position(current.getRow() + 1, current.getColumn() - 2); 
		if (isOnBoard(temp)){
			if (!b.isOccupied(temp)){
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}else if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}
		}
		
		//southwest
		temp = new Position(current.getRow() + 2, current.getColumn() + 1); 
		if (isOnBoard(temp)){
			if (!b.isOccupied(temp)){
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}else if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}
		}

		temp = new Position(current.getRow() + 1, current.getColumn() + 2); 
		if (isOnBoard(temp)){
			if (!b.isOccupied(temp)){
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}else if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}
		}

		return possibleConfigurations; 
	}
	
	
	private static List<ChessBoard> getPawnPositions(Position current, ChessBoard b){
		Piece currentPiece = b.getPiece(current); 
		List<ChessBoard> possibleConfigurations = new ArrayList<ChessBoard>();
		
		//north
		Position temp = new Position(current.getRow() - 1, current.getColumn()); 
		if (isOnBoard(temp)){
			if (!b.isOccupied(temp)){
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}
		}

		//northwest
		temp = new Position(current.getRow() - 1, current.getColumn()-1); 
		if (isOnBoard(temp)){
			if (b.isOccupied(temp)){
				if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
					possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
				}
			}
		}

		//northeast
		temp = new Position(current.getRow() - 1, current.getColumn()+1); 
		if (isOnBoard(temp)){
			if (b.isOccupied(temp)){
				if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
					possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
				}
			}
		}
		
		return possibleConfigurations; 
	}
	
	
	private static List<ChessBoard> getKingPositions(Position current, ChessBoard b){
		Piece currentPiece = b.getPiece(current); 
		List<ChessBoard> possibleConfigurations = new ArrayList<ChessBoard>();

		//northwest
		Position temp = new Position(current.getRow() - 1, current.getColumn() - 1); 
		if (isOnBoard(temp)){
			if (!b.isOccupied(temp)){
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}else if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}
		}
		
		//north
		temp = new Position(current.getRow() - 1, current.getColumn()); 
		if (isOnBoard(temp)){
			if (!b.isOccupied(temp)){
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}else if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}
		}

		//northeast
		temp = new Position(current.getRow() - 1, current.getColumn() + 1); 
		if (isOnBoard(temp)){
			if (!b.isOccupied(temp)){
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}else if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}
		}
		
		
		//east
		temp = new Position(current.getRow(), current.getColumn()+1); 
		if (isOnBoard(temp)){
			if (!b.isOccupied(temp)){
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}else if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}
		}
		
		//southeast
		temp = new Position(current.getRow() + 1, current.getColumn()+1); 
		if (isOnBoard(temp)){
			if (!b.isOccupied(temp)){
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}else if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}
		}
		
		
		//south
		temp = new Position(current.getRow() + 1, current.getColumn()); 
		if (isOnBoard(temp)){
			if (!b.isOccupied(temp)){
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}else if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}
		}
		
		
		//southwest
		temp = new Position(current.getRow() + 1, current.getColumn()-1); 
		if (isOnBoard(temp)){
			if (!b.isOccupied(temp)){
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}else if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}
		}
		
		
		//west
		temp = new Position(current.getRow(), current.getColumn()-1); 
		if (isOnBoard(temp)){
			if (!b.isOccupied(temp)){
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}else if (b.isWhiteOccupied(temp) != currentPiece.pieceIsWhite()) {
				possibleConfigurations.add(movePieceAndGenerateBoard(current, temp, b)); 
			}
		}
		return possibleConfigurations; 
	}
	
	
	
	
	
	private static boolean isOnBoard(Position p){
		if (p.getRow() < 0 || p.getColumn() < 0) return false; 
		if (p.getRow() >= ChessSpecs.ROWS || p.getColumn() >= ChessSpecs.COLUMNS) return false; 
		return true; 
	}
	
	private static ChessBoard movePieceAndGenerateBoard(Position current, Position future, ChessBoard b){
		ChessBoard newBoard = b.copy(); 
		newBoard.movePiece(current, future);
		return newBoard; 
		
	}

}
