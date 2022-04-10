import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Board extends JPanel implements MouseListener{

	private static final long serialVersionUID = 4203437795153052318L;
	
	public Board() {	
		
		super.addMouseListener(this);
		setPreferredSize(new Dimension(Main.getBoxsize() * 8, Main.getBoxsize() * 9));
		
		
	}

	@Override
    public void paintComponent(Graphics g) {
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
        
        g2d.drawImage(Main.getGameLogic().getTestPiece().getImage(), 0, 0, Main.getBoxsize(), Main.getBoxsize(), this);
        
    }
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	}

}
