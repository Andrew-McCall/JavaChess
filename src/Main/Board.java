package Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import pieces.Piece;

public class Board extends JPanel implements MouseListener{

	private static final long serialVersionUID = 4203437795153052318L;
	
	private Cursor cursor = new Cursor();
	
	private Timer paintCall = new Timer();
	
	public Cursor getChessCursor() {
		return cursor;
	}


	public void getChessCursor(Cursor cursor) {
		this.cursor = cursor;
	}


	public Board() {
		
		super.addMouseListener(this);
		setPreferredSize(new Dimension(Main.BOXSIZE * 8, Main.BOXSIZE * 9));
		
		paintCall.schedule(new TimerTask(){
			@Override
	        public void run() {
	            Board.super.repaint();
	        }
		}, 100, 1000/Main.FPS);
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
                        col * Main.BOXSIZE, 
                        row * Main.BOXSIZE, 
                        Main.BOXSIZE, 
                        Main.BOXSIZE
                    );
                    
                }
                
            }    
        }
 
        // Piece Render (Has to be seperate for layers and async)
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
            
            	Piece currentPiece = Main.getGameLogic().getPiece(row, col);
                
                if (currentPiece != null) {
                    g2d.drawImage(currentPiece.getImage(), Main.BOXSIZE*row, Main.BOXSIZE*col, Main.BOXSIZE, Main.BOXSIZE, this);
                }
                
            }    
        }
        
        // Cursor 
        g2d.setColor(new Color(220, 220, 255));
        if (cursor.getPickup()) {
        	g2d.fillRect(
                cursor.getX() * Main.BOXSIZE, 
                cursor.getY() * Main.BOXSIZE, 
                Main.BOXSIZE, 
                Main.BOXSIZE
                );
        	
        	if (this.getMousePosition() != null) {
                g2d.drawImage(cursor.getPiece().getImage(), (int) this.getMousePosition().getX()-Main.BOXSIZE/2, (int) this.getMousePosition().getY()-Main.BOXSIZE/2, Main.BOXSIZE, Main.BOXSIZE, this);
        	}

	    }
       
    }
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		cursor.setPickup(true, e.getX(), e.getY());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		cursor.setPickup(false, e.getX(), e.getY());
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	}

}