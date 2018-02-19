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
	 * This method updates the model and repaints it.
	 */
	@Override
	public void update(DrawingModel model) {
		this.model = model;
		repaint();
	}

	/**
	 * This method iterates through each shape in the ArrayList of shapes and draws them.
	 */
	@Override
	public void paintComponent(Graphics g) { // paints all components in the Arraylist of shapes
		g.clearRect(0, 0, getWidth() / 2, getHeight());
		super.paintComponents(g);
		ArrayList<Shape> shapes = model.getShapes();
		Iterator<Shape> iter = shapes.iterator();
		while (iter.hasNext()) {
			Shape s = iter.next();
			s.draw(g);
		}
	}
}