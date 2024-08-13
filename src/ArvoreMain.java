
public class ArvoreMain {

	public static void main(String[] args) {
		Arvore arvore = new Arvore();
		arvore.inserir(20);
		arvore.inserir(18);
		arvore.inserir(19);
		arvore.inserir(17);
		arvore.inserir(16);
		arvore.inserir(26);
		arvore.deletarNo(17);
		System.out.println("item ja deletado");
		arvore.preOrdem(arvore.getRaiz());
	}
}
//95
//97