package itens.runa.especial;

import itens.Item;
import personagens.AtributoPersonagem;

public class DobraDano extends Item{
	//Atributos para o item
	private final static String nome = "Runa de dano especial";
	private final static String descricao = "Uma runa especial que dobra o seu dano base!";
	private final static int raridade = 3;
	private final static int custo = 1000;
	private final static int usos = 0;
	
	//Atributos para o personagem
	private final static int vida = 0;
	private final static int dano = 0;
	private final static int armadura = 0;
	private final static int chanceCritico = 0;
	private final static int mana = 0;
	private final static int manaRegen = 0;
	
	public DobraDano() {
		super(nome, 
				  descricao, 
				  raridade, 
				  custo, 
				  usos,
				  mana,
				  manaRegen,
				  new AtributoPersonagem(vida, dano, armadura, chanceCritico)
				  );
	}
}