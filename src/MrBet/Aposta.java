package MrBet;

/**
 * @author André
 *	Cria a classe Aposta
 */
public class Aposta {

	/**
	 * O codigo do time em que se deseja apostar.
	 */
	String codigo;
	/**
	 * O nome do campeonato em que o time se encontra.
	 */
	String nomeCampeonato;
	/**
	 * A colocação em que o time ira alcançar ao fim do campeonato.
	 */
	int colocacao;
	/**
	 *  O valor da aposta do usuário.
	 */
	double valorAposta;

	/**
	 * Construtor da classe Aposta
	 * @param codigo O codigo do time
	 * @param nomeCampeonato O nome do campeonato
	 * @param colocacao A colocação em que o time ira alcançar ao fim do campeonato.
	 * @param valorAposta O valor da aposta do usuário.
	 */
	public Aposta(String codigo, String nomeCampeonato, int colocacao, double valorAposta) {
		this.colocacao = colocacao;
		this.valorAposta = valorAposta;
		this.codigo = codigo;
		this.nomeCampeonato = nomeCampeonato;
	}

	/**
	 * Método de visualização das apostas realizadas.
	 * @return uma String com informações sobre a aposta.
	 */
	public String apostaString() {
		return "Código: " + codigo + "\nCampeonato: " + nomeCampeonato + "\nColocação: " + colocacao
				+ "\nValor da Aposta: R$" + valorAposta;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNomeCampeonato() {
		return nomeCampeonato;
	}

	public int getColocacao() {
		return colocacao;
	}

	public double getValorAposta() {
		return valorAposta;
	}

	/**
	 * Método utilizado para fornecer uma representação em String de apostas realizadas.
	 * @param time O time a ser analisado
	 * @param campeonato O campeonato em que o time está presente
	 * @return Informações em String da aposta do usuário em determinado time e campeonato.
	 */
	public String exibirApostaCompleta(Time time, Campeonato campeonato) {
		return "[" + getCodigo() + "]" + " " + time.toString() + "\n" + getNomeCampeonato() + "\n" + getColocacao()
				+ "/" + campeonato.getNumeroParticipantes() + "\nR$ " + getValorAposta() + "\n";
	}

}
