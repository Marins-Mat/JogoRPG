package dungeons;

import inimigos.Inimigo;
import inimigos.Slime;
import inimigos.LoboSelvagem;
import inimigos.KingSlime;
import java.util.Random;

public class PradariasVerdejantes extends Dungeon {
	public PradariasVerdejantes() {
		super();
		setRoudMax(10);
	}

	public void gerarInimigosRound() {
		int qntInimigos;
		int qntInimigosMin;
		int qntInimigosMax;
		int nivMin;
		int nivMax;

		Random rand = new Random();

		switch (getRoud()) {
		case 1:
			qntInimigosMin = 1;
			qntInimigosMax = 3;
			qntInimigos = rand.nextInt(qntInimigosMin, qntInimigosMax);
			nivMin = 1;
			nivMax = 3;
			loopGerarInimigos(qntInimigos, nivMin, nivMax, rand);

			break;

		case 2:

			qntInimigosMin = 1;
			qntInimigosMax = 4;
			qntInimigos = rand.nextInt(qntInimigosMin, qntInimigosMax);
			nivMin = 2;
			nivMax = 3;

			loopGerarInimigos(qntInimigos, nivMin, nivMax, rand);

			break;
		case 3:
			qntInimigosMin = 1;
			qntInimigosMax = 5;
			qntInimigos = rand.nextInt(qntInimigosMin, qntInimigosMax);
			nivMin = 2;
			nivMax = 5;

			loopGerarInimigos(qntInimigos, nivMin, nivMax, rand);
			break;
		case 4:
			qntInimigosMin = 2;
			qntInimigosMax = 6;
			qntInimigos = rand.nextInt(qntInimigosMin, qntInimigosMax);
			nivMin = 2;
			nivMax = 6;

			loopGerarInimigos(qntInimigos, nivMin, nivMax, rand);
			break;
		case 5:
			qntInimigosMin = 3;
			qntInimigosMax = 7;
			qntInimigos = rand.nextInt(qntInimigosMin, qntInimigosMax);
			nivMin = 3;
			nivMax = 7;

			loopGerarInimigos(qntInimigos, nivMin, nivMax, rand);
			break;
		case 6:
			qntInimigosMin = 4;
			qntInimigosMax = 7;
			qntInimigos = rand.nextInt(qntInimigosMin, qntInimigosMax);
			nivMin = 4;
			nivMax = 8;

			loopGerarInimigos(qntInimigos, nivMin, nivMax, rand);
			break;
		case 7:
			qntInimigosMin = 1;
			qntInimigosMax = 8;
			qntInimigos = rand.nextInt(qntInimigosMin, qntInimigosMax);
			nivMin = 5;
			nivMax = 8;

			loopGerarInimigos(qntInimigos, nivMin, nivMax, rand);
			break;
		case 8:
			qntInimigosMin = 1;
			qntInimigosMax = 8;
			qntInimigos = rand.nextInt(qntInimigosMin, qntInimigosMax);
			nivMin = 5;
			nivMax = 8;

			loopGerarInimigos(qntInimigos, nivMin, nivMax, rand);
			break;
		case 9:
			qntInimigosMin = 1;
			qntInimigosMax = 8;
			qntInimigos = rand.nextInt(qntInimigosMin, qntInimigosMax);
			nivMin = 6;
			nivMax = 8;

			loopGerarInimigos(qntInimigos, nivMin, nivMax, rand);
			break;
		case 10:
			qntInimigosMin = 3;
			qntInimigosMax = 6;
			qntInimigos = rand.nextInt(qntInimigosMin, qntInimigosMax);
			nivMin = 7;
			nivMax = 9;

			Inimigo kingSlime = new KingSlime(10);
			gerarInimigo(kingSlime);
			loopGerarInimigos(qntInimigos, nivMin, nivMax, rand);
			break;
		}

	}

	private void loopGerarInimigos(int qntInimigos, int nivMin, int nivMax, Random rand) {
		int tipoInimigo;
		int niv;
		Inimigo in;
		for (int i = 0; i < qntInimigos; i++) {
			niv = rand.nextInt(nivMin, nivMax);
			tipoInimigo = rand.nextInt(1, 101);
			if (tipoInimigo <= 75) {
				in = new Slime(niv);
				gerarInimigo(in);
			} else {
				in = new LoboSelvagem(niv);
				gerarInimigo(in);
			}
		}
	}
}
