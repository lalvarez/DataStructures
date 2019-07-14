/**
 * 
 */

/**
 * @author Laura
 *
 */
public interface IListInt {
	
	public void addFirst(int newElem);
	public void addLast(int newElem);
	public void removeFirst();
	public void removeLast();
	public void insertAt(int index, int newElem);
	public boolean isEmpty();
	public boolean contains(int elem);
	public int getSize();
	public int getIndexOf(int elem);
	public int getFirst();
	public int getLast();
	public int getAt();
	public String toString();
	public void removeAll(int elem);
	public void removeAt(int index);

}
