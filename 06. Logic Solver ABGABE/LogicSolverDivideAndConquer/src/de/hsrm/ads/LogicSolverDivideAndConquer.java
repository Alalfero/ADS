
package de.hsrm.ads;

import java.util.Arrays;

public class LogicSolverDivideAndConquer {

	static boolean satisfies(short[] assignment, short[] clause) {
		for (int i = 0; i < clause.length; ++i)
			if (assignment[i] * clause[i] == 1)
				return true;
		return false;
	}

	// Bei Bedarf können Sie hierhin andere
	// satisfies() / satisfiable() - Methoden
	// aus LogicSolverGreedy kopieren.

	public static short[][] copyArray(short[][] array, int end) {
		short[][] result = new short[end][0];
		for (int i = 0; i < end; ++i) result[i] = array[i];
		return result;
	}

	public static short[][] binear(short belegungen, short laenge) {
		short[][] loesungen = new short[belegungen][laenge];
		for (int i = 0; i < belegungen; i++) {
			short[] zustand = new short[laenge];
			for (int j = 0; j < laenge; j++) {
				// alle möglichen Belegungen werden gespeichert, Belegungen werden berechnet nach dem Tipp aus der Aufgabenstellung
				zustand[j] = (short) ((i / (int) Math.pow(2, j)) % 2 == 0 ? -1 : 1);

			}
			loesungen[i] = zustand;
		}

		return loesungen;
	}

	public static short[][] solutionsForClause(short[] clause) {
		short x = (short) clause.length;
		short klauseln = (short) Math.pow(2, x); //Anzahl der Möglichen Belegungen
		short[][] moegliche = binear(klauseln, x);
		short[][] loesungen = new short[klauseln][x]; //hier werden die richtigen Belegungen gespeichert

		int pos = 0;
		for (int i = 0; i < klauseln; i++) {
			short[] belegung = moegliche[i];
			if (satisfies(belegung, clause)) loesungen[pos++] = belegung;

		}

		return copyArray(loesungen, pos);
	}

	static short[][] vergleicheLoesungen(short[][] loesung1, short[][] loesung2) {
		if (loesung1.length == 0 || loesung2.length == 0) return new short[][]{};

		int pos = 0; //Jetztige Position im Finalen Array
		short[][] loesungen = new short[loesung1.length][loesung1[0].length]; //hier werden die doppelten Belegungen gespeichert (Schnittmenge aus der Eingabe)

		for (short[] value1 : loesung1)
			for (short[] value2 : loesung2) {
				if (Arrays.equals(value1, value2)) {
					loesungen[pos++] = value1;
					break;
				}
			}

		return copyArray(loesungen, pos);
	}

	static short[][] solveDivideAndConquer(short[][] formula) {
		return solveDivideAndConquer(formula, 0, formula.length - 1);
	}

	static short[][] solveDivideAndConquer(short[][] formula, int start, int ende) {
		if (start >= ende) return solutionsForClause(formula[start]);

		int mitte = (start + ende) / 2;
		short[][] loesungen1 = solveDivideAndConquer(formula, start, mitte);
		short[][] loesungen2 = solveDivideAndConquer(formula, mitte + 1, ende);

		return vergleicheLoesungen(loesungen1, loesungen2);
	}

}


