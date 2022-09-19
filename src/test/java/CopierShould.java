import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
	@Test
	public void
	copies_many_char() {
		ArgumentCaptor<Character> input =  ArgumentCaptor.forClass(Character.class);
		given(source.GetChar()).willReturn('R', 'E', 'S', 'P', 'E', 'C', 'T', '\n');

		new Copier(source, destination).Copy();
		verify(destination, times(7)).SetChar(input.capture());
		String result = input.getAllValues().toString();

		assertEquals("[R, E, S, P, E, C, T]", result);
	}
}