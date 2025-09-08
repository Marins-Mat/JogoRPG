package dungeons;

import java.util.ArrayList;
import java.util.Scanner;

import inimigos.Inimigo;
import jogo.Personagem;

public abstract class Dungeon {
	private int roundMax;
	private int roundAtual;
	private ArrayList<Inimigo> inimigosEmCampo = new ArrayList<>();
	boolean fugirDungeon;

	public Dungeon() {
		roundAtual = 0;
	}

	public void runDungeon(Personagem p) {

		Scanner sc = new Scanner(System.in);
		do {
			round(p);
			System.out.println("Você deseja fugir da dungeon?");
			System.out.println("1. Sim | x. Não");
			fugirDungeon = sc.nextInt() == 1 ? true : false;
		} while (roundAtual != roundMax || !fugirDungeon);
		sc.close();
	}

	public void round(Personagem p) {
		roundAtual++;
		gerarInimigosRound();
		quebrarLinhas(10);
		System.out.println("----- ROUND " + roundAtual + " -----");
		while (!inimigosEmCampo.isEmpty()) {
			System.out.println(p);
			quebrarLinhas(2);
			System.out.println("Inimigos em campo: ");
			mostrarInimigos();
			quebrarLinhas(2);

			p.menuBatalha(this);
			for (int i = 0; i < inimigosEmCampo.size(); i++) {
				derrotarInimigo(p);
				if (inimigosEmCampo.size()==0) {
					break;
				}else {
					inimigosEmCampo.get(i).causarDano(p, 5);
					quebrarLinhas(2);
					personagemDerrotado(p);
					if (personagemDerrotado(p)) {
						break;
					}
				}
				
			}

		}
	}

	public void mostrarInimigos() {
		for (int i = 0; i < inimigosEmCampo.size(); i++) {
			System.out.print("Inimigo " + (i + 1) + " : ");
			System.out.println(inimigosEmCampo.get(i));
			fugirDungeon = true;
		}
	}

	public abstract void gerarInimigosRound();

	public void gerarInimigo(Inimigo i) {
		inimigosEmCampo.add(i);

	}

	public boolean personagemDerrotado(Personagem p) {

		if (p.getVida() <= 0) {
			System.out.println("Você desmaiou durante a batalha!!");
			System.out.println("Você chegou ao round " + roundAtual + "!!");
			p.setVida(1);
			quebrarLinhas(5);
			return true;
		}
		return false;
	}

	public void derrotarInimigo(Personagem p) {
		for (int i = 0; i < inimigosEmCampo.size(); i++) {
			if (inimigosEmCampo.get(i).getVida() == 0) {
				System.out.println("Um " + inimigosEmCampo.get(i) + " foi derrotado!!");
				inimigosEmCampo.get(i).inimigoDerrotado(p);
				inimigosEmCampo.remove(i);
				quebrarLinhas(5);
			}
		}
	}

	public int getRoudMax() {
		return roundMax;
	}

	public void setRoudMax(int roudMax) {
		this.roundMax = roudMax;
	}

	public int getRoud() {
		return roundAtual;
	}

	public void setRoud(int roud) {
		this.roundAtual = roud;
	}

	public ArrayList<Inimigo> getInimigosEmCampo() {
		return inimigosEmCampo;
	}

	public void setInimigosEmCampo(ArrayList<Inimigo> inimigosEmCampo) {
		this.inimigosEmCampo = inimigosEmCampo;
	}

	public void quebrarLinhas(int linhas) {
		for (int i = 0; i < linhas; i++) {
			System.out.println();
		}
	}

}
