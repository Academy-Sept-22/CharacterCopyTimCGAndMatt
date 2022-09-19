import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)

public class CopierShould {
	@Mock public Source source;
	@Mock public Destination destination;

	@Test
	public void
	copies_one_char() {
		given(source.GetChar()).willReturn('M', '\n');

		new Copier(source, destination).Copy();

		verify(destination).SetChar('M');
	}
	@Test
	public void
	copies_two_char() {
		given(source.GetChar()).willReturn('M', 'C', '\n');

		new Copier(source, destination).Copy();

		InOrder inOrder = inOrder(destination);

		inOrder.verify(destination).SetChar('M');
		inOrder.verify(destination).SetChar('C');

	}
}