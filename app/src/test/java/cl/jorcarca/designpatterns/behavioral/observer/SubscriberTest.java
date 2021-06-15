package cl.jorcarca.designpatterns.behavioral.observer;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SubscriberTest {
	@Mock
	private Publisher publisher;

	private String subscriberName = "Subscriber";
	private Subscriber subscriber;

	@Before
	public void setup() {
		subscriber = new Subscriber(subscriberName);
	}

	@Test
	public void shouldUpdate() {
		String expectedUpdatedTitle = "Updated title";
		when(publisher.getTitle()).thenReturn(expectedUpdatedTitle);

		assertEquals("", subscriber.getNewsTitle());

		subscriber.update(publisher);
		assertEquals(expectedUpdatedTitle, subscriber.getNewsTitle());
	}
}
