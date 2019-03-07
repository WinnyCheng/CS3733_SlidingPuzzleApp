package slide.controller;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class QuitAppController {
	
	JFrame app;
	
	public QuitAppController(JFrame app) {
		this.app = app;
	}
	
	public void process() {
		int confirm = JOptionPane.showConfirmDialog(app, "Do you wish to exit?");
		
		if(confirm == JOptionPane.OK_OPTION) {
			app.setVisible(false);
			app.dispose();
		}

	}
}
