package jogo;

import java.util.Random;

import main.Main;
import personagens.Heroi;
import personagens.Inimigo;
import personagens.herois.Arqueiro;
import personagens.herois.Guerreiro;
import utils.Cores;
import utils.ExibeJogo;
import utils.TextoGradativo;

public class Batalha {
	Heroi heroi;
	Inimigo inimigo;
	int restaurarVida;
	int restaurarMana;
	int vilaoVidaMaxima;
	
	public Batalha(Heroi heroi, Inimigo vilao) {
		this.heroi = heroi;
		this.inimigo = vilao;
		restaurarVida = heroi.atributos.getVida();
		restaurarMana = heroi.atributosHeroi.getMana();
	}
	
	public boolean iniciarBatalha() {
		int escolha;
		int vidaHeroi = heroi.atributos.getVida();
		int vidaInimigo = inimigo.atributos.getVida();
		int vidaMaximaInimigo = inimigo.atributos.getVida();
		heroi.atributosHeroi.setMana(0);
		int manaHeroi = heroi.atributosHeroi.getMana();
		
		do {
			ExibeJogo.exibeBarraManaVida(heroi.nome, vidaHeroi, restaurarVida, inimigo.nome, vidaInimigo, vidaMaximaInimigo, manaHeroi, restaurarMana);			
			String especial = (heroi instanceof Arqueiro) ? "Super Flecha" : (heroi instanceof Guerreiro) ? "Ataque Avassalador" : "Bola de Fogo";
			System.out.println();
			System.out.println("-".repeat(140));
			TextoGradativo.imprimirTextoGradativo("Sua ação!", 10);
			TextoGradativo.imprimirTextoGradativo("1 - ⚔️ Atacar", 10);
			TextoGradativo.imprimirTextoGradativo("2 - 🛡️ Defender", 10);
			TextoGradativo.imprimirTextoGradativo("3 - ❤️ Poção de Vida", 10);
			TextoGradativo.imprimirTextoGradativo("4 - 💧 Poção de Mana", 10);
			TextoGradativo.imprimirTextoGradativo("5 - 🎯 " + especial, 10);
			System.out.println("-".repeat(140));
			System.out.print("Sua escolha: ");
			escolha = Main.verificarEscolha(1, 5);
			
			if (escolha == 5) {
				if (heroi.atributosHeroi.getMana() < 10) {
					TextoGradativo.imprimirTextoGradativo("Sem mana suficiente!", 10);
					continue;
				}
			}
			
			int defesaDoInimigo = 1, defesaDoHeroi = 1;
			int acao = acaoDoInimigo(inimigo.chefao);
			inimigo.atordoado = false;
			
			// Ação do jogador
			switch (escolha) {
				case 1:
					if (acao == 0) {
						defesaDoInimigo = 2;
					}
					heroi.atacar(inimigo, defesaDoInimigo);
					break;
				case 2:
					defesaDoHeroi = 2;
					TextoGradativo.imprimirTextoGradativo("Você se defendeu!", 10);
					break;
				case 3:
					heroi.escolherPocao("Vida", restaurarVida);
					break;
				case 4:
					heroi.escolherPocao("Mana", restaurarMana);
					break;
				case 5:
					heroi.especial(inimigo, defesaDoInimigo);
					break;
				default:
					break;
			}
			
			// Ação do vilão
			if (inimigo.atributos.getVida() > 0 && !inimigo.atordoado) {
				switch (acao) {
				case 1:
					inimigo.atacar(heroi, defesaDoHeroi);
					break;
				case 2:
					inimigo.util();
					break;
				case 3:
					inimigo.especial1(heroi, defesaDoHeroi);
					break;
				case 4:
					inimigo.especial2(heroi);
					break;
				case 5:
					inimigo.especial3(heroi);
					break;
				case 6:
					inimigo.especial4(heroi);
					break;
				default:
					System.out.println("O demônio se defendeu!");
					break;
				}
			}

			if (escolha != 5) heroi.regeneracaoManaTurno(restaurarMana);
			vidaHeroi = heroi.atributos.getVida();
			manaHeroi = heroi.atributosHeroi.getMana();
			vidaInimigo = inimigo.atributos.getVida();
			
		} while(vidaHeroi > 0 && vidaInimigo > 0);
		
		ExibeJogo.exibeBarraManaVida(heroi.nome, vidaHeroi, restaurarVida, inimigo.nome, vidaInimigo, vidaMaximaInimigo, manaHeroi, restaurarMana);			
		
		boolean resultado = vidaHeroi>vidaInimigo;
		restaurarVidaManaParaBase();
		if (resultado) {
			TextoGradativo.imprimirTextoGradativo("Você derrotou o inimigo!", 10);
			TextoGradativo.imprimirTextoGradativoColorido("Recuperou totalmente a vida e ganhou 100 de vida para o próximo combate.", Cores.ANSI_GREEN, 10);
			TextoGradativo.imprimirTextoGradativoColorido("Você recebeu " + inimigo.getValor() + " moedas por derrotar o " + inimigo.nome, Cores.ANSI_YELLOW, 10);
		}
		heroi.atributosHeroi.setMoedas(heroi.atributosHeroi.getMoedas() + inimigo.getValor());
		return resultado;
	}

	private void restaurarVidaManaParaBase() {
		heroi.atributos.setVida(restaurarVida);
		heroi.atributosHeroi.setMana(restaurarMana);
	}

	/**
	 * Gera uma ação aleatória para o inimigo
	 * @param chefao	parâmetro para caso seja o boss do jogo
	 * @return			inteiro que corresponderá à alguma ação do inimigo
	 */
	private int acaoDoInimigo(boolean chefao) {
		Random gerador = new Random();
		int numGerado;
		if (chefao) {
			numGerado = gerador.nextInt(7);
		} else {
			numGerado = gerador.nextInt(4);
		}
		return numGerado;
	}
}
