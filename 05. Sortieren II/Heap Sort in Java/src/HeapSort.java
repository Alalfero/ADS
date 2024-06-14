public class HeapSort {

	private int leftChild(int i) {
		return 2 * i + 1;
	}

	private int rightChild(int i) {
		return 2 * i + 2;
	}

	// corrects an incorrect value at position i
	// (see lecture)
	private void min_heapify(int[] a, int i) {
		int left = leftChild(i);
		int right = rightChild(i);
		int smallest = i;

		if (left < heap_size && a[left] < a[smallest]) {
			smallest = left;
		}
		if (right < heap_size && a[right] < a[smallest]) {
			smallest = right;
		}
		if (smallest != i) {
			int temp = a[i];
			a[i] = a[smallest];
			a[smallest] = temp;
			min_heapify(a, smallest);
		}
	}

	// turns an unsorted array into a heap
	// (see lecture)
	private void build_min_heap(int[] a) {
		heap_size = a.length;
		for (int i = heap_size / 2; i >= 0; i--) min_heapify(a, i);
	}

	private int heap_size;

	// HeapSort
	public void sort(int[] a) {
		build_min_heap(a);
		for (int i = a.length - 1; i >= 1; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;

			heap_size--;
			min_heapify(a, 0);
		}
	}

}
