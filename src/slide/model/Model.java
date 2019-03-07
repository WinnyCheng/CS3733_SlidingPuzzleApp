package slide.model;

/**
 * Top-level entity class
 */
public class Model {
	Puzzle puzzle;
	
	public Model(){
		puzzle = new Puzzle();
	}
	
	public Puzzle getPuzzle(){
		return this.puzzle;
	}
}
