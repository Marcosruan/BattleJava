package itens;

import jogo.Loja;
import personagens.AtributoPersonagem;
import utils.Cores;

public class Item {
	public String nome;
	public String descricao;
	public int raridade;
	public int custo;
	private int usos;
	private int mana;
	private int manaRegen;
	public AtributoPersonagem atributos;
	
	public Item(String nome, 
				String descricao, 
				int raridade, 
				int custo, 
				int usos, 
				int mana,
				int manaRegen,
				AtributoPersonagem atributos
				) {
		this.nome = nome;
		this.descricao = descricao;
		this.raridade = raridade;
		this.custo = custo;
		this.usos = usos;
		this.atributos = atributos;
		this.setMana(mana);
		this.setManaRegen(manaRegen);
	}

	public int getUsos() {
		return usos;
	}

	public void setUsos(int usos) {
		this.usos = usos;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getManaRegen() {
		return manaRegen;
	}

	public void setManaRegen(int manaRegen) {
		this.manaRegen = manaRegen;
	}
	
	public String toString() {
		String cor = Loja.obterCor(raridade);
		String retorno = cor + "Nome: " + nome + "\n Descrição: " + descricao + "\nQuantidade: " + usos + Cores.ANSI_RESET;
		return retorno;
	}
}
