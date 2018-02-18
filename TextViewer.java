
public class TextViewer implements View {
	DrawingModel model;
	private int count;

	public TextViewer(DrawingModel model) {
		this.model = model;
	}

	public void display() {
		count++;
		for (Shape s : model.getShapes()) {
			System.out.println(s);
		}
	}

	@Override
	public void update(DrawingModel model) {
		this.model = model;
		if (count <= 7) {
			display();
		}
	}

}
