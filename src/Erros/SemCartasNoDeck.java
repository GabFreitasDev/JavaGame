package Erros;

public class SemCartasNoDeck extends Exception{

	public SemCartasNoDeck() {
		super("Sem cartas no deck!");
	}
}
