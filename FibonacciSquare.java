import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Class for drawing Fibonacci square shapes
 * 
 * @author Colby Easton, Max Sutters
 *
 */
public class FibonacciSquare extends AbstractShape {
	static int n = 0;
	private int quadrant;
	

	/**
	 * Constructor for Fibonacci Square shape
	 * 
	 * @param x
	 * @param y
	 * @param c
	 * @param size
	 */
	public FibonacciSquare(int x, int y, int n, Color c, int quadrant) {
		super(x, y, fibNum(n), c);
		this.n = n;
		this.quadrant = quadrant;
		array = new Shape[1];
	}

	/**
	 * Simple recursion method that calculates the Fibonacci number n.
	 * 
	 * @param n
	 * @return
	 */
	public static int fibNum(int n) {
		if (n <= 1) {
			return n;
			}
			return fibNum(n - 1) + fibNum(n - 2);
	}

	/**
	 * This method builds consecutively larger Fibonacci Square objects by using the fibNum method to modulate size.
	 */
	@Override
	public boolean createChildren() {
		if (n < 10) {
			array[0] = new FibonacciSquare(x, y, n, c, ((this.quadrant%4)+1));
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method draws out the Fibonacci square and spiral with switch cases for
	 * each of 4 possible quadrants.
	 */
	public void draw(Graphics g) {
		g.setColor(this.c);
		quadrant = this.quadrant + 1;
		int newSize = n*30;
		switch (quadrant) {
		// Quadrant 1
		case 1:
			g.drawRect(x, y, newSize, newSize);
			g.drawArc(x - newSize, y, 2 * newSize, 2 * newSize, 0, 90);
			break;

		// Quadrant 2
		case 2:
			g.drawRect(x- newSize, y, newSize, newSize);
			g.drawArc(x-newSize, y, 2 * newSize, 2 * newSize, 90, 90);
			n++;
			break;

		// Quadrant 3
		case 3:
			g.drawRect(x-newSize/2, y+newSize/2 , newSize, newSize);
			g.drawArc(x- newSize/2, y-newSize/2 , 2 * newSize, 2 * newSize, 180, 90);
			n++;
			break;

		// Quadrant 4
		case 4:
			g.drawRect(x+newSize/3, y, newSize, newSize);
			g.drawArc(x -2* newSize/3, y - newSize, 2 * newSize, 2 * newSize, 0, -90);
			break;

		}
	}
}