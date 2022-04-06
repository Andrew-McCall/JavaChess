import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener  {
	
	private static final long serialVersionUID = -3691008469289316169L;


	public Menu() {

		JFrame frame = new JFrame("Menu (Chess by Andrew)");
		
		JButton test1 = new JButton("test 1");
		JButton test2 = new JButton("test 2");
		JButton test3 = new JButton("test 3");

		frame.setLayout(new GridLayout(3,1, 5 , 10));
		
		frame.add(test1);
		frame.add(test2);
		frame.add(test3);
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
