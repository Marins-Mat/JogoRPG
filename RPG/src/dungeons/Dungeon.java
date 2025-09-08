package dungeons;

import java.util.ArrayList;
import java.util.Scanner;

import inimigos.Inimigo;
import jogo.Personagem;

public abstract class Dungeon {
	private int roundMax;
	private int roundAtual;
	private ArrayList<Inimigo> inimigosEmCampo = new ArrayList<>();
	Scanner sc;
	boolean ativo;
	boolean fugirDungeon;

	public Dungeon(Scanner sc) {
		roundAtual = 0;
		fugirDungeon = false;
		ativo = true;
		this.sc=sc;
	}

	public void runDungeon(Personagem p) {

		do {
			round(p);
			System.out.println("Você deseja fugir da dungeon?");
			System.out.println("1. Sim | x. Não");
			
			if (sc.nextInt() == 1) {
				fugirDungeon = true;
			} else {
				fugirDungeon = false;
			}
			
			encerrarDungeon(p);
		} while (ativo);
		
		System.out.println("Você chegou ao round " + roundAtual + "!!");
		
		
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
					encerrarDungeon(p);
				}
				
			}

		}
	}
	
	public void encerrarDungeon(Personagem p) {
		if (personagemDerrotado(p)||fugirDungeon||roundAtual == roundMax) {
			System.out.println("Encerrando dungeon");
			System.out.println(personagemDerrotado(p));
			System.out.println(fugirDungeon);
			System.out.println(roundAtual == roundMax);
			ativo=false;
			inimigosEmCampo.clear();
		}
	}

	public void mostrarInimigos() {
		for (int i = 0; i < inimigosEmCampo.size(); i++) {
			System.out.print("Inimigo " + (i + 1) + " : ");
			System.out.println(inimigosEmCampo.get(i));
		}
	}

	public abstract void gerarInimigosRound();

	public void gerarInimigo(Inimigo i) {
		inimigosEmCampo.add(i);

	}

	public boolean personagemDerrotado(Personagem p) {

		if (p.getVida() <= 0) {
			System.out.println("Você desmaiou durante a batalha!!");
			
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
