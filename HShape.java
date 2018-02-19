import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

/**
 * HShape class that draws H-shaped objects for the DrawingModel class
 * 
 * @author Colby Easton, Max Sutters
 *
 */
public class HShape extends AbstractShape {

	/**
	 * Constructor for H Shape
	 * 
	 * @param x
	 * @param y
	 * @param c
	 * @param size
	 */
	public HShape(int x, int y, int size, Color c) {
		super(x, y, size, c);
		this.array = new HShape[7];
	}

	public boolean createChildren() {
		if (size > 10) {
			for (int i = 0; i < array.length; i++) {
				int childSize = size / 3;
				if (i == 0) {
					array[0] = new HShape(x+ childSize, y+childSize, childSize, c);
				}
				if (i == 1) {
					array[1] = new HShape(x - size + childSize, y + childSize, childSize, c);
				}
				if (i == 2) {
					array[2] = new HShape(x - size + childSize, y - size + childSize, childSize, c);
				}
				if (i == 3) {
					array[3] = new HShape(x - size + childSize, y + size + childSize, childSize, c);
				}
				if (i == 4) {
					array[4] = new HShape(x + size + childSize, y + size + childSize, childSize, c);
				}
				if (i == 5) {
					array[5] = new HShape(x + size + childSize, y - size+ childSize, childSize, c);
				}
				if (i == 6) {
					array[6] = new HShape(x + size + childSize, y + childSize, childSize, c);
				}
			}
			return true;
		} else {
			return false;

		}
	}

	/**
	 * This method draws the HShape object using nested for loops and the Graphics
	 * class methods drawRect() & fillRect()
	 * 
	 * @param g
	 */
	@Override
	public void draw(Graphics g) {
		if (array[0] == null) {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, size, size);
			g.fillRect(x - size, y, size, size);
			g.fillRect(x - size, y + size, size, size);
			g.fillRect(x - size, y - size, size, size);
			g.fillRect(x + size, y, size, size);
			g.fillRect(x + size, y + size, size, size);
			g.fillRect(x + size, y - size, size, size);
			g.setColor(Color.WHITE);
			g.fillRect(x, y + size, size, size);
			g.fillRect(x, y - size, size, size);
		} else {
			for (int i = 0; i < array.length; i++) {
				array[i].draw(g);
			}
		}

	}
}
