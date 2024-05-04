import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class SieveTest {

    private static final int laenge = 200;
    boolean[] sieb = Sieve.sieve(laenge);
  
    @Test
    public void testSieveLength() {
        assertEquals("falsche Länge des Arrays" , laenge+1, sieb.length);
    }

    @Test
    public void testSieve200ValuesPrimes() {
        int [] prims = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199};
        for (int prim:prims){
            assertTrue(prim+" nicht als Primzahl erkannt", sieb[prim]);
        }
    }
    
    @Test
    public void testSieve200ValuesNonPrimes() {
        int [] nonprims = {4,6,8,9,10,12,14,15,16,18,20,21,22,24,25,26,27,28,30,32,33,34,35,36,38,39,40,42,44,45,46,48,49,50,51,52,54,55,56,57,58,60,62,63,64,65,66,68,69,70,72,74,75,76,77,78,80,81,82,84,85,86,87,88,90,91,92,93,94,95,96,98,99,100,102,104,105,106,108,110,111,112,114,115,116,117,118,119,120,121,122,123,124,125,126,128,129,130,132,133,134,135,136,138,140,141,142,143,144,145,146,147,148,150,152,153,154,155,156,158,159,160,161,162,164,165,166,168,169,170,171,172,174,175,176,177,178,180,182,183,184,185,186,187,188,189,190,192,194,195,196,198,200};
        for (int prim:nonprims){
            assertFalse(prim+" fehlerhaft als Primzahl erkannt", sieb[prim]);
        }
    }

    @Test
    public void testSieve100Values() {
        int[] expected = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    
        assertArrayEquals(expected, Sieve.primesUpTo(100));
    }

    @Test
    public void testSieveLength10() {
        boolean[] primes = Sieve.sieve(10);
        assertEquals("Result array for 10 numbers should have length 11!", 11, primes.length);
    }

    @Test
    public void testSieveZeroOne() {
        boolean[] primes = Sieve.sieve(2);
        assertEquals("isPrime[0] should be false!", false, primes[0]);
        assertEquals("isPrime[1] should be false!", false, primes[1]);
    }
  
    @Test
    public void testSieve10Values() {
        boolean[] primes = Sieve.sieve(10);
        assertEquals("isPrime[2] should be true!", true, primes[2]);
        assertEquals("isPrime[3] should be true!", true, primes[3]);
        assertEquals("isPrime[4] should be false!", false, primes[4]);
        assertEquals("isPrime[5] should be true!", true, primes[5]);
        assertEquals("isPrime[6] should be false!", false, primes[6]);
        assertEquals("isPrime[7] should be true!", true, primes[7]);
        assertEquals("isPrime[8] should be false!", false, primes[8]);
        assertEquals("isPrime[9] should be false!", false, primes[9]);
        assertEquals("isPrime[10] should be false!", false, primes[10]);
    }

    @Test
    public void testSieve10KValues() {
        boolean[] primes = Sieve.sieve(10000);
        int nPrimes = 0;
        for (int i=0; i<primes.length; ++i) {
            if (primes[i]) {
                nPrimes++;
            }
        }
        assertEquals("There should be 1229 prime numbers <= 10000!", 1229, nPrimes);
    }  

}
