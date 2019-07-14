
/**
 * @author Laura
 *Ejercicio semana 1
 *Implementacion de un TAD
 *Grupo 82
 */
public class ListArray implements IListInt {

	
	
	//Atributos
	
	private int [] data ;
	
	//Este atributo almacena el margen para anadir o quitar elementos en el array
	private int extraBounds;
	
	//Este atributo establece cual es la posicion en la que se encuentra el ultimo elemento anadido al array
	//Hasta que no se crea se sobre entiende que el array esta vacio diciendo que la posicion del ultimo elemento es -1
	private int lastElementPos = -1;
	
	//Constructor
	
	public ListArray (int [] data1, int extraBounds, int lastElementPos){
		//Constructor 1 : crea el array igualandolo a la direccion de memoria de el introducido 
		//por parametro
		
		//Se crea el array con el espacio extra deseado
		this.data = new int [data1.length + extraBounds];
		
		//Se copian los elementos del array uno a uno 
		//El espacio extra se rellena con -1 (valor no valido por defecto)
		for ( int i =0; i < data.length; i ++){
			if (i <data1.length){
			data [i] = data1[i];
			}
			else {
				data[i] =-1;
			}
		}
		
		this.extraBounds = extraBounds;
		this.lastElementPos = lastElementPos;
	}
	
	
	
	
	public void addFirst(int newElem){
		//Este metodo permite poner el elemento que se introduce por parametro en la primera posicion.
		//Si hay espacio suficiente en el array se anade y se mueven los demas elementos una pos
		if (lastElementPos < data.length -1){
			int aux = data[lastElementPos];
			
			for ( int i = lastElementPos; i > 0; i --){
				data [i] = data [i -1];
			}
			data[lastElementPos +1] = aux;
			data[0]= newElem;
			
			this.lastElementPos ++;
			
		}
		else{
		//Se crea un array auxiliar
		int [] aux = new int [data.length +1];
		//Primero se guarda el elemento en la primera posicion
		aux [0] = newElem;
		//Se rellena con los elementos que conformaban el array principalmente a partir de la posicion 1.
		for( int i =1; i < aux.length; i++){
			aux [i] = data [i-1];
		}
		//Se igualan las direcciones de memoria 
		//Ahora data posee los elementos de aux
		data = aux ;
		
		
		}
	}
	public void addLast(int newElem){
		//Este metodo permite poner el elemento que se introduce por parametro en la ultima posicion.
		//Si hay espacio suficiente en el array se anade y se mueven los demas elementos una pos
				if (lastElementPos < data.length -1){
					
					data[lastElementPos +1 ]= newElem;
					
					this.lastElementPos ++;
					
				}
				
				else{
		int [] aux = new int [data.length +1];
		//Se copia el array dejando un hueco vacio para el nuevo elemeto
		for(int i =0; i <data.length; i ++){
			aux[i]= data[i];
			
		}
				
		
		aux[data.length]= newElem;
		//Igualo direcciones de memoria
		data = aux;
	}
	}
	
	public void removeFirst(){
		//Este metodo elimina el primer elemento del array
		
		//Para eliminarlo moveremos todos los elementos hacia la izquierda
		
		//Comprobamos que no esta vacio el array
		if ( lastElementPos >= 0){
		for (int i =0; i < data.length -1; i++){
			data[i] =data [i+1];
			
		}
		
		//Llamo a la funcion para modificar el ultimo elemento que quedaria repetido 
		removeLast();
		
		/*Otra implementacion si quisieramos modificar tambien el tamano del array
		 * 
		//primero comprobamos que el array no esta vacio para evitar errores al salirse del limite si estuviera vacio
		if (data.length >0){
		int [] aux = new int [data.length -1];
		for(int i =1;i <aux.length;i ++){
			aux [i -1]= data[i];
		}
		//Se copian todos a partir del primero (sin incluir) en el array auxiliar
		//Igualo las direcciones de memoria
		data = aux;
		}
		*/
		
	}
		}
	public void removeLast(){
		//Este metodo elimina el ultimo elemento del array
		
		//Valor por defecto al ultimo elemento que estaria repetido al mover los demas
		data[lastElementPos] = -1;
		lastElementPos --;
		
		
		
		
		/*Otra implementacion si quisieramos modificar tambien el tamano del array
		 *
		int [] aux = new int [data.length-1];
		for(int i =0; i < aux.length; i ++){
			aux [i] = data [i];
			
		}
		
		data = aux;
		*/
		
	}
	public void insertAt(int index, int newElem){
		//Este metodo inserta el elemento deseado en la posicion indicada
		
		//Si no se ha superado el margen del array dispuesto para anadir elementos 
		//Se mueven todos un espacio a la derecha
		//Y se anade en la posicion definida por parametro el elemento
		if (data.length -1 >= index){
			
			if (index <= lastElementPos){
			for ( int i = lastElementPos; i > index; i --){
				data [i+1] = data [i]; 
				
			}
			
			data [index] = newElem;
			lastElementPos ++;
			
		}
			else{
				data [index] = newElem;
				lastElementPos ++;
			}
			}
		
		
		//Si ya no queda margen disponible procede a crear un array auxiliar y se realiza el metodo sobre el mismo
		else if (index > lastElementPos){
			
			//Se pide memoria para llegar hasta la posicion donde se desea incluir
			int [] aux = new int [index +1];
			//Se rellena hasta el indice donde ira el elemento con los anteriores datos
				for( int i =0; i < data.length; i ++){
					aux[i]= data[i];
				}
				//Se rellena el margen con -1
				for( int i =data.length; i < aux.length; i ++){
					aux[i]= -1;
				}
				//Se pone el elemento en la posicion
				aux[index ]= newElem;
				lastElementPos ++;
				
				data = aux;
		}
			
			
		
		}
	public boolean isEmpty(){
		//Suponemos que un array vacio es el que tiene como valor del atributo lastElementPos -1 (valor por defecto) 
		
		if ( lastElementPos == -1 ){ 
			return true;
			
		}
		
		else {
			return false;
		}
	}
	
	public boolean contains(int elem){
		
		for (int i =0; i <=lastElementPos ; i++){
			if ( data [i] == elem){
				return true;
			}
		}
		
		return false;
		
	}
	public int getSize(){
		//Devuelve el numero de datos que se han almacenado
		return lastElementPos +1 ;
	}
	
	public int getIndexOf(int elem){
		
		//La variable pos almacena la primera posicion donde esta el  elemento
		//Tiene -1 como valor por defecto, ya que no existe ninguna posicion con ese valor
		//Indica que no esta el elemento
		int pos = -1;
		
		if(contains (elem) == true){
			
			for(int i =0; i <=lastElementPos ; i++){
				
				if(data[i]== elem){
					//Si esta el elemento se actualiza la posicion
					pos = i;
					return pos;
				}
			}
		}
		
		
		return pos;
		
	}
	
	
	public int getFirst(){
		//Devuelve el elemento que ocupa la primera posicion del array
		if (lastElementPos >= 0){
			//Si el array no esta vacio devuelve el elemento
		return data[0];
		}
		//Si esta vacio devuelve -1 
		//Partimos de que -1 no es un dato valido
		return -1;
	}
	
	
	public int getLast(){
		//Devuelve el elemento que ocupa la primera posicion del array
		if (lastElementPos >= 0){
			//Si el array no esta vacio devuelve el elemento
		return data[lastElementPos-1];
		}
		//Si esta vacio devuelve -1 
		//Partimos de que -1 no es un dato valido
		return -1;
	}
	
	
	public int getAt(int index){
		
		//Devuelve el valor que hay en el indice establecido por el parametro index
		
		//Comprueba que es un index valido
		if (index <= lastElementPos || index >= 0){
		return data[ index];
		}
		
		return -1;
		//Suponemos que el -1 es un dato no valido
	}
	
	public String toString(){
		
		//Este metodo convierte el array en un tipo String
		String elem = " ";
		for (int i =0; i <data.length ; i++){
			elem = elem + data[i];
		}
		return elem;
	}
	
	public void removeAll(int elem){
		//Este metodo elimina todos los incides del array que contienen ese elemento
		
		for (int i =0; i < data.length; i ++){
			if (data [i] == elem){
				removeAt (i);
			}
		}
	}
	
	public void removeAt(int index){
		
		//Este metodo localiza el elemento que se encuentra en el indice establecido por parametro 
		//A partir de ese elemento (sin incluir) mueve todos los demas elementos una posicion a la izquierda
		if(index<data.length){
		for ( int i = index ; i < lastElementPos; i ++){
			data [i] = data [i +1]; 
			
		}
		
		//Valor por defecto al ultimo elemento que estaria repetido al mover los demas
		data[lastElementPos] = -1;
		lastElementPos --;
		
		}
		
	}
	public static void main(String[] args) {
		
		int [] array1 = new int []{1,2,3,5,3};
		ListArray lista1 = new ListArray(array1, 4, 4);
		
		for( int i =0; i <lista1.data.length; i++){
			System.out.print(lista1.data[i]);
			
			}
			
			System.out.println();
		
			
			
			
			
		//Comprobacion de la funcionalidad de los metodos
		lista1.addFirst(8);
		for( int i =0; i <lista1.data.length; i++){
		System.out.print(lista1.data[i]);
		
		}
		
		System.out.println();
		
		lista1.addLast(5);
		for( int i =0; i <lista1.data.length; i++){
			System.out.print(lista1.data[i]);
			}
		
		System.out.println();
		
		lista1.removeFirst();
		for( int i =0; i <lista1.data.length; i++){
			System.out.print(lista1.data[i]);
			}
		System.out.println();
		
		lista1.removeLast();
		for( int i =0; i <lista1.data.length; i++){
			System.out.print(lista1.data[i]);
			}
		System.out.println();
		
		lista1.insertAt(2, 7);
		for( int i =0; i <lista1.data.length; i++){
			System.out.print(lista1.data[i]);
			}
		System.out.println();
		
		//Manejo del error
		//Se quiere anadir un indice que no existe, se evita el error pero no se tiene en cuenta el dato 
		lista1.insertAt(15, 8);
		for( int i =0; i <lista1.data.length; i++){
			System.out.print(lista1.data[i]);
			}
		System.out.println();
		
		System.out.println (lista1.isEmpty());
		
		System.out.println (lista1.contains(7));
		
		System.out.println (lista1.contains(78));
		
		System.out.println (lista1.getSize());
		System.out.println (lista1.getIndexOf(7));

		System.out.println (lista1.getIndexOf(78));
		
		System.out.println (lista1.getFirst());
		System.out.println (lista1.getLast());
		System.out.println (lista1.getAt(1));
		lista1.removeAll(1);
		for( int i =0; i <lista1.data.length; i++){
			System.out.print(lista1.data[i]);
			}
		System.out.println();
		
		lista1.removeAt(3);
		for( int i =0; i <lista1.data.length; i++){
			System.out.print(lista1.data[i]);
			}
		System.out.println();
		
		//Si el indice no es el correcto no hace nada
		lista1.removeAt(98);
		for( int i =0; i <lista1.data.length; i++){
			System.out.print(lista1.data[i]);
			}
		System.out.println();

	}




	@Override
	public int getAt() {
		// TODO Auto-generated method stub
		return 0;
	}

}
