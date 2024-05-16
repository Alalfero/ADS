public class Matrix {

	double[][] data;

	public Matrix(double[][] data) {
		this.data = data.clone();
	}

	public Matrix(int n) {
		this.data = new double[n][n];
	}

	Matrix mult(Matrix other) {
		int l = this.data.length;
		Matrix result = new Matrix(l);

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				for (int k = 0; k < l; k++) {
					result.data[i][j] += this.data[i][k] * other.data[k][j];
				}
			}
		}
		return result;
	}


}