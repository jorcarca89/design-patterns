package cl.jorcarca.designpatterns.behavioral.state;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EngineTest {
	private Engine engine;

	@Before
	public void setup() {
		this.engine = new Engine();
	}

	@Test
	public void shouldBeStoppedOnNew() {
		assertEquals(true, engine.getState() instanceof Stopped);
	}

	@Test
	public void shouldTurnOn() {
		engine.turnOn();
		assertEquals(true, engine.getState() instanceof Ready);
	}

	@Test
	public void whenIsReadyThenCannotDoEmergencyStop() {
		engine.turnOn();
		engine.emergencyStop();
		assertEquals(true, engine.getState() instanceof Ready);
	}

	@Test
	public void shouldDoWork() {
		engine.turnOn();
		engine.doWork();
		assertEquals(true, engine.getState() instanceof Working);
	}

	@Test
	public void whenIsWorkingThenCannotBeReady() {
		engine.turnOn();
		engine.doWork();
		assertEquals(true, engine.getState() instanceof Working);
	}

	@Test
	public void shouldStop() {
		engine.turnOn();
		engine.stop();
		assertEquals(true, engine.getState() instanceof Stopped);
	}

	@Test
	public void shouldEmergencyStop() {
		engine.turnOn();
		engine.doWork();
		engine.emergencyStop();
		assertEquals(true, engine.getState() instanceof Stopped);
	}

	@Test
	public void whenIsStoppedThenCannotBeWorking() {
		engine.doWork();
		assertEquals(true, engine.getState() instanceof Stopped);
	}
}
