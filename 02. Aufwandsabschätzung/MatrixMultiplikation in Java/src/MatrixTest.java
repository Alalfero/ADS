import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class MatrixTest {
    
    public void check(Matrix A, Matrix B) {
    	assertEquals( A.data.length, B.data.length);
    	for (int i=0; i<A.data.length; ++i) {
    		assertEquals( A.data[i].length, B.data[i].length );
    		for (int j=0; j<A.data[i].length; ++j) {
    			assertEquals( A.data[i][j], B.data[i][j], 0.001 );
    		}
    	}
    }
    
    @Test
    public void test1() {

    	double[][] Adata = new double[][] {
        	{1,2,3},
        	{4,1,0},
        	{5,2,-3}
        };

    	double[][] Bdata = new double[][] {
    		{2,1,-3},
    		{-1,0,4},
    		{1,2,-4}
        };

    	double[][] Cdata = new double[][] {
    		{3,7,-7},
    		{7,4,-8},
    		{5,-1,5}
        };

    	Matrix A = new Matrix(Adata);
    	Matrix B = new Matrix(Bdata);
    	Matrix C = new Matrix(Cdata);
    
    	check(C, A.mult(B));
    }

    @Test
    public void test2() {
        check(new Matrix(100), new Matrix(100).mult(new Matrix(100)));
    }

    @Test
    public void test3() {
    	double[][] Adata = new double[][] {
        	{1,1,1,1,1,1,1,1,1,1},
        	{1,1,1,1,1,1,1,1,1,1},
        	{1,1,1,1,1,1,1,1,1,1},
        	{1,1,1,1,1,1,1,1,1,1},
        	{1,1,1,1,1,1,1,1,1,1},
        	{1,1,1,1,1,1,1,1,1,1},
        	{1,1,1,1,1,1,1,1,1,1},
        	{1,1,1,1,1,1,1,1,1,1},
        	{1,1,1,1,1,1,1,1,1,1},
        	{1,1,1,1,1,1,1,1,1,1},
        };
    	double[][] Cdata = new double[][] {
        	{10,10,10,10,10,10,10,10,10,10},
        	{10,10,10,10,10,10,10,10,10,10},
        	{10,10,10,10,10,10,10,10,10,10},
        	{10,10,10,10,10,10,10,10,10,10},
        	{10,10,10,10,10,10,10,10,10,10},
        	{10,10,10,10,10,10,10,10,10,10},
        	{10,10,10,10,10,10,10,10,10,10},
        	{10,10,10,10,10,10,10,10,10,10},
        	{10,10,10,10,10,10,10,10,10,10},
        	{10,10,10,10,10,10,10,10,10,10},
        };
    	
        Matrix A = new Matrix(Adata);
        Matrix c = new Matrix(Cdata);
        check(c, A.mult(A));
    }
    
    @Test
    public void test4Timing() {
    	for (int n=10; n<=1000; n*=2) {
	    	Matrix m1 = new Matrix(n);
	    	Matrix m2 = new Matrix(n);
	    	m1.mult(m2);
    	}
    }

    
}