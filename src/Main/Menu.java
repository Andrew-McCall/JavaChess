package Main;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener  {
	
	private static final long serialVersionUID = -3691008469289316169L;

	public Menu() {
		
		JButton play = new JButton("Play");
		JButton button2 = new JButton("test 2");
		JButton quit = new JButton("Quit");
				
		play.addActionListener(this);
		button2.addActionListener(this);
		quit.addActionListener(this);
				
		this.add(play);
		//this.add(button2);
		this.add(quit);
				
		
		this.setLayout(new GridLayout(2,1,10,10));
//		setPreferredSize(new Dimension(Main.getBoxsize() * 10, Main.getBoxsize() * 8));
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		
			case "Play":
				Main.setPanel(new Board());
				break;
				
			case "Quit":
				Main.getWindow().dispose();
				break;
				
			default:
				
		}
		
		repaint();
						
	}
	
}
