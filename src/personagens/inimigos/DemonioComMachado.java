package personagens.inimigos;

import personagens.AtributoPersonagem;
import personagens.Heroi;
import personagens.Inimigo;
import utils.Cores;
import utils.TextoGradativo;

public class DemonioComMachado extends Inimigo {
	private static final String nome = "Demônio com Machado";
	private static final int VIDA = 500;
	private static final int DANO = 100;
	private static final int ARMADURA = 40;
	private static final int CHANCECRITICO = 10;
	private static final int VALOR = 100;
	public DemonioComMachado() {
		super(nome,
				new AtributoPersonagem(VIDA, DANO, ARMADURA, CHANCECRITICO),
				VALOR);
	}
	@Override
	public void apresentacao() {
		TextoGradativo.imprimirTextoGradativo("Você ouve um arrastar de machado...", 20);
		TextoGradativo.imprimirTextoGradativo("Um demônio com um machado te vê!", 20);
		TextoGradativo.imprimirTextoGradativo("Ele fala - 'Eu amo cortar... cortar... cortar...'", 20);
		TextoGradativo.imprimirTextoGradativo("Ele vem em sua direção para te atacar!", 20);
	}
	
	@Override
	public void util() {
		TextoGradativo.imprimirTextoGradativoColorido("💪 O demônio se fortaleceu e ganhou 50 de dano de ataque!", Cores.ANSI_YELLOW, 10);
		atributos.setDano(atributos.getDano() + 50);
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
		
		TextoGradativo.imprimirTextoGradativoColorido("⚔️ O demônio atacou com Machadada Voraz, causando " + (-danoFinal) + " de dano!", Cores.ANSI_RED, 10);
		alvo.atributos.setVida(vidaHeroi + danoFinal);
	}
}
