package jogo;

import java.util.ArrayList;
import java.util.Random;

import itens.Item;
import itens.pocao.mana.PocaoManaP;
import main.Main;
import personagens.Heroi;
import utils.Cores;
import utils.TextoGradativo;

public class Loja {
	static Heroi heroi;
	public static ArrayList<Item> comuns = new ArrayList<Item>();
	public static ArrayList<Item> raros = new ArrayList<Item>();
	public static ArrayList<Item> epicos = new ArrayList<Item>();
	public static ArrayList<Item> lendarios = new ArrayList<Item>();
	static ArrayList<Item> itensAtuais = new ArrayList<Item>();
	static int[] itensComprados;
	
	public Loja(Heroi novoHeroi) {
		heroi = novoHeroi;
	}

	public void exibirLoja(Heroi heroi) {
		itensComprados = new int[] {0,0,0,0};
		System.out.println("\n==================================================");
		System.out.printf( "\t\t%s\n","LOJA DE EQUIPAMENTOS");
		System.out.println("==================================================");
		TextoGradativo.imprimirTextoGradativo("Bem-vindo à loja do BattleJava!", 20);
		TextoGradativo.imprimirTextoGradativo("Temos os seguintes itens disponíveis para compra!", 20);
		System.out.println("--------------------------------------------------");
		
		exibirItens();
		
		escolhaDeItem(heroi);
		
		itensAtuais.clear();
	}
	
	private static void escolhaDeItem(Heroi heroi) {
		System.out.println();
		TextoGradativo.imprimirTextoGradativoColorido("Suas moedas: " + heroi.atributosHeroi.getMoedas(), Cores.ANSI_YELLOW, 20);
		System.out.print("Sua escolha: ");
		int escolha = Main.verificarEscolha(0, 4);
		
		while (escolha != 0) {
			boolean comprado = false;
			
			for (int item: itensComprados) {
				if (item == escolha) {
					System.out.println("Item já comprado!");
					comprado = true;
				}
			}
			
			if (!comprado) {
				Item atual = itensAtuais.get(escolha - 1);
				if (heroi.atributosHeroi.getMoedas() < atual.custo) {
					System.out.println("Moedas insuficientes!");
				} else {
					for (Item item: Heroi.itens) {
						if (item.getClass() == atual.getClass()) {
							item.setUsos(item.getUsos() + 1);
							heroi.atributosHeroi.setMoedas(heroi.atributosHeroi.getMoedas() - atual.custo);
						}
					}
					System.out.println("Item comprado com sucesso!");
					itensComprados[escolha-1] = escolha;					
				}
			}
			System.out.println("Compre outra coisa.");
			TextoGradativo.imprimirTextoGradativoColorido("\nSuas moedas: " + heroi.atributosHeroi.getMoedas(), Cores.ANSI_YELLOW, 20);
			System.out.print("Sua escolha: ");
			escolha = Main.verificarEscolha(0, 4);
		}
	}
	
	private static void exibirItens() {
		for (int i = 0; i < 4; i++) {
			Item itemSorteado = itemAleatorio();
			itensAtuais.add(itemSorteado);
			String cor = obterCor(itemSorteado.raridade);
			TextoGradativo.imprimirTextoGradativoColorido("[" + (i+1) + "] - " + itemSorteado.nome, cor, 10);
			TextoGradativo.imprimirTextoGradativoColorido("Descrição: " + itemSorteado.descricao, cor, 10);
			TextoGradativo.imprimirTextoGradativoColorido("Custo: " + itemSorteado.custo, cor, 10);
			System.out.println("--------------------------------------------------");
		}
		System.out.println("[0] - Sair da Loja");
	}
	
	/**
	 * Retorna uma cor baseado na raridade do item.
	 * 0 - Raridade comum e cor padrão do console.
	 * 1 - Raridade rara e cor verde.
	 * 2 - Raridade épica e cor roxa.
	 * 3 - Raridade lendária e cor amarela.
	 * @param raridade	Raridade do item.
	 * @return			Caractere ansi para alguma cor.
	 */
	public static String obterCor(int raridade) {
		String cor = Cores.ANSI_WHITE;
		switch (raridade) {
		case 1:
			cor = Cores.ANSI_GREEN;
			break;
		case 2:
			cor = Cores.ANSI_PURPLE;
			break;
		case 3:
			cor = Cores.ANSI_YELLOW;
			break;
		default:
			break;
		}
		return cor;
	}

	/**
	 * Retorna um item aleatório da lista de itens
	 * @return	instancia de Item
	 */
	private static Item itemAleatorio() {
		Item item = new PocaoManaP();
		Random gerador = new Random();
		//Gera numero para raridade
		int numGerado = gerador.nextInt(100) + 1;
		//Gera numero para tipo do item
		int novoNumGerado = gerador.nextInt(8);
		
		if (numGerado > 0 && numGerado < 56) {
			item = comuns.get(novoNumGerado);
		} else if (numGerado > 55 && numGerado < 81) {
			item = raros.get(novoNumGerado);
		} else if (numGerado > 80 && numGerado < 96) {
			item = epicos.get(novoNumGerado);
		} else {
			int novoNumGeradoLendario = gerador.nextInt(6);
			item = lendarios.get(novoNumGeradoLendario);
		}
		
		return item;
	}
}
