package slide;

import java.awt.event.*;
import javax.swing.*;

import slide.controller.*;
import slide.model.*;
import slide.view.*;

public class Main {
	public static void main(String[] args) {
		Model m = new Model();
		
		final SlidingPuzzleApp app = new SlidingPuzzleApp(m);
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				new QuitAppController(app).process(); 
			}
		});
		
		app.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		app.setVisible(true);
	}

}
