import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class Controller extends MouseAdapter implements ActionListener {

	private DrawingModel model;

	/**
	 * Constructor for Controller class
	 * 
	 * @param model
	 */
	public Controller(DrawingModel model) {
		this.model = model;
	}

	/**
	 * Detects buttons being pressed and calls DrawingModel add/remove/reset
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Add Level.")) {
			model.addLevel();
		} else if (e.getActionCommand().equals("Remove Level.")) {
			model.removeLevel();
		} else if (e.getActionCommand().equals("Reset")) {
			model.reset();
		}
	}


}
