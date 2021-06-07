package cl.jorcarca.designpatterns.behavioral.observer;

import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BaseObservableTest {
	private String observableName;
	private BaseObservable baseObservable;
	@Spy
	Observer observer1;
	@Spy
	Observer observer2;

	@Before
	public void setup() {
		this.observableName = "Publisher";
		this.baseObservable = new BaseObservable(observableName);
	}

	@Test
	public void shouldNotifyChanges() {
		when(observer1.getName()).thenReturn("Observer 1");
		when(observer2.getName()).thenReturn("Observer 2");

		baseObservable.attachObserver(observer1);
		baseObservable.attachObserver(observer2);

		baseObservable.notifyChanges();

		Mockito.verify(observer1, times(1)).update(baseObservable);
		Mockito.verify(observer2, times(1)).update(baseObservable);
	}
}
