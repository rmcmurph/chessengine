package board;
import java.util.List;
import java.util.Scanner;

import game.ChessGame;

import ai.ChessAlphaBetaTree;

public class Test {

	public static void main(String[] args) {
		
//		ChessBoard b = ChessBoard.InitialBoard(); 
//		System.out.println(b);
//		b.movePiece(new Position(6,3), new Position(4,3));
//		System.out.println(b);
//		List<ChessBoard> moves = b.getPossibleMoves(new Position(4,3)); 
//		for (ChessBoard board : moves){
//			System.out.println(board);
//		}
//		
		
		ChessGame game = new ChessGame(); 
		
		System.out.println(game);
		
		Scanner scan = new Scanner(System.in); 
		
		while (true){
			System.out.println("user turn");
			System.out.println(game);
			int currentRow = scan.nextInt(); 
			int currentColumn = scan.nextInt(); 
			int futureRow = scan.nextInt(); 
			int futureColumn = scan.nextInt(); 
			
			Position current = new Position(currentRow, currentColumn); 
			Position future = new Position(futureRow, futureColumn); 
			
			System.out.println("making user move");
			game.makeUserMove(current, future);
			game.switchTurns();
			
			System.out.println("making ai move");
			game.makeAiMove(); 
			game.switchTurns();
			
		}
		
		
//		ChessBoard b = ChessBoard.InitialBoard(); 
//		
//		System.out.println(b.toString());
//		
////		b.movePiece(new Position(6,0), new Position(5,0));
////		System.out.println(b.toString());
////		
////		ChessBoard c = b.getFlippedBoard(); 
////		System.out.println("flipped, whites turn: " + c.getIsWhitesTurn());
////		c.movePiece(new Position(6,0), new Position(5,0));
////		System.out.println(c.toString());
////		
////		ChessBoard d = c.getFlippedBoard(); 
////		System.out.println("flipped, whites turn: " + d.getIsWhitesTurn());
////		d.movePiece(new Position(7,1), new Position(5,2));
////		System.out.println(d.toString());
////		
////		ChessBoard e = d.getFlippedBoard(); 
////		System.out.println("flipped");
////		e.movePiece(new Position(7,1), new Position(5,2));
////		System.out.println(e.toString());
////		
////		ChessBoard f = e.getFlippedBoard(); 
////		System.out.println("flipped");
////		List<ChessBoard> boards = f.getAllPossibleMoves(); 
////		for (ChessBoard bd : boards){
////			System.out.println(bd.toString());
////		}
////		
////		
//		
//		
//		
//		ChessAlphaBetaTree t = new ChessAlphaBetaTree(); 
//		ChessBoard best = t.chooseMove(5, b);
//		System.out.println(best);
//		
//		ChessBoard best2 = best.getFlippedBoard(); 
//		System.out.println(best2);
//		
//		best2.movePiece(new Position(6,4), new Position(4,4));
//		System.out.println(best2); 
//		
//		ChessBoard best3 = best2.getFlippedBoard(); 
//		
//		ChessBoard best4 = t.chooseMove(5, best3); 
//		System.out.println(best4); 
//		
//		best4 = best4.getFlippedBoard(); 
//		best4.movePiece(new Position(6,3), new Position(5,3));
//		
//		System.out.println(best4);
//		
//		best4 = t.chooseMove(5, best4.getFlippedBoard()); 
//		System.out.println(best4);
//		
//		
//		
//		
//		
//		
////		List<ChessBoard> possible = b.getAllPossibleMoves(); 
////		for (ChessBoard temp : possible){
////			System.out.println("first");
////			System.out.println(temp.getBoardEvaluation());
////			System.out.println(temp.toString());
////			List<ChessBoard> nextPossible = temp.getFlippedBoard().getAllPossibleMoves(); 
////			for (ChessBoard nextTemp : nextPossible){
////				System.out.println("second");
////				System.out.println(nextTemp.getBoardEvaluation());
////				System.out.println(nextTemp.toString());
////			}
////			
////		}
		
	}

}
