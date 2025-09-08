package inimigos;

public class LoboSelvagem extends Inimigo{
	public LoboSelvagem(int nivel) {
		super(nivel);
		setNome("Lobo Selvagem");
		setVidaMax(5 * nivel);
		setManaMax(1 * nivel);
		setEstaminaMax((int) Math.round(1.9) * nivel);
		setVida(getVidaMax());
		setMana(getManaMax());
		setEstamina(getEstaminaMax());
		setExpConcedida((int) Math.round(8.5)*nivel);
	}
}
