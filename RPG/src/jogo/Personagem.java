package jogo;

public class Personagem {
	private String nome;
	private int vida;
	private int vidaMax;
	private int mana;
	private int manaMax;
	private int estamina;
	private int estaminaMax;
	private int nivel;
	private int exp;
	private int expMax;


	public Personagem(String nome) {
		super();
		this.nome = nome;
		vidaMax = 10;
		manaMax = 10;
		estaminaMax = 10;
		vida = vidaMax;
		mana = manaMax;
		estamina = estaminaMax;
		nivel = 1;
		exp = 0;
		expMax = 200;
	}

	public void abrirInventario() {
		System.out.println("------Inventario------");
		System.out.println("Nome : " + nome);
		System.out.println("Nivel : " + nivel + "|| Exp: (" + exp + "/" + expMax + ")");
		System.out.println("Vida : "  + "(" + vida + "/" + vidaMax + ")");
		System.out.println("Mana : "  + "(" + mana + "/" + manaMax + ")");
		System.out.println("Estamina : " + "(" + estamina + "/" + estaminaMax + ")");
	
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
}
