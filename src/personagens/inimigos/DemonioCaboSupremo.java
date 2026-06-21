package personagens.inimigos;

import personagens.AtributoPersonagem;
import personagens.Heroi;
import personagens.Inimigo;
import utils.Cores;
import utils.TextoGradativo;

public class DemonioCaboSupremo extends Inimigo{
	private static final String nome = "Demônio Soldado Supremo";
	private static final int VIDA = 1500;
	private static final int DANO = 300;
	private static final int ARMADURA = 100;
	private static final int CHANCECRITICO = 30;
	private static final int VALOR = 500;
	private static int cura = 100;
	public DemonioCaboSupremo() {
		super(nome,
				new AtributoPersonagem(VIDA, DANO, ARMADURA, CHANCECRITICO),
				VALOR);
	}
	@Override
	public void apresentacao() {
		TextoGradativo.imprimirTextoGradativo("Você consegue adentrar o covil do Rei Demônio.", 10);
		TextoGradativo.imprimirTextoGradativo("Uma aura maligna te domina. Você sabe que algo poderoso se aproxima!", 10);
		TextoGradativo.imprimirTextoGradativo("O grande demônio surge das sombras!", 10);
		TextoGradativo.imprimirTextoGradativo("Ele fala - 'Você derrotou meus subordinados imprestáveis, mas você não terá chances contra mim, um soldado do Rei Demônio!'", 10);
	}
	
	@Override
	public void util() {
		TextoGradativo.imprimirTextoGradativoColorido("❤️ O demônio se curou em " + cura + " de vida!", Cores.ANSI_GREEN, 10);
		int curaRecebida = atributos.getVida() + cura;
		if (curaRecebida >= VIDA) {
			curaRecebida = VIDA;
		}
		atributos.setVida(curaRecebida);
	}	
	
	@Override
	public void especial1(Heroi alvo, int defesaDoHeroi) {
		atributos.setDano(atributos.getDano() + 50);
		cura += 50;
		TextoGradativo.imprimirTextoGradativoColorido("💪 O demônio usou Fortalecimento Demoníaco, aumentando a cura e o dano em 50", Cores.ANSI_RED, 10);
	}
}
