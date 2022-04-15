import java.util.ArrayList;

import enums.Name;
import enums.Side;
import pieces.*;

public class GameLogic {

	private Piece[] boardData;
	private ArrayList<Name> deadData;
	private int boardVersion = 0;
	private Side turn = Side.WHITE;
	
	public GameLogic() {

		boardData = new Piece[64];
		deadData = new ArrayList<Name>();
		
		/// Standard Board
		
		// Black 
		boardData[0] = new Rook(Side.BLACK);
		boardData[1] = new Knight(Side.BLACK);
		boardData[2] = new Bishop(Side.BLACK);
		boardData[3] = new King(Side.BLACK);
		boardData[4] = new Queen(Side.BLACK);
		boardData[5] = new Knight(Side.BLACK);
		boardData[6] = new Bishop(Side.BLACK);
		boardData[7] = new Rook(Side.BLACK);
		
		boardData[8]  = new Pawn(Side.BLACK);
		boardData[9]  = new Pawn(Side.BLACK);
		boardData[10] = new Pawn(Side.BLACK);
		boardData[11] = new Pawn(Side.BLACK);
		boardData[12] = new Pawn(Side.BLACK);
		boardData[13] = new Pawn(Side.BLACK);
		boardData[14] = new Pawn(Side.BLACK);
		boardData[15] = new Pawn(Side.BLACK);
		
		// White
		boardData[63] = new Rook();
		boardData[62] = new Knight();
		boardData[61] = new Bishop();
		boardData[60] = new Queen();
		boardData[59] = new King();
		boardData[58] = new Knight();
		boardData[57] = new Bishop();
		boardData[56] = new Rook();
		
		boardData[55] = new Pawn();
		boardData[54] = new Pawn();
		boardData[53] = new Pawn();
		boardData[52] = new Pawn();
		boardData[51] = new Pawn();
		boardData[50] = new Pawn();
		boardData[49] = new Pawn();
		boardData[48] = new Pawn();
		
	}

	public Side getTurn() {
		return turn;
	}
	
	public void endTurn() {
		if (turn == Side.BLACK) {
			turn = Side.WHITE;
		}else {
			turn = Side.BLACK;
		}
	}
	
	public Piece getPiece(int x, int y) {

		return boardData[x + (y*8)];
		
	}
	
	public void setPiece(int x, int y, Piece piece) {

		boardData[x + (y*8)] = piece;
		
	}
	
	public void movePiece(int x, int y, int newX, int newY) {
		
		Piece piece1 = getPiece(x, y);
		Piece piece2 = getPiece(newX, newY);

		// TODO: replace with piece1.getLegal(newX, newY)
		if (piece2 == null || (piece2.getSide() != piece1.getSide())) { // Legal check
			
			if (piece2 != null) {
				deadData.add(piece2.getName());
			}
			
			boardData[newX + (newY*8)] = boardData[x + (y*8)];
			boardData[x + (y*8)] = null;
			
			boardVersion += 1;

		}
		
	}

	public int getBoardVersion() {
		return boardVersion;
	}
	
}
