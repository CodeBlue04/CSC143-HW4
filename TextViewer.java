
public class TextViewer implements View {

	DrawingModel model;

	/**
	 * TextViewer constructor
	 * 
	 * @param model
	 */
	public TextViewer(DrawingModel model) {
		this.model = model;
	}

	/**
	 * Prints out the toString method for each shape from the AbstractShape class.
	 */
	public void display() {
		for (Shape s : model.getShapes()) {
			System.out.println(s);
		}
	}

	/**
	 * Updates display with correct model information
	 */
	@Override
	public void update(DrawingModel model) {
		this.model = model;
		display();

	}

}
