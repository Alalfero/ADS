import java.util.Random;

public class MergeSort {

	// buffer for merge operation.
	int[] b;

	public void sort(int[] a) {
		b = new int[a.length];

		for (int currentSize = 1; currentSize < a.length; currentSize *= 2) {

			// merge für jedes Segment
			for (int left = 0; left < a.length - 1; left += 2 * currentSize) {

				int mid = Math.min(left + currentSize - 1, a.length - 1);
				int right = Math.min(left + 2 * currentSize - 1, a.length - 1);

				//a in b kopieren
				if (right + 1 - left >= 0) System.arraycopy(a, left, b, left, right + 1 - left);

				int curElemLeft = left;
				int curElemRight = mid + 1;
				int newIndex = left;

				// die Hälften mergen
				while (curElemLeft <= mid && curElemRight <= right) {
					if (b[curElemLeft] <= b[curElemRight]) {
						a[newIndex] = b[curElemLeft];
						curElemLeft++;
					} else {
						a[newIndex] = b[curElemRight];
						curElemRight++;
					}
					newIndex++;
				}

				//restliche aus der linken Hälfte kopieren
				while (curElemLeft <= mid) {
					a[newIndex] = b[curElemLeft];
					curElemLeft++;
					newIndex++;
				}

				//restliche Elemente aus der rechten Hälfte kopieren
				while (curElemRight <= right) {
					a[newIndex] = b[curElemRight];
					curElemRight++;
					newIndex++;
				}
			}
		}
	}

	public static void swap(int[] a, int pos1, int pos2) {
		int tmp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = tmp;
	}

	// always the same pseudo random numbers!
	private static final Integer DEFAULT_SEED = Integer.valueOf(654321);

	public static int[] createRandomArray(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; ++i)
			a[i] = i;
		// shuffle randomly.
		Random rand = new Random(DEFAULT_SEED * n);
		for (int i = 0; i < n; ++i) {
			int pos = rand.nextInt(n);
			swap(a, i, pos);
		}
		return a;
	}

	public static void runTest(int n) {

		long startTime;
		long endTime;

		int[] a = createRandomArray(n);
		MergeSort sort = new MergeSort();
		startTime = System.currentTimeMillis();
		sort.sort(a);
		endTime = System.currentTimeMillis();
		System.out.format("[n=%d] : %d ms.\n", n, (endTime - startTime));
	}

	public static void main(String[] args) {
	}

}
