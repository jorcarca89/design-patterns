package cl.jorcarca.designpatterns.behavioral.chainofresponsibility;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OAuthHandlerTest {
	@Mock
	private Handler nextHandler;

	private OAuthHandler oAuthHandler;

	@Before
	public void setup() {
		this.oAuthHandler = new OAuthHandler(nextHandler);
	}

	@Test
	public void shouldHandleOAuthProvider() {
		AuthenticationProvider authenticationProvider = new OAuthProvider(
				"origin=origin;username=username;password=encryptedpassword");
		boolean actualValue = oAuthHandler.implementation(authenticationProvider);
		assertTrue("Couldn\'t handle OAuthProvider", actualValue);
	}
}
