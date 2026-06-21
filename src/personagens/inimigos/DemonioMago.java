package personagens.inimigos;

import personagens.AtributoPersonagem;
import personagens.Heroi;
import personagens.Inimigo;
import utils.Cores;
import utils.TextoGradativo;

public class DemonioMago extends Inimigo{
	private static final String nome = "Demônio Mago";
	private static final int VIDA = 400;
	private static final int DANO = 100;
	private static final int ARMADURA = 20;
	private static final int CHANCECRITICO = 30;
	private static final int VALOR = 300;
	
	public DemonioMago() {
		super(nome,
				new AtributoPersonagem(VIDA, DANO, ARMADURA, CHANCECRITICO),
				VALOR);
	}
	@Override
	public void apresentacao() {
		TextoGradativo.imprimirTextoGradativo("Você está próximo do covil do Rei Demônio.", 10);
		TextoGradativo.imprimirTextoGradativo("Mas antes de adentrar no castelo, um sujeito encapuzado surge no seu caminho!", 10);
		TextoGradativo.imprimirTextoGradativo("Ele te diz - 'Daqui você não passa, verme! Eu usarei minha magia maligna para te destruir!'", 10);
	}
	
	@Override
	public void util() {
		TextoGradativo.imprimirTextoGradativoColorido("💧 O demônio se curou em 100 de vida!", Cores.ANSI_GREEN, 10);
		int curaRecebida = atributos.getVida() + 100;
		if (curaRecebida >= VIDA) {
			curaRecebida = VIDA;
		}
		atributos.setVida(curaRecebida);
	}
	
	public void especial1(Heroi alvo, int defesaDoHeroi) {
		int vidaHeroi = alvo.atributos.getVida();
		int armadura = alvo.atributos.getArmadura();
		int dano = atributos.getDano() * 2;
		int danoFinal = (armadura * defesaDoHeroi ) - dano;
		
		// Evita de um personagem curar o outro
		if (danoFinal > 0) {
			danoFinal = 0;
		}
		
		alvo.atributos.setVida(vidaHeroi + danoFinal);
		
		TextoGradativo.imprimirTextoGradativoColorido("⚔️ O demônio atacou com Fogo Demoníaco, causando " + (-danoFinal) + " de dano!", Cores.ANSI_RED, 10);			
	}
}
