public class Sieve {

    static boolean[] sieve(int n) {
        boolean[] result = new boolean[n + 1];
        int smallest = 2;
        // setzte alle Zahlen von 2 bis n auf mögliche Primzahlen
        for (int i = 2; i <= n; i++) result[i] = true;

        while (smallest <= n) {

            if (smallest * smallest > n) break;

            // entferne Vielfache von smallest
            for (int i = smallest * smallest; i <= n; i += smallest) result[i] = false;

            // setze smallest auf die kleinste nicht gestrichene Zahl
            for (int i = smallest + 1; i <= n; i++) {
                if (result[i]) {
                    smallest = i;
                    break;
                }
            }
        }
        return result;
    }

    static int[] primesUpTo(int n) {
        boolean[] isPrime = sieve(n);
        int count = 0;
        int index = 0;
        // Anzahl der Primzahlen bestimmen
        for (int i = 2; i <= n; i++) if (isPrime[i]) count++;

        int[] result = new int[count];
        // Array mit Primzahlen befüllen
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                result[index] = i;
                index++;
            }
        }

        return result;
    }

}
