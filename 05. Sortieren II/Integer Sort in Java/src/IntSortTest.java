import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class IntSortTest {
    IntSort so = new IntSort();
    
    @Test
    public void test1() {
        int[]xs={};
        int[]rs={};
        so.sort(xs);

        assertArrayEquals(rs,xs);
    }

    @Test
    public void test2() {
        int[]xs={1,1,1,1,1,1,1,1,1,1};
        int[]rs={1,1,1,1,1,1,1,1,1,1};
        so.sort(xs);

        assertArrayEquals(rs,xs);
    }

    @Test
    public void test3() {
        int[]xs={1000000};
        int[]rs={1000000};
        so.sort(xs);

        assertArrayEquals(rs,xs);
    }

    @Test
    public void test4() {
        int[]xs={9,2,4,6,2,7,98,3,3,6,43,5432,5,5,5,54,2,2435,54,2,5452,4,4,4,4};
        int[]rs={2,2,2,2,3,3,4,4,4,4,4,5,5,5,6,6,7,9,43,54,54,98,2435,5432,5452};
        new IntSort().sort(xs);
        reverse(rs);

        assertArrayEquals(rs,xs);
    }
    
    public static void check(String msg, int[] a, int[] gt) {
        assertEquals(msg, a.length, gt.length);
        for (int i=0; i<a.length; ++i) {
            assertEquals(msg, a[i], gt[i]);
        }
    }
    
    private static void reverse(int[] b) {
        for (int i=0; i<b.length/2; ++i) {
            int tmp = b[i];
            b[i] = b[b.length-1-i];
            b[b.length-1-i] = tmp;
        }
    }

    private static void checkSorted(String msg, int[] a) {
        int[] b = new int[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        Arrays.sort(b);  // b ist sortiertes Array von Original
        reverse(b);
        assertTrue(msg, Arrays.equals(a, b));
    }
    
    
    @Test
    public void test5() {
        int[] a = new int[] {7};
        so.sort(a);
        check("Falsches Ergebnis für Eingabe-Array [7]", a, new int[] {7});
    }
    
    @Test
    public void test6() {
        int[] a = new int[] {3, 8, 1, 4};
        so.sort(a);
        check("Falsches Ergebnis für Eingabe-Array [3, 8, 1, 4]", a, new int[] {8, 4, 3, 1});
    }

    @Test
    public void test7() {
        int[] a = new int[] {1, 2, 3, 4, 5};
        so.sort(a);
        check("Falsches Ergebnis für Eingabe-Array [1, 2, 3, 4, 5]", a, new int[] {5, 4, 3, 2, 1});
    }

    @Test
    public void test8() {
        int[] a = new int[] {5, 4, 3, 2, 1};
        so.sort(a);
        check("Falsches Ergebnis für Eingabe-Array [5, 4, 3, 2, 1]", a, new int[] {5, 4, 3, 2, 1});
    }

    private static final Integer DEFAULT_SEED = Integer.valueOf(123456);

    public static int[] createRandomIntArray(int n, int max) {
        Random rand = new Random(DEFAULT_SEED*n); // immer dieselben Zahlen!
        int a[] = new int[n];
        for (int i=0; i < n; i+=1) {
            a[i] = rand.nextInt(max);
        }

        return a;
    }

    @Test
    public void test9() {
        int[] a = createRandomIntArray(10000, 1000);
        so.sort(a);
        checkSorted("Array aus 10000 Zahlen ist nicht korrekt (absteigend) sortiert!", a);
    }
}
