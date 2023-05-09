package MrBet;

public class Aposta {

	String codigo;
	String nomeCampeonato;
	int colocacao;
	double valorAposta;

	public Aposta(String codigo, String nomeCampeonato, int colocacao, double valorAposta) {
		this.colocacao = colocacao;
		this.valorAposta = valorAposta;
		this.codigo = codigo;
		this.nomeCampeonato = nomeCampeonato;
	}
	
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
	
}
