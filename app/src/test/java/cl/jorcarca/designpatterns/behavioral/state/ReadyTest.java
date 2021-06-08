package cl.jorcarca.designpatterns.behavioral.state;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ReadyTest {
	@Mock
	private Engine engine;
	private Ready ready;

	@Before
	public void setup() {
		this.engine = new Engine();
		this.ready = new Ready(engine);
	}

	@Test
	public void shouldDoWork() {
		ready.doWork();
		assertEquals(true, engine.getState() instanceof Working);
	}

	@Test
	public void shouldStop() {
		ready.stop();
		assertEquals(true, engine.getState() instanceof Stopped);
	}
}
