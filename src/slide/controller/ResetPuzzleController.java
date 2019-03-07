package slide.controller;

import slide.model.*;
import slide.view.*;

public class ResetPuzzleController { 
	Model model;
	SlidingPuzzleApp app;
	
	public ResetPuzzleController(Model m, SlidingPuzzleApp a) {
		this.model = m;
		this.app = a;
	}
	
	public void reset() {
		model.getPuzzle().resetToInitial();
		app.getLabel().setText(Integer.toString(model.getPuzzle().getMove()));
		app.getPuzzleView().repaint();
	}

}
