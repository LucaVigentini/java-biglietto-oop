package it.biglietti;

import java.util.Scanner;

//@author MarcoFabretti,  AndreaConti33, LucaVigentini, FrancescaPompi

public class Biglietteria {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		boolean valido = true;
		int km = 0;
		int eta = 0;
		String sceltaBiglietto;
		Biglietto biglietto = null;
		boolean valid = false;

		do {
			System.out.println("Inserire numero di chilometri da percorrere: ");
			km = scan.nextInt();
			System.out.println("Hai digitato " + km + " chilometri.");

			System.out.println("Inserire l'età del passeggero: ");
			eta = scan.nextInt();
			System.out.println("Hai digitato " + eta + " anni");

			System.out.println("Scegliere biglietto normale (30 giorni) o flessibile (90 giorni): ");
			scan.nextLine();
			
			do {
				sceltaBiglietto = scan.nextLine().toLowerCase();
				if (sceltaBiglietto.equals("normale")) {
					valido = false;
					break;
				} else if (sceltaBiglietto.equals("flessibile")) {
					valido = true;
					break;
				} else {
					System.out.println("Scrivi normale o flessibile.");
				}
			} while (!sceltaBiglietto.equals("normale") || !sceltaBiglietto.equals("flessibile"));

			try {
				biglietto = new Biglietto(km, eta, valido);
				valid = true;
			} catch (Exception e) {
				valid = false;
			}

		} while (valid == false);

		System.out.println("Ciao");
		System.out.println("Il costo del biglietto è: " + biglietto.calcolaPrezzo() + " euro");

		scan.close();

	}
}