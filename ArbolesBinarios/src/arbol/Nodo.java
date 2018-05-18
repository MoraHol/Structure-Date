package arbol;

public class Nodo {
	private int info;
	private Nodo LeftLeaf;
	private Nodo RightLeaf;
	private Nodo Father;
	public Nodo(int info) {
		this.info = info;
	}
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
