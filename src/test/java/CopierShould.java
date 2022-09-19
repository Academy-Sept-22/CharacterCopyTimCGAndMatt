import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.xml.sax.InputSource;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)

public class CopierShould {

	@Mock public ISource iSource;
	@Mock public IDestination iDestination;

	@Test
	public void
	this_should_do_something() {
		given(iSource.GetChar()).willReturn('M');
		new Copier().Copy();

		verify(iDestination).SetChar('M');
	}
}/**/