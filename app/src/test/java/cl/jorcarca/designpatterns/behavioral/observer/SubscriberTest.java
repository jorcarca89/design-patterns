package cl.jorcarca.designpatterns.behavioral.observer;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SubscriberTest {
	private String subscriberName;
	private String publisherName;
	private Publisher publisher;
	private Subscriber subscriber;

	@Before
	public void setup() {
		this.subscriberName = "Subscriber";
		this.publisherName = "Publisher";
		this.subscriber = new Subscriber(subscriberName);
		this.publisher = new Publisher(publisherName);

		publisher.attachObserver(subscriber);
	}

	@Test
	public void shouldUpdate() {
		String expectedUpdatedTitle = "Updated title";
		assertEquals("", subscriber.getNewsTitle());
		publisher.setTitle(expectedUpdatedTitle);
		assertEquals(expectedUpdatedTitle, subscriber.getNewsTitle());

	}
}
