package lista;


public class DList {

	// Atributes
	DNode header; // by default is null
	DNode trailer;// by default is null
	int size; // by default is 0

	
	// Main constructor
	public DList() {
		// we have to create the sentinel nodes
		header = new DNode(null);
		trailer = new DNode(null);
		// they have to point with each other
		header.next = trailer;
		trailer.prev = header;
	}

	// IList Methods
	public void addFirst(String elem) {
		DNode newNode = new DNode(elem);
		newNode.next = header.next;
		newNode.prev = header;
		header.next.prev = newNode;
		header.next = newNode;
		size++;

	}

	public void addLast(String elem) {
		DNode newNode = new DNode(elem);
		newNode.next = trailer;
		newNode.prev = trailer.prev;
		trailer.prev.next = newNode;
		trailer.prev = newNode;
		size++;

	}

	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		header.next = header.next.next;
		header.next.prev = header;
		size--;

	}

	public void removeLast() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		trailer.prev = trailer.prev.prev;
		trailer.prev.next = trailer;
		size--;
	}

	public void insertAt(int index, String elem) {
		
		if(!testIndex(index))
		return;
		
		int i = 0;
		DNode newNode = new DNode(elem);
		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
			
			if (index == i) {
				newNode.next = nodeIt;
				newNode.prev = nodeIt.prev;

				nodeIt.prev.next = newNode;
				newNode.next.prev = newNode;
				size++;
			}
			i++;
		}

		if (index == size) {
			addLast(elem);
			size++;
		}

		

	}

	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	public boolean contains(String elem) {
		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
			if (nodeIt.elem.compareToIgnoreCase(elem) == 0) {

				return true;
			}
		}
		return false;
	}

	public int getIndexOf(String elem) {
		int i = 0;
		if (contains(elem)) {
			for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {

				if (nodeIt.elem.compareToIgnoreCase(elem) == 0) {
				
					return i;
				}
				i++;
			}

		} 
		
		else {
			System.out.println("The element isnt in the list");
			//Not correct index 
			
		}

		return -1;
	}

	public void removeAll(String elem) {
		int i = 0;

		if (contains(elem)) {
			for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
				if (nodeIt.elem.compareToIgnoreCase(elem) == 0) {
					removeAt(i);
				}
				i++;
			}

		}
	}

	public void removeAt(int index) {
		
		if(!testIndex(index)) return ;

		int i = 0;
		
		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
			if (index == i) {

				nodeIt.prev.next = nodeIt.next;
				nodeIt.next.prev = nodeIt.prev;
				size++;
			}
			i++;
		}

	}

	public int getSize() {
		return size;
	}

	public String getFirst() {
		return header.next.elem;
	}

	public String getLast() {

		return trailer.prev.elem;
	}

	public String getAt(int index) {
		
		if(!testIndex(index)) return null;

		int i = 0;

		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
			if (index == i) {
				return nodeIt.elem;
			}
			i++;
		}
		return null;
	}

	// Overwritten method to String
	public String toString() {
		String result = null;
		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
			if (result == null) {
				result = nodeIt.elem;
			} else {
				result += "," + nodeIt.elem;
			}
		}
		return result == null ? "empty" : result;
	}

	// Extra methods

	// Sort method implements with nodes
	public void sort() {
		for (int i = 0; i < size; i++) {
			DNode aux;
			for (DNode nodeIt = header.next; nodeIt.next != trailer; nodeIt = nodeIt.next) {

				if (nodeIt.elem.compareToIgnoreCase(nodeIt.next.elem) > 0) {

					// first keep the reference of the node that is followed by
					// the two that we are going to exchange
					aux = nodeIt.next.next;

					// Now link the previous to nodeIt with the next to this
					nodeIt.prev.next = nodeIt.next;
					nodeIt.next.prev = nodeIt.prev;

					// Link the nodes to each other
					nodeIt.next.next = nodeIt;
					nodeIt.prev = nodeIt.next;

					// Is necessary to save in an auxiliar nodeIt.next.next to
					// avoid losing it s reference
					nodeIt.next = aux;
					aux.prev = nodeIt;

					// Now nodeIt has been interchanged by the following so we
					// return nodeIt to the initial value
					nodeIt = nodeIt.prev;
				}

			}

		}

	}

	// We have to test all the index that are introduced by parameter so this
	// method make it easy
	public boolean testIndex(int index) {
		if (index < 0 || index > size) {
			System.out.println("index is not correct");
			return false;
		}
		return true;

	}

	// This method implements another way to insert in the list
	// The element will be introduced in its corresponding alphabetical position
	public void insertSort(String elem) {
		
		sort();
		int i = 0;

		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {

			// When the next word is bigger (alphabetically) the method stops
			// and introduces elem in that position
			
			if (nodeIt.elem.compareToIgnoreCase(elem) > 0) {
				
				insertAt(i, elem);

				return;
			}

			i++;
		}
		
		if (i == size ) addLast(elem);
	}

	public static void main(String[] args) {

		DList list = new DList();
		System.out.println(list.toString());
		System.out.println("isEmpty?" + list.isEmpty());

		list.addLast("Ana");
		System.out.println(list.toString());

		list.removeLast();
		System.out.println(list.toString());

		list.addLast("Isabel");
		System.out.println(list.toString());

		list.removeFirst();
		System.out.println(list.toString());

		list.addLast("Maria");
		System.out.println(list.toString());

		list.addLast("Ana");
		System.out.println(list.toString());

		list.addFirst("Pilar");
		System.out.println(list.toString());

		list.addLast("Afda");
		list.addLast("Andfdga");
		list.addLast("Laura");
		
		System.out.println(list.toString());
		
		System.out.println(list.contains("laura"));
		System.out.println(list.getAt(3));
		System.out.println(list.getAt(5));
		System.out.println(list.getAt(-34));

		System.out.println(list.getFirst());
		System.out.println(list.getIndexOf("Pilar"));
		System.out.println(list.getLast());
		System.out.println(list.getSize());
		
		list.insertAt(3, "Pedro");
		System.out.println(list.toString());
		
		list.insertSort("Zamir");
		System.out.println(list.toString());
		
		list.removeAll("Maria");
		System.out.println(list.toString());
		
		list.removeAt(0);
		System.out.println(list.toString());
		
		list.removeFirst();
		System.out.println(list.toString());
		
		list.removeLast();
		System.out.println(list.toString());
		
		
	}

}
