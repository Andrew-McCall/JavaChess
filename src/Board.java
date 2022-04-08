import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Board extends JPanel implements MouseListener{

	private static final long serialVersionUID = 4203437795153052318L;

	public Board() {		
		
		setPreferredSize(new Dimension(Main.getBoxsize() * 10, Main.getBoxsize() * 8));
		
	}

	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
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
