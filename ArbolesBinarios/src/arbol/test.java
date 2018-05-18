package arbol;

public class test {
	public static void main(String[] args) {
		Arbol arbol = new Arbol();
		int[] nodos = {6,3,4,2,1,8,9,4,5,7};
		for (int i = 0; i < nodos.length; i++) {
			arbol.addNodo(nodos[i]);
		}
		System.out.println(arbol.CountNodes());
		arbol.inorden();
		System.out.println();
		arbol.preorden();
		System.out.println();
		arbol.postorden();
		System.out.println();
		System.out.println(arbol.countInternalNodes());
		System.out.println();
		System.out.println(arbol.sumaNodos());
		System.out.println();
		System.out.println(arbol.promedio());
		System.out.println();
		System.out.println(arbol.maxValue());
	}
}
