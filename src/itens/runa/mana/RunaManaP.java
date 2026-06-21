package itens.runa.mana;

import itens.Item;
import personagens.AtributoPersonagem;

public class RunaManaP extends Item {
	//Atributos para o item
	private final static String nome = "Runa pequena de mana";
	private final static String descricao = "Uma runa que aumenta a mana em 2 permanentemente!";
	private final static int raridade = 0;
	private final static int custo = 100;
	private final static int usos = 0;
	
	//Atributos para o personagem
	private final static int vida = 0;
	private final static int dano = 0;
	private final static int armadura = 0;
	private final static int chanceCritico = 0;
	private final static int mana = 2;
	private final static int manaRegen = 0;
	
	public RunaManaP() {
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