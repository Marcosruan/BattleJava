package itens.runa.vida;

import itens.Item;
import personagens.AtributoPersonagem;

public class RunaVidaM extends Item{
	//Atributos para o item
	private final static String nome = "Runa de vida";
	private final static String descricao = "Uma runa que aumenta a vida em 250 permanentemente!";
	private final static int raridade = 1;
	private final static int custo = 300;
	private final static int usos = 0;
	
	//Atributos para o personagem
	private final static int vida = 250;
	private final static int dano = 0;
	private final static int armadura = 0;
	private final static int chanceCritico = 0;
	private final static int mana = 0;
	private final static int manaRegen = 0;
	
	public RunaVidaM() {
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
