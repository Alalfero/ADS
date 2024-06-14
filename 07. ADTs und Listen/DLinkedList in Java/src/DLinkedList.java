
public class DLinkedList {

	class Node {
		Node next;
		Node prev;
		int obj;
	}

	Node head, tail;

	public DLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}

	public void addLast(int t) {
		Node newNode = new Node();
		newNode.obj = t;
		Node lastNode = tail.prev;
		lastNode.next = newNode;
		newNode.prev = lastNode;
		newNode.next = tail;
		tail.prev = newNode;
	}

	// Komplexität O(n2)
	public void zip(DLinkedList other) {
		Node current1 = head.next;
		Node current2 = other.head.next;

		//Komplexität O(min(n1, n2))
		while (current1 != tail && current2 != other.tail) {
			Node next1 = current1.next;
			Node next2 = current2.next;

			current1.next = current2;
			current2.prev = current1;
			current2.next = next1;
			next1.prev = current2;
			current1 = next1;
			current2 = next2;

		}

		//Komplexität O(max(n2-n1,0))
		while (current2 != other.tail) {
			Node next1 = tail.prev;
			Node next2 = current2.next;
			tail.prev = current2;
			current2.next = tail;
			current2.prev = next1;
			next1.next = current2;
			current2 = next2;
		}

	}


}
