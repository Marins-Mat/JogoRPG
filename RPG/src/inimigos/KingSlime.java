package inimigos;

public class KingSlime extends Inimigo{

	public KingSlime(int nivel) {
		super(nivel);
		setNome("King Slime");
		setVidaMax(7 * nivel);
		setManaMax(5 * nivel);
		setEstaminaMax((int) Math.round(2.5) * nivel);
		setVida(getVidaMax());
		setMana(getManaMax());
		setEstamina(getEstaminaMax());
		setExpConcedida((int) Math.round(12.5)*nivel);
	}

}
