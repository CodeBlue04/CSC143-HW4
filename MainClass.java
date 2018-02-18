import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/**
 * Class that builds frame, then uses loop to instantiate ten objects inside of
 * that frame
 * 
 * @author Colby Easton, Max Sutters
 *
 */
public class MainClass {

	public static void main(String[] args) {

		createGUI();// runs entire program
	}

	public static void createGUI() {
		JFrame frame = new JFrame("Homework 4");// Title of frame
		
		Viewer view = new Viewer();
		DrawingModel model = new DrawingModel();
		Controller controller = new Controller(model);


		JRadioButton addLevel = new JRadioButton("Add Level.", false);
		addLevel.setActionCommand("Add Level.");
		addLevel.setBounds(200, 50, 100, 30);
		
		JRadioButton removeLevel = new JRadioButton("Remove Level.", false);
		removeLevel.setActionCommand("Remove Level.");
		removeLevel.setBounds(400,50,100,30);
		
		JRadioButton reset = new JRadioButton("Reset", false);
		reset.setActionCommand("Reset");
		reset.setBounds(600,50,100,30);
			
		addLevel.addActionListener(controller);
		removeLevel.addActionListener(controller);
		reset.addActionListener(controller);
		view.add(addLevel);
		view.add(removeLevel);
		view.add(reset);
		
		model.addView(view);
		frame.add(view);
		frame.setSize(800, 600);// Dimensions of frame
		frame.setBackground(Color.WHITE);// Sets background color
		
		model.notifyViews();
		
		frame.setVisible(true); // Put at bottom to make frame visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// End condition
	}

}
