package assets;

import jogo.Personagem;

public class PocaoDeCura extends Item {
	private int valorCura;
	private String grauDaPocao;

	public PocaoDeCura(String grauDaPocao) {
		this.grauDaPocao = grauDaPocao;
		if (grauDaPocao == "s") {
			valorCura = 5;
		} else if (grauDaPocao == "m") {
			valorCura = 10;
		} else if (grauDaPocao == "g") {
			valorCura = 15;
		}
	}

	public void usarItem(Personagem p) {
		p.setVida(p.getVida() + valorCura);
		if (p.getVida() > p.getVidaMax()) {
			int vidaRecuperada = valorCura - (p.getVida()-p.getVidaMax());
			System.out.println("Vida Maxima atingida!!");
			System.out.println("Vida recuperada em " + vidaRecuperada + " pontos");
			p.setVida(p.getVidaMax());
		} else {
			System.out.println("Vida recuperada em " + valorCura + " pontos");

		}
	}

	public String toString() {
		return "Poção de Cura (" + grauDaPocao + ")";
	}

}
