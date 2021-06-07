package cl.jorcarca.designpatterns.behavioral.observer;

import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PublisherTest {
	@Spy
	private Publisher publisher;

	@Test
	public void shouldNotifyTitleChanges() {
		publisher.setTitle("Changing title");
		Mockito.verify(publisher, times(1)).notifyChanges();
	}
}
