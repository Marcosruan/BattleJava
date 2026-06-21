package itens.runa.especial;

import itens.Item;
import personagens.AtributoPersonagem;

public class ChanceCriticoMax extends Item{
	//Atributos para o item
	private final static String nome = "Runa de chance de critico máximo";
	private final static String descricao = "Uma runa especial que aumenta a sua chance de critico para o máximo!";
	private final static int raridade = 3;
	private final static int custo = 1000;
	private final static int usos = 0;
	
	//Atributos para o personagem
	private final static int vida = 0;
	private final static int dano = 0;
	private final static int armadura = 0;
	private final static int chanceCritico = 100;
	private final static int mana = 0;
	private final static int manaRegen = 0;
	
	public ChanceCriticoMax() {
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