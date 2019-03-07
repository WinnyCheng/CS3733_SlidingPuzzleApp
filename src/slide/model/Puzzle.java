package slide.model;

public class Puzzle {
	
	//Array to store the tiles of the puzzle, tiles will be stored in the following order
	//key tile, 2x1 tiles, 1x2 tiles, and lastly 1x1 tiles
	Tile[] tilePieces = new Tile[10];
	
	//Index position of the selected tile with tilePieces array
	int selected = -1; // -1 means no tile is selected
	
	//initial position of left top square of each tiles, row 0 is the x position, row 1 is the corresponding y position
	int[][] initial = {{1, 0, 2, 1, 3, 4, 0, 0, 0, 3},
					   {2, 0, 0, 1, 1, 2, 1, 2, 3, 3}};
	/* Testing Purposes
	int[][] winning = {{3, 0, 3, 1, 1, 2, 0, 0, 0, 2},
			   		   {0, 0, 3, 1, 2, 2, 1, 2, 3, 0}}; */
	
	
	//State of puzzle: solved versus unsolved
	boolean solved = false;
	
	//number of moves
	int numMove = 0;
	
	//solve state of puzzle
	boolean won = false;

	//Open squares in the puzzle, there is always two 4,0 4,1
	int openR1 = 4; 
	int openC1 = 0; 
	
	int openR2 = 4; 
	int openC2 = 1;
	
	/**
	 * Constructs the Puzzle with 10 tile pieces with set initial positions
	 */
	public Puzzle() {
		//create the key tile
		tilePieces[0] = new Tile(2, 2, initial[0][0], initial[1][0]);
		
		//create 2x1, 1x2, and 1x1 tiles
		int h = 2; 
		int w = 1;
		
		for(int i = 0; i < 9; i++) {
			
			tilePieces[i+1] = new Tile(h, w, initial[0][i+1], initial[1][i+1]);
			
			if(i == 4)
				w = 1;
			else if(i == 2 ) {
				h = 1;
				w = 2;
			}
		}
		
	}
	
	/**
	 * Retrieves the tile at the given index
	 * @param n tile index
	 * @return tile at the given index
	 */
	public Tile getTile(int n) {
		return tilePieces[n];
	}
	
	/**
	 * 
	 * @return true if the key tiles is 
	 */
	public boolean wonGame() {
		return won;
	}
	
	/**
	 * Check if the move made requested by User is a valid move and sets the variable solved to true when the puzzle is solved
	 * 
	 * @param direction "left", "right", "up", or "down" to indicated the direction of the move
	 * @return true if the move is valid, false otherwise
	 */
	public boolean validMove(String direction) {
		//No tile is selected
		if(selected < 0)
			return false;
		
		//A tile is selected
		Tile s = tilePieces[selected];
		int r = s.row;
		int c = s.col;
		int h = s.height;
		int w = s.width;
		
		if(direction.equals("left")) {
			if(r == openR1 && c-1 == openC1) {
				if(h == 1) {
					s.setCol(openC1);
					numMove++;
					
					if(w == 1)
						openC1 = c;
					else if (w == 2)
						openC1 = c+1;
					
					return true;
				}
				else if(h == 2) {
					if(r+1 == openR2 && openC1 == openC2) {
						s.setCol(openC1);
						numMove++;
						
						if(w == 2) {
							if(s.isKey() && s.row == 3 && s.col == 1) {
								won = true;
							}
							openC1 = c+1;
							openC2 = c+1;
						}
						else if (w == 1) {
							openC1 = c;
							openC2 = c;
						}
						return true;
					}
				}
			}
			else if(r == openR2 && c-1 == openC2) {
				if(h == 1) {
					s.setCol(openC2);
					numMove++;
					
					if(w == 1)
						openC2 = c;
					else if(w == 2)
						openC2 = c+1;
					
					return true;
				}
				else if(h == 2) {
					if(r+1 == openR1 && openC1 == openC2) {
						s.setCol(openC2);
						numMove++;

						if(w == 2) {
							if(s.isKey() && s.row == 3 && s.col == 1) {
								won = true;
							}
							openC1 = c+1;
							openC2 = c+1;
						}
						else if (w == 1) {
							openC1 = c;
							openC2 = c;
						}
						return true;
					}
				}
			}
		}
		else if(direction.equals("right")) {
			if(w == 1 && r == openR1 && c+1 == openC1) {
				if(h == 1) {
					s.setCol(openC1);
					numMove++;
					openC1 = c;
					return true;
				}
				else if(h == 2 && openC1 == openC2 && r+1 == openR2) {
					s.setCol(openC1);
					numMove++;
					openC1 = c;
					openC2 = c;
					return true;
				}
			}
			else if(w == 2 && r == openR1 && c+2 == openC1) {
				if(h == 1) {
					s.setCol(c+1);
					numMove++;
					openC1 = c;
					return true;
				}
				else if (h == 2 && openC1 == openC2 && r+1 == openR2) {
					s.setCol(c+1);
					if(s.isKey() && s.row == 3 && s.col == 1) {
						won = true;
					}
					numMove++;
					openC1 = c;
					openC2 = c;
					return true;
				}
			}
			if(w == 1 && r == openR2 && c+1 == openC2) {
				if(h == 1) {
					s.setCol(openC2);
					numMove++;
					openC2 = c;
					return true;
				}
				else if(h == 2 && openC1 == openC2 && r+1 == openR1) {
					s.setCol(openC2);
					numMove++;
					openC1 = c;
					openC2 = c;
					return true;
				}
			}
			else if(w == 2 && r == openR2 && c+2 == openC2) {
				if(h == 1) {
					s.setCol(c+1);
					numMove++;
					openC2 = c;
					return true;
				}
				else if (h == 2 && openC1 == openC2 && r+1 == openR1) {
					s.setCol(c+1);
					if(s.isKey() && s.row == 3 && s.col == 1) {
						won = true;
					}
					numMove++;
					openC1 = c;
					openC2 = c;
					return true;
				}
			}
		}
		else if(direction.equals("up")) {
			if(r-1 == openR1 && c == openC1) {
				if(w == 1) {
					s.setRow(openR1);
					numMove++;
					
					if(h == 1)
						openR1 = r;
					else if (h == 2)
						openR1 = r+1;
					
					return true;
				}
				else if(w == 2) {
					if(openR1 == openR2 && c+1 == openC2) {
						s.setRow(openR1);
						numMove++;
						
						if(h == 2) {
							openR1 = r+1;
							openR2 = r+1;
						}
						else if (h == 1) {
							openR1 = r;
							openR2 = r;
						}
						return true;
					}
				}
			}
			if(r-1 == openR2 && c == openC2) {
				if(w == 1) {
					s.setRow(openR2);
					numMove++;
					
					if(h == 1)
						openR2 = r;
					else if (h == 2)
						openR2 = r+1;
					
					return true;
				}
				else if(w == 2) {
					if(openR1 == openR2 && c+1 == openC1) {
						s.setRow(openR2);
						numMove++;
						
						if(h == 2) {
							openR1 = r+1;
							openR2 = r+1;
						}
						else if (h == 1) {
							openR1 = r;
							openR2 = r;
						}
						return true;
					}
				}
			}
		}
		else if (direction.equals("down")){
			if(h == 1 && r+1 == openR1 && c == openC1) {
				if(w == 1) {
					s.setRow(openR1);
					numMove++;
					openR1 = r;
					return true;
				}
				else if(w == 2 && openR1 == openR2 && c+1 == openC2) {
					s.setRow(openR1);
					numMove++;
					openR1 = r;
					openR2 = r;
					return true;
				}
			}
			else if(h == 2 && c == openC1 && r+2 == openR1) {
				if(w == 1) {
					s.setRow(r+1);
					numMove++;
					openR1 = r;
					return true;
				}
				else if (w == 2 && openR1 == openR2 && c+1 == openC2) {
					s.setRow(r+1);
					if(s.isKey() && s.row == 3 && s.col == 1) {
						won = true;
					}
					numMove++;
					openR1 = r;
					openR2 = r;
					return true;
				}
			}
			if(h == 1 && r+1 == openR2 && c == openC2) {
				if(w == 1) {
					s.setRow(openR2);
					numMove++;
					openR2 = r;
					return true;
				}
				else if(w == 2 && openR1 == openR2 && c+1 == openC1) {
					s.setRow(openR2);
					numMove++;
					openR1 = r;
					openR2 = r;
					return true;
				}
			}
			else if(h == 2 && c == openC2 && r+2 == openR2) {
				if(w == 1) {
					s.setRow(r+1);
					numMove++;
					openR2 = r;
					return true;
				}
				else if (w == 2 && openR1 == openR2 && c+1 == openC1) {
					s.setRow(r+1);
					if(s.isKey() && s.row == 3 && s.col == 1) {
						won = true;
					}
					numMove++;
					openR1 = r;
					openR2 = r;
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Selects a tile with the give r and c position
	 * 
	 * @param r the x position of selected area
	 * @param c the y position of selected area
	 * @return true if at (r,c) there is a piece to be selected and false otherwise
	 */
	public boolean selectTile(int r, int c) {
		int k = -1; //counter
		
		for(Tile t: tilePieces) {
			if((t.row == r && t.col == c) || //if r and c = position of upper left square of tile
			   (t.isKey() && ((t.row == r && t.col + 1 == c) || (t.row + 1 == r && t.col == c ) || (t.row + 1 == r && t.col + 1 == c))) || // if is key check other 3 squares
			   (t.width > 1 && t.row == r && t.col + 1== c) || //if is 1x2 tile check right square
			   (t.height > 1 && t.row + 1== r && t.col == c)) //if is 2x1 tile check bottom square
			{
				selected = k+1; // set index of selected tile
				return true;
			}
			k++;
		}
		selected = -1;
		return false; //no tile was selected
	}
	
	/**
	 * Resets all the tiles back to it's initial positions
	 */
	public void resetToInitial() {
		for(int i = 0; i < 10; i++) {
			tilePieces[i].setRow(initial[0][i]);
			tilePieces[i].setCol(initial[1][i]);
		}
		selected = -1;
		numMove = 0;
		openR1 = 4;
		openC1 = 0;
		openR2 = 4;
		openC2 = 1;
	}
	
	/** 
	 * @return number of moves
	 */
	public int getMove() {
		return numMove;
	}
	
	/**
	 * 
	 * @return index of selected tile
	 */
	public int getSelected() {
		return selected;
	}
	
	//for testing purpose only
	public void setOpen1(int r, int c) {
		openR1 = r;
		openC1 = c;
	}
	
	//for testing purpose only
	public void setOpen2(int r, int c) {
		openR2 = r;
		openC2 = c;
	}
}


