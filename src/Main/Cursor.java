package Main;
import pieces.Piece;

public class Cursor {

	private int x;
	private int y;
	
	private boolean pickup;
	
	private Piece selected;

	

	public void setPickup(boolean pickup, int newX, int newY) { 
		
		if (pickup != this.pickup) {
			int xCoords = newX/Main.BOXSIZE;
			int yCoords = newY/Main.BOXSIZE;
						
			if (xCoords < 8 && yCoords < 8  &&  xCoords>=0 & yCoords>=0) {
				
				if (pickup) { // Picked up
					
					selected = Main.getGameLogic().getPiece(xCoords, yCoords);
					this.x = xCoords;
					this.y = yCoords;
					
					if (getPiece() == null || Main.getGameLogic().getTurn() != selected.getSide()) {
						return;
					}
					
					Main.getGameLogic().setPiece(xCoords, yCoords, null);
					
				}else { // Put Down
					
					Main.getGameLogic().setPiece(this.x, this.y, selected); // Piece in old location
					Main.getGameLogic().movePiece(selected, new Coordinate(xCoords, yCoords));
					
				}
				
				this.pickup = pickup;
				
			}else {
				
				if (!pickup) { // Invaild Coords AND piece droped, just resets it
					Main.getGameLogic().setPiece(this.x, this.y, this.selected);
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
