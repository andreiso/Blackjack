package andreiSomesanBlackjack;

import java.util.ArrayList;

public class Jucator {
	
	String nume;
	ArrayList<Carte> manaJucator = new ArrayList<Carte>();

	public Jucator(String nume) {
		super();
		this.nume = nume;
	}

	public void hit(PachetDeCarti pachet) {
		Carte carte = pachet.pachet.remove(0);
		manaJucator.add(carte);
		System.out.println("\nAi tras cartea: " + carte);
		
	}

	public int calculPuncte() {
		int puncte = 0;
		for (int i = 0; i < manaJucator.size(); i++) {
			puncte += manaJucator.get(i).valoare;			
		}
		return puncte;
	}
	
	public void resetManaJucator() {
		for (int i = 0; i < manaJucator.size(); i++) {
			manaJucator.remove(i);
			i--;
		}
	}
	
	@Override
	public String toString() {
		return "Jucator [manaJucator=" + manaJucator;
	}

	
}
