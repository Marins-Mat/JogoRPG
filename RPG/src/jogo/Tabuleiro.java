package jogo;

import java.util.Scanner;
import racas.*;
import classes.*;

public class Tabuleiro {

	private boolean ativo;
	Scanner sc = new Scanner(System.in);
	Personagem p;

	public Tabuleiro() {
		ativo = false;

	}

	public void novoJogo() {
		ativo = true;
		p = criarPersonagem(p);
		menuDoJogador();
	}

	public Personagem criarPersonagem(Personagem p) {
		if (ativo) {
			System.out.println("Qual o nome do seu personagem?");
			String nome = sc.next();
			Raca raca = null;
			Classe classe = null;
			System.out.println("Qual será sua raça?");
			System.out.println("1.Humano | 2.Elfo");
			int idRaca = sc.nextInt();
			while (raca == null) {
				switch (idRaca) {
				case 1:
					raca = new Humano();
					break;
				case 2:
					raca = new Elfo();
					break;
				default:
					System.out.println("Você precisa selecionar uma raça!!");
					break;
				}
			}

			System.out.println("Qual será sua classe?");
			System.out.println("1.Guerreiro | 2.Mago");
			int idClasse = sc.nextInt();
			while (classe == null) {
				switch (idClasse) {
				case 1:
					classe = new Guerreiro();
					break;
				case 2:
					classe = new Mago();
					break;
				default:
					System.out.println("Você precisa selecionar uma classe!!");
					break;
				}
			}

			return p = new Personagem(nome, raca, classe);
		} else {
			System.out.println("Jogo não está iniciado, comece um novo jogo para criar personagem");
			return null;
		}

	}

	public void menuDoJogador() {
		if (ativo) {
			while (ativo) {
				System.out.println("O que você quer fazer?");
				System.out.println("1. Abrir inventario | 2. Ir para Dungeon | 3. Encerrar o jogo ");
				int opcao = sc.nextInt();
				switch (opcao) {
				case 1:
					p.abrirInventario();
					break;
				case 2:
					System.out.println("Ainda vai ser implementado");
					break;
				case 3:
					System.out.println("Encerrando jogo...");
					ativo = false;
					break;
				default:
					System.out.println("Nenhuma opção selecionada, escolha novamente");
					break;
				}
			}

		} else {
			System.out.println("Jogo não está iniciado, comece um novo jogo!!");
		}

	}
}
