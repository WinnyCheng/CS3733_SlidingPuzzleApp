package slide.view;

import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import slide.model.*;

/** 
 * Knows how to visually present the puzzle. 
 */
public class PuzzleView extends JPanel {
	
	Model model;
	
	int offset = 10; // buffer between squares
	
	int hTile, wTile, xPos, yPos;
	
	Tile temp;
	
	JLabel lblMoves, label;

	public PuzzleView(Model m) {
		this.model = m;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i = 0; i < 10; i++) { 
			temp = model.getPuzzle().getTile(i);
			
			hTile = temp.getHeight()*100 - offset;
			wTile = temp.getWidth()*100 - offset;
			xPos = temp.getCol()*100 + offset;
			yPos = temp.getRow()*100 + offset;
			
			if(model.getPuzzle().getSelected() == i)
				g.setColor(Color.blue);
			else if(temp.isKey())
				g.setColor(Color.red);
			else
				g.setColor(Color.orange); 

			g.fillRect(xPos, yPos, wTile, hTile);
		}
	}
	
	public int getRow(int y) {
		for(int i = 0; i< 5; i++) {
			if (y >= i*100 && y <= (i+1)*100)
				return i;
		}
		return -1;
	}

	public int getColumn(int x) {
		for(int i = 0; i< 5; i++) {
			if (x >= i*100 && x <= (i+1)*100)
				return i;
		}
		return -1;
	}
	
}
