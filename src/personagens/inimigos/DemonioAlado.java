package personagens.inimigos;

import personagens.AtributoPersonagem;
import personagens.Heroi;
import personagens.Inimigo;
import utils.Cores;
import utils.TextoGradativo;

public class DemonioAlado extends Inimigo{
	private static final String nome = "Demônio Alado";
	private static final int VIDA = 750;
	private static final int DANO = 100;
	private static final int ARMADURA = 30;
	private static final int CHANCECRITICO = 30;
	private static final int valor = 200;
	private static int altura = 1;
	
	public DemonioAlado() {
		super(nome,
				new AtributoPersonagem(VIDA, DANO, ARMADURA, CHANCECRITICO),
				valor);
	}
	@Override
	public void apresentacao() {
		TextoGradativo.imprimirTextoGradativo("Você ouve um bater de asas no céu...", 20);
		TextoGradativo.imprimirTextoGradativo("Um demônio com asas surge e te ataca!", 20);
		TextoGradativo.imprimirTextoGradativo("Ele grita - 'Você não chegará mais perto do Rei Demônio, seu verme!'", 20);
	}
	
	@Override
	public void util() {
		TextoGradativo.imprimirTextoGradativoColorido("🕊️ O demônio voou! Quanto mais alto ele estiver, maior o dano do especial dele!", Cores.ANSI_CYAN, 10);
		altura += 1;
		TextoGradativo.imprimirTextoGradativoColorido("Altura atual: " + altura + " metro(s).", Cores.ANSI_CYAN, 10);
	}
	
	public void especial1(Heroi alvo, int defesaDoHeroi) {
		int vidaHeroi = alvo.atributos.getVida();
		int armadura = alvo.atributos.getArmadura();
		int dano = atributos.getDano();
		dano *= altura;
		int danoFinal = (armadura * defesaDoHeroi ) - dano;
		
		// Evita de um personagem curar o outro
		if (danoFinal > 0) {
			danoFinal = 0;
		}
		
		TextoGradativo.imprimirTextoGradativoColorido("⚔️ O demônio atacou com Golpe Rasante, causando " + (-danoFinal) + " de dano!", Cores.ANSI_RED, 10);
		alvo.atributos.setVida(vidaHeroi + danoFinal);
	}
}
