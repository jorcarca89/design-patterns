package cl.jorcarca.designpatterns.behavioral.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrderByTest {
	@Test
	public void ascShouldBeOne() {
		assertEquals(1, OrderBy.ASC.getValue());
	}

	@Test
	public void descShouldBeMinusOne() {
		assertEquals(-1, OrderBy.DESC.getValue());
	}
}