package jogo;

import java.util.Scanner;
import assets.Item;
import classes.*;
import dungeons.Dungeon;
import racas.*;

public class Personagem extends Entidade {
	Scanner sc = new Scanner(System.in);
	private Raca raca;
	private Classe classe;
	private int nivel;
	private int exp;
	private int expMax;
	private Item inventario[]; // Criar uma classe Inventario, com os metodos referentes ao inventario,
								// semelhante a criação de uma ArrayList estudada na faculdade

	public Personagem(String nome, Raca raca, Classe classe) {
		setNome(nome);
		this.raca = raca;
		this.classe = classe;
		setVidaMax(raca.getVidaMax() + classe.getVidaMax());
		setManaMax(raca.getManaMax() + classe.getManaMax());
		setEstaminaMax(raca.getEstaminaMax() + classe.getEstaminaMax());
		;
		setVida(getVidaMax());
		setMana(getManaMax());
		setEstamina(getEstaminaMax());
		;
		nivel = 1;
		exp = 0;
		expMax = 200;
		inventario = new Item[5];
	}

	public void subirDeNivel() {
		if (exp >= expMax && nivel < 20 && nivel >= 1) {
			int nivelAntigo = nivel;
			int vidaAntiga = getVidaMax();
			int manaAntiga = getManaMax();
			int estaminaAntiga = getEstaminaMax();
			nivel++;
			System.out.println("Parabéns, seu nivel aumentou de " + nivelAntigo + " para --> " + nivel);
			if (nivel < 5) {
				expMax *= 1.5;
				setVidaMax(vidaAntiga + 2);
				setManaMax(manaAntiga + 2);
				setEstaminaMax(estaminaAntiga + 2);
			} else if (nivel < 10) {
				expMax *= 2;
				setVidaMax(vidaAntiga + 3);
				setManaMax(manaAntiga + 3);
				setEstaminaMax(estaminaAntiga + 3);
			} else if (nivel == 10) {
				expMax *= 2.5;
				setVidaMax(vidaAntiga + 5);
				setManaMax(manaAntiga + 5);
				setEstaminaMax(estaminaAntiga + 5);
			} else if (nivel <= 15) {
				expMax *= 3;
				setVidaMax(vidaAntiga + 4);
				setManaMax(manaAntiga + 4);
				setEstaminaMax(estaminaAntiga + 4);
			} else if (nivel == 20) {
				setVidaMax(vidaAntiga + 7);
				setManaMax(manaAntiga + 7);
				setEstaminaMax(estaminaAntiga + 7);
				System.out.println("Parabéns, você atingiu o nivel maxímo");
			}
			System.out.println("Sua vida maxima aumentou de " + vidaAntiga + " para --> " + getVidaMax());
			System.out.println("Sua mana maxima aumentou de " + manaAntiga + " para --> " + getManaMax());
			System.out.println("Sua estamina maxima aumentou de " + estaminaAntiga + " para --> " + getEstaminaMax());
		}

	}

	public void abrirInventario() {
		informacoesMenu();

		for (int i = 0; i < inventario.length; i++) {
			System.out.println("Item " + (i + 1) + " : " + inventario[i]);
		}

		if (!estaVazio()) {
			usarItem();
			System.out.println("Você gostaria de usar algum item? ");
			System.out.println("1. Sim | x. Não");
			boolean verificador = sc.nextInt() == 1 ? true : false;

			if (verificador) {

			}
		}
	}

	private void informacoesMenu() {
		System.out.println("------Inventario------");
		System.out.println("Nome : " + getNome());
		System.out.println("Raça : " + raca);
		System.out.println("Classe : " + classe);
		System.out.println("Nivel : " + nivel + "|| Exp: (" + exp + "/" + expMax + ")");
		System.out.println("Vida : " + "(" + getVida() + "/" + getVidaMax() + ")");
		System.out.println("Mana : " + "(" + getMana() + "/" + getManaMax() + ")");
		System.out.println("Estamina : " + "(" + getEstaminaMax() + "/" + getEstaminaMax() + ")");

	}

	private boolean estaVazio() {
		for (int i = 0; i < inventario.length; i++) {
			if (inventario[i] != null) {
				return false;
			}
		}
		return true;
	}

	private void usarItem() {
		System.out.println("Qual item você gostaria de usar? ");
		int idItem = sc.nextInt() - 1;
		if (idItem < 0 || idItem >= inventario.length || inventario[idItem] == null) {

			System.out.println("Valor do item invalido");

		} else {

			inventario[idItem].usarItem(this);
			inventario[idItem] = null;
		}
	}

	public void coletarItem(Item item) {
		if (inventario[inventario.length - 1] != null) {
			System.out.println("Inventario cheio!!");
			System.out.println("Escolha um item de 1-5 para excluir ou 6 para deixar o novo item");
			for (int i = 0; i < inventario.length; i++) {
				System.out.println("Item " + (i + 1) + " : " + inventario[i]);
			}
			switch (sc.nextInt()) {
			case 1:
				inventario[0] = item;
				break;
			case 2:
				inventario[1] = item;
				break;
			case 3:
				inventario[2] = item;
				break;
			case 4:
				inventario[3] = item;
				break;
			case 5:
				inventario[4] = item;
				break;
			case 6:
				System.out.println("Você desistiu do novo item!!");
				break;

			default:
				System.out.println("Você não selecionou nenhuma opção, então perdeu seu item!!");
				break;
			}

		} else {
			for (int i = 0; i < inventario.length; i++) {
				if (inventario[i] == null) {
					inventario[i] = item;
					break;
				}
			}
		}

	}

	public boolean menuBatalha(Dungeon d) {
		System.out.println("Selecione o que quer fazer: ");
		System.out.println("1. Lutar| 2. Usar Item | 3. Fugir ");
		int idEscolha = sc.nextInt();

		do {
			switch (idEscolha) {
			case 1:
				menuMovimentos(d);

				break;

			case 2:
				abrirInventario();

				break;
			case 3:
				return true;

			default:
				System.out.println("Nenhuma opção escolhida, selecione novamente");
				break;
			}
		} while (idEscolha > 3 || idEscolha < 1);

		return false;

	}

	public void menuMovimentos(Dungeon d) {
		int idInimigo;
		
		if (d.getInimigosEmCampo().size() > 1) {
			System.out.println("Qual inimigo deseja atacar: ");
			d.mostrarInimigos();
			idInimigo = sc.nextInt() - 1;
			causarDano(d.getInimigosEmCampo().get(idInimigo), 10);

		} else {
			causarDano(d.getInimigosEmCampo().get(0), 10);
		}

	}

	
	public String toString() {
		return getNome() + " [" + getNivel() + "] "
				+ "Vida : " + "(" + getVida() + "/" + getVidaMax() + ")"
						+ "Mana : " + "(" + getMana() + "/" + getManaMax() + ")"
								+ "Estamina : " + "(" + getEstamina() + "/" + getEstaminaMax() + ")";
	}
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getExpMax() {
		return expMax;
	}

	public void setExpMax(int expMax) {
		this.expMax = expMax;
	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Item[] getInventario() {
		return inventario;
	}

	public void setInventario(Item[] inventario) {
		this.inventario = inventario;
	}

	public void quebrarLinhas() {
		for (int i = 0; i < 10; i++) {
			System.out.println();
		}
	}

}
