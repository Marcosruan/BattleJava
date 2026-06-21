package jogo;


import java.util.ArrayList;

import main.Main;
import personagens.Heroi;
import personagens.Inimigo;
import personagens.herois.Arqueiro;
import personagens.herois.Guerreiro;
import personagens.inimigos.DemonioAlado;
import personagens.inimigos.DemonioCapitaoSupremo;
import personagens.inimigos.DemonioComMachado;
import personagens.inimigos.DemonioCoronelSupremo;
import personagens.inimigos.DemonioMago;
import personagens.inimigos.DemonioSargentoSupremo;
import personagens.inimigos.DemonioCaboSupremo;
import personagens.inimigos.ReiDemonio;
import utils.InicializaItens;
import utils.TextoGradativo;


public class Jogo {
	static ArrayList<Inimigo> inimigos = new ArrayList<Inimigo>();
	public static void iniciarJogo(Heroi heroi) {
		Loja loja = new Loja(heroi);
		new InicializaItens();
		inicializarInimigos();
		String arma = (heroi instanceof Arqueiro) ? "arco" : (heroi instanceof Guerreiro) ? "machado" : "cajado";
		System.out.println();
		TextoGradativo.imprimirTextoGradativo(heroi.nome + ", o destemido herói inicia sua jornada!", 20);
		TextoGradativo.imprimirTextoGradativo("Ele pretende destruir as forças malígnas que assolam sua terra natal!", 20);
		TextoGradativo.imprimirTextoGradativo("Com seu " + arma + " em mãos, segue estrada em direção ao covil do Rei Demônio...", 20);
		System.out.println();
		
		for (int i = 0; i < 8; i++) {
			boolean heroiVivo = fase(i, heroi);
			if (heroiVivo) {
				if (i == 7) {
					encerramento(heroi);
				} else {
					escalarHeroi(heroi);
					posCombate(loja, heroi);
				}
			} else {
				TextoGradativo.imprimirTextoGradativo("🪦 GAME OVER", 400);
				TextoGradativo.imprimirTextoGradativo("Rode o código novamente para jogar outra vez!", 20);
				return;
			}
		}
	}
	
	private static void escalarHeroi(Heroi heroi) {
		heroi.atributos.setVida(heroi.atributos.getVida() + 100);
	}

	private static void posCombate(Loja loja, Heroi heroi) {
		int escolha = 10;
		int cont = 0;
		do {
			escolha = exibirMenu();
			if (escolha == 1) {
				return;
			}
			if (escolha == 2 && cont == 0) {
				loja.exibirLoja(heroi);
				cont++;
			} else if (escolha == 3) {
				heroi.verInventario();
			} else if (escolha == 4) {
				System.out.println(heroi);
			} else {
				TextoGradativo.imprimirTextoGradativo("Você já acessou a loja!", cont);
			}
		} while (escolha != 0);
	}

	private static int exibirMenu() {
		System.out.println();
		System.out.println("-".repeat(140));
		TextoGradativo.imprimirTextoGradativo("1 - Ir para próxima batalha.", 10);
		TextoGradativo.imprimirTextoGradativo("2 - Ver loja.", 10);
		TextoGradativo.imprimirTextoGradativo("3 - Inventário.", 10);
		TextoGradativo.imprimirTextoGradativo("4 - Ver atributos do herói.", 10);
		System.out.println("-".repeat(140));
		System.out.print("Sua escolha: ");
		return Main.verificarEscolha(1, 4);
	}

	private static void encerramento(Heroi heroi) {
		TextoGradativo.imprimirTextoGradativo(heroi.nome + ", o destemido herói encerra sua jornada!", 20);		
		TextoGradativo.imprimirTextoGradativo("As forças malígnas que assolavam sua terra natal foram finalmente destruídas!", 20);		
		TextoGradativo.imprimirTextoGradativo("Você pode finalmente descançar, herói!", 20);
		TextoGradativo.imprimirTextoGradativo("BattleJava", 400);		
		TextoGradativo.imprimirTextoGradativo("Criador: Marcos Ruan", 100);		
		TextoGradativo.imprimirTextoGradativo("Patrocínio: Não teve.", 100);
		TextoGradativo.imprimirTextoGradativo("Obrigado por jogar!", 100);
	}
	
	/**
	 * Inicializa a classe batalha passando o inimigo e o heroi
	 * 
	 * @param indice	posição do vetor de inimigos
	 * @param heroi		instancia do herói
	 * @return 			retorna true se o heroi estiver vivo e false caso contrario
	 */
	private static boolean fase(int indice, Heroi heroi) {
		boolean heroiVivo = false;
		Inimigo inimigo = inimigos.get(indice);
		inimigo.apresentacao();
		Batalha batalha = new Batalha(heroi, inimigo);
		heroiVivo = batalha.iniciarBatalha();
		return heroiVivo;
	}

	private static void inicializarInimigos() {
		inimigos.add(new DemonioComMachado());
		inimigos.add(new DemonioAlado());
		inimigos.add(new DemonioMago());
		inimigos.add(new DemonioCaboSupremo());
		inimigos.add(new DemonioSargentoSupremo());
		inimigos.add(new DemonioCapitaoSupremo());
		inimigos.add(new DemonioCoronelSupremo());
		inimigos.add(new ReiDemonio());
	}
}
