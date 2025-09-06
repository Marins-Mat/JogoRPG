package inimigos;

public class Slime extends Inimigo{
	public Slime(int nivel) {
		setNome("Slime");
		setVidaMax(3 * nivel);
		setManaMax(2 * nivel);
		setEstaminaMax((int) Math.round(1.5) * nivel);
		setVida(getVidaMax());
		setMana(getManaMax());
		setEstamina(getEstaminaMax());;
		setNivel(nivel);
	}
}
