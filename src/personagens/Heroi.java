package personagens;
import java.util.ArrayList;

import itens.Item;
import main.Main;
import personagens.herois.AtributosHeroi;
import utils.Cores;
import utils.TextoGradativo;

public abstract class Heroi extends Personagem{
	public AtributosHeroi atributosHeroi;
	public static ArrayList<Item> itens = new ArrayList<Item>();
	private static ArrayList<Item> itensAtuais = new ArrayList<Item>();
	
	public Heroi(String nome, AtributoPersonagem atributos, AtributosHeroi atributosHeroi) {
		super(nome, atributos);
			
		this.atributosHeroi = atributosHeroi;
	}
	
	public void regeneracaoManaTurno(int atributoBase) {
		int regen = atributosHeroi.getManaRegen();
		int manaAtual = atributosHeroi.getMana();
		int novaMana = manaAtual + regen;
		
		if (novaMana > atributoBase) novaMana = atributoBase;
		
		atributosHeroi.setMana(novaMana);
	}
	
	public void escolherPocao(String tipo, int atributoBase) {
		exibirPocoes(tipo);
		System.out.print("Sua escolha: ");
		int escolha = Main.verificarEscolha(0, itensAtuais.size());
		
		if (escolha == 0) {
			return;
		}
		
		Item item = itensAtuais.get(escolha - 1);
		
		if (tipo.equals("Vida")) {
			curar(item, atributoBase);			
		} else {
			recuperarMana(item, atributoBase);
		}
	}
	
	private void exibirPocoes(String acaba) {
		int cont = 1;
		TextoGradativo.imprimirTextoGradativo("\t\t--- Poções de " + acaba +" ---", 20);
		System.out.println("--------------------------------------------");
		for (Item item: Heroi.itens) {
			if (item.nome.startsWith("Poção") && item.nome.endsWith(acaba)) {
				if (item.getUsos() > 0) {
					itensAtuais.add(item);
					TextoGradativo.imprimirTextoGradativo("[" + (cont++) + "] - Nome: " + item.nome, 20);
					TextoGradativo.imprimirTextoGradativo("Descrição: " + item.descricao, 20);
					TextoGradativo.imprimirTextoGradativo("Quantidade disponível: " + item.getUsos(), 20);
					System.out.println("--------------------------------------------");	
				}
			}
		}
		System.out.println("[0] - Sair");
	}
	
	private void curar(Item item, int vidaBase) {
		if (item.getUsos() == 0) {
			TextoGradativo.imprimirTextoGradativo("Sem usos disponíveis!", 20);
			return;
		}
		
		if (atributos.getVida() == vidaBase) {
			TextoGradativo.imprimirTextoGradativo("Vida cheia!", 20);
			return;
		}
		
		int vida = atributos.getVida() + item.atributos.getVida();
		if (vida > vidaBase) {
			vida = vidaBase;
		}
		atributos.setVida(vida);
		item.setUsos(item.getUsos() - 1);
		TextoGradativo.imprimirTextoGradativoColorido("Se curou em " + item.atributos.getVida() + " pontos de vida!", Cores.ANSI_GREEN, 20);
	}
	
	private void recuperarMana(Item item, int manaBase) {
		if (item.getUsos() == 0) {
			TextoGradativo.imprimirTextoGradativo("Sem usos disponíveis!", 20);
			return;
		}
		if (atributosHeroi.getMana() == manaBase) {
			TextoGradativo.imprimirTextoGradativo("Mana cheia!", 20);
			return;
		}
		int mana = atributosHeroi.getMana() + item.getMana();
		if (mana > manaBase) {
			mana = manaBase;
		}
		atributosHeroi.setMana(mana);
		item.setUsos(item.getUsos() - 1);
		TextoGradativo.imprimirTextoGradativoColorido("Recuperou " + mana + " de mana!", Cores.ANSI_CYAN, 20);
	}
	
	public void usarItens(Item item) {
		
		if (item.nome.startsWith("Poção")) {
			System.out.println("Poção só pode ser usada em batalha!");
			return;
		}
		
		int vida = item.atributos.getVida();
		int dano = item.atributos.getDano();
		int armadura = item.atributos.getArmadura();
		int chanceCritico = item.atributos.getChanceCritico();
		int mana = item.getMana();
		int manaRegen = item.getManaRegen();
		
		
		if (vida > 0) {
			atributos.setVida(atributos.getVida() + vida);
		} else if (dano > 0) {
			atributos.setDano(atributos.getDano() + dano);
		} else if (armadura > 0) {
			atributos.setArmadura(atributos.getArmadura() + armadura);
		} else if (chanceCritico > 0) {
			atributos.setChanceCritico(atributos.getChanceCritico() + chanceCritico);
		} else if (mana > 0) {
			atributosHeroi.setMana(atributosHeroi.getMana() + mana);
		} else if (manaRegen > 0) {
			atributosHeroi.setManaRegen(atributosHeroi.getManaRegen() + manaRegen);			
		}
		item.setUsos(item.getUsos() - 1);
	}
	
	public void verInventario() {
		itensAtuais.clear();
		int cont = 0;
		if (itens.size() == 0) {
			TextoGradativo.imprimirTextoGradativo("Inventário vazio!", 15);
		}
		System.out.println("---------------------------------------------");
		for (Item item: itens) {
			if (item.getUsos() > 0) {
				cont++;
				itensAtuais.add(item);
				System.out.print("[ " + cont + " ] - ");
				System.out.println(item);
				System.out.println("---------------------------------------------");
			}
		}
		if (cont > 0) {
			TextoGradativo.imprimirTextoGradativo("Deseja usar qual item? (0 para sair)", 20);
			int escolha = Main.verificarEscolha(0, cont);
			if (escolha == 0) {
				return;
			} else {
				usarItens(itensAtuais.get(escolha - 1));
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String titulo = "STATUS DO HERÓI: " + nome.toUpperCase();
		int tamanho = titulo.length() + 20;
		
	    String topoDivisoria  = "╔" + "═".repeat(tamanho + 2) + "╗\n";
	    String divisorMeio    = "╠" + "═".repeat(tamanho + 2) + "╣\n";
	    String linhaDivisoria = "╚" + "═".repeat(tamanho + 2) + "╝\n";


	    String vidaString = ajustaString("Vida Atual:", String.valueOf(this.atributos.getVida()), tamanho);
	    String danoString = ajustaString("Dano Atual:", String.valueOf(this.atributos.getDano()), tamanho);
	    String armaduraString = ajustaString("Armadura:", String.valueOf(this.atributos.getArmadura()), tamanho);
	    String chanceString = ajustaString("Chance de Crítico:", String.valueOf(this.atributos.getChanceCritico()) + "%", tamanho);
	    String manaString = ajustaString("Mana:", String.valueOf(this.atributosHeroi.getMana()), tamanho);
	    String regenString = ajustaString("Regen. de Mana:", String.valueOf(this.atributosHeroi.getManaRegen()) + " p/turno", tamanho);
	    String moedasString = ajustaString("Moedas:", String.valueOf(this.atributosHeroi.getMoedas()), tamanho);
	    
	    sb.append(topoDivisoria);
	    
	    sb.append(String.format("║ %s ║\n", centro(titulo, tamanho)));
	    
	    sb.append(divisorMeio);
	    
	    sb.append(vidaString);
	    sb.append(danoString);
	    sb.append(armaduraString);
	    sb.append(chanceString);
	    sb.append(manaString);
	    sb.append(regenString);
	    sb.append(moedasString);
	    
	    sb.append(linhaDivisoria);

	    return sb.toString();
	}
	
	/**
	 * Cria uma String formatada com os atributos do herói
	 * @param parte1	Primeira parte da String final que deverá ficar à esquerda. Contém o tipo do atributo.
	 * @param parte2	Parte derradeira da String final que deverá ficar à direita. Contém o valor do atributo.
	 * @param tamanho	Tamanho total da String final com espaços
	 * @return			String formatada com os atributos e valores do herói
	 */
	private String ajustaString(String parte1, String parte2, int tamanho) {
		int espacos = Math.max(0, tamanho - parte1.length() - parte2.length());
		
		return "║ " + parte1 + " ".repeat(espacos) + parte2 + " ║\n";
	}

	/**
	 * Centraliza uma String e coloca espaços até atingir o tamanho da String final a ser retornada
	 * @param texto		String a ser centralizada
	 * @param tamanho	Tamanho total da String final com espaços
	 * @return			String centralizada e com espaços
	 */
	private String centro(String texto, int tamanho) {
	    if (texto == null || tamanho <= texto.length()) return texto;
	    int espacos = tamanho - texto.length();
	    int espacosEsquerda = espacos / 2;
	    int espacosDireita = espacos - espacosEsquerda;
	    return " ".repeat(espacosEsquerda) + texto + " ".repeat(espacosDireita);
	}

	public abstract void especial(Inimigo vilao, int defesaDoInimigo);	
}
