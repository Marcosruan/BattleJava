package personagens.inimigos;

import personagens.AtributoPersonagem;
import personagens.Heroi;
import personagens.Inimigo;
import utils.Cores;
import utils.TextoGradativo;

public class DemonioSargentoSupremo extends Inimigo{
	private static final String nome = "Demônio Sargento Supremo";
	private static final int VIDA = 1000;
	private static final int DANO = 200;
	private static final int ARMADURA = 100;
	private static final int CHANCECRITICO = 30;
	private static final int VALOR = 600;
	public DemonioSargentoSupremo() {
		super(nome,
				new AtributoPersonagem(VIDA, DANO, ARMADURA, CHANCECRITICO),
				VALOR);
	}
	@Override
	public void apresentacao() {
		TextoGradativo.imprimirTextoGradativo("Um grande demônio aterrorizante e imponente surge do chão!", 10);
		TextoGradativo.imprimirTextoGradativo("Você sente que ele não é peixe pequeno só pela aura!", 10);
		TextoGradativo.imprimirTextoGradativo("'Você é mais forte do que pensávamos, humano nojento?' - disse o demônio", 10);
		TextoGradativo.imprimirTextoGradativo("Mas eu vou te destruir!!!", 10);
	}
	
	@Override
	public void util() {
		TextoGradativo.imprimirTextoGradativoColorido("💪 O demônio se fortaleceu e ganhou 10% de chance de crítico!", Cores.ANSI_YELLOW, 10);
		atributos.setChanceCritico(atributos.getChanceCritico() + 10);
	}
	
	@Override
	public void especial1(Heroi alvo, int defesaDoHeroi) {
		int vidaHeroi = alvo.atributos.getVida();
		int armadura = alvo.atributos.getArmadura();
		int dano = atributos.getDano() + 100;
		int danoFinal = (armadura * defesaDoHeroi ) - dano;
		
		// Evita de um personagem curar o outro
		if (danoFinal > 0) {
			danoFinal = 0;
		}
		
		TextoGradativo.imprimirTextoGradativoColorido("⚔️ O demônio atacou com Jato de Plasma, causando " + (-danoFinal) + " de dano!", Cores.ANSI_RED, 10);
		alvo.atributos.setVida(vidaHeroi + danoFinal);
	}
}
