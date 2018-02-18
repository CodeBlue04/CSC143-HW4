import javax.swing.*;
import java.awt.*;

/**
 * Abstract class with constructor for all shapes.
 * 
 * @author Colby Easton, Max Sutters
 *
 */
public abstract class AbstractShape implements Shape {
	protected int x; // X coordinate
	protected int y; // Y coordinate
	protected int size; // Size for HShape, n for FibonacciSquare
	protected int quadrant; // Quadrant for Fibonacci Square shape, must be here for FibonacciSquare
							// constructor to work
	protected Color c; // Color of shape
	protected int n = 1;
	protected Shape[] array;

	/**
	 * Constructor for all shapes.
	 * 
	 * @param x
	 * @param y
	 * @param c
	 */
	public AbstractShape(int x, int y, int size, Color c) {// Basic constructor
		this.x = x;
		this.y = y;
		this.size = size;
		this.c = c;
	}

	public boolean addLevel() {
		n++;
		try {
			if (array[0] != null) {
				boolean recur = true;
				for (Shape s1 : array) {
					recur = s1.addLevel();
				}return recur;
			} else {
				return createChildren();
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Cannot add level", "Information", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Cannot add level", "Information", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}
	
	
	@Override
	public boolean removeLevel() {
		n--;
		try {
			if (array[0] == null) {
				JOptionPane.showMessageDialog(null, "Cannot remove level AS RL", "Information",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			} else if (array[0].getChildren()[0] == null) {
				for (int i = 0; i < array.length; i++) {
					array[i] = null;
				}
			} else {
				for (int i = 0; i < array.length; i++) {
					array[i].removeLevel();
					}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Cannot remove level", "Information", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Cannot remove level", "Information", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}return false;
	}
	
	@Override
	public void resetLevel() {
		try {
			for (int i = 0; i < array.length; i++) {
				array[i] = null;
				}
		} catch (NullPointerException e) {
			return;
		}
	}

	@Override
	public String toString() {
		return String.format("Coordinates: (%d, %d), Color = %s", x, y, c);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSize() {
		return size;
	}

	public int getQuadrant() {
		if (this instanceof FibonacciSquare) {
			return this.quadrant;
		} else {
			return 0;
		}
	}

	public Color getColor() {
		return c;
	}

	public Shape[] getChildren() {
		return array;
	}
}