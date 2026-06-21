package itens.runa.chanceCritico;

import itens.Item;
import personagens.AtributoPersonagem;

public class RunaChanceCriticoG extends Item {
	//Atributos para o item
	private final static String nome = "Runa grande de chance de crítico";
	private final static String descricao = "Uma runa que aumenta a chance de crítico em 50% permanentemente!";
	private final static int raridade = 2;
	private final static int custo = 500;
	private final static int usos = 0;
	
	//Atributos para o personagem
	private final static int vida = 0;
	private final static int dano = 0;
	private final static int armadura = 0;
	private final static int chanceCritico = 50;
	private final static int mana = 0;
	private final static int manaRegen = 0;
	
	public RunaChanceCriticoG() {
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
