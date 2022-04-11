package pieces;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import enums.Name;

public class Queen extends Piece{
	
	private BufferedImage image;
	
	public Queen() {
		try {
			
			image = ImageIO.read(new File("./assets/Queen.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Name getName() {
		return Name.QUEEN;
	}

	@Override
	public void setImage(BufferedImage image) {

		this.image = image;
		
	}

	@Override
	public BufferedImage getImage() {

		return image;
		
	}

}
