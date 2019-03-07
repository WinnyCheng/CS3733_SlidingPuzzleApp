package slide.model;

import junit.framework.TestCase;

public class TestTile extends TestCase {
	
	Tile t1 = new Tile(1, 2, 0, 3);
	Tile t2 = new Tile(2, 2, 3, 4);
	
	public void testConstructor() {
		assertEquals(1, t1.height);
		assertEquals(2, t1.width);
		assertEquals(0, t1.row);
		assertEquals(3, t1.col);
	}
	
	public void testIsKey() {
		assertEquals (true, t2.isKey());
	}
	
	public void testSetRow() {
		t2.setRow(5);
		assertEquals(5, t2.row);
	}
	
	public void testSetCol() {
		t2.setCol(0);
		assertEquals(0, t2.col);
	}
	
	public void testGetHeight() {
		assertEquals(2, t2.getHeight());
	}
	
	public void testGetWidth() {
		assertEquals(2, t1.getWidth());
	}
	
	public void testGetRow() {
		assertEquals(0, t1.getRow());
	}
	
	public void testGetCol() {
		assertEquals(4, t2.getCol());
	}
}
