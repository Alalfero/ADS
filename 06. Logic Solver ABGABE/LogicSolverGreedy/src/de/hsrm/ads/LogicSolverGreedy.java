package de.hsrm.ads;

public class LogicSolverGreedy {

	static boolean satisfies(short[] assignment, short[] clause) {
		for (int i = 0; i < clause.length; ++i)
			if (assignment[i] * clause[i] == 1)
				return true;
		return false;
	}

	static boolean satisfies(short[] assignment, short[][] formula) {
		for (short[] clause : formula) {
			boolean wert = false;
			for (int i = 0; i < clause.length; i++) {
				if (assignment[i] * clause[i] == 1) {
					wert = true;
					break;
				}
			}
			if (!wert) return false;
		}
		return true;
	}

	static boolean satisfiable(short[] assignment, short[] clause) {
		if (satisfies(assignment, clause)) return true;
		for (int i = 0; i < assignment.length; ++i) {
			if (assignment[i] == 0 && clause[i] > 0) {
				assignment[i] = 1;
				return true;
			}
			if (assignment[i] == 0 && clause[i] < 0) {
				assignment[i] = -1;
				return true;
			}
		}
		return false;
	}

	static boolean satisfiable(short[] assignment, short[][] formula) {
		for (short[] clause : formula) {
			if (!satisfiable(assignment, clause)) return false;
		}
		return true;
	}

	static short[] solveGreedy(short[][] formula) {
		short[] state = new short[formula[0].length];
		for (short[] clause : formula) {
			if (!satisfiable(state, clause)) return new short[formula[0].length];
			if (!satisfies(state, clause)) satisfiable(state, clause);
		}
		return state;
	}
}
