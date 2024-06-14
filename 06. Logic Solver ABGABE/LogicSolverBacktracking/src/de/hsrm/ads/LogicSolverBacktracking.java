package de.hsrm.ads;

public class LogicSolverBacktracking {

	static boolean satisfies(short[] assignment, short[] clause) {
		for (int i = 0; i < clause.length; ++i)
			if (assignment[i] * clause[i] == 1)
				return true;
		return false;
	}

	static boolean satisfiable(short[] assignment, short[][] formula) {
		for (short[] clause : formula) if (!satisfies(assignment, clause)) return false;
		return true;
	}


	// Bei Bedarf können Sie hierhin andere
	// satisfies() / satisfiable() - Methoden
	// aus LogicSolverGreedy kopieren.

	static short[] solveBacktracking(short[][] formula) {
		short[] assignment = new short[formula[0].length];
		return solveBacktracking(formula, assignment, 0);

	}

	static short[] solveBacktracking(short[][] formula, short[] assignment, int index) {
		if (index == assignment.length) {
			if (satisfiable(assignment, formula)) return assignment;
			else return new short[formula[0].length];
		}
		// erstmal mit -1 versuchen
		assignment[index] = -1;
		short[] solution = solveBacktracking(formula, assignment, index + 1);
		if (satisfiable(solution, formula)) return solution;

		// dann mit 1
		assignment[index] = 1;
		solution = solveBacktracking(formula, assignment, index + 1);
		if (satisfiable(solution, formula)) return solution;

		return new short[formula[0].length];
	}

}
