package cl.jorcarca.designpatterns.behavioral.chainofresponsibility;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
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
		assertTrue("should handle OAuthProvider", actualValue);
	}
}
