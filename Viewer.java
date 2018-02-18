import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

/**
 * Viewer class has methods to update the desired DrawingModel object, and
 * another to draw all shapes in ArrayList of DrawingModel objects/shapes
 * 
 * @author Colby Easton, Max Sutters
 *
 */
public class Viewer extends JPanel implements View {

	private static final long serialVersionUID = 1L;
	DrawingModel model;

	/**
	 * Update method used to repaint shape in question.
	 */
	public void update(DrawingModel model) {
		this.model = model; // repaints this DrawingModel object
		repaint();
	}

	/**
	 * This method goes through the ArrayList of shapes and draws them all.
	 */
	@Override
	public void paintComponent(Graphics g) { // paints all components in the Arraylist of shapes
		super.paintComponents(g);
		if (model != null) {
			ArrayList<Shape> shapes = model.getShapes();
			Iterator<Shape> iter = shapes.iterator();
			while (iter.hasNext()) {
				Shape s = iter.next();
				s.draw(g);
			}
		}
	}
}
