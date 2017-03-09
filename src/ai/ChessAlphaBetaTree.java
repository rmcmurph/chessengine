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
		
		if ( depthleft == 0 ){
			//return board.getBoardEvaluation();
			return this.Quiesce(alpha, beta, board); 
		}
		List<ChessBoard> allMoves = board.getAllPossibleMoves(); 
		for ( ChessBoard current : allMoves) {
			int score = alphaBetaMin( alpha, beta, depthleft - 1, current.getFlippedBoard(), false);
			if( score >= beta ){
				return beta;   // fail hard beta-cutoff
			}
			if( score > alpha ){
				if (first) move = current.copy(); 
				alpha = score; // alpha acts like max in MiniMax
			}
		}
		return alpha;
	}

	private int alphaBetaMin( int alpha, int beta, int depthleft, ChessBoard board, boolean first ) {


		if (depthleft == 0){
			//return -board.getBoardEvaluation(); 
			return -this.Quiesce(alpha, beta, board); 
		}
		List<ChessBoard> allMoves = board.getAllPossibleMoves(); 
		for ( ChessBoard current : allMoves) {
			int score = alphaBetaMax( alpha, beta, depthleft - 1 ,current.getFlippedBoard(), false);
			if( score <= alpha ){
				return alpha; // fail hard alpha-cutoff
			}
			if( score < beta ){
				beta = score; // beta acts like min in MiniMax
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
	
//	def Quiesce(alpha, beta):
//	    eval = static_evaluation()
//	    if (eval >= beta):
//	        return beta
//	    alpha = max(alpha, eval)
//	    for every move M which is a capture:
//	        make move M
//	        score = -Quiesce(-beta, -alpha)
//	        undo move M
//	        if (score >= beta):
//	            return beta
//	        alpha = max(alpha, score)
//	    return alpha




}
