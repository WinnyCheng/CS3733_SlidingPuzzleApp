package slide.model;

public class Tile {
	
	// Tile dimensions
	final int height;
	final int width;
	
	// Tile position
	int row;
	int col;
	
	/**
	 * Constructs a tile with given dimensions and initial starting positions
	 * 
	 * @param h the height of the tile
	 * @param w the width of the tile
	 * @param r the x position of the tile
	 * @param c the y position of the tile
	 */
	public Tile(int h, int w, int r, int c) {
		this.height = h;
		this.width = w;
		this.row = r;
		this.col = c;
	}
	
	/**
	 * Checks if this tile is the key tile to solving the puzzle
	 * 
	 * @return true if this tile is 2x2 (only key tile is 2x2) otherwise false
	 */
	public boolean isKey() {
		return this.width == 2 && this.height == 2;
	}
	
	/**
	 * Sets new x position of this tile
	 * 
	 * @param r the new x position of this tile
	 */
	public void setRow(int r) {
		this.row = r;
	}
	
	/**
	 * Sets new y position of this tile
	 * 
	 * @param c the new y position of this tile
	 */
	public void setCol(int c) {
		this.col = c;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}

}
