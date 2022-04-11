import pieces.Piece;

public class Cursor {

	private int x;
	private int y;
	
	private boolean pickup;
	
	private Piece selected;

	public Piece getPiece() {
		return selected;
	}

	public void setPiece(Piece selected) {
		this.selected = selected;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public void setCoords(int x, int y) {
		this.y = y;
		this.x = x;
	}

	public boolean getPickup() {
		return pickup;
	}

	public void setPickup(boolean pickup) {
		if (pickup) {
			setPiece(Main.getGameLogic().getPiece(x, y));
			Main.getGameLogic().setPiece(x, y, null);
		}else {
			Main.getGameLogic().setPiece(x, y, getPiece());
		}
		this.pickup = pickup;
	}

}
