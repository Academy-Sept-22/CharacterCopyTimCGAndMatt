import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)

public class CopierShould {
	@Mock public Source source;
	@Mock public Destination destination;

	@Test
	public void
	copies_one_char() {
		given(source.GetChar()).willReturn('M');

		new Copier(source, destination).Copy();

		verify(destination).SetChar('M');
	}
}