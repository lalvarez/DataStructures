
public class Hanoi {
	SStack source, target, auxiliar;
	int n; // number of discs
	int steps; // number of steps

	public Hanoi(int discs) {

		n = discs;
		source = new SStack();
		target = new SStack();
		auxiliar = new SStack();

		//
		for (int i = n; i >= 1; i--) {
			source.push(i);
		}

		steps = 0;

	}

	public void solve() {
		imprimir(source, target, auxiliar);
		moveDiscs(n, source, auxiliar, target);
		imprimir(source, target, auxiliar);
	
	}

	public void moveDiscs(int n, SStack source, SStack auxiliar, SStack target) {
		
		if (n==1)  {
			//Si solo hay un elemento se mueve a la pila final
			//imprimir(source, target, auxiliar);
			target.push(source.pop());
		}
			
		else {
			//imprimir(source, target, auxiliar);
			moveDiscs(n-1, source, target, auxiliar);
			target.push(source.pop());
			imprimir(source, target, auxiliar);
			moveDiscs(n-1, auxiliar, source, target);
			
			
		}
		
	}
	
	public static void imprimir(SStack source,SStack target, SStack auxiliar){
		String source1 = source.toString();
		String target1 = target.toString();
		String auxiliar1 = auxiliar.toString();
		
		System.out.println(source1);
		System.out.println(target1);
		System.out.println(auxiliar1);
		
		System.out.println();
		
		
	}

	public static void main(String args[]) {

		int n = 4;
		Hanoi obj = new Hanoi(n);
		obj.solve();
		
		
	

	}
}
