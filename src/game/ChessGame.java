package game;

import board.ChessBoard;
import board.Position; 

import ai.ChessAlphaBetaTree;

public class ChessGame {
	private ChessBoard gameBoard = ChessBoard.InitialBoard(); 
	private ChessAlphaBetaTree ai = new ChessAlphaBetaTree(); 
	
	public void makeUserMove(Position current, Position future){
		gameBoard.movePiece(current, future);
	}
	
	public void makeAiMove(){
		gameBoard = ai.chooseMove(4, gameBoard); 
	}
	
	public void switchTurns(){
		gameBoard = gameBoard.getFlippedBoard(); 
	}
	
	public String toString(){
		return gameBoard.toString(); 
	}
	
	public String getPieceAt(Position p){
		return gameBoard.getIdentifierAt(p); 
	}

}
