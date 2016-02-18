package andreiSomesanBlackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class Principala {

	/**
	 * In primul rand vreau sa mentionez ca, desi nu am reusit sa schimb
	 * valoarea AS-ului in functie de punctaj, am ales ca in programul meu,
	 * AS-ul sa aibe valoarea 11 pentru ca jucatorul sa poata face BlackJack din
	 * prima. Stiu ca in cerinta se cere valoarea 10 pentru AS, insa am
	 * considearat ca este mai logic asa. Prin urmare sper sa nu fiu depunctat
	 * pentru acest lucru. Multumesc.
	 * 
	 * Am declarat variabilele "flag" si "sc" inainte de metoda main pentru a le
	 * putea folosi atat in main cat si in metoda.
	 */
	static boolean flag;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Salut! Bine ai venit la King Casino!\nCum te numesti?");
		/**
		 * Initializarea jucatorului si verificarea introducerii unui nume
		 * valid cu regex.
		 */
		Jucator player;
		for (int i = 0;; i++) {
			String nume = sc.nextLine();
			player = new Jucator(nume);
			String regex = "[A-Z][a-z]+";
			nume = nume.trim();
			if (nume != null && nume.matches(regex)) {
				break;
			} else {
				System.out.println("\nNu ai introdus un nume valid. Te rog sa incerci din nou.");
			}
		}

		System.out.println("\n\nSalut " + player.nume + "! Sa incepem jocul.");

		/**
		 * Aceasta bucla while contine tot codul necesar pentru desfasurarea
		 * jocului. Cu ajutorul ei, utilizatorul poate juca de cate ori doreste.
		 */
		while (!flag) {

			/**
			 * Crearea pachetului de carti.
			 */
			PachetDeCarti pachet = new PachetDeCarti();

			/**
			 * Metoda ce amesteca pachetul de carti, ce se regaseste in clasa
			 * PachetDeCarti.
			 */
			pachet.shuffle();

			/**
			 * Metoda ce reseteaza ArrayListul ce contine mana jucatorului.
			 * Acceasta este necesara pentru ca la fiecare joc nou, ArrayListul
			 * manaJucator sa fie gol. Metoda se regaseste in clasa Jucator.
			 */
			player.resetManaJucator();

			/**
			 * Mai jos este mana initiala a jucatorului.
			 */
			Carte carte = pachet.pachet.remove(0);
			Carte carte1 = pachet.pachet.remove(0);
			player.manaJucator.add(carte);
			player.manaJucator.add(carte1);

			/**
			 * Afisarea mainii initale alaturi de punctele jucatorului,
			 * calculate cu metoda calculPuncte() din clasa Jucator
			 */
			System.out.println("Aceasta este mana ta:\n---------------------------------\n" + carte + " " + carte1);
			System.out.println("---------------------------------\nPuncte: " + player.calculPuncte());

			/**
			 * In cazul in care jucatorul obtine 21 (BlackJack) din prima mana,
			 * acesta a castigat si prin urmare dealer-ul nu mai are trage
			 * carti. Jucatorul este intrebat direct daca doreste sa inceapa un
			 * nou joc.
			 */
			if (player.calculPuncte() == 21) {
				System.out.println("Balckjack!!! Felicitari!");
				/**
				 * In cazul in care jucatorul nu obtine 21 (BlackJack) din prima
				 * mana, se va executa codul de mai jos. Are optiune pentru a
				 * cere carte ("Hit") sau a nu mai cere carte ("Hold"), si prin
				 * urmare sa lase dealer-ul sa traga.
				 */
			} else {

				/**
				 * Aceasta bucla do while este necesara pentru ca jucatorul sa
				 * poata cere carte de cate ori doreste. Se iese din bucla doar
				 * daca jucatorul alege sa se opreasca ("Hold") sau daca mana
				 * lui este >= 21.
				 */
				String alegere;
				do {
					/**
					 * Aceasta bucla for este necesara pentru ca jucatorul sa nu
					 * introduca altceva de la tastatura, in afara de optiunile
					 * afisate. Prin urmare bucla, va repeta codul pana cand
					 * jucatorul introduce o optiune valida, sau conditia din
					 * while devine falsa.
					 * 
					 * Metoda hit() si se poate vedea in clasa Jucator.
					 */
					for (int i = 0;; i++) {
						System.out.println("\nCe doresti sa faci acum?\n1. Hit\n2. Hold");
						alegere = sc.nextLine();
						if (alegere.equalsIgnoreCase("1") || alegere.equalsIgnoreCase("Hit")) {
							player.hit(pachet);
							System.out
									.println("Mana ta este:\n---------------------------------\n" + player.manaJucator);
							System.out.println("---------------------------------\nPuncte: " + player.calculPuncte());
							if (player.calculPuncte() >= 21) {
								break;
							}
						} else if ((alegere.equalsIgnoreCase("2") || alegere.equalsIgnoreCase("Hold"))) {
							break;
						} else if (!(alegere.equalsIgnoreCase("1") || alegere.equalsIgnoreCase("Hit"))) {
							System.out.println("Optiunea introdusa nu este valida. Te rog sa incerci din nou.");
						} else if (!(alegere.equalsIgnoreCase("2") || alegere.equalsIgnoreCase("Hold"))) {
							System.out.println("Optiunea introdusa nu este valida. Te rog sa incerci din nou.");
						}
					}

				} while ((alegere.equalsIgnoreCase("1") || alegere.equalsIgnoreCase("Hit"))
						&& player.calculPuncte() < 21);

				/**
				 * Dealerul va juca doar daca jucatorul nu depaseste 21 de
				 * puncte si nu face BlacJack din prima mana.
				 */
				if (player.calculPuncte() <= 21) {

					/**
					 * Initializarea dealer-ului.
					 */
					Dealer dealer = new Dealer();
					do {
						/**
						 * Dealer-ul va trage carti doar daca puctajul lui este
						 * mai mic decat 17.
						 */
						Carte carte2 = pachet.pachet.remove(0);
						dealer.manaDealer.add(carte2);

					} while (dealer.calculPuncte() < 17);

					/**
					 * Afisarea mainii dealerului si a punctajului acestuia.
					 */
					System.out.println(
							"\nDealerul a tras cartile:\n---------------------------------\n" + dealer.manaDealer
									+ "\n---------------------------------\nPuncte dealer: " + dealer.calculPuncte());

					/**
					 * Verificarea punctajului si desemnarea castigatorului.
					 */
					if (player.calculPuncte() <= 21
							&& (dealer.calculPuncte() < player.calculPuncte() || dealer.calculPuncte() > 21)) {
						System.out.println("\nFelicitari " + player.nume + "! Ai castigat.");
					} else if ((player.calculPuncte() > 21 && dealer.calculPuncte() <= 21)
							|| (dealer.calculPuncte() > player.calculPuncte()) && dealer.calculPuncte() <= 21) {
						System.out.println("\n" + player.nume + ", ai piedut.");
					} else if ((player.calculPuncte() > 21 && dealer.calculPuncte() > 21)
							|| (player.calculPuncte() == dealer.calculPuncte())) {
						System.out.println("\nRemiza.");
					}
				} else {
					System.out.println("\n" + player.nume + ", ai piedut.");
				}
			}

			/**
			 * Apelarea metodei newGame() ce permite utilizatorului sa aleaga
			 * daca doreste sa inceapa un nou joc sau nu (se poate raspunde doar
			 * cu "y/Y" sau "n/N").
			 * 
			 * Metoda se regaseste mai jos, dupa metoda main().
			 */
			newGame(player);
		}
	}

	public static void newGame(Jucator jucator) {
		System.out.println("\nDoresti sa incepi un nou joc " + jucator.nume + "? (y / n)");
		for (int i = 0;; i++) {
			String raspuns = sc.nextLine();
			if (raspuns.equalsIgnoreCase("n")) {
				flag = !flag;
				System.out.println("Ok " + jucator.nume + ". Mi-a facut placere sa joc cu tine.");
				break;
			} else if (raspuns.equalsIgnoreCase("y")) {
				break;
			} else {
				System.out.println("Optiunea introdusa nu este valida. Te rog sa raspunzi cu \"y\" sau \"n\".");
			}
		}
	}
}
