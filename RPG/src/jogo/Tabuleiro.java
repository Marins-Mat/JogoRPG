package jogo;

import java.util.Scanner;

public class Tabuleiro {
	
	private boolean ativo;
	Scanner sc = new Scanner(System.in);
	Personagem p;
	public Tabuleiro() {
		ativo=false;
		
	}
	public void novoJogo() {
		ativo=true;
		p = criarPersonagem(p);
		menuDoJogador();
	}
	
	public Personagem criarPersonagem(Personagem p) {
		if (ativo) {
			System.out.println("Qual o nome do seu personagem?");
			String nome = sc.next();
			return p= new Personagem(nome);
		}else {
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
					ativo=false;
					break;
				default:
					System.out.println("Nenhuma opção selecionada, escolha novamente");
					break;
				}
			}
			
		}else {
			System.out.println("Jogo não está iniciado, comece um novo jogo!!");
		}
		
	}
}
