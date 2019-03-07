package slide.controller;

import javax.swing.JOptionPane;

import slide.model.*;
import slide.view.*;

public class MoveSelectedController { 
	Model model;
	SlidingPuzzleApp app;
	
	public MoveSelectedController(Model m, SlidingPuzzleApp a) {
		this.model = m;
		this.app = a;
	}
	
	public void moveTile(String direction) {
		if(model.getPuzzle().wonGame()) {
			JOptionPane.showMessageDialog(app, "YOU WON!");
			return;
		}
		model.getPuzzle().validMove(direction);
		app.getLabel().setText(Integer.toString(model.getPuzzle().getMove()));
		app.getPuzzleView().repaint();
	}
}
