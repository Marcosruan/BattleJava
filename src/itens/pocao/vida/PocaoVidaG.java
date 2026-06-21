package itens.pocao.vida;

import itens.Item;
import personagens.AtributoPersonagem;

public class PocaoVidaG extends Item{
	//Atributos para o item
	private final static String nome = " Poção Grande de Vida";
	private final static String descricao = "Uma poção mágica grande que cura 300 de vida!";
	private final static int raridade = 2;
	private final static int custo = 500;
	private final static int usos = 0;
	
	//Atributos para o personagem
	private final static int vida = 300;
	private final static int dano = 0;
	private final static int armadura = 0;
	private final static int chanceCritico = 0;
	private final static int mana = 0;
	private final static int manaRegen = 0;
	
	public PocaoVidaG() {
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
