import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Controller extends MouseAdapter implements ActionListener {

	private DrawingModel model;

	
	public Controller(DrawingModel model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if (e.getActionCommand().equals("Add Level.")) {
			model.addLevel();
		}
		else if (e.getActionCommand().equals("Remove Level.")) {
			model.removeLevel();
		}else if (e.getActionCommand().equals("Reset")) {
			model.reset();
		}
	}

}
