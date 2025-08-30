package classes;

public class Guerreiro extends Classe{
	public Guerreiro() {
		setVidaMax(7);
		setManaMax(1);
		setEstaminaMax(4);
	}

	@Override
	public String toString() {
		return "Guerreiro";
	}
}
