package slide.model;

import junit.framework.TestCase;

public class TestPuzzle extends TestCase {
	
	Puzzle game = new Puzzle();
	Tile[] tiles = {new Tile(2, 2, 1, 2),
					new Tile(2, 1, 0, 0),
					new Tile(2, 1, 2, 0),
					new Tile(2, 1, 1, 1),
					new Tile(1, 2, 3, 1),
					new Tile(1, 2, 4, 2),
					new Tile(1, 1, 0, 1),
					new Tile(1, 1, 0, 2),
					new Tile(1, 1, 0, 3),
					new Tile(1, 1, 3, 3)};

	public void testConstructor() {
		int i = 0;
		for(Tile t: tiles) {
			assertEquals(t.height, game.tilePieces[i].height);
			assertEquals(t.width, game.tilePieces[i].width);
			assertEquals(t.row, game.tilePieces[i].row);
			assertEquals(t.col, game.tilePieces[i].col);
			i++;
		}
	}
	
	public void testValidMove_1x2TileLeft() {
		game.selectTile(4, 2);

		assertEquals(true, game.validMove("left"));
		assertEquals(1, game.tilePieces[5].col);
		assertEquals(3, game.openC2);
	}
	
	public void testValidMove_1x2TileLeft2() {
		game.selectTile(4, 2);
		game.setOpen1(4, 1);
		game.setOpen2(4, 0);
		
		assertEquals(true, game.validMove("left"));
		assertEquals(1, game.tilePieces[5].col);
		assertEquals(3, game.openC1);
	}
	
	public void testValidMove_1x2TileRight() {
		game.selectTile(4, 2);
		game.validMove("left");

		assertEquals(true, game.validMove("right"));
		assertEquals(2, game.tilePieces[5].col);
		assertEquals(1, game.openC2);
	}
	
	public void testValidMove_1x2TileRight2() {
		game.selectTile(4, 2);
		game.setOpen1(4, 1);
		game.setOpen2(4, 0);
		game.validMove("left");
		
		assertEquals(true, game.validMove("right"));
		assertEquals(2, game.tilePieces[5].col);
		assertEquals(1, game.openC1);
	}
	
	public void testValidMove_1x2TileUp() {
		game.selectTile(3, 1);
		game.setOpen1(2, 1);
		game.setOpen2(2, 2);

		assertEquals(true, game.validMove("up"));
		assertEquals(2, game.tilePieces[4].row);
		assertEquals(3, game.openR1);
		assertEquals(3, game.openR2);
		assertEquals(1, game.openC1);
		assertEquals(2, game.openC2);
	}
	
	public void testValidMove_1x2TileUp2() {
		game.selectTile(3, 1);
		game.setOpen1(2, 2);
		game.setOpen2(2, 1);

		assertEquals(true, game.validMove("up"));
		assertEquals(2, game.tilePieces[4].row);
		assertEquals(3, game.openR1);
		assertEquals(3, game.openR2);
		assertEquals(2, game.openC1);
		assertEquals(1, game.openC2);
	}
	
	public void testValidMove_1x2TileDown() {
		game.selectTile(3, 1);
		game.setOpen1(4, 1);
		game.setOpen2(4, 2);

		assertEquals(true, game.validMove("down"));
		assertEquals(4, game.tilePieces[4].row);
		assertEquals(1, game.tilePieces[4].col);
		assertEquals(3, game.openR1);
		assertEquals(3, game.openR2);
		assertEquals(1, game.openC1);
		assertEquals(2, game.openC2);
	}
	
	public void testValidMove_1x2TileDown2() {
		game.selectTile(3, 1);
		game.setOpen1(4, 2);
		game.setOpen2(4, 1);

		assertEquals(true, game.validMove("down"));
		assertEquals(4, game.tilePieces[4].row);
		assertEquals(1, game.tilePieces[4].col);
		assertEquals(3, game.openR1);
		assertEquals(3, game.openR2);
		assertEquals(2, game.openC1);
		assertEquals(1, game.openC2);
	}
	
	public void testValidMove_1x1TileLeft() {
		game.selectTile(3, 3);
		game.setOpen1(3, 2);

		assertEquals(true, game.validMove("left"));
		assertEquals(3, game.tilePieces[9].row);
		assertEquals(2, game.tilePieces[9].col);
		assertEquals(3, game.openR1);
		assertEquals(3, game.openC1);
	}
	
	public void testValidMove_1x1TileLeft2() {
		game.selectTile(3, 3);
		game.setOpen2(3, 2);

		assertEquals(true, game.validMove("left"));
		assertEquals(3, game.tilePieces[9].row);
		assertEquals(2, game.tilePieces[9].col);
		assertEquals(3, game.openR2);
		assertEquals(3, game.openC2);
	}
	
	public void testValidMove_1x1TileRight() {
		game.selectTile(0, 1);
		game.setOpen1(0, 2);

		assertEquals(true, game.validMove("right"));
		assertEquals(0, game.tilePieces[6].row);
		assertEquals(2, game.tilePieces[6].col);
		assertEquals(0, game.openR1);
		assertEquals(1, game.openC1);
	}
	
	public void testValidMove_1x1TileRight2() {
		game.selectTile(0, 1);
		game.setOpen2(0, 2);

		assertEquals(true, game.validMove("right"));
		assertEquals(0, game.tilePieces[6].row);
		assertEquals(2, game.tilePieces[6].col);
		assertEquals(0, game.openR2);
		assertEquals(1, game.openC2);
	}
	
	public void testValidMove_1x1TileUp() {
		game.selectTile(3, 3);
		game.setOpen1(2, 3);

		assertEquals(true, game.validMove("up"));
		assertEquals(2, game.tilePieces[9].row);
		assertEquals(3, game.tilePieces[9].col);
		assertEquals(3, game.openR1);
		assertEquals(3, game.openC1);
	}
	
	public void testValidMove_1x1TileUp2() {
		game.selectTile(3, 3);
		game.setOpen2(2, 3);

		assertEquals(true, game.validMove("up"));
		assertEquals(2, game.tilePieces[9].row);
		assertEquals(3, game.tilePieces[9].col);
		assertEquals(3, game.openR2);
		assertEquals(3, game.openC2);
	}
	
	public void testValidMove_1x1TileDown() {
		game.selectTile(0, 2);
		game.setOpen1(1, 2);

		assertEquals(true, game.validMove("down"));
		assertEquals(1, game.tilePieces[7].row);
		assertEquals(2, game.tilePieces[7].col);
		assertEquals(0, game.openR1);
		assertEquals(2, game.openC1);
	}
	
	public void testValidMove_1x1TileDown2() {
		game.selectTile(0, 2);
		game.setOpen2(1, 2);

		assertEquals(true, game.validMove("down"));
		assertEquals(1, game.tilePieces[7].row);
		assertEquals(2, game.tilePieces[7].col);
		assertEquals(0, game.openR2);
		assertEquals(2, game.openC2);
	}

	public void testValidMove_2x1TileLeft() {
		game.selectTile(2, 1);
		game.setOpen1(1, 0);
		game.setOpen2(2, 0);

		assertEquals(true, game.validMove("left"));
		assertEquals(1, game.tilePieces[3].row);
		assertEquals(0, game.tilePieces[3].col);
		assertEquals(1, game.openR1);
		assertEquals(1, game.openC1);
		assertEquals(2, game.openR2);
		assertEquals(1, game.openC2);
	}
	
	public void testValidMove_2x1TileLeft2() {
		game.selectTile(2, 1);
		game.setOpen1(2, 0);
		game.setOpen2(1, 0);

		assertEquals(true, game.validMove("left"));
		assertEquals(1, game.tilePieces[3].row);
		assertEquals(0, game.tilePieces[3].col);
		assertEquals(2, game.openR1);
		assertEquals(1, game.openC1);
		assertEquals(1, game.openR2);
		assertEquals(1, game.openC2);
	}
	
	public void testValidMove_2x1TileRight() {
		game.selectTile(1, 1);
		game.setOpen1(1, 2);
		game.setOpen2(2, 2);

		assertEquals(true, game.validMove("right"));
		assertEquals(1, game.tilePieces[3].row);
		assertEquals(2, game.tilePieces[3].col);
		assertEquals(1, game.openR1);
		assertEquals(1, game.openC1);
		assertEquals(2, game.openR2);
		assertEquals(1, game.openC2);
	}
	
	public void testValidMove_2x1TileRight2() {
		game.selectTile(1, 1);
		game.setOpen1(2, 2);
		game.setOpen2(1, 2);

		assertEquals(true, game.validMove("right"));
		assertEquals(1, game.tilePieces[3].row);
		assertEquals(2, game.tilePieces[3].col);
		assertEquals(2, game.openR1);
		assertEquals(1, game.openC1);
		assertEquals(1, game.openR2);
		assertEquals(1, game.openC2);
	}
	
	public void testValidMove_2x1TileUp() {
		game.selectTile(3, 0);
		game.setOpen1(1, 0);

		assertEquals(true, game.validMove("up"));
		assertEquals(1, game.tilePieces[2].row);
		assertEquals(0, game.tilePieces[2].col);
		assertEquals(3, game.openR1);
		assertEquals(0, game.openC1);
	}
	
	public void testValidMove_2x1TileUp2() {
		game.selectTile(3, 0);
		game.setOpen2(1, 0);

		assertEquals(true, game.validMove("up"));
		assertEquals(1, game.tilePieces[2].row);
		assertEquals(0, game.tilePieces[2].col);
		assertEquals(3, game.openR2);
		assertEquals(0, game.openC2);
	}
	
	public void testValidMove_2x1TileDown() {
		game.selectTile(0, 0);
		game.setOpen1(2, 0);

		assertEquals(true, game.validMove("down"));
		assertEquals(1, game.tilePieces[1].row);
		assertEquals(0, game.tilePieces[1].col);
		assertEquals(0, game.openR1);
		assertEquals(0, game.openC1);
	}
	
	public void testValidMove_2x1TileDown2() {
		game.selectTile(0, 0);
		game.setOpen2(2, 0);

		assertEquals(true, game.validMove("down"));
		assertEquals(1, game.tilePieces[1].row);
		assertEquals(0, game.tilePieces[1].col);
		assertEquals(0, game.openR2);
		assertEquals(0, game.openC2);
	}
	
	public void testValidMove_2x2TileLeft() {
		game.selectTile(1, 2);
		game.setOpen1(1, 1);
		game.setOpen2(2, 1);

		assertEquals(true, game.validMove("left"));
		assertEquals(1, game.tilePieces[0].row);
		assertEquals(1, game.tilePieces[0].col);
		assertEquals(1, game.openR1);
		assertEquals(3, game.openC1);
		assertEquals(2, game.openR2);
		assertEquals(3, game.openC2);
	}
	
	public void testValidMove_2x2TileLeft2() {
		game.selectTile(1, 2);
		game.setOpen1(2, 1);
		game.setOpen2(1, 1);

		assertEquals(true, game.validMove("left"));
		assertEquals(1, game.tilePieces[0].row);
		assertEquals(1, game.tilePieces[0].col);
		assertEquals(2, game.openR1);
		assertEquals(3, game.openC1);
		assertEquals(1, game.openR2);
		assertEquals(3, game.openC2);
	}
	
	public void testValidMove_2x2TileRight() {
		game.selectTile(1, 2);
		game.setOpen1(1, 1);
		game.setOpen2(2, 1);
		assertEquals(true, game.validMove("left"));

		assertEquals(true, game.validMove("right"));
		assertEquals(1, game.tilePieces[0].row);
		assertEquals(2, game.tilePieces[0].col);
		assertEquals(1, game.openR1);
		assertEquals(1, game.openC1);
		assertEquals(2, game.openR2);
		assertEquals(1, game.openC2);
	}
	
	public void testValidMove_2x2TileRight2() {
		game.selectTile(1, 2);
		game.setOpen1(2, 1);
		game.setOpen2(1, 1);
		assertEquals(true, game.validMove("left"));

		assertEquals(true, game.validMove("right"));
		assertEquals(1, game.tilePieces[0].row);
		assertEquals(2, game.tilePieces[0].col);
		assertEquals(2, game.openR1);
		assertEquals(1, game.openC1);
		assertEquals(1, game.openR2);
		assertEquals(1, game.openC2);
	}
	
	public void testValidMove_2x2TileUp() {
		game.selectTile(1, 2);
		game.setOpen1(0, 2);
		game.setOpen2(0, 3);

		assertEquals(true, game.validMove("up"));
		assertEquals(0, game.tilePieces[0].row);
		assertEquals(2, game.tilePieces[0].col);
		assertEquals(2, game.openR1);
		assertEquals(2, game.openC1);
		assertEquals(2, game.openR2);
		assertEquals(3, game.openC2);
	}
	
	public void testValidMove_2x2TileUp2() {
		game.selectTile(1, 2);
		game.setOpen1(0, 3);
		game.setOpen2(0, 2);

		assertEquals(true, game.validMove("up"));
		assertEquals(0, game.tilePieces[0].row);
		assertEquals(2, game.tilePieces[0].col);
		assertEquals(2, game.openR1);
		assertEquals(3, game.openC1);
		assertEquals(2, game.openR2);
		assertEquals(2, game.openC2);
	}
	
	public void testValidMove_2x2TileDown() {
		game.selectTile(1, 2);
		game.setOpen1(3, 2);
		game.setOpen2(3, 3);

		assertEquals(true, game.validMove("down"));
		assertEquals(2, game.tilePieces[0].row);
		assertEquals(2, game.tilePieces[0].col);
		assertEquals(1, game.openR1);
		assertEquals(2, game.openC1);
		assertEquals(1, game.openR2);
		assertEquals(3, game.openC2);
	}
	
	public void testValidMove_2x2TileDown2() {
		game.selectTile(1, 2);
		game.setOpen1(3, 3);
		game.setOpen2(3, 2);

		assertEquals(true, game.validMove("down"));
		assertEquals(2, game.tilePieces[0].row);
		assertEquals(2, game.tilePieces[0].col);
		assertEquals(1, game.openR1);
		assertEquals(3, game.openC1);
		assertEquals(1, game.openR2);
		assertEquals(2, game.openC2);
	}
	
	public void testValidMoveFalseCases() {
		//key tile
		game.selectTile(1, 2);
		
		assertEquals(false, game.validMove("left"));
		assertEquals(false, game.validMove("right"));
		assertEquals(false, game.validMove("up"));
		assertEquals(false, game.validMove("down"));
		
		//2x1 tile
		game.selectTile(0,0);
		
		assertEquals(false, game.validMove("left"));
		assertEquals(false, game.validMove("right"));
		assertEquals(false, game.validMove("up"));
		assertEquals(false, game.validMove("down"));
		
		//1x2 tile
		game.selectTile(3, 1);
		assertEquals(false, game.validMove("left"));
		assertEquals(false, game.validMove("right"));
		assertEquals(false, game.validMove("up"));
		assertEquals(false, game.validMove("down"));
		
		//1x1 tile
		game.selectTile(3, 3);
		assertEquals(false, game.validMove("left"));
		assertEquals(false, game.validMove("right"));
		assertEquals(false, game.validMove("up"));
		assertEquals(false, game.validMove("down"));
	}
	
	public void testSelectTile() {
		assertEquals(true, game.selectTile(0, 0));
		assertEquals(1, game.selected);
		
		assertEquals(true, game.selectTile(0, 1));
		assertEquals(6, game.selected);
		
		assertEquals(true, game.selectTile(0, 2));
		assertEquals(7, game.selected);	
		
		assertEquals(true, game.selectTile(3, 1));
		assertEquals(4, game.selected);
		
		assertEquals(true, game.selectTile(2,  3));
		assertEquals(0, game.selected);
		
		assertEquals(true, game.selectTile(3, 2));
		assertEquals(4, game.selected);
		
		assertEquals(true, game.selectTile(3, 0));
		assertEquals(2, game.selected);
		
		assertEquals(false, game.selectTile(4, 5));
		
		assertEquals(false, game.selectTile(4, 0));
	}
	
	public void testResetToInitial() {
		
		game.selectTile(2, 0);
		game.validMove("down");
		game.selectTile(0, 0);
		game.validMove("down");
		game.selectTile(0, 1);
		game.validMove("left");
		
		game.resetToInitial();
		
		
		int i = 0;
		for(Tile t: tiles) {
			assertEquals(t.height, game.tilePieces[i].height);
			assertEquals(t.width, game.tilePieces[i].width);
			assertEquals(t.row, game.tilePieces[i].row);
			assertEquals(t.col, game.tilePieces[i].col);
			i++;
		}
		
	}
}
