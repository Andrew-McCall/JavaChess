package pieces;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Knight extends Piece{
	
	private BufferedImage image;
	
	public Knight() {
		try {
			
			image = ImageIO.read(new File("./assets/Knight.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Name getName() {
		return Name.KNIGHT;
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
