package org.jpacman.test.framework.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.jpacman.framework.model.Board;
import org.jpacman.framework.model.Direction;
import org.jpacman.framework.model.Sprite;
import org.jpacman.framework.model.Ghost;
import org.jpacman.framework.model.IBoardInspector.SpriteType;
import org.jpacman.framework.model.Player;
import org.jpacman.framework.model.Wall;
import org.jpacman.framework.model.Food;
import org.jpacman.framework.model.Tile;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	private Board board;
	private static final int WIDTH = 10;
	private static final int HEIGHT = 20;
	private final Sprite sprite = new Sprite () {};
	private final Player player = new Player () {};
	private final Ghost ghost = new Ghost () {};
	private final Food food = new Food () {};
	private final Wall wall = new Wall () {};
	private final Tile tile1 = new Tile(-2, -3);
	
	@Before
	public void setUp() throws Exception {
		board = new Board(WIDTH, HEIGHT);
	}
	
	/*
	 * Test Assertion error of constructor when width is smaller than 0.
	 */
    @Test(expected = AssertionError.class)
    public void testConstructorWidth() {
    	board  = new Board(-1, 20);
    }
    /*
	 * Test Assertion error of constructor when height is smaller than 0.
	 */
    @Test(expected = AssertionError.class)
    public void testConstructorHeight() {
    	board  = new Board(10, -1);
    }

	/*
	 * Test method getWidth()
	 */
	@Test
	public void testGetWidth () {
		assertEquals(WIDTH, board.getWidth());
	}
	
	/*
	 * Test method getHeight()
	 */
	@Test
	public void testGetHeight () {
		assertEquals(HEIGHT, board.getHeight());
	}
	
	
	/*
	 * Test method withinBoarders()
	 */
	@Test
	public void testWithinBoarders () {
		assertTrue(board.withinBorders(0, 19));
		assertTrue(board.withinBorders(9, 19));
		assertTrue(board.withinBorders(0, 0));
		assertTrue(board.withinBorders(9, 0));
		assertFalse(board.withinBorders(-1, -1));
		assertFalse(board.withinBorders(-1, 2));
		assertFalse(board.withinBorders(1, 20));
		assertFalse(board.withinBorders(10, 19));
	}
	
	/*
	 * Test the assertion error of tileAt() 
	 * when tile (x, y) is out of boarders;
	 */
	@Test(expected = AssertionError.class)
	    public void testTileAtOutsideBorders() {
	    	board.tileAt(-1, -1);
	    }

	/*
	 * Test the normal function of method tileAt()
	 */
    @Test
    public void testTileAtReturnValue() {
    	assertEquals(1, board.tileAt(1, 1).getX());
    	assertEquals(2, board.tileAt(1, 2).getY());
    	assertEquals(9, board.tileAt(9,19).getX());
    	assertEquals(19, board.tileAt(9,19).getY());
    }

	
	
	/*
	 * Test the assertion error of put() 
	 * when tile (x, y) is out of boarders.
	 */
	@Test (expected = AssertionError.class)
	public void testPutOutsideBorders() {
		board.put(sprite, -2 ,-2);
	}
	
	/*
	 * Test the assertion error of put() 
	 * when sprite is null.
	 */
	@Test (expected = AssertionError.class)
	public void testPutSpriteIsNull() {
		board.put(null, 1 , 1);
	}
	
	/*
	 * Test the assertion error of put() 
	 * when tile has been occupied.
	 */
	@Test (expected = AssertionError.class)
	public void testPutTileOccupied() {
		player.occupy(board.tileAt(1, 1));
		board.put(player, 1 , 1);
	}
	
	
	
	/*
	 * Test assertion error of SpriteAt()  
	 * when tile (x ,y) is out of boarders.
	 */
    @Test(expected = AssertionError.class)
    public void testSpriteAtOutsideBorders() {
        board.spriteAt(-1,-1);
    }
	/*
	 * Test normal function of method SpriteAt().
	 */
    @Test
	public void testSpriteAt() {
        board.put(ghost, 4, 5);   	
        board.put(food, 4, 6);
        board.put(player, 7, 10);
        board.put(wall, 8, 18);
        assertEquals(ghost, board.spriteAt(4, 5));
        assertEquals(food, board.spriteAt(4, 6));
        assertEquals(player, board.spriteAt(7, 10));
        assertEquals(wall, board.spriteAt(8, 18));
        assertEquals(null, board.spriteAt(9, 19));
    }
    

	/*
	 * Test assertion error of SpriteTypeAt() 
	 * when tile (x ,y) is out of boarders.
	 */
    @Test(expected = AssertionError.class)
    public void testSpriteTypeAtOutsideBorders() {
        board.spriteTypeAt(-1,-1);
    }
    
    
    /*
	 * Test normal function of method SpriteTypeAt().
	 */
    @Test
    public void testSpriteTypeAtCorrect() {
    	 board.put(ghost, 4, 5);   	
         board.put(food, 4, 6);
         board.put(player, 7, 10);
         board.put(wall, 8, 18);
    	assertEquals(SpriteType.GHOST, board.spriteTypeAt(4, 5));
    	assertEquals(SpriteType.FOOD, board.spriteTypeAt(4, 6));
    	assertEquals(SpriteType.PLAYER, board.spriteTypeAt(7, 10));
    	assertEquals(SpriteType.WALL, board.spriteTypeAt(8, 18));
    	assertEquals(SpriteType.EMPTY, board.spriteTypeAt(9, 19));
    }
    
    
           /*Three Test Cases for the method tileAtOffset()*/
    /*
   	 * Test assertion error when the start tile is null.
   	 */
    
    @Test(expected = AssertionError.class) 
    public void testTileAtOffsetStartNull() {
    	board.tileAtOffset(null, 1, 1);
    }
       
    /*
   	 * Test assertion error when the start tile is out of borders
   	 */
    @Test(expected = AssertionError.class) 
    public void testTileAtOffsetStartOutsideBorders() {
    	board.tileAtOffset(tile1, 1, 1);
    }
 

    /*
	 * Test normal function of method tileAtOffset().
	 */
    @Test
    public void testTileAtOffsetCorrect() {
    	assertEquals(board.tileAt(2, 2), board.tileAtOffset(board.tileAt(3, 3), -1, -1));
    	assertEquals(board.tileAt(2, 5), board.tileAtOffset(board.tileAt(3, 3), -1, 2));
    	assertEquals(board.tileAt(5, 2), board.tileAtOffset(board.tileAt(3, 3), 2, -1));
    	assertEquals(board.tileAt(6, 6), board.tileAtOffset(board.tileAt(3, 3), 3, 3));
    }

    /*
   	 * Test normal function of method tileAtDirection().
   	 */
    @Test
    public void testTileAtDirection() {
    	assertEquals(board.tileAt(2,3),board.tileAtDirection(board.tileAt(3,3),Direction.LEFT));
    	assertEquals(board.tileAt(3,2),board.tileAtDirection(board.tileAt(3,3),Direction.UP));
    	assertEquals(board.tileAt(3,4),board.tileAtDirection(board.tileAt(3,3),Direction.DOWN));
    	assertEquals(board.tileAt(4,3),board.tileAtDirection(board.tileAt(3,3),Direction.RIGHT));
    }
    
    /*
   	 * Test normal function of method onBoardMessage().
   	 */
    @Test
    public void testOnBoardMessage() {
    	try {
    		board.tileAt(-2,-2);
    	}catch(AssertionError e) {
    		assertEquals("PRE: "+"(" + -2 + ", " + -2 + ")"
    				+ "not on board of size "
    				+ 10 + " * " + 20, e.getMessage());
    	}
    }


}

