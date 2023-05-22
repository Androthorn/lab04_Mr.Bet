package MrBet;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author André Cunha Cria a classe Campeonato.
 */
public class Campeonato {
	/**
	 * o nome do Campeonato, também funciona como chave para o HashMap usado em
	 * MrBet.
	 */
	private String nomeCampeonato;
	/**
	 * Um HashSet do objeto Time, responsável por armazenar os times do campeonato.
	 */
	private HashSet<Time> times;
	/**
	 * o número máximo de participantes do campeonato.
	 */
	private int numeroParticipantes;

	/**
	 * Construtor de Campeonato, inicializa o HashSet de times e seus atributos.
	 * 
	 * @param numeroParticipantes o numero maximo de participantes do campeonato.
	 * @param nomeCampeonato      o nome e chave do campeonato.
	 */
	public Campeonato(int numeroParticipantes, String nomeCampeonato) {
		this.nomeCampeonato = nomeCampeonato;
		this.times = new HashSet<>();
		this.numeroParticipantes = numeroParticipantes;
	}

	public int getNumeroParticipantes() {
		return numeroParticipantes;
	}

	/**
	 * Método responsável por incluir time em campeonato.
	 * 
	 * @param time o objeto time a ser incluido em campeonato.
	 * @return Retorna true se o campeonato ainda tem vaga para receber um novo time
	 *         ou falso em caso contrário.
	 */
	public boolean incluirTime(Time time) {
		if (temVaga()) {
			this.times.add(time);
			return true;
		}
		return false;
	}

	/**
	 * Método usado para verificar a existência do referido time no campeonato.
	 * 
	 * @param time O objeto Time o qual se deseja verificar a existência.
	 * @return True se o time já está inserido no campeonato ou False em caso
	 *         contrário.
	 */
	public boolean contemTime(Time time) {
		return times.contains(time);
	}

	/**
	 * Método responsável por verificar se o campeonato ainda possui vagas para a
	 * inscrição de times.
	 * 
	 * @return True se ainda há vagas ou False em caso contrário.
	 */
	public boolean temVaga() {
		return times.size() < numeroParticipantes;
	}

	/**
	 * Método responsável por apresentar uma representação em String do campeonato.
	 * 
	 * @return uma String com o nome do campeonato, o número de times inscritos e o
	 *         número máximo de participantes.
	 */
	public String leCampeonato() {
		return "\n* " + nomeCampeonato + " - " + times.size() + "/" + numeroParticipantes;
	}

	public HashSet<Time> getTimes() {
		return times;
	}

	@Override
	public int hashCode() {
		return Objects.hash(times);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campeonato other = (Campeonato) obj;
		return Objects.equals(times, other.times);
	}
	
}