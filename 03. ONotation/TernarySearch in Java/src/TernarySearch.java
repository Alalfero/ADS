public class TernarySearch {

	public static int ternarySearch(int[] a, int value) {
		int left = 0;
		int right = a.length - 1;


		while (left <= right) {
			int midL = left + (right - left) / 3;
			int midR = right - (right - left) / 3;

			if (value == a[midL]) {
				return midL;
			}
			if (value == a[midR]) {
				return midR;
			}

			if (value < a[midL]) {
				right = midL - 1;
			} else if (value > a[midR]) {
				left = midR + 1;
			} else {
				left = midL + 1;
				right = midR - 1;
			}
		}
		return -1;
	}

}
