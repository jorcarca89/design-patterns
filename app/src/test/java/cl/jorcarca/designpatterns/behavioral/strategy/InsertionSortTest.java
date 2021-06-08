package cl.jorcarca.designpatterns.behavioral.strategy;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InsertionSortTest {
	private InsertionSort sortStrategy;
	private Integer[] array = { 5, 4, 3, 2, 1 };
	private Integer[] expectedAscArray = { 1, 2, 3, 4, 5 };
	private Integer[] expectedDescArray = { 5, 4, 3, 2, 1 };

	@Before
	public void setup() {
		this.sortStrategy = new InsertionSort();
	}

	@Test
	public void shouldSortAscByDefault() {
		Integer[] result = sortStrategy.sort(array);

		assertArrayEquals(expectedAscArray, result);
	}

	@Test
	public void shouldSortAsc() {
		Integer[] result = sortStrategy.sort(array, OrderBy.ASC);

		assertArrayEquals(expectedAscArray, result);
	}

	@Test
	public void shouldSortDesc() {
		Integer[] result = sortStrategy.sort(array, OrderBy.DESC);

		assertArrayEquals(expectedDescArray, result);
	}
}
