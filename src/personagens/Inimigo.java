package personagens;

public class Inimigo extends Personagem{
	private int valor;
	public boolean chefao;
	public boolean atordoado;
	
	public Inimigo(String nome, AtributoPersonagem atributos, int valor) {
		super(nome, atributos);
		if (valor < 0) {
			throw new IllegalArgumentException("Valor negativo. Inválido!:");
		}
		this.setValor(valor);
	}
	
	public Inimigo(String nome, AtributoPersonagem atributos, int valor, boolean chefao) {
		super(nome, atributos);
		if (valor < 0) {
			throw new IllegalArgumentException("Valor negativo. Inválido!:");
		}
		this.setValor(valor);
		this.chefao = chefao;
	}
	
	public void util() {
		System.out.println("Util");
	}
	
	public void especial1(Heroi alvo, int defesaDoHeroi) {
		System.out.println("Especial 1");
	}
	
	public void especial2(Heroi alvo) {
		System.out.println("Especial 2");
	}
	
	public void especial3(Heroi alvo) {
		System.out.println("Especial 3");
	}
	
	public void especial4(Heroi alvo) {
		System.out.println("Especial 4");
	}
	
	public void apresentacao() {
		System.out.println("Um inimigo aparece e te encara com maldade!");
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
}
