package personagens.herois;

import personagens.AtributoPersonagem;
import personagens.Heroi;
import personagens.Inimigo;
import utils.Cores;
import utils.TextoGradativo;

public class Mago extends Heroi{
	private static final int VIDA = 300;
	private static final int DANO = 200;
	private static final int ARMADURA = 50;
	private static final int MANA = 10;
	private static final int MANAREGEN = 2;
	private static final int CHANCECRITICO = 0;
	private static boolean burn;
	
	public Mago(String nome) {
		super(nome, 
				new AtributoPersonagem(VIDA, DANO, ARMADURA, CHANCECRITICO),
				new AtributosHeroi(MANA, MANAREGEN));
	}
	
	public static void apresentacao() {
		System.out.println("=".repeat(150));
		TextoGradativo.imprimirTextoGradativo("🧙‍♂️ Mago: ", 5);
		TextoGradativo.imprimirTextoGradativo("Um ardiloso héroi que usa uma cajado. Perfeito para jogadores que prezam por muito dano e pouca resistência!", 5);
	    TextoGradativo.imprimirTextoGradativo("❤️ Vida base: " + VIDA, 5);
	    TextoGradativo.imprimirTextoGradativo("⚔️ Dano base: " + DANO, 5);
	    TextoGradativo.imprimirTextoGradativo("🛡️ Armadura base: " + ARMADURA, 5);
	    TextoGradativo.imprimirTextoGradativo("💧 Mana base: " + MANA, 5);
	    TextoGradativo.imprimirTextoGradativo("⏳ Regeneração de mana base: " + MANAREGEN + " p/turno", 5);
	    TextoGradativo.imprimirTextoGradativo("🎯 Chance de crítico base: " + CHANCECRITICO + "%", 5);
	    TextoGradativo.imprimirTextoGradativo("💫 Especial do héroi: Lança uma Bola de Fogo que causa 2x o dano base no inimigo e marca com fogo. O próximo especial quebra a marca e dá mais dano!", 5);
	    System.out.println("=".repeat(150));
		System.out.println();
	}
	
	@Override
	public void especial(Inimigo alvo, int defesaDoInimigo) {
		String texto1 = "⚔️ Você atacou com Bola de Fogo, causando ";
		String texto2 = "";
		
		int vidaInimigo = alvo.atributos.getVida();
		int armadura = alvo.atributos.getArmadura();
		
		int dano = 0;
		
		
		if (burn) {
			dano += (atributos.getDano() / 2);
			burn = false;
			texto1 = "⚔️ Você atacou com Bola de Fogo, quebrando a marca de fogo e causando ";
		} else {
			burn = true;
			texto2 = "🔥 Agora o demônio está marcado com fogo! Seu próximo especial causará mais dano.";
		}
		
		dano += atributos.getDano();
		dano *= 2;
		
		int danoFinal = (armadura * defesaDoInimigo ) - dano;
		
		// Evita de um personagem curar o outro
		if (danoFinal > 0) {
			danoFinal = 0;
		}
				
		TextoGradativo.imprimirTextoGradativoColorido(texto1 + (-danoFinal) + " de dano!", Cores.ANSI_RED, 10);
		TextoGradativo.imprimirTextoGradativoColorido(texto2, Cores.ANSI_RED, 10);
		alvo.atributos.setVida(vidaInimigo + danoFinal);
		atributosHeroi.setMana(atributosHeroi.getMana() - 10);
	}	
}
