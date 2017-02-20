import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		ChessBoard board = new ChessBoard(); 
		board.addPiece(new Position(5,4), Piece.createQueen(true));
		
		System.out.println(board.toString());
		
		

		
		List<ChessBoard> boards = board.getPossibleMoves(new Position(5,4)); 
		
		
		
		for (ChessBoard b : boards){
			System.out.println(b);
		}

	}

}
