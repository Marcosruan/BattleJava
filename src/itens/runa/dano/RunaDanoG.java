package itens.runa.dano;

import itens.Item;
import personagens.AtributoPersonagem;

public class RunaDanoG extends Item {
	//Atributos para o item
	private final static String nome = "Runa grande de dano";
	private final static String descricao = "Uma runa que aumenta o dano em 300 permanentemente!";
	private final static int raridade = 2;
	private final static int custo = 500;
	private final static int usos = 0;
	
	//Atributos para o personagem
	private final static int vida = 0;
	private final static int dano = 300;
	private final static int armadura = 0;
	private final static int chanceCritico = 0;
	private final static int mana = 0;
	private final static int manaRegen = 0;
	
	public RunaDanoG() {
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
