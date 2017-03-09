package game;

import java.util.Scanner;

import board.Position;

public class PlayGame{
	public static void main(String[] args){
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
	}
}