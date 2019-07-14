
/**
 * @author Laura
 *
 */
public class SListCircular implements IList {
	public SNode first;
	public SNode last;
	public int size;



	public void addFirst(String newElem) {


		SNode newNodo = new SNode(newElem);
		
		if (!isEmpty()) {
			
				newNodo.next = first;
				first = newNodo;
				last.next = first;
			
				size++;
		}
		
		
		else {
			first = newNodo;
			last = newNodo;
			last.next = first;
			size ++;
		}
	}

	public void addLast(String newElem) {

		SNode newNodo = new SNode(newElem);
		
		if (isEmpty()) {
			addFirst(newElem);
			
		}

		else {
			last.next = newNodo;
			last = newNodo;
			last.next = first;
			size++;
		}

	}

	public void removeFirst() {

		if (isEmpty()) {
			System.out.println("Sorry, the list is empty");
		}

		else if (size == 1) {
			first = null;
			last = null;
			size--;

		}

		else {
			first = first.next;
			last.next = first;
			size--;
		}

	}

	public void removeLast() {
		if (isEmpty()) {
			System.out.println("Sorry, the list is empty");
		}

		else if (size == 1) {
			first = null;
			last = null;
			size--;

		}

		else {
			for (SNode nodeIt = first; nodeIt != last ; nodeIt = nodeIt.next){
				if (nodeIt.next == last){
					last = nodeIt;
					nodeIt.next = first;
					size --;
					return ;
				}
				
				
			}
			
		}
		}

	public void insertAt(int index, String newElem) {
		SNode newNode = new SNode(newElem);
		
		if (index == 0)
			addFirst(newElem);
		
		else if (index == size)
			addLast(newElem);
		
		else if (!indexTest(index))
			System.out.println("Index isn't correct");
		
		else {
			
			int i = 0;
			boolean inserted = false;
			for (SNode nodeIt = first; nodeIt != last && inserted == false; nodeIt = nodeIt.next) {
				if (i == index-1) {
					newNode.next = nodeIt.next;
					nodeIt.next = newNode;
					inserted = true;
				}
				i++;
			}
			size++;
		}
	}

	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	public boolean contains(String elem) {
		if (isEmpty())
			return false;
		
		else {
			for (SNode nodeIt = first; nodeIt.next != last; nodeIt = nodeIt.next) {
				if (nodeIt.elem == elem) {
					return true;
				}
				
			}
			
			if(last.elem == elem)
				return true;
		}
		return false;
	}
	

	public int getSize() {

		return size;
	}

	public int getIndexOf(String elem) {

		int i = 0;
		if (contains(elem)){
		for (SNode nodeIt = first; nodeIt != null; nodeIt = nodeIt.next) {
			if (nodeIt.elem == elem) {
				return i;
			}
			i++;
		}
		
		}
		
		return -1;
	}

	public String getFirst() {

		return first.elem;
	}

	public String getLast() {

		return last.elem;
	}

	public String getAt(int index) {

		if (isEmpty())
			return null;
		else if (!indexTest(index)){
			System.out.println("The index isnt correct"); 
			return null;}
		else if ( index == size -1){
			return last.elem;
			
		}
		
		else {
			int i = 0;
			for (SNode nodeIt = first; nodeIt != last; nodeIt = nodeIt.next) {
				if (i == index) {
					return nodeIt.elem;
					
				}
				i++;
			}
			
			
		}
		return null;
	}

	public void removeAll(String elem) {
		if (contains(elem)) {
			int i = 0;
			
			for (SNode nodeIt = first; nodeIt != last; nodeIt = nodeIt.next) {
				if (nodeIt.elem == elem) {
					removeAt(i);
				}
				i++;
			}
			
			if(last.elem == elem)
				removeAt(i);

		}
		else
			System.out.println("not in the list");

	}

	public void removeAt(int index) {

		if (isEmpty())
			System.out.println("Is empty");
		
		else if (!indexTest(index))
			System.out.println("The index isnt correct");
		
		else if (size == 1)
			removeFirst();
		
		else if (index == size-1){
			removeLast();
		System.out.println("k");
	}
		else {
			int i = 0;
			for (SNode nodeIt = first; nodeIt != last; nodeIt = nodeIt.next) {
				if (i == index-1) {
					nodeIt.next = nodeIt.next.next;
				}
				i++;
			}
			size--;
		}
	}
	
	public String toString (){
		
		 String elem = "";
		 SNode aux = first;
		 for ( int i =0; i < size ; i ++){
			 
			 
			 elem = elem + first.elem;
			 first = first.next;
			 
		 }
		 
		return elem;
		
	}
	
	public boolean indexTest (int index){
		//Returns true if the index has a correct value
		if (index >= size || index < 0 )
			return false;
		
		return true;
	}
	public static void main(String[] args) {
		
		String [] array1 = new String []{"1","2","3"};
		
		SListCircular listC = new SListCircular();
		
		listC.addFirst("10");
		listC.addFirst("7");
		listC.addFirst("2");
		listC.addLast("6");
		listC.addLast("8");
		listC.addLast("9");
		
	
		System.out.println(listC.toString());
		listC.removeAll("7");
		System.out.println(listC.toString());
		listC.removeLast();
		listC.getFirst();
		System.out.println(listC.toString());
		listC.removeLast();
		System.out.println(listC.toString());
		listC.addLast("6");
		System.out.println(listC.first.elem);
		listC.insertAt(2, "0");
		System.out.println(listC.toString());
		System.out.println(listC.isEmpty());
		System.out.println(listC.contains("0"));
		System.out.println(listC.getSize());
		System.out.println(listC.getIndexOf("0"));
		System.out.println(listC.getLast());
		System.out.println(listC.getAt(4));
		listC.removeAt(3);
		
		
	}

}
