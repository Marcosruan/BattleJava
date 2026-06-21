package itens.runa.dano;

import itens.Item;
import personagens.AtributoPersonagem;

public class RunaDanoP extends Item {
	//Atributos para o item
	private final static String nome = "Runa pequena de dano";
	private final static String descricao = "Uma runa que aumenta o dano em 50 permanentemente!";
	private final static int raridade = 0;
	private final static int custo = 100;
	private final static int usos = 0;
	
	//Atributos para o personagem
	private final static int vida = 0;
	private final static int dano = 50;
	private final static int armadura = 0;
	private final static int chanceCritico = 0;
	private final static int mana = 0;
	private final static int manaRegen = 0;
	
	public RunaDanoP() {
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
