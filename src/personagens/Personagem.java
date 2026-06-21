package personagens;

import utils.Cores;
import utils.TextoGradativo;

import java.util.Random;

public abstract class Personagem {
	public String nome;
	private int critico = 2;
	public AtributoPersonagem atributos;
	
	public Personagem(String nome, AtributoPersonagem atributos) {
		this.nome = nome;
		this.atributos = atributos;
	}
	
	public void atacar(Personagem alvo, int defesa) {
		int vida = alvo.atributos.getVida();
		int armadura = alvo.atributos.getArmadura();
		int dano = this.atributos.getDano();
		int chanceCritico = this.atributos.getChanceCritico();
		int danoComCritico = critico(dano, chanceCritico);
		int danoFinal = (armadura * defesa ) - danoComCritico;
		
		// Evita de um personagem curar o outro
		if (danoFinal > 0) {
			danoFinal = 0;
		}
		
		alvo.atributos.setVida(vida + danoFinal);
		
		if (alvo instanceof Inimigo == true) {
			TextoGradativo.imprimirTextoGradativo("⚔️ Seu ataque inflingiu " + (-danoFinal) + " de dano no inimigo!", 20);			
		} else {
			TextoGradativo.imprimirTextoGradativo("⚔️ Você sofreu " + (-danoFinal) + " de dano do inimigo!", 20);					
		}
	}
	
	protected int critico(int dano, int chanceCritico) {
		int danoFinal = dano;
		if (chanceCritico > 0) {
			Random gerador = new Random();
			int numGerado = gerador.nextInt(100/chanceCritico) + 1;
			if (numGerado == 1) {
				danoFinal *= critico;
				System.out.println();
				TextoGradativo.imprimirTextoGradativoColorido("DANO CRÍTICO!!!", Cores.ANSI_RED, 10);
			}			
		}
		return danoFinal;
	}
}
