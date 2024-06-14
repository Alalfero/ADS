import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Test;

public class HeapSortTest {

    // Parameter für die Zufallszahlengenerierung
    public static final Integer DEFAULT_RAND_MAX = Integer.valueOf(1073741824);
    private static final Integer DEFAULT_SEED = Integer.valueOf(123456);

    @Test
    public void testSmall() {
        HeapSort sort = new HeapSort();
        int[] a = new int[] {7, 3, 1, 9, 5, 6, 4, 2, 8};
        sort.sort(a);
        for (int i=0; i<a.length; ++i) {
            assertEquals(a[i], a.length-i);
        }
    }
    
        public static int[] createRandomIntArray(int n) {
        Random rand = new Random(DEFAULT_SEED*n); // immer dieselben Zahlen!
        int a[] = new int[n];
        for (int i=0; i < n; i+=1) {
            a[i] = rand.nextInt(DEFAULT_RAND_MAX);
        }

        return a;
    }

    @Test
    public void testRandomBig() {
        HeapSort sort = new HeapSort();
        int[] a = createRandomIntArray(10000);
        sort.sort(a);
        for (int i=0; i<a.length-1; ++i) {
            assertTrue( a[i]>=a[i+1]);
        }
    }
}