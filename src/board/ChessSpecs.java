package board;
import java.util.ArrayList;
import java.util.HashMap;

public class ChessSpecs {
	public static final int ROWS = 8; 
	public static final int COLUMNS = 8; 
	
	public static final HashMap<String, String> imageMap = new HashMap<String, String>(); 
	
	//http://chessprogramming.wikispaces.com/Simplified+evaluation+function
	
	public static final int PAWN_VALUE = 100; 
	public static final int BISHOP_VALUE = 315; 
	public static final int NIGHT_VALUE = 325; 
	public static final int ROOK_VALUE = 500; 
	public static final int QUEEN_VALUE = 900; 
	public static final int KING_VALUE = 1000000; 
	
	public static final int PAWN_ADJUSTMENT = 25; 
	public static final int KNIGHT_ADJUSTMENT = 50; 
	public static final int BISHOP_ADJUSTMENT = 20; 
	public static final int KING_ADJUSTMENT = 50; 
	
	
	//http://www.chessbin.com/post/Piece-Square-Table.aspx
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
	
	public static String getDeadImageName(String identifier){
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
	
	public static String getImageName(String identifier){
		imageMap.put("wWp", "w_w_pawn.png"); 
		imageMap.put("bWp", "b_w_pawn.png"); 
		imageMap.put("wBp", "w_b_pawn.png"); 
		imageMap.put("bBp", "b_b_pawn.png");
		imageMap.put("wWr", "w_w_rook.png"); 
		imageMap.put("bWr", "b_w_rook.png");
		imageMap.put("wBr", "w_b_rook.png"); 
		imageMap.put("bBr", "b_b_rook.png"); 
		imageMap.put("wWb", "w_w_bishop.png"); 
		imageMap.put("bWb", "b_w_bishop.png"); 
		imageMap.put("wBb", "w_b_bishop.png"); 
		imageMap.put("bBb", "b_b_bishop.png"); 
		imageMap.put("wWn", "w_w_knight.png"); 
		imageMap.put("bWn", "b_w_knight.png"); 
		imageMap.put("wBn", "w_b_knight.png"); 
		imageMap.put("bBn", "b_b_knight.png");
		imageMap.put("wWq", "w_w_queen.png"); 
		imageMap.put("bWq", "b_w_queen.png"); 
		imageMap.put("wBq", "w_b_queen.png"); 
		imageMap.put("bBq", "b_b_queen.png"); 
		imageMap.put("wWk", "w_w_king.png"); 
		imageMap.put("bWk", "b_w_king.png"); 
		imageMap.put("wBk", "w_b_king.png"); 
		imageMap.put("bBk", "b_b_king.png"); 
		imageMap.put("w", "w_square.png"); 
		imageMap.put("b", "b_square.png"); 
		
		imageMap.put("wWp_star", "w_w_pawn_star.png"); 
		imageMap.put("bWp_star", "b_w_pawn_star.png"); 
		imageMap.put("wBp_star", "w_b_pawn_star.png"); 
		imageMap.put("bBp_star", "b_b_pawn_star.png");
		imageMap.put("wWr_star", "w_w_rook_star.png"); 
		imageMap.put("bWr_star", "b_w_rook_star.png");
		imageMap.put("wBr_star", "w_b_rook_star.png"); 
		imageMap.put("bBr_star", "b_b_rook_star.png"); 
		imageMap.put("wWb_star", "w_w_bishop_star.png"); 
		imageMap.put("bWb_star", "b_w_bishop_star.png"); 
		imageMap.put("wBb_star", "w_b_bishop_star.png"); 
		imageMap.put("bBb_star", "b_b_bishop_star.png"); 
		imageMap.put("wWn_star", "w_w_knight_star.png"); 
		imageMap.put("bWn_star", "b_w_knight_star.png"); 
		imageMap.put("wBn_star", "w_b_knight_star.png"); 
		imageMap.put("bBn_star", "b_b_knight_star.png");
		imageMap.put("wWq_star", "w_w_queen_star.png"); 
		imageMap.put("bWq_star", "b_w_queen_star.png"); 
		imageMap.put("wBq_star", "w_b_queen_star.png"); 
		imageMap.put("bBq_star", "b_b_queen_star.png"); 
		imageMap.put("wWk_star", "w_w_king_star.png"); 
		imageMap.put("bWk_star", "b_w_king_star.png"); 
		imageMap.put("wBk_star", "w_b_king_star.png"); 
		imageMap.put("bBk_star", "b_b_king_star.png"); 
		imageMap.put("w_star", "w_square_star.png"); 
		imageMap.put("b_star", "b_square_star.png"); 
		return imageMap.get(identifier);
	}

}
