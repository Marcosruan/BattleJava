package personagens;

public class AtributoPersonagem {
	private int vida;
	private int dano;
	private int armadura;
	private int chanceCritico;
	
	public AtributoPersonagem(
			int vida, 
			int dano, 
			int armadura, 
			int chanceCritico) {
		
		this.vida = vida;
		this.dano = dano;
		this.armadura = armadura;
		this.chanceCritico = chanceCritico;
		
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getDano() {
		return dano;
	}
	
	public void setDano(int dano) {
		this.dano = dano;
	}

	public int getChanceCritico() {
		return chanceCritico;
	}

	public void setChanceCritico(int chanceCritico) {
		if(chanceCritico < 100) this.chanceCritico = chanceCritico;
	}

	public int getArmadura() {
		return armadura;
	}

	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}
}
