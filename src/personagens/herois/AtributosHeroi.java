package personagens.herois;

public class AtributosHeroi {
	private int mana;
	private int manaRegen;
	private int moedas = 0;
	public AtributosHeroi(int mana, int manaRegen) {
		
		if (mana < 0) {
			throw new IllegalArgumentException("Mana inválida. Mana negativa.");			
		}
		
		if (manaRegen < 0) {
			throw new IllegalArgumentException("Regeneração de mana inválida. Regeneração de mana negativa.");			
		}
		
		this.mana = mana;
		this.manaRegen = manaRegen;
	}
	
	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getManaRegen() {
		return manaRegen;
	}

	public void setManaRegen(int manaRegen) {
		this.manaRegen = manaRegen;
	}

	public int getMoedas() {
		return moedas;
	}

	public void setMoedas(int moedas) {
		this.moedas = moedas;
	}
}
