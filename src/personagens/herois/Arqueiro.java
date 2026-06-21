package personagens.herois;

import personagens.AtributoPersonagem;
import personagens.Heroi;
import personagens.Inimigo;
import utils.TextoGradativo;

public class Arqueiro extends Heroi{
	private static final int VIDA = 400;
	private static final int DANO = 150;
	private static final int ARMADURA = 50;
	private static final int MANA = 10;
	private static final int MANAREGEN = 2;
	private static final int CHANCECRITICO = 10;
	
	public Arqueiro(String nome) {
		super(nome,
				new AtributoPersonagem(VIDA, DANO, ARMADURA, CHANCECRITICO),
				new AtributosHeroi(MANA, MANAREGEN));
	}
	
	public static void apresentacao() {
		System.out.println("=".repeat(150));
	    TextoGradativo.imprimirTextoGradativo("🏹 Arqueiro: ", 5);
	    TextoGradativo.imprimirTextoGradativo("Um preciso herói que usa um arco. Perfeito para jogadores que prezam por equilíbrio de atributos!", 5);
	    TextoGradativo.imprimirTextoGradativo("❤️ Vida base: " + VIDA, 5);
	    TextoGradativo.imprimirTextoGradativo("⚔️ Dano base: " + DANO, 5);
	    TextoGradativo.imprimirTextoGradativo("🛡️ Armadura base: " + ARMADURA, 5);
	    TextoGradativo.imprimirTextoGradativo("💧 Mana base: " + MANA, 5);
	    TextoGradativo.imprimirTextoGradativo("⏳ Regeneração de mana base: " + MANAREGEN + " p/turno", 5);
	    TextoGradativo.imprimirTextoGradativo("🎯 Chance de crítico base: " + CHANCECRITICO + "%", 5);
	    TextoGradativo.imprimirTextoGradativo("💫 Especial do héroi: Dispara uma flecha que impede a ação do inimigo naquele turno e inflinge o dano base x2 de dano no inimigo!", 5);
	    System.out.println("=".repeat(150));
	    System.out.println();
	}
	
	public void especial(Inimigo alvo, int defesaDoInimigo) {
		int vidaInimigo = alvo.atributos.getVida();
		int armadura = alvo.atributos.getArmadura();
		int dano = atributos.getDano();
		int danoComCritico = dano * 2;
		int danoFinal = (armadura * defesaDoInimigo ) - danoComCritico;
		
		alvo.atordoado = true;
		
		// Evita de um personagem curar o outro
		if (danoFinal > 0) {
			danoFinal = 0;
		}
		
		alvo.atributos.setVida(vidaInimigo + danoFinal);
		
		atributosHeroi.setMana(atributosHeroi.getMana() - 10);
		
		TextoGradativo.imprimirTextoGradativo("⚔️ Sua Super Flecha inflingiu " + (-danoFinal) + " de dano no inimigo!", 20);			

		TextoGradativo.imprimirTextoGradativo("O inimigo está atordoado! Não atacará este turno.", 40);			
	}
}
