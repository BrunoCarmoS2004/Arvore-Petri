public class Arvore {

	private No raiz;

	public Arvore() {
		this.raiz = null;
	}
	public Arvore(No raiz) {
		this.raiz = raiz;
	}

	public No inserir(int valor) {
        No novoNo = new No(valor);
        if (this.raiz == null) {
            this.raiz = novoNo;
        } else {
            No atual = this.raiz;
            No pai = null;
            while (atual != null) {
                if (novoNo.getValor() < atual.getValor()) {
                    pai = atual;
                    atual = atual.getLeft();
                } else {
                    pai = atual;
                    atual = atual.getRight();
                }
            }
            if (novoNo.getValor() < pai.getValor()) {
                pai.setLeft(novoNo);
            } else {
                pai.setRight(novoNo);
            }
        }
        return novoNo;
    }
	
	public void preOrdem(No no) {
		if (no == null) {
			return;
		}
		System.out.println(no.getValor());
		preOrdem(no.getLeft());
		preOrdem(no.getRight());
	}

    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getLeft());
        posOrdem(no.getRight());
        System.out.println(no.getValor());
    }
	
	public void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getLeft());
        System.out.println(no.getValor());
        emOrdem(no.getRight());
    }
	
	
	public void deletarNo(int valor) {
		if (this.raiz == null) {
			System.out.println("Não existe itens na árvore");
			return;
		}
		//DELETAR RAIZ
		if (this.raiz.getValor() == valor) {
			deletarRaiz();
			System.out.println("Raiz deletada");
			return;
		}
		No paiNo = null;
		No atual = raiz;
		recursividadeArvore(atual, paiNo, valor);
	}
	
	public void recursividadeArvore(No atual, No paiNo, int valor ) {
		if (atual.getValor() == valor) {
			// REMOVER NÓ FOLHA
			if (atual.getLeft() == null && atual.getRight() == null) {
				removerNoFolha(atual, paiNo);
				System.out.println(valor + " removido FOLHA");
				return;
			}
			//REMOVER NO COM DOIS FILHOS
			if (atual.getLeft() != null && atual.getRight() != null) {
				removerNoDoisFilhos(atual, paiNo);
				System.out.println(valor + " removido DOIS FILHOS");
				return;
			}
			// REMOVER FILHOS SEM FILHOS NOS DOIS LADOS
			removerNoComFilhosAoLado(atual, paiNo);
			System.out.println(valor + " removido COM FILHOS AO LADO");
			return;
		}
		//BUSCA PELO VALOR
		if (atual.getValor() > valor) {
			//VALOR NA ESQUERDA
			if (atual.getLeft() == null) {
				System.out.println("Valor não encontrado");
				return;
			}
			paiNo = atual;
			atual = atual.getLeft();
		} else {
			//VALOR NA DIREITA
			if (atual.getRight() == null) {
				System.out.println("Valor não encontrado");
				return;
			}
			paiNo = atual;
			atual = atual.getRight();
		}
		recursividadeArvore(atual, paiNo, valor);
	}
	
	public void deletarRaiz() {
		if (this.raiz.getLeft() != null) {
			No paiNo = this.raiz;
			No atual = this.raiz.getLeft();
			while (true) {
				if (atual.getRight() == null) {
					if (paiNo == this.raiz) {
						atual.setRight(raiz.getRight());
						this.raiz = atual;
						break;
					}else {
						paiNo.setRight(atual.getLeft());
						atual.setLeft(this.raiz.getLeft());
						atual.setRight(this.raiz.getRight());
						this.raiz = atual;
						break;
					}	
				}
				paiNo = atual;
				atual = atual.getRight();
			}
		}
	}
	
	public void removerNoFolha(No atual, No paiNo) {
		if (atual.getLeft() == null && atual.getRight() == null) {
			if (paiNo.getValor() > atual.getValor()) {
				paiNo.setLeft(null);
			}else {
				paiNo.setRight(null);
			}
		}	
	}
	
	public void removerNoDoisFilhos(No atual, No paiNo) {
		No maiorFilho = atual.getLeft();
		No paiMaiorFilho = atual;
		while (true) {
			if (maiorFilho.getRight() == null) {
				if (paiMaiorFilho == atual) {
					maiorFilho.setRight(atual.getRight());
					if (paiNo.getValor() > atual.getValor()) {
						paiNo.setLeft(maiorFilho);
					}else {
						paiNo.setRight(maiorFilho);
					}
				}else {
					paiMaiorFilho.setRight(maiorFilho.getLeft());
					maiorFilho.setLeft(atual.getLeft());
					maiorFilho.setRight(atual.getRight());
					if (paiNo.getValor() > atual.getValor()) {
						paiNo.setLeft(maiorFilho);
					}else {
						paiNo.setRight(maiorFilho);
					}
				}	
				break;
			}
			paiMaiorFilho = maiorFilho;
			maiorFilho = maiorFilho.getRight();
		}
	}
	
	public void removerNoComFilhosAoLado(No atual, No paiNo) {
		if (paiNo.getValor() > atual.getValor()) {
			// Esta na esquerda
			if (atual.getLeft() != null) {
				paiNo.setLeft(atual.getLeft());
			} else {
				paiNo.setLeft(atual.getRight());
			}
		} else {
			// Esta na direita
			if (atual.getLeft() != null) {
				paiNo.setRight(atual.getLeft());
			} else {
				paiNo.setRight(atual.getRight());
			}
		}
	}
	

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

}
