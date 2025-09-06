package inimigos;

import java.util.Random;

import assets.*;
import jogo.Entidade;
import jogo.Personagem;

public abstract class Inimigo extends Entidade{
	private int expConcedida;
	private Random rand = new Random();
	private int verif;
	public String toString() {
		return getNome() + " [" + getNivel() + "]"
				+ "Vida : " + "(" + getVida() + "/" + getVidaMax() + ")" 
					+ " Mana : "+ "(" + getMana() + "/" + getManaMax() + ")" 
						+ " Estamina : " + "(" + getEstaminaMax() + "/" + getEstaminaMax() + ")";
	}
	
	public void inimigoDerrotado(Personagem p) {
		verif = rand.nextInt(0, 31);
		Item item;
		if (verif<20) {
			item = new PocaoDeCura("s");
		} else if(verif<28) {
			item = new PocaoDeCura("m");
		} else {
			item = new PocaoDeCura("g");
		}
			
		p.setExp(p.getExp()+expConcedida);
		p.subirDeNivel();
		if (item!=null) {
			p.coletarItem(null);
		}
		

	}
	
}
