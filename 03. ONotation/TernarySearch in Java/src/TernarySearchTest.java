import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class TernarySearchTest {

    @Test
    public void testSmall() {
        int[] a;
        a = new int[] {1};
        assertEquals("For the array a=[1], ternarySearch(a, 2) should return -1!",
                     -1, TernarySearch.ternarySearch(a, 2));
        assertEquals("For the array a=[1], ternarySearch(a, 1) should return 0!",
                 0, TernarySearch.ternarySearch(a, 1));
        a = new int[] {1,2};
        assertEquals("For the array a=[1,2], ternarySearch(a, 5) should return -1!",
                     -1, TernarySearch.ternarySearch(a, 5));
        assertEquals("For the array a=[1,2], ternarySearch(a, 2) should return 1!",
                 1, TernarySearch.ternarySearch(a, 2));
        a = new int[] {1,2,3};
        assertEquals("For the array a=[1,2,3], ternarySearch(a, 5) should return -1!",
                     -1, TernarySearch.ternarySearch(a, 5));
        assertEquals("For the array a=[1,2,3], ternarySearch(a, 2) should return 1!",
                 1, TernarySearch.ternarySearch(a, 2));
    }

    @Test
    public void testFirst() {
        int[] a;
        a = new int[] {1,2,3,4,5,6,7,8,9,10};
        assertEquals("For the array a=[1,2,3,4,5,6,7,8,9,10], ternarySearch(a, 1) should return 0!",
                     0, TernarySearch.ternarySearch(a, 1));
        assertEquals("For the array a=[1,2,3,4,5,6,7,8,9,10], ternarySearch(a, 8) should return 7!",
                 7, TernarySearch.ternarySearch(a, 8));
        assertEquals("For the array a=[1,2,3,4,5,6,7,8,9,10], ternarySearch(a, 6) should return 5!",
                 5, TernarySearch.ternarySearch(a, 6));
    }

    @Test
    public void testGap() {
        int[] a;
        a = new int[] {1,2,3,4,5,6,8,9,10};
        assertEquals("For the array a=[1,2,3,4,5,6,8,9,10], ternarySearch(a, 7) should return -1!",
                     -1, TernarySearch.ternarySearch(a, 7));
    }

    @Test
    public void testDup() {
        int[] a;
        a = new int[] {1,2,2,2,2,2,2,2,2};
        assertTrue("For the array a=[1,2,2,2,2,2,2,2,2]], ternarySearch(a, 2) should return a value > 0!",
                    TernarySearch.ternarySearch(a, 2) > 0);
        assertEquals("For the array a=[1,2,2,2,2,2,2,2,2]], ternarySearch(a, 3) should return -1!",
                 -1, TernarySearch.ternarySearch(a, 3));
    }

}
