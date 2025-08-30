package jogo;

import java.util.Scanner;

import assets.Item;
import classes.*;
import racas.*;

public class Personagem {
	Scanner sc = new Scanner(System.in);

	private String nome;
	private Raca raca;
	private Classe classe;
	private int vida;
	private int vidaMax;
	private int mana;
	private int manaMax;
	private int estamina;
	private int estaminaMax;
	private int nivel;
	private int exp;
	private int expMax;
	private Item inventario[];

	public Personagem(String nome, Raca raca, Classe classe) {

		this.nome = nome;
		this.raca = raca;
		this.classe = classe;
		vidaMax = raca.getVidaMax() + classe.getVidaMax();
		manaMax = raca.getManaMax() + classe.getManaMax();
		estaminaMax = raca.getEstaminaMax() + classe.getEstaminaMax();
		vida = vidaMax;
		mana = manaMax;
		estamina = estaminaMax;
		nivel = 1;
		exp = 0;
		expMax = 200;
		inventario = new Item[5];
	}

	public void subirDeNivel() {
		if (exp >= expMax && nivel < 20 && nivel>=1) {
			int nivelAntigo = nivel;
			int vidaAntiga=vidaMax;
			int manaAntiga=manaMax;
			int estaminaAntiga=estaminaMax;
			nivel++;
			System.out.println("Parabéns, seu nivel aumentou de " + nivelAntigo + " para --> " + nivel);
			if (nivel < 5) {
				expMax*=1.5;
				vidaMax += 2;
				manaMax += 2;
				estaminaMax += 2;
			} else if (nivel < 10) {
				expMax*=2;
				vidaMax += 3;
				manaMax += 3;
				estaminaMax += 3;
			} else if (nivel == 10) {
				expMax*=2.5;
				vidaMax += 5;
				manaMax += 5;
				estaminaMax += 5;
			} else if (nivel <= 15) {
				expMax*=3;
				vidaMax += 4;
				manaMax += 4;
				estaminaMax += 4;
			} else if (nivel == 20) {
				vidaMax += 7;
				manaMax += 7;
				estaminaMax += 7;
				System.out.println("Parabéns, você atingiu o nivel maxímo");
			}
			System.out.println("Sua vida maxima aumentou de " + vidaAntiga + " para --> " + vidaMax);
			System.out.println("Sua mana maxima aumentou de " + manaAntiga + " para --> " + manaMax);
			System.out.println("Sua estamina maxima aumentou de " + estaminaAntiga + " para --> " + estaminaMax);
		}

	}
	
	public void abrirInventario() {
		informacoesMenu();

		for (int i = 0; i < inventario.length; i++) {
			System.out.println("Item " + (i + 1) + " : " + inventario[i]);
		}

		if (!estaVazio()) {
			usarItem();
		}
	}

	private void informacoesMenu() {
		System.out.println("------Inventario------");
		System.out.println("Nome : " + nome);
		System.out.println("Raça : " + raca);
		System.out.println("Classe : " + classe);
		System.out.println("Nivel : " + nivel + "|| Exp: (" + exp + "/" + expMax + ")");
		System.out.println("Vida : " + "(" + vida + "/" + vidaMax + ")");
		System.out.println("Mana : " + "(" + mana + "/" + manaMax + ")");
		System.out.println("Estamina : " + "(" + estamina + "/" + estaminaMax + ")");

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
		System.out.println("Você gostaria de usar algum item? ");
		System.out.println("1. Sim | x. Não");
		boolean verificador = sc.nextInt() == 1 ? true : false;

		if (verificador) {

			System.out.println("Qual item você gostaria de usar? ");
			int idItem = sc.nextInt() - 1;
			if (idItem < 0 || idItem >= inventario.length || inventario[idItem] == null) {
				
				System.out.println("Valor do item invalido");

			} else {

				inventario[idItem].usarItem(this);
				inventario[idItem] = null;
			}
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

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getVidaMax() {
		return vidaMax;
	}

	public void setVidaMax(int vidaMax) {
		this.vidaMax = vidaMax;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getManaMax() {
		return manaMax;
	}

	public void setManaMax(int manaMax) {
		this.manaMax = manaMax;
	}

	public int getEstamina() {
		return estamina;
	}

	public void setEstamina(int estamina) {
		this.estamina = estamina;
	}

	public int getEstaminaMax() {
		return estaminaMax;
	}

	public void setEstaminaMax(int estaminaMax) {
		this.estaminaMax = estaminaMax;
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

}
