/*
 * Modular Power
 * - compute a^e mod n
 * - implement recursively
 */

public class Power {

    // Performance counter
    public static int calls = 0;

    public static int powerMod(int a, int e, int n) {
        if (e == 0) return 1;
        return (powerMod(a, e - 1, n) * a) % n;
    }

    public static int fastPowerMod(int a, int e, int n) {
        if (e == 0) return 1;
        if (e % 2 == 0) return (fastPowerMod(a, e / 2, n)* fastPowerMod(a, e / 2, n)) % n;
        return ((fastPowerMod(a, (e-1) / 2, n)* fastPowerMod(a, (e-1) / 2, n)) * a) % n;
    }

    public static void testPower(int a, int e, int n, int result, boolean mode) {

        int testResult;

        // Check mode
        if (mode) {

            // Use fast mode
            testResult = fastPowerMod(a, e, n);

        } else {

            // Use slow mode
            testResult = powerMod(a, e, n);

        }

        // Simple debug message
        System.out.format("Es wurde %d^%d mod %d = %d berechnet (richtig: %d)\n", a, e, n, testResult, result);

    }

    public static void main(String[] args) {

        // Tests (slow mode)
        calls = 0;
        System.out.format("Slow-Mode test\n");
        testPower(2, 8, 1000, 256, false);

        System.out.format("Calls: %d\n\n", calls);

        // Tests (fast mode)
        calls = 0;
        System.out.format("Fast-Mode test\n");
        testPower(2, 16, 100, 36, true);
        System.out.format("Calls: %d\n", calls);

    }
}
