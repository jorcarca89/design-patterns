package cl.jorcarca.designpatterns.behavioral.strategy;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

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

	@Test
	public void test() {
		var k = new ArrayList<>();
        k.add("hola");
        k.add(11);
		k.add(OrderBy.ASC);
		System.out.println(k.toString());
		for(var element: k) {
		System.out.println(element.getClass().getName());

		}
	}
}