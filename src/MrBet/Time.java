package MrBet;

import java.util.ArrayList;

/**
 * @author André Cunha Cria a classe Time
 */
public class Time {
	/**
	 * O nome do time
	 */
	private String nome;
	/**
	 * o mascote designado para o time
	 */
	private String mascote;
	/**
	 * Os campeonatos em que o time está presente.
	 */
	private ArrayList<Campeonato> campeonatos;

	/**
	 * @param codigo  o codigo do time, usado no HashMap.
	 * @param nome    o nome do time.
	 * @param mascote o nome do mascote designado para o time.
	 */
	public Time(String codigo, String nome, String mascote) {

		this.nome = nome;
		this.mascote = mascote;
		this.campeonatos = new ArrayList<>();
	}

	public String toString() {
		return this.nome + " / " + this.mascote;
	}

	/**
	 * Adiciona um campeonato para a lista de campeonatos em que o time está presente.
	 * 
	 * @param campeonato O campeonato a ser analisado.
	 * @return True se o time está presente no campeonato, False em caso contrário.
	 */
	public boolean presenteEmCampeonato(Campeonato campeonato) {
		campeonatos.add(campeonato);
		return true;
	}

	public ArrayList<Campeonato> getCampeonatos() {
		return campeonatos;
	}

	/**
	 * Exibe todos os campeonatos em que um determinado time está presente.
	 * 
	 * @param codigo o codigo do time
	 * @return uma String com todos os campeonatos em que o time está presente.
	 */
	public String leCampeonatos(String codigo) {
		String exibir = "Campeonatos do " + nome + ":";
		for (Campeonato camp : campeonatos) {
			exibir += camp.leCampeonato();
		}
		return exibir;
	}
	
}