import pieces.Piece;

public class Cursor {

	private int x;
	private int y;
	
	private boolean pickup;
	
	private Piece selected;

	

	public void setPickup(boolean pickup, int x, int y) { 
		
		if (pickup != this.pickup) {
			int xCoords = x/Main.getBoxsize();
			int yCoords = y/Main.getBoxsize();
						
			if (xCoords < 8 && yCoords < 8  &&  xCoords>=0 & yCoords>=0) {
				
				if (pickup) {
					
					setPiece(Main.getGameLogic().getPiece(xCoords, yCoords));
					
					if (getPiece() == null) {
						return;
					}
					
					Main.getGameLogic().setPiece(xCoords, yCoords, null);
					setCoords(xCoords, yCoords);
					
				}else {
					
					Main.getGameLogic().setPiece(this.x, this.y, getPiece());
					Main.getGameLogic().movePiece(this.x, this.y, xCoords, yCoords);
					
				}
				
				this.pickup = pickup;
				
			}else {
				
				if (!pickup) {
					Main.getGameLogic().setPiece(this.x, this.y, getPiece());
					this.pickup = pickup;
				}
				

			}
			
		}
		
	}

	
	// Setters & Getters
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
}
