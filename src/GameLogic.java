import pieces.*;

public class GameLogic {

	private Piece testPiece;
	
	public GameLogic() {

		testPiece = new King();

	}

	public Piece getTestPiece() {
		return testPiece;
	}

	public void setTestPiece(Piece testPiece) {
		this.testPiece = testPiece;
	}
	
}
