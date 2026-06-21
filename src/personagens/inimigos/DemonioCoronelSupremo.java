package personagens.inimigos;

import personagens.AtributoPersonagem;
import personagens.Heroi;
import personagens.Inimigo;
import utils.Cores;
import utils.TextoGradativo;

public class DemonioCoronelSupremo extends Inimigo{
	private static final String nome = "Demônio Coronel Supremo";
	private static final int VIDA = 2000;
	private static final int DANO = 400;
	private static final int ARMADURA = 200;
	private static final int CHANCECRITICO = 40;
	private static final int VALOR = 1000;
	private static boolean hipnose;
	
	public DemonioCoronelSupremo() {
		super(nome,
				new AtributoPersonagem(VIDA, DANO, ARMADURA, CHANCECRITICO),
				VALOR);
	}
	@Override
	public void apresentacao() {
		TextoGradativo.imprimirTextoGradativo("Você sente que está perto do Rei Demônio de verdade, mas antes de pôr um fim nele, um último inimigo surge na sua frente!", 10);
		TextoGradativo.imprimirTextoGradativo("'Eu como braço direito do Rei Demônio, jamais deixarei que você passe daqui!!!'", 10);
		TextoGradativo.imprimirTextoGradativo("Um demônio com forma humanóide e vestimentas sumptuosas se prepara para te atacar!", 10);
	}
	
	@Override
	public void util() {
		TextoGradativo.imprimirTextoGradativoColorido("🌀 O demônio te hipnotizou!", Cores.ANSI_PURPLE, 10);
		hipnose = true;
	}
	
	@Override
	public void especial1(Heroi alvo, int defesaDoHeroi) {
		int vidaHeroi = alvo.atributos.getVida();
		int armadura = alvo.atributos.getArmadura();
		int dano = atributos.getDano() * 2;
		int danoFinal = (armadura * defesaDoHeroi ) - dano;
		
		// Evita de um personagem curar o outro
		if (danoFinal > 0) {
			danoFinal = 0;
		}
		
		TextoGradativo.imprimirTextoGradativoColorido("⚔️ O demônio atacou com Magia Ancestral, causando " + (-danoFinal) + " de dano!", Cores.ANSI_RED, 10);
		
		if (hipnose) {
			int danoProprio = alvo.atributos.getDano();
			TextoGradativo.imprimirTextoGradativoColorido("🌀 ⚔️ Como você foi hipnotizado, você atacou a si mesmo, causando " + danoProprio + " de dano!", Cores.ANSI_RED, 10);
			alvo.atributos.setVida(vidaHeroi - danoProprio);			
			hipnose = false;
		}
		alvo.atributos.setVida(vidaHeroi + danoFinal);
	}
}
