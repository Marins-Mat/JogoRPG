package classes;

public abstract class Classe {
	private int vidaMax;
	private int manaMax;
	private int estaminaMax;
	
	public int getVidaMax() {
		return vidaMax;
	}
	public void setVidaMax(int vidaMax) {
		this.vidaMax = vidaMax;
	}
	public int getManaMax() {
		return manaMax;
	}
	public void setManaMax(int manaMax) {
		this.manaMax = manaMax;
	}
	public int getEstaminaMax() {
		return estaminaMax;
	}
	public void setEstaminaMax(int estaminaMax) {
		this.estaminaMax = estaminaMax;
	}
}
