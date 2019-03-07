package slide.controller;

import java.awt.event.*;

import slide.model.*;
import slide.view.*;

public class SelectTileController extends MouseAdapter{
	SlidingPuzzleApp app;
	Model model;
	
	public SelectTileController(Model m, SlidingPuzzleApp a) {
		this.model = m;
		this.app = a;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		PuzzleView view = app.getPuzzleView();
		
		int r = view.getRow(e.getY());
		int c = view.getColumn(e.getX());
		
		model.getPuzzle().selectTile(r, c);
		view.repaint();
	}

}
