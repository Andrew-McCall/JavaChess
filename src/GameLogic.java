import java.util.ArrayList;

import enums.Name;
import pieces.*;

public class GameLogic {

	private Piece[] boardData;
	private ArrayList<Name> deadData;
	
	public GameLogic() {

		boardData = new Piece[64];
		deadData = new ArrayList<Name>();
		
		
		// Test Data
		boardData[0] = new Rook();
		boardData[1] = new Knight();
		boardData[2] = new Bishop();
		boardData[3] = new Queen();
		boardData[4] = new King();
		boardData[5] = new Knight();
		boardData[6] = new Bishop();
		boardData[7] = new Rook();
		
		boardData[8] = new Pawn();
		boardData[9] = new Pawn();
		boardData[10] = new Pawn();
		boardData[11] = new Pawn();
		boardData[12] = new Pawn();
		boardData[13] = new Pawn();
		boardData[14] = new Pawn();
		boardData[15] = new Pawn();
		
	}

	public Piece getPiece(int x, int y) {

		return boardData[x + (y*8)];
		
	}
	
	public void MovePiece(int x, int y, int newX, int newY) {
		
	}
	
	
	
}
