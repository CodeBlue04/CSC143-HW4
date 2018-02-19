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
	protected Shape[] array;
	protected int n = 0;

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

	/**
	 * This method adds children to each shape using recursion to see if the object
	 * can add level, and if it can then calling the createChildren method.
	 */
	public boolean addLevel() {
		try {
			if (array[0] != null) {
				boolean recur = true;
				for (Shape s1 : array) {
					recur = s1.addLevel();
				}
				return recur;
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

	/**
	 * This method removes children from each shape by checking to see if the array
	 * is empty, then if it is not it nullifies the array element.
	 */
	@Override
	public boolean removeLevel() {
		try {
			if (array[0] == null) {
				JOptionPane.showMessageDialog(null, "Cannot remove level.", "Information",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			} else if (array[0].getChildren()[0] == null) {
				for (int i = 0; i < array.length; i++) {
					array[i] = null;
				}
			} else {
				array[0].removeLevel();
				createChildren();
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Cannot remove level", "Information", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Cannot remove level", "Information", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return false;
	}

	/**
	 * This method resets both shapes to their original positon and size.
	 */
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

	/**
	 * This method returns a formatted string containing the shape's name, location,
	 * and color values.
	 */
	@Override
	public String toString() {
		return String.format("Shape: %s, Coordinates: (%d, %d), Color = %s", this.getClass().getSimpleName(), x, y, c);
	}

	/**
	 * This method returns the X coordinate of the desired shape.
	 * 
	 * @return x coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * This method returns the Y coordinate of the desired shape.
	 * 
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * This method returns the size/n value of the desired shape.
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * This method returns the color information of the desired shape.
	 * 
	 * @return
	 */
	public Color getColor() {
		return c;
	}

	/**
	 * This method returns a copy of the shape's array.
	 */
	public Shape[] getChildren() {
		return array;
	}
}