package andreiSomesanBlackjack;

import java.util.ArrayList;

public class Dealer {
	
	ArrayList<Carte> manaDealer = new ArrayList<Carte>();

	public int calculPuncte() {
		int puncte = 0;
		for (int i = 0; i < manaDealer.size(); i++) {
			puncte += manaDealer.get(i).valoare;
		}
		return puncte;
		
	}
	
	@Override
	public String toString() {
		return "Dealer [manaDealer=" + manaDealer;
	}
}
