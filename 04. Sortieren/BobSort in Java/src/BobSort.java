import java.util.Random;

public class BobSort {

    public static void swap(int[] a, int pos1, int pos2) {
        int tmp = a[pos1];
        a[pos1] = a[pos2];
        a[pos2] = tmp;
    }

    public static void sort(int[] a) {
        // FIXME: implement
    }

    // immer dieselben Pseudozufallszahlen!
    private static final Integer DEFAULT_SEED = Integer.valueOf(654321);

    public static int[] createRandomArray(int n) {
        int[] a = new int[n];
        for (int i=0; i<n; ++i)
            a[i] = i;
        // shuffle randomly.
        Random rand = new Random(DEFAULT_SEED*n);
        for (int i=0; i<n; ++i) {
            int pos = rand.nextInt(n);
            swap(a, i, pos);
        }
        return a;
    }

    // optionally, benchmark sorting time on a random array
    public static void runTest(int n) {

        long startTime;
        long endTime;

        int[] a = createRandomArray(n);
        startTime = System.currentTimeMillis();
        sort(a);
        endTime = System.currentTimeMillis();
        System.out.format(
                "[n=%d] : %d ms.\n",
                n, (endTime - startTime));
    }

    public static void main(String[] args) {
    }

}
