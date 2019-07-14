
public class SStack implements IStack {
	
	//Atributes
	public SNode peak = null;
	public int size = 0;
	
	
	//Methods
	@Override
	public boolean isEmpty() {
		if (size ==0){
		return true;
		}
		return false;
	}


	
	
	
	@Override
	public void push(Object elem) {
		//Put the object of the parameter in the peak of the stack
		SNode aux = new SNode(elem);
		if (size>0){
			aux.next = peak;
			peak = aux;
			size++;
		}
		if (size==0){
			peak = aux;
			size++;
		}
		

	}

	@Override
	public SNode pop() {
		//Return the element of the peak and clean it from the stack
		if (isEmpty()==false){
			if (size>1){
				SNode aux = new SNode (peak);
				peak = peak.next;
				size--;
				return aux;
			}
		
			else {
				SNode aux = new SNode (peak);
				peak = null;
				size --;
				return aux;
			}
		}
			
		
		else {
			System.out.println("The stack is empty!");
			return null;
		}
		
		
	}

	@Override
	public SNode top() {
		//This method returns the last element (peak) of the stack
		if (isEmpty()){
			System.out.println("The stack is empty!");
			return null;
		}
		else{
			return peak;
		}
	}

	@Override
	public int getSize() {
		//This method returns the size of the stack
		return size;
	}
	
	public String toString(){
		//Returns a String of the stack
		 String elem = "";
		 SNode aux = new SNode (peak);
		 for ( int i =0; i < size -1; i ++){
			 aux = aux.next;
			 elem = elem + aux.elem;
			 
		 }
		return elem;
		
	}

}
