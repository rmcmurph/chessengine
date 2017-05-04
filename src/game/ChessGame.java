package game;

import board.ChessBoard;
import board.ChessMoveGenerator;
import board.Position;

import java.util.ArrayList;
import java.util.List;

import ai.ChessAlphaBetaTree;

public class ChessGame {
	private ChessBoard gameBoard = ChessBoard.InitialBoard(); 
	private ChessAlphaBetaTree ai = new ChessAlphaBetaTree(); 
	private List<String> graveyard = new ArrayList<>(); 
	
	public void makeUserMove(Position current, Position future){
		if (gameBoard.getIdentifierAt(current).contains("k") && current.getColumn()==4 && future.getColumn()==2){
			gameBoard.movePiece(new Position(7, 0), new Position(7, 3));
		}else if (gameBoard.getIdentifierAt(current).contains("k") && current.getColumn()==4 && future.getColumn()==6){
			gameBoard.movePiece(new Position(7, 7), new Position(7, 5));
		}
		if (!gameBoard.getIdentifierAt(future).equals("-")){
			graveyard.add(gameBoard.getIdentifierAt(future)); 
		}
		
		gameBoard.movePiece(current, future);
	}
	
	public boolean isValidMove(Position current, Position future){
		System.out.println("current position: " + current);
		List<Position> validMoves = gameBoard.getValidPositions(current); 
		for (Position p : validMoves){
			if (p.equals(future)){
				return true; 
			}
		}
		return false; 
	}
	
	public List<Position> getValidPositions(Position current){
		return gameBoard.getValidPositions(current); 
	}
	
	public List<Position> getBestMove(int level){
		ArrayList<Position> move = new ArrayList<Position>(); 
		ChessBoard newBoard = ai.chooseMove(4, gameBoard); 
		Position to = ChessMoveGenerator.newPiecePosition(gameBoard, newBoard); 
		Position from = ChessMoveGenerator.newEmptyPiecePosition(gameBoard, newBoard); 
		move.add(from); 
		move.add(to); 
		return move; 
	}
	
	public List<String> getGraveyard(){
		return graveyard; 
	}
	
	public boolean isOver(){
		if (graveyard.contains("Wk") || graveyard.contains("Bk")) return true; 
		return false; 
	}
	
	
	
	public void makeAiMove(int level){
		ChessBoard aiMove = ai.chooseMove(level, gameBoard); 
		Position p = ChessMoveGenerator.newPiecePosition(gameBoard, aiMove); 
		if (!gameBoard.getIdentifierAt(p).equals("-")){
			graveyard.add(gameBoard.getIdentifierAt(p)); 
		}
		
		System.out.println(gameBoard.getBoardEvaluation());
		gameBoard = ai.chooseMove(level, gameBoard); 
		System.out.println(gameBoard.getBoardEvaluation());
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