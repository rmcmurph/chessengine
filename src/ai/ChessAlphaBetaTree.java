package ai;

import java.util.ArrayList;
import java.util.List;

import board.ChessBoard;
import board.ChessSpecs;
import board.Position;

public class ChessAlphaBetaTree {

	private int bestScore; 
	private ChessBoard move = new ChessBoard(); 
	


	public ChessAlphaBetaTree(boolean isWhitesTurn){

	}

	public ChessBoard chooseMove(int depth, ChessBoard b){
		int score = alphaBetaMax(Integer.MIN_VALUE, Integer.MAX_VALUE, depth, b, true); 
		return move.copy(); 
	}

	private int alphaBetaMax( int alpha, int beta, int depthleft, ChessBoard board, boolean first) {
		
		if ( depthleft == 0 ) return board.getBoardEvaluation();
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


		if (depthleft == 0) return -board.getBoardEvaluation(); 
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




}
