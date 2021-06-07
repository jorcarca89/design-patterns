package cl.jorcarca.designpatterns.behavioral.chainofresponsibility;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BaseHandlerTest {
	@Spy
	private Handler nextHandler;
	@Mock
	private AuthenticationProvider authenticationProvider;
	private BaseHandler baseHandlerWithoutNextHandler;
	private BaseHandler baseHandlerWithNextHandler;

	public static class ConcreteBaseHandler extends BaseHandler {
		public ConcreteBaseHandler() {
			super();
		}

		public ConcreteBaseHandler(Handler nextHandler) {
			super(nextHandler);
		}

		@Override
		public boolean implementation(AuthenticationProvider authenticationProvider) {
			return false;
		}
	}

	@Before
	public void setup() {
		this.baseHandlerWithoutNextHandler = new ConcreteBaseHandler();
		this.baseHandlerWithNextHandler = new ConcreteBaseHandler(nextHandler);
	}

	@Test
	public void shouldPassNextHandlerIfCannotHandleTheProvider() {
		baseHandlerWithNextHandler.handle(authenticationProvider);
		Mockito.verify(nextHandler).handle(authenticationProvider);
	}

	@Test
	public void shouldNotPassNextHandlerIfDoesNotHaveNextHander() {
		baseHandlerWithoutNextHandler.handle(authenticationProvider);
		Mockito.verifyNoInteractions(nextHandler);
	}
}
