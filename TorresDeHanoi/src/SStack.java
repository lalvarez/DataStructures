
public class SStack {
	SNode peak = null;
	int size;
	
	public boolean isEmpty() {
		return peak == null;
	}

	public void push(Integer newElem) {
		SNode newNode = new SNode(newElem);
		newNode.next = peak;
		peak = newNode;
		size++;
	}

	public Integer pop() {
		if (isEmpty()) {
			System.out.println("The stack is empty.");
			return null;
		}
		Integer elem = peak.elem;
		peak = peak.next;
		size--;
		return elem;
	}

	
	public Integer top() {
		if (isEmpty()) {
			System.out.println("The stack is empty.");
			return null;
		}
		return peak.elem;
	}

	public String toString() {
		String result = null;
		for (SNode nodeIt = peak; nodeIt != null; nodeIt = nodeIt.next) {
			if (result == null) {
				result = "[" + nodeIt.elem.toString() + "]";
			} else {
				result += "," + nodeIt.elem.toString();
			}
		}
		return result == null ? "empty" : result;
	}

	

	public int getSize() {
		return size;
	}
}
