package board;
import java.util.List;

import ai.ChessAlphaBetaTree;

public class Test {

	public static void main(String[] args) {
		
		ChessBoard b = ChessBoard.InitialBoard(); 
		
		System.out.println(b.toString());
		
//		b.movePiece(new Position(6,0), new Position(5,0));
//		System.out.println(b.toString());
//		
//		ChessBoard c = b.getFlippedBoard(); 
//		System.out.println("flipped, whites turn: " + c.getIsWhitesTurn());
//		c.movePiece(new Position(6,0), new Position(5,0));
//		System.out.println(c.toString());
//		
//		ChessBoard d = c.getFlippedBoard(); 
//		System.out.println("flipped, whites turn: " + d.getIsWhitesTurn());
//		d.movePiece(new Position(7,1), new Position(5,2));
//		System.out.println(d.toString());
//		
//		ChessBoard e = d.getFlippedBoard(); 
//		System.out.println("flipped");
//		e.movePiece(new Position(7,1), new Position(5,2));
//		System.out.println(e.toString());
//		
//		ChessBoard f = e.getFlippedBoard(); 
//		System.out.println("flipped");
//		List<ChessBoard> boards = f.getAllPossibleMoves(); 
//		for (ChessBoard bd : boards){
//			System.out.println(bd.toString());
//		}
//		
//		
		
		
		
		ChessAlphaBetaTree t = new ChessAlphaBetaTree(true); 
		ChessBoard best = t.chooseMove(5, b);
		System.out.println(best);
		
		
		
		
//		List<ChessBoard> possible = b.getAllPossibleMoves(); 
//		for (ChessBoard temp : possible){
//			System.out.println("first");
//			System.out.println(temp.getBoardEvaluation());
//			System.out.println(temp.toString());
//			List<ChessBoard> nextPossible = temp.getFlippedBoard().getAllPossibleMoves(); 
//			for (ChessBoard nextTemp : nextPossible){
//				System.out.println("second");
//				System.out.println(nextTemp.getBoardEvaluation());
//				System.out.println(nextTemp.toString());
//			}
//			
//		}
		
	}

}
