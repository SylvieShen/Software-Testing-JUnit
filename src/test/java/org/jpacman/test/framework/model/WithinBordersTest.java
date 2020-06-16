package org.jpacman.test.framework.model;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

import org.jpacman.framework.model.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class WithinBordersTest {
	private static final int WIDTH = 10;
	private static final int HEIGHT = 20;
	private Board board;
	private int x;
    private int y;	
    private boolean flag;
    
	public WithinBordersTest(int x, int y, boolean flag) {
        this.x = x;
        this.y = y;
        this.flag = flag;
        board = new Board(WIDTH, HEIGHT);
	}
	
    @Test
    public void testWithinBorders() {
    	assertEquals(flag,board.withinBorders(x, y));

    }
    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 0, 1,true }, 
                 { -1, 2,false }, 
                 { 10, 3,false }, 
                 { 9, 4,true }, 
                 { 1, 0,true }, 
                 { 2, -1,false }, 
                 { 3, 20,false },
                 { 4,19,true}  
           });
    }
}

