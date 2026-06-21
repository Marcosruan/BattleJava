package personagens.inimigos;

import personagens.AtributoPersonagem;
import personagens.Heroi;
import personagens.Inimigo;
import utils.Cores;
import utils.TextoGradativo;

public class DemonioCapitaoSupremo extends Inimigo{
	private static final String nome = "Demônio Capitão Supremo";
	private static final int VIDA = 1500;
	private static final int DANO = 300;
	private static final int ARMADURA = 100;
	private static final int CHANCECRITICO = 40;
	private static final int VALOR = 700;
	private static int acumulador = 0;
	
	public DemonioCapitaoSupremo() {
		super(nome,
				new AtributoPersonagem(VIDA, DANO, ARMADURA, CHANCECRITICO),
				VALOR);
	}
	@Override
	public void apresentacao() {
		TextoGradativo.imprimirTextoGradativo("Você ouve uma voz estranha em sua mente!", 10);
		TextoGradativo.imprimirTextoGradativo("'Como ousa chegar tão próximo do Rei. Não terei piedade!'", 10);
		TextoGradativo.imprimirTextoGradativo("No mesmo instante surge um demônio sem rosto vindo em sua direção vorazmente!", 10);
	}
	
	@Override
	public void util() {
		TextoGradativo.imprimirTextoGradativoColorido("❤️ O demônio se curou em 200 de vida!", Cores.ANSI_GREEN, 10);
		int curaRecebida = atributos.getVida() + 200;
		if (curaRecebida >= VIDA) {
			curaRecebida = VIDA;
		}
		atributos.setVida(curaRecebida);
	}
	
	@Override
	public void especial1(Heroi alvo, int defesaDoHeroi) {
		acumulador += 100;
		int vidaHeroi = alvo.atributos.getVida();
		int armadura = alvo.atributos.getArmadura();
		int dano = atributos.getDano();
		dano =+ acumulador;
		int danoFinal = (armadura * defesaDoHeroi ) - dano;
		
		// Evita de um personagem curar o outro
		if (danoFinal > 0) {
			danoFinal = 0;
		}
				
		TextoGradativo.imprimirTextoGradativoColorido("⚔️ O demônio atacou com Golpe Dilacerante, causando " + (-danoFinal) + " de dano!", Cores.ANSI_RED, 10);
		TextoGradativo.imprimirTextoGradativoColorido("A cada novo especial, o dano é aumentado em 100", Cores.ANSI_RED, 10);
		alvo.atributos.setVida(vidaHeroi + danoFinal);
	}
}
