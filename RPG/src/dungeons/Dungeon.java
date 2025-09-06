package dungeons;
import java.util.ArrayList;
import inimigos.Inimigo;
import jogo.Personagem;
public abstract class Dungeon {
	private int roudMax;
	private int round;
	private ArrayList<Inimigo> inimigosEmCampo = new ArrayList<>();
	
	public Dungeon() {
		round=0;
	}
	public void roud(Personagem p) {
		round++;
		System.out.println("Inimigos apareceram: " + inimigosEmCampo);
		while (!inimigosEmCampo.isEmpty()) {
			System.out.println("Inimigos em campo: " + inimigosEmCampo);
			derrotarInimigo(p);
			
			p.menuBatalha();
			for (int i = 0; i < inimigosEmCampo.size(); i++) {
				inimigosEmCampo.get(i).causarDano(p, 5);
				personagemDerrotado(p);
			}
		}
	}
			
	public void personagemDerrotado(Personagem p) {
		if (p.getVida()==0) {
			System.out.println("Você desmaiou durante a batalha!!");
			System.out.println("Você chegou ao round " + round + "!!");
			p.setVida(1);
		}
	}
	
	public void derrotarInimigo(Personagem p) {
		for (int i = 0; i < inimigosEmCampo.size(); i++) {
			if (inimigosEmCampo.get(i).getVida()==0) {
				System.out.println("Um " + inimigosEmCampo.get(i) + " foi derrotado!!");
				inimigosEmCampo.get(i).inimigoDerrotado(p);
				inimigosEmCampo.remove(i);
			}
		}
	}
	
	
	public int getRoudMax() {
		return roudMax;
	}
	public void setRoudMax(int roudMax) {
		this.roudMax = roudMax;
	}
	public int getRoud() {
		return round;
	}
	public void setRoud(int roud) {
		this.round = roud;
	}
	public ArrayList<Inimigo> getInimigosEmCampo() {
		return inimigosEmCampo;
	}
	public void setInimigosEmCampo(ArrayList<Inimigo> inimigosEmCampo) {
		this.inimigosEmCampo = inimigosEmCampo;
	}
	
	
	
}
