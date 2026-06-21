package personagens.herois;

import personagens.AtributoPersonagem;
import personagens.Heroi;
import personagens.Inimigo;
import utils.TextoGradativo;

public class Guerreiro extends Heroi{
	private static final int VIDA = 500;
	private static final int DANO = 100;
	private static final int ARMADURA = 80;
	private static final int MANA = 10;
	private static final int MANAREGEN = 2;
	private static final int CHANCECRITICO = 0;
		
	public Guerreiro(String nome) {
		super(
				nome, 
				new AtributoPersonagem(VIDA, DANO, ARMADURA, CHANCECRITICO),
				new AtributosHeroi(MANA, MANAREGEN)
				);
	}
	
	public static void apresentacao() {
		System.out.println("=".repeat(150));
		TextoGradativo.imprimirTextoGradativo("🪓 Guerreiro: ", 5);
		TextoGradativo.imprimirTextoGradativo("Um valente héroi que usa um grande machado. Perfeito para jogadores que prezam por resistência e pouco dano!", 5);
	    TextoGradativo.imprimirTextoGradativo("❤️ Vida base: " + VIDA, 5);
	    TextoGradativo.imprimirTextoGradativo("⚔️ Dano base: " + DANO, 5);
	    TextoGradativo.imprimirTextoGradativo("🛡️ Armadura base: " + ARMADURA, 5);
	    TextoGradativo.imprimirTextoGradativo("💧 Mana base: " + MANA, 5);
	    TextoGradativo.imprimirTextoGradativo("⏳ Regeneração de mana base: " + MANAREGEN + " p/turno", 5);
	    TextoGradativo.imprimirTextoGradativo("🎯 Chance de crítico base: " + CHANCECRITICO + "%", 5);
	    TextoGradativo.imprimirTextoGradativo("💫 Especial do héroi: Ataca causando 3x o dano base no inimigo e aumentando a própria defesa em 10 permanentemente a cada especial.", 5);
	    System.out.println("=".repeat(150));
		System.out.println();
	}
	
	public void especial(Inimigo alvo, int defesaDoInimigo) {
		int vidaInimigo = alvo.atributos.getVida();
		int armadura = alvo.atributos.getArmadura();
		int dano = atributos.getDano();
		int danoComCritico = dano * 3;
		int danoFinal = (armadura * defesaDoInimigo ) - danoComCritico;
		
		// Evita de um personagem curar o outro
		if (danoFinal > 0) {
			danoFinal = 0;
		}
		
		alvo.atributos.setVida(vidaInimigo + danoFinal);
		
		atributosHeroi.setMana(atributosHeroi.getMana() - 10);
		
		atributos.setArmadura(atributos.getArmadura() + 10);
				
		TextoGradativo.imprimirTextoGradativo("⚔️ Seu ataque especial inflingiu " + (-danoFinal) + " de dano no inimigo!", 20);			
		TextoGradativo.imprimirTextoGradativo("🛡️ O herói aumentou a armadura em 10 com o especial!", 20);			
	}
}
