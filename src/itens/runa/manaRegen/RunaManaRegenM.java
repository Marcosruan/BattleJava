package itens.runa.manaRegen;

import itens.Item;
import personagens.AtributoPersonagem;

public class RunaManaRegenM extends Item {
	//Atributos para o item
	private final static String nome = "Runa de regeneração de mana";
	private final static String descricao = "Uma runa que aumenta a regeneração de mana em 4 permanentemente!";
	private final static int raridade = 1;
	private final static int custo = 300;
	private final static int usos = 0;
	
	//Atributos para o personagem
	private final static int vida = 0;
	private final static int dano = 0;
	private final static int armadura = 0;
	private final static int chanceCritico = 0;
	private final static int mana = 0;
	private final static int manaRegen = 4;
	
	public RunaManaRegenM() {
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
