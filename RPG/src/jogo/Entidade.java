package jogo;

import inimigos.Inimigo;

public abstract class Entidade {
	private String nome;
	private int vida;
	private int vidaMax;
	private int mana;
	private int manaMax;
	private int estamina;
	private int estaminaMax;
	private int nivel;
	
	public void causarDano(Personagem p, int dano) {
		p.setVida(p.getVida()-dano);
		System.out.println(p.getNome() + " recebeu " + dano + " de dano!!");
		
	}
	
	public void causarDano(Inimigo i, int dano) {
		i.setVida(i.getVida()-dano);
		if (i.getVida()<0) {
			i.setVida(0);
		}
		System.out.println(i + " recebeu " + dano + " de dano!!");
		
		
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
	
}
