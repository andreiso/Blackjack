package andreiSomesanBlackjack;

import java.util.ArrayList;
import java.util.Collections;

public class PachetDeCarti {

	ArrayList<Carte> pachet = new ArrayList<Carte>();

	public PachetDeCarti() {
		super();
		
		Carte carteASi = new Carte(11, "AS♥");
		Carte carte2i = new Carte(2, "2♥");
		Carte carte3i = new Carte(3, "3♥");
		Carte carte4i = new Carte(4, "4♥");
		Carte carte5i = new Carte(5, "5♥");
		Carte carte6i = new Carte(6, "6♥");
		Carte carte7i = new Carte(7, "7♥");
		Carte carte8i = new Carte(8, "8♥");
		Carte carte9i = new Carte(9, "9♥");
		Carte carte10i = new Carte(10, "10♥");
		Carte carteJi = new Carte(10, "J♥");
		Carte carteQi = new Carte(10, "Q♥");
		Carte carteKi = new Carte(10, "K♥");

		Carte carteASf = new Carte(11, "AS♠");
		Carte carte2f = new Carte(2, "2♠");
		Carte carte3f = new Carte(3, "3♠");
		Carte carte4f = new Carte(4, "4♠");
		Carte carte5f = new Carte(5, "5♠");
		Carte carte6f = new Carte(6, "6♠");
		Carte carte7f = new Carte(7, "7♠");
		Carte carte8f = new Carte(8, "8♠");
		Carte carte9f = new Carte(9, "9♠");
		Carte carte10f = new Carte(10, "10♠");
		Carte carteJf = new Carte(10, "J♠");
		Carte carteQf = new Carte(10, "Q♠");
		Carte carteKf = new Carte(10, "K♠");

		Carte carteASr = new Carte(11, "AS♦");
		Carte carte2r = new Carte(2, "2♦");
		Carte carte3r = new Carte(3, "3♦");
		Carte carte4r = new Carte(4, "4♦");
		Carte carte5r = new Carte(5, "5♦");
		Carte carte6r = new Carte(6, "6♦");
		Carte carte7r = new Carte(7, "7♦");
		Carte carte8r = new Carte(8, "8♦");
		Carte carte9r = new Carte(9, "9♦");
		Carte carte10r = new Carte(10, "10♦");
		Carte carteJr = new Carte(10, "J♦");
		Carte carteQr = new Carte(10, "Q♦");
		Carte carteKr = new Carte(10, "K♦");

		Carte carteASt = new Carte(11, "AS♣");
		Carte carte2t = new Carte(2, "2♣");
		Carte carte3t = new Carte(3, "3♣");
		Carte carte4t = new Carte(4, "4♣");
		Carte carte5t = new Carte(5, "5♣");
		Carte carte6t = new Carte(6, "6♣");
		Carte carte7t = new Carte(7, "7♣");
		Carte carte8t = new Carte(8, "8♣");
		Carte carte9t = new Carte(9, "9♣");
		Carte carte10t = new Carte(10, "10♣");
		Carte carteJt = new Carte(10, "J♣");
		Carte carteQt = new Carte(10, "Q♣");
		Carte carteKt = new Carte(10, "K♣");

		pachet.add(carteASi);
		pachet.add(carte2i);
		pachet.add(carte3i);
		pachet.add(carte4i);
		pachet.add(carte5i);
		pachet.add(carte6i);
		pachet.add(carte7i);
		pachet.add(carte8i);
		pachet.add(carte9i);
		pachet.add(carte10i);
		pachet.add(carteJi);
		pachet.add(carteQi);
		pachet.add(carteKi);

		pachet.add(carteASf);
		pachet.add(carte2f);
		pachet.add(carte3f);
		pachet.add(carte4f);
		pachet.add(carte5f);
		pachet.add(carte6f);
		pachet.add(carte7f);
		pachet.add(carte8f);
		pachet.add(carte9f);
		pachet.add(carte10f);
		pachet.add(carteJf);
		pachet.add(carteQf);
		pachet.add(carteKf);

		pachet.add(carteASr);
		pachet.add(carte2r);
		pachet.add(carte3r);
		pachet.add(carte4r);
		pachet.add(carte5r);
		pachet.add(carte6r);
		pachet.add(carte7r);
		pachet.add(carte8r);
		pachet.add(carte9r);
		pachet.add(carte10r);
		pachet.add(carteJr);
		pachet.add(carteQr); 
		pachet.add(carteKr);

		pachet.add(carteASt);
		pachet.add(carte2t);
		pachet.add(carte3t);
		pachet.add(carte4t);
		pachet.add(carte5t);
		pachet.add(carte6t);
		pachet.add(carte7t);
		pachet.add(carte8t);
		pachet.add(carte9t);
		pachet.add(carte10t);
		pachet.add(carteJt);
		pachet.add(carteQt);
		pachet.add(carteKt);
	}

	@Override
	public String toString() {
		return "PachetDeCarti [pachet=" + pachet + "]";
	}
	
	public void shuffle() {
		Collections.shuffle(pachet);
	}
	
	

	
	
	
}
