package org.jpacman.test.framework.factory;

import org.jpacman.framework.factory.FactoryException;
import org.junit.Test;
import static org.junit.Assert.*;

public class FactoryExceptionTest {
	private FactoryException factoryTest;
	private FactoryException factoryTestWithCause;
	
	/**
     * Testing constructor FactoryException(String message) 
     */
	@Test
	public void testFactoryException() {
		String message1 = "Testing Factory Exception";
		factoryTest = new FactoryException(message1);
		try {
		   throw factoryTest;
		} catch (Exception e) {
			assertEquals(e.getMessage(), message1);
		}
	}
	
	/**
     * Testing constructor FactoryException(String message, Throwable cause) 
     */
	@Test
	public void testFactoryExceptionWithCause() {
		String message2 = "Testing Factory Exception With Cause";
		Throwable error = new Throwable("cause");
		factoryTestWithCause = new FactoryException(message2, error);
		try {
		    throw factoryTestWithCause;
	   } catch(Exception e) {
			assertEquals(e.getMessage(), message2);
			assertEquals(e.getCause(), error);
			}
	}
	
}
