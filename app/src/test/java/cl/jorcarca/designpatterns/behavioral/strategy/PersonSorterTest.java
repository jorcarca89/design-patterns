package cl.jorcarca.designpatterns.behavioral.strategy;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PersonSorterTest {
	private PersonSorter personSorter;
	private Person[] people1 = { new Person("A", 180), new Person("B", 150), new Person("C", 200) };
	private Person[] people2 = { new Person("A", 180), new Person("B", 150), new Person("C", 200) };
	private Person[] expectedOrder = { new Person("B", 150), new Person("A", 180), new Person("C", 200) };

	@Before
	public void setup() {
	}

	@Test
	public void bubbleSortAndInsertionSortProducesSameResult() {
		Person[] bubbleSortResult;
		Person[] insertionSortResult;
		personSorter = new PersonSorter(new BubbleSort());
		bubbleSortResult = personSorter.sortPeople(people1, OrderBy.ASC);
		personSorter.setSortStrategy(new InsertionSort());
		insertionSortResult = personSorter.sortPeople(people2, OrderBy.ASC);
		assertArrayEquals(expectedOrder, bubbleSortResult);
		assertArrayEquals(expectedOrder, insertionSortResult);

	}
}
