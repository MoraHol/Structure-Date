package arbol;

public class test {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		System.out.println("ingrese los numeros que desea agregar al arbol separados por coma :");
		String line = br.readLine();
		Arbol arbol = new Arbol();
		int[] nodos = {6,3,4,2,1,8,9,4,5,7};
		String[] numeros = line.split(",");
		for (int i = 0; i < nodos.length; i++) {
			arbol.addNodo(Integer.parseInt(numeros[i]));
		}
		System.out.println("En este nodo hay: "+arbol.CountNodes());
		System.out.println("arbol en inorden: ");
		arbol.inorden();
		System.out.println("Arbol en preorden:");
		System.out.println();
		arbol.preorden();
		System.out.println("Arbol en postorden: ");
		System.out.println();
		arbol.postorden();
		System.out.println("En este arbo hay "+arbol.countInternalNodes()+" internos.");
		
		
		System.out.println("la suma de todos los nodos del arbol es : "+arbol.sumaNodos());
		
		System.out.println("el promedio de los numeros de este arbol es: "+arbol.promedio());
	
		System.out.println("el numero mas grande de este arbol es: "+arbol.maxValue());
	}
}
