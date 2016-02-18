package andreiSomesanBlackjack;

public class Carte {

	int valoare;
	String culoare;
	
	public Carte(int valoare, String culoare) {
		super();
		this.valoare = valoare;
		this.culoare = culoare;
	}

	@Override
	public String toString() {
		return culoare;
	}
}
