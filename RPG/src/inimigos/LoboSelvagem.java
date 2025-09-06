package inimigos;

public class LoboSelvagem extends Inimigo{
	public LoboSelvagem(int nivel) {
		setNome("Lobo Selvagem");
		setVidaMax(4 * nivel);
		setManaMax(1 * nivel);
		setEstaminaMax((int) Math.round(1.7) * nivel);
		setVida(getVidaMax());
		setMana(getManaMax());
		setEstamina(getEstaminaMax());;
		setNivel(nivel);
	}
}
