package itens.pocao.mana;

import itens.Item;
import personagens.AtributoPersonagem;

public class PocaoManaG extends Item {
	//Atributos para o item
	private final static String nome = "Poção Grande de Mana";
	private final static String descricao = "Uma poção mágica que regenera 8 de mana!";
	private final static int raridade = 2;
	private final static int custo = 500;
	private final static int usos = 0;
	
	//Atributos para o personagem
	private final static int vida = 0;
	private final static int dano = 0;
	private final static int armadura = 0;
	private final static int chanceCritico = 0;
	private final static int mana = 8;
	private final static int manaRegen = 0;
	
	public PocaoManaG() {
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
