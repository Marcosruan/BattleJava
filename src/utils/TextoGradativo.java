package utils;

public abstract class TextoGradativo {
	/**
	 * Imprime o texto no console gradativamente
	 * @param texto					String a ser imprimida no console
	 * @param tempoMilissegundos	Tempo em milisegundos para a impressão de cada caractere
	 */
	public static void imprimirTextoGradativo(String texto, int tempoMilissegundos) {
		for (char caractere : texto.toCharArray()) {
			System.out.print(caractere);
			System.out.flush();

			try {
				Thread.sleep(tempoMilissegundos);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.println();
	}
	/**
	 * Imprime o texto colorido no console gradativamente
	 * @param texto					String a ser impressa no console
	 * @param cor					Cor do texto a ser impresso no console
	 * @param tempoMilissegundos	Tempo em milisegundos para a impressão de cada caractere
	 */
	public static void imprimirTextoGradativoColorido(String texto, String cor, int tempoMilissegundos) {
		System.out.printf("%s", cor);
		for (char caractere : texto.toCharArray()) {
			System.out.print(caractere);
			System.out.flush();

			try {
				Thread.sleep(tempoMilissegundos);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.printf("%s", Cores.ANSI_RESET);
		System.out.println();
	}
}
