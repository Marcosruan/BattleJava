package itens.pocao.vida;

import itens.Item;
import personagens.AtributoPersonagem;

public class PocaoVidaP extends Item {
	//Atributos para o item
	private final static String nome = "Poção Pequena de Vida";
	private final static String descricao = "Uma pequena poção mágica que cura 50 de vida!";
	private final static int raridade = 0;
	private final static int custo = 50;
	private final static int usos = 0;
	
	//Atributos para o personagem
	private final static int vida = 50;
	private final static int dano = 0;
	private final static int armadura = 0;
	private final static int chanceCritico = 0;
	private final static int mana = 0;
	private final static int manaRegen = 0;
	
	public PocaoVidaP() {
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
