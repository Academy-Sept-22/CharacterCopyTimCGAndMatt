public class Copier {
	private Source source;
	private Destination destination;

	public Copier(Source source, Destination destination) {
		this.source = source;
		this.destination = destination;
	}
	public void Copy() {
		char sourceCharacter = source.GetChar();
		while (sourceCharacter != '\n') {
			destination.SetChar(sourceCharacter);
			sourceCharacter = source.GetChar();
		}
	}
}
