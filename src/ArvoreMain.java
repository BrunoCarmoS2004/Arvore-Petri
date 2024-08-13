public class ArvoreMain {
	public static void main(String[] args) {
		Arvore arvore = new Arvore();
		arvore.inserir(25);
		arvore.inserir(26);
		arvore.inserir(27);
		arvore.inserir(30);
		arvore.inserir(28);
		arvore.deletarNo(25);
		System.out.println("item ja deletado");
		arvore.preOrdem(arvore.getRaiz());
	}
}