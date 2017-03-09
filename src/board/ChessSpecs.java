package board;
import java.util.ArrayList;
import java.util.HashMap;

public class ChessSpecs {
	public static final int ROWS = 8; 
	public static final int COLUMNS = 8; 
	
	public static final HashMap<String, String> imageMap = new HashMap<String, String>(); 
	
	//public static final Move[] PAWN_MOVES ={new Move(-1, 1), new Move(0, 1), new Move(1, 1)}; 
	//public static final Move[] BISHOP_MOVES = {new Move()
	
	public static final int PAWN_VALUE = 100; 
	public static final int BISHOP_VALUE = 315; 
	public static final int NIGHT_VALUE = 325; 
	public static final int ROOK_VALUE = 500; 
	public static final int QUEEN_VALUE = 900; 
	public static final int KING_VALUE = 100000; 
	
	public static final int PAWN_ADJUSTMENT = 25; 
	public static final int KNIGHT_ADJUSTMENT = 50; 
	public static final int BISHOP_ADJUSTMENT = 20; 
	public static final int KING_ADJUSTMENT = 50; 
	
	public static final int[][] PAWN_TABLE = {
			   {0,  0,  0,  0,  0,  0,  0,  0},
			  {45, 50, 40, 50, 50, 40, 45, 45},
			  {15, 35, 20, 33, 33, 20, 35, 15},
			   {5, 15, 10, 30, 30, 10, 15,  5},
			   {0,  0,  0, 25, 25,  0,  0,  0},
			   {5, -5,-10,  0,  0,-10, -5,  5},
			   {5, 10, 10,-25,-25, 10, 10,  5},
			   {0,  0,  0,  0,  0,  0,  0,  0}
			};
	
	public static final int KNIGHT_TABLE[][] = {
			  {-50,-40,-30,-30,-30,-30,-40,-50},
			  {-40,-20,  0,  0,  0,  0,-20,-40},
			  {-30,  0, 10, 15, 15, 10,  0,-30},
			  {-30,  5, 15, 20, 20, 15,  5,-30},
			  {-30,  0, 15, 20, 20, 15,  0,-30},
			  {-30,  5, 10, 15, 15, 10,  5,-30},
			  {-40,-20,  0,  5,  5,  0,-20,-40},
			  {-50,-40,-20,-30,-30,-20,-40,-50}
			};
	
	public static final int BISHOP_TABLE[][] = {
			  {-20,-10,-10,-10,-10,-10,-10,-20},
			  {-10,  0,  0,  0,  0,  0,  0,-10},
			  {-10,  0,  5, 10, 10,  5,  0,-10},
			  {-10,  5,  5, 10, 10,  5,  5,-10},
			  {-10,  0, 10, 10, 10, 10,  0,-10},
			  {-10, 10, 10, 10, 10, 10, 10,-10},
			  {-10,  5,  0,  0,  0,  0,  5,-10},
			  {-20,-10,-40,-10,-10,-40,-10,-20}
			};
	public static final int ROOK_TABLE[][] = {
			  {0,0,0,0,0,0,0,0},
			  {0,0,0,0,0,0,0,0},
			  {0,0,0,0,0,0,0,0},
			  {0,0,0,0,0,0,0,0},
			  {0,0,0,0,0,0,0,0},
			  {0,0,0,0,0,0,0,0},
			  {0,0,0,0,0,0,0,0},
			  {0,0,0,0,0,0,0,0}
			};
	public static final int QUEEN_TABLE[][] = {
			  {0,0,0,0,0,0,0,0},
			  {0,0,0,0,0,0,0,0},
			  {0,0,0,0,0,0,0,0},
			  {0,0,0,0,0,0,0,0},
			  {0,0,0,0,0,0,0,0},
			  {0,0,0,0,0,0,0,0},
			  {0,0,0,0,0,0,0,0},
			  {0,0,0,0,0,0,0,0}
			};
	
	public static final int KING_TABLE[][] = { 
			    {-30, -40, -40, -50, -50, -40, -40, -30},
			    {-30, -40, -40, -50, -50, -40, -40, -30},
			    {-30, -40, -40, -50, -50, -40, -40, -30},
			    {-30, -40, -40, -50, -50, -40, -40, -30},
			    {-20, -30, -30, -40, -40, -30, -30, -20},
			    {-10, -20, -20, -20, -20, -20, -20, -10},
			    {20,  20,   0,   0,   0,   0,  20,  20},
			    {20,  50,  10,   0,   0,  10,  50,  20}
			  }; 
	
	public static String getImageName(String identifier){
		imageMap.put("Wp", "white_pawn.png"); 
		imageMap.put("Bp", "black_pawn.png"); 
		imageMap.put("Wr", "white_rook.png"); 
		imageMap.put("Br", "black_rook.png"); 
		imageMap.put("Wb", "white_bishop.png"); 
		imageMap.put("Bb", "black_bishop.png"); 
		imageMap.put("Wn", "white_knight.png"); 
		imageMap.put("Bn", "black_knight.png"); 
		imageMap.put("Wq", "white_queen.png"); 
		imageMap.put("Bq", "black_queen.png"); 
		imageMap.put("Wk", "white_king.png"); 
		imageMap.put("Bk", "black_king.png"); 
		return imageMap.get(identifier);
	}

}
