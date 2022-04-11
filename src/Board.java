import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import pieces.Piece;

public class Board extends JPanel implements MouseListener{

	private static final long serialVersionUID = 4203437795153052318L;
	
	private Cursor cursor = new Cursor();;
	
	
	public Board() {	
		
		super.addMouseListener(this);
		setPreferredSize(new Dimension(Main.getBoxsize() * 8, Main.getBoxsize() * 9));
	
	}
	
	
	@Override
    public void paintComponent(Graphics g) {
		// Boiler Then BG
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
               
        g2d.setColor(new Color(190, 190, 190));
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
            
                if ((row + col) % 2 == 1) {
                	
                	g2d.fillRect(
                        col * Main.getBoxsize(), 
                        row * Main.getBoxsize(), 
                        Main.getBoxsize(), 
                        Main.getBoxsize()
                    );
                    
                }
                
            }    
        }
        
        
        // Cursor
        g2d.setColor(new Color(220, 220, 255));
        if (cursor.getPickup()) {
        	g2d.fillRect(
                cursor.getX() * Main.getBoxsize(), 
                cursor.getY() * Main.getBoxsize(), 
                Main.getBoxsize(), 
                Main.getBoxsize()
                );
        	
        	if (this.getMousePosition() != null) {
                g2d.drawImage(cursor.getPiece().getImage(), (int) this.getMousePosition().getX()-Main.getBoxsize()/2, (int) this.getMousePosition().getY()-Main.getBoxsize()/2, Main.getBoxsize(), Main.getBoxsize(), this);
        	}

	    }
        
 
        // Piece Render (Has to be seperate for layers and async)
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
            
            	Piece currentPiece = Main.getGameLogic().getPiece(row, col);
                
                if (currentPiece != null) {
                    g2d.drawImage(currentPiece.getImage(), Main.getBoxsize()*row, Main.getBoxsize()*col, Main.getBoxsize(), Main.getBoxsize(), this);
                }
                
            }    
        }
        
       
    }
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		int x = e.getX()/Main.getBoxsize();
		int y = e.getY()/Main.getBoxsize();
		
		if (y > 7 || x > 7) {
			return;
		}
		
		Piece piece = Main.getGameLogic().getPiece( x, y );
		if (piece != null) {
			cursor.setCoords( x, y );			
			cursor.setPickup(true);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if (cursor.getPickup()) {
			cursor.setPickup(false);
			cursor.setPiece(null);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	}

}
