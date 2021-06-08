package cl.jorcarca.designpatterns.behavioral.state;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StoppedTest {
	@Mock
	private Engine engine;
	private Stopped stopped;

	@Before
	public void setup() {
		this.engine = new Engine();
		this.stopped = new Stopped(engine);
	}

	@Test
	public void shouldTurnOn() {
		stopped.turnOn();
		assertEquals(true, engine.getState() instanceof Ready);
	}

	@Test
	public void shouldEmergencyStop() {
		assertEquals(true, engine.getState() instanceof Stopped);
	}

}
