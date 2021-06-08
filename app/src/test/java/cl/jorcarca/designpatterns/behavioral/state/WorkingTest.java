package cl.jorcarca.designpatterns.behavioral.state;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WorkingTest {
	@Mock
	private Engine engine;
	private Working working;

	@Before
	public void setup() {
		this.engine = new Engine();
		this.working = new Working(engine);
	}

	@Test
	public void shouldStop() {
		working.stop();
		assertEquals(true, engine.getState() instanceof Stopped);
	}

	@Test
	public void shouldEmergencyStop() {
		working.emergencyStop();
		assertEquals(true, engine.getState() instanceof Stopped);
	}
}
