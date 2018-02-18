import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * DrawingModel class does the majority of the heavy lifting, with methods
 * returning various values and objects to other classes.
 * 
 * @author Colby Easton, Max Sutters
 *
 */
public class DrawingModel {
	protected ArrayList<Shape> shapes = new ArrayList<Shape>();
	protected ArrayList<View> views = new ArrayList<View>();
	
	
	
	/**
	 * Instantiates two shapes
	 */
	public DrawingModel() {
		this.shapes = new ArrayList<Shape>();
		this.views = new ArrayList<View>();

		drawModel();
	}

	public void drawModel() {

		addShape(new HShape(100, 200, 99, Color.BLUE));
		addShape(new FibonacciSquare(500, 200, 3, Color.RED, 0));
	}

	/**
	 * This method allows the user to add a shape to the frame.
	 */
	public void addShape(Shape s) {
		System.out.println(s.toString()); // Alerts user to new shape
		shapes.add(s);
	}

	/**
	 * This method returns a deep copy of an ArrayList of shapes.
	 * 
	 * @param s
	 * @return
	 */
	public ArrayList<Shape> getShapes() {
		return this.shapes;
	}

	/**
	 * This method adds View v to ArrayList of Views.
	 * 
	 * @param v
	 */
	public void addView(View v) {
		views.add(v);
		v.update(this);
	}

	public void addLevel() {
		for (Shape s : getShapes()) {
			s.addLevel();
		}
		notifyViews();
	}

	public void removeLevel() {
		for (Shape s : getShapes()) {
			s.removeLevel();
		}
		notifyViews();
	}
	
	public void reset() {
		for (Shape s : getShapes()) {
			s.resetLevel();
		}
		notifyViews();
	}

	public void notifyViews() {
		Iterator<View> iter = views.iterator();
		while (iter.hasNext()) {
			View next = iter.next();
			next.update(this);
		}
	}
}
