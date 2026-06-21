package personagens.inimigos;

import personagens.AtributoPersonagem;
import personagens.Heroi;
import personagens.Personagem;
import personagens.Inimigo;
import utils.Cores;
import utils.TextoGradativo;

public class ReiDemonio extends Inimigo{
	private static final String nome = "Rei Demônio";
	private static final int VIDA = 3000;
	private static final int DANO = 500;
	private static final int ARMADURA = 300;
	private static final int CHANCECRITICO = 50;
	private static final int VALOR = 0;
	private static int stack = 1;
	
	public ReiDemonio() {
		super(nome,
				new AtributoPersonagem(VIDA, DANO, ARMADURA, CHANCECRITICO),
				VALOR,
				true);
	}
	
	public void atacar(Personagem alvo, int defesa) {
		int vidaHeroi = alvo.atributos.getVida();
		int armadura = alvo.atributos.getArmadura();
		int dano = atributos.getDano();
		int chanceCritico = this.atributos.getChanceCritico();
		int danoComCritico = critico(dano, chanceCritico);
		int danoFinal = (armadura * defesa ) - danoComCritico;
		
		// Evita de um personagem curar o outro
		if (danoFinal > 0) {
			danoFinal = 0;
		}
		
		alvo.atributos.setVida(vidaHeroi + danoFinal);
		stack += 1;
		TextoGradativo.imprimirTextoGradativo("Você sofreu " + (-danoFinal) + " de dano do inimigo!", 20);
		TextoGradativo.imprimirTextoGradativo("O Rei Demônio stacka com o ataque e está com " + stack + " stack(s)", 20);
	}
	
	@Override
	public void apresentacao() {
		TextoGradativo.imprimirTextoGradativo("Finalmente você cara a cara com o Rei Demônio!", 10);
		TextoGradativo.imprimirTextoGradativo("Ele te ver e começa a rir com um riso de deboche!", 10);
		TextoGradativo.imprimirTextoGradativo("'Não sei como um ser tão asqueroso conseguiu chegar até aqui.' - diz o Rei Demônio", 10);
		TextoGradativo.imprimirTextoGradativo("'Eu não queria manchar minhas mãos com seu sangue impuro, mas eu tenho que dar um fim a isso!' - e o Rei parte pro ataque!", 10);
	}
	
	@Override
	public void util() {
		TextoGradativo.imprimirTextoGradativoColorido("❤️ O Rei Demônio se curou em 400 de vida!", Cores.ANSI_GREEN, 10);
		int curaRecebida = atributos.getVida() +(100 * stack);
		if (curaRecebida >= VIDA) {
			curaRecebida = VIDA;
		}
		atributos.setVida(curaRecebida);
	}
	
	public void especial1(Heroi alvo, int defesaDoHeroi) {
		int vidaHeroi = alvo.atributos.getVida();
		int armadura = alvo.atributos.getArmadura();
		int dano = (200 * stack);
		int danoFinal = (armadura * defesaDoHeroi) - dano;
		
		// Evita de um personagem curar o outro
		if (danoFinal > 0) {
			danoFinal = 0;
		}
		
		TextoGradativo.imprimirTextoGradativoColorido("⚔️ O demônio atacou com Meteoro, causando " + (-danoFinal) + " de dano!", Cores.ANSI_RED, 10);
		alvo.atributos.setVida(vidaHeroi + danoFinal);
	}
	
	public void especial2(Heroi alvo) {
		TextoGradativo.imprimirTextoGradativoColorido("💧 O demônio sugou " + stack + " da sua mana!", Cores.ANSI_BLUE, 10);
		alvo.atributosHeroi.setMana(alvo.atributosHeroi.getMana() - stack);
	}
	
	public void especial3(Heroi alvo) {
		TextoGradativo.imprimirTextoGradativoColorido("💪 O demônio se fortaleceu com 100 de armadura!", Cores.ANSI_YELLOW, 10);
		atributos.setArmadura(atributos.getArmadura() + 100);
	}
	
	public void especial4(Heroi alvo) {
		TextoGradativo.imprimirTextoGradativoColorido("O Rei Demônio se concentra e dobra suas stacks!", Cores.ANSI_CYAN, 10);
		stack *= 2;
	}
}
