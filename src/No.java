
public class No {
	private int valor;
	private No right;
	private No left;
	
	public No(int valor) {
		this.valor = valor;
	}
	
	public No() {
		
	}
	
	public No getRight() {
		return right;
	}
	public void setRight(No right) {
		this.right = right;
	}
	public No getLeft() {
		return left;
	}
	public void setLeft(No left) {
		this.left = left;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
}
