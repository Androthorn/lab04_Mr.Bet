package MrBet;

import java.util.HashSet;

public class Campeonato {
	private String nomeCampeonato;
	private HashSet<Time> times;
	private int numeroParticipantes;

	public Campeonato(int numeroParticipantes, String nomeCampeonato) {
		this.nomeCampeonato = nomeCampeonato;
		this.times = new HashSet<>();
		this.numeroParticipantes = numeroParticipantes;
	}

	public int getNumeroParticipantes() {
		return numeroParticipantes;
	}

	public boolean incluirTime(Time time) {
		if (temVaga()) {
			this.times.add(time);
			return true;
		}
		return false;
	}

	public boolean contemTime(Time time) {
		return times.contains(time);
	}

	public boolean temVaga() {
		return times.size() < numeroParticipantes;
	}
	
	public String leCampeonato() {
		return  "\n* " + nomeCampeonato + " - " + times.size() + "/" + numeroParticipantes;
	}
}
