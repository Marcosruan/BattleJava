package utils;

public abstract class ExibeJogo {
	/**
	 * Imprime as barras de vida para o herói e para o inimigo no console
	 * @param nomeHeroi			String com o nome do heroi
	 * @param vidaAtualHeroi	Vida atual do herói
	 * @param vidaMaximaHeroi	Vida máxima do herói
	 * @param nomeInimigo		Nome do inimigo
	 * @param vidaAtualInimigo	Vida do atual do inimigo
	 * @param vidaMaximaInimigo Vida mázima do inimigo
	 * @param manaAtual			Mana atual do heroi
	 * @param manaMaxima		Mana máxima do Heroi
	 */
	public static void exibeBarraManaVida(String nomeHeroi, int vidaAtualHeroi, int vidaMaximaHeroi, String nomeInimigo, int vidaAtualInimigo, int vidaMaximaInimigo, int manaAtual, int manaMaxima) {
		String barraVidaHeroi = geraBarraVida(vidaAtualHeroi, vidaMaximaHeroi, false);
		String barraMana = geraBarraMana(manaAtual, manaMaxima);
		String barraVidaVilao = geraBarraVida(vidaAtualInimigo, vidaMaximaInimigo, true);
		
		String nomeHeroiComCor = Cores.ANSI_BLUE + nomeHeroi + Cores.ANSI_RESET;
		String nomeVilaoComCor = Cores.ANSI_PURPLE + nomeInimigo + Cores.ANSI_RESET;
		System.out.println("=".repeat(140));
		System.out.printf("\n%s - %s%40s%s - %s\n", nomeHeroiComCor, barraVidaHeroi, " ", barraVidaVilao, nomeVilaoComCor);
		System.out.printf("%s%s%s\n\n", Cores.ANSI_CYAN, barraMana, Cores.ANSI_RESET);
		System.out.println("=".repeat(140));
	}
	
	/**
	 * Cria as barras de vida para o herói e para o inimigo
	 * @param vidaAtual		Vida atual do herói ou inimigo
	 * @param vidaMaxima	Vida máxima do herói ou inimigo
	 * @param inimigo		booleano para saber se é inimigo ou não
	 * @return				String formatada com nome e barra de vida de ambos herói e inimigo
	 */
	private static String geraBarraVida(int vidaAtual, int vidaMaxima, boolean inimigo) {
		final int quantTotalBarras = 20;
		
		int vidaChecada = Math.max(0, vidaAtual);
		double proporcao = (double) vidaChecada / vidaMaxima;
		if (proporcao > 1) proporcao = 1;
		int barrasCheias = (int) Math.round(proporcao * quantTotalBarras);
		int barrasVazias = quantTotalBarras - barrasCheias;
		
		String cor = GeraCor(barrasCheias);
		
		if (inimigo) {
			return cor + vidaChecada + "/" + vidaMaxima + " [ " + "░".repeat(barrasVazias) + "█".repeat(barrasCheias) + " ] HP" + Cores.ANSI_RESET;
		}
		
		return cor + "HP [ " + "█".repeat(barrasCheias) + "░".repeat(barrasVazias) + " ] " + vidaChecada + "/" + vidaMaxima + Cores.ANSI_RESET;
	}
	
	/**
	 * Gera a barra de mana para o herói
	 * @param manaAtual		Mana atual do herói
	 * @param manaMaxima	Mana máxima do herói
	 * @return				String formatada com a barra de mana do herói
	 */
	private static String geraBarraMana(int manaAtual, int manaMaxima) {
		int barraManaCheia = manaAtual;
		int barraManaVazia = manaMaxima - manaAtual;
		return "Mana [ " + "▰".repeat(barraManaCheia) + "▱".repeat(barraManaVazia) + " ] " + manaAtual + "/" + manaMaxima;
	}
	
	/**
	 * Gera a cor da barra de vida dependendo da porcentagem de vida restante. Verde para 60% de vida ou mais, amarelo de 30% a 60% de vida e vermelho para menos que 30% de vida.
	 * @param quantidade	Quantidade de barrinhas cheias de vida
	 * @return				Caractere ansi com cor correspondente à porcentagem de vida restante
	 */
	private static String GeraCor(int quantidade) {
		if (quantidade < 6) {
			return Cores.ANSI_RED;
		} else if (quantidade < 12) {
			return Cores.ANSI_YELLOW;
		}
		return Cores.ANSI_GREEN;
	}
}
