package cl.jorcarca.designpatterns.behavioral.chainofresponsibility;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UsernameAndPasswordHandlerTest {
	@Mock
	private Handler nextHandler;

	private UsernameAndPasswordHandler usernameAndPasswordHandler;

	@Before
	public void setup() {
		this.usernameAndPasswordHandler = new UsernameAndPasswordHandler(nextHandler);
	}

	@Test
	public void shouldHandleUsernameAndPasswordProvider() {
		AuthenticationProvider usernameAndPasswordProvider = new UsernameAndPasswordProvider("username",
				"encryptedpassword");
		boolean actualValue = usernameAndPasswordHandler.implementation(usernameAndPasswordProvider);
		assertTrue("Couldn\'t handle UsernameAndPasswordProvider", actualValue);
	}

}
