package main;

import java.util.Scanner;

import jogo.Jogo;
import personagens.herois.Arqueiro;
import personagens.herois.Guerreiro;
import personagens.herois.Mago;
import utils.TextoGradativo;

public class Main {
	public static final Scanner LEITOR = new Scanner(System.in);
	public static void main(String[] args) {
		
		TextoGradativo.imprimirTextoGradativo("Bem vindo ao BattleJava!", 30);
		System.out.print("Selecione o nome do seu personagem: ");
		String nome = LEITOR.next();
		TextoGradativo.imprimirTextoGradativo("Selecione a classe do seu personagem: ", 30);
		
		System.out.println();
		Arqueiro.apresentacao();
		Guerreiro.apresentacao();
		Mago.apresentacao();
		
		int escolha;
		do {
			menuEscolha();
			escolha = verificarEscolha(0, 3);
			switch(escolha) {
				case 1:
					Arqueiro arqueiro = new Arqueiro(nome);
					Jogo.iniciarJogo(arqueiro);
					escolha = 0;
					break;
				case 2:
					Guerreiro guerreiro = new Guerreiro(nome);
					Jogo.iniciarJogo(guerreiro);
					escolha = 0;
					break;
				case 3:
					Mago mago = new Mago(nome);
					Jogo.iniciarJogo(mago);
					escolha = 0;
					break;
				default:
					TextoGradativo.imprimirTextoGradativo("Opção inválida! Tente novamente!", 10);
					break;
			}
		} while (escolha != 0);
		
		LEITOR.close();
		
	}

	private static void menuEscolha() {
		TextoGradativo.imprimirTextoGradativo("1 - 🏹 Arqueiro", 10);
		TextoGradativo.imprimirTextoGradativo("2 - 🪓 Guerreiro",10);
		TextoGradativo.imprimirTextoGradativo("3 - 🧙‍♂️ Mago", 10);
		TextoGradativo.imprimirTextoGradativo("0 - Sair", 10);
		System.out.print("Sua escolha: ");
	}
	
	public static int lerInteiro() {
		while (!LEITOR.hasNextInt()) {
			System.out.println("Isso não é um número!");
			System.out.print("Tente novamente: ");
			LEITOR.next();
		}
		return LEITOR.nextInt();
	}
	
	/**
	 * @param menor = menor número possível
	 * @param maior = maior número possivel
	 * @return um número dentro do intervalo compreendido entre o menor e o maior número possível
	 */
	public static int verificarEscolha(int menor, int maior) {
		int escolha = lerInteiro();
		while (escolha < menor || escolha > maior) {
			System.out.println("Escolha inválida! Número fora do intervalo.");
			System.out.print("Tente novamente: ");
			escolha = lerInteiro();
		}
		System.out.println();
		return escolha;
	}
}
