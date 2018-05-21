package arbol;

/**
 * @version 2.0
 * @author Alexis Holguin
 * @since 18/05/2018 5:57 p.m
 */
public class Nodo {
	// -----------------------------------------------------------------------------------
	// Atribbutos
	// -----------------------------------------------------------------------------------
	private int info;
	private Nodo LeftLeaf;
	private Nodo RightLeaf;
	private Nodo Father;

	// -----------------------------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------------------------
	public Nodo(int info) {
		this.info = info;
	}

	// -----------------------------------------------------------------------------------
	// Getters And Setters
	// -----------------------------------------------------------------------------------
	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public Nodo getLeftLeaf() {
		return LeftLeaf;
	}

	public void setLeftLeaf(Nodo leftLeaf) {
		this.LeftLeaf = leftLeaf;
		this.LeftLeaf.setFather(this);
	}

	public Nodo getRightLeaf() {
		return RightLeaf;
	}

	public void setRightLeaf(Nodo rightLeaf) {
		this.RightLeaf = rightLeaf;
		this.RightLeaf.setFather(this);
	}

	public Nodo getFather() {
		return Father;
	}

	public void setFather(Nodo father) {
		Father = father;
	}
}
