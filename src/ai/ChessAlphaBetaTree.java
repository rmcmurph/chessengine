package ai;

import java.util.ArrayList;
import java.util.List;

import board.ChessBoard;
import board.ChessSpecs;
import board.Position;

public class ChessAlphaBetaTree {

	private int bestScore; 
	private ChessBoard move = new ChessBoard(); 
	

	public ChessBoard chooseMove(int depth, ChessBoard b){
		int score = alphaBetaMax(Integer.MIN_VALUE, Integer.MAX_VALUE, depth, b, true); 
		return move.copy(); 
	}

	private int alphaBetaMax( int alpha, int beta, int depthleft, ChessBoard board, boolean first) {
		
		if (depthleft == 0){
			return this.Quiesce(alpha, beta, board); 
		}
		List<ChessBoard> allMoves = board.getAllPossibleMoves(); 
		for (ChessBoard current : allMoves) {
			int score = alphaBetaMin( alpha, beta, depthleft - 1, current.getFlippedBoard(), false);
			if( score >= beta ){
				return beta;   
			}
			if(score > alpha){
				if (first) move = current.copy(); 
				alpha = score;
			}
		}
		return alpha;
	}

	private int alphaBetaMin( int alpha, int beta, int depthleft, ChessBoard board, boolean first ) {


		if (depthleft == 0){
			return -this.Quiesce(alpha, beta, board); 
		}
		List<ChessBoard> allMoves = board.getAllPossibleMoves(); 
		for (ChessBoard current : allMoves) {
			int score = alphaBetaMax( alpha, beta, depthleft - 1 ,current.getFlippedBoard(), false);
			if(score <= alpha){
				return alpha; 
			}
			if(score < beta){
				beta = score; 
			}
		}
		return beta;
	}
	
	public int Quiesce(int alpha, int beta, ChessBoard b){
		int score = b.getBoardEvaluation(); 
		if (score >= beta){
			return beta; 
		}
		alpha = Math.max(alpha, score); 
		List<ChessBoard> moves = b.getAllPossibleMoves(); 
		for (ChessBoard move : moves){
			int moveScore = move.getBoardEvaluation(); 
			if (Math.abs(moveScore - score) >= 100){
				int newScore = -this.Quiesce(-beta, -alpha, move.getFlippedBoard()); 
				if (newScore >= beta){
					return beta; 
				}
				alpha = Math.max(alpha, newScore); 
			}
		}
		return alpha; 
	}
	





}
