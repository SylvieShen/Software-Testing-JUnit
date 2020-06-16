package org.jpacman.test.framework.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.jpacman.framework.model.Board;
import org.jpacman.framework.view.BoardView;
import org.junit.Test;

public class BoardViewTest {
	@Test
	public void boardViewTest(){
		try {
			Board board = new Board(10, 20);
			BoardView bv = new BoardView(board);
			assertEquals((20 + 1) * (10 + 1), bv.windowWidth());
			assertEquals((20 + 1) * (20 + 1), bv.windowHeight());
		} catch (Exception e) {
			fail("boardView testing failed!");
		}
	}
}
