package fahrzeugev2;

public class LinienBus extends Bus implements OeffentlichesVerkehrsmittel {
	
	public String verkehrsverbund() {
		throw new UnsupportedOperationException();
	}

	public String linie() {
		throw new UnsupportedOperationException();
	}
}