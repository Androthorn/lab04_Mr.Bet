package MrBet;

import java.util.ArrayList;

public class Time {
	private String codigo;
	private String nome;
	private String mascote;
	private ArrayList<Campeonato> campeonatos;

	public Time(String codigo, String nome, String mascote) {
		this.codigo = codigo;
		this.nome = nome;
		this.mascote = mascote;
		this.campeonatos = new ArrayList<>();
	}

	public String toString() {
		return this.nome + " / " + this.mascote;
	}

	public boolean presenteEmCampeonato(Campeonato campeonato) {
		campeonatos.add(campeonato);
		return true;
	}

	public ArrayList<Campeonato> getCampeonatos() {
		return campeonatos;
	}

	public String leCampeonatos(String codigo) {
		String exibir = "Campeonatos do " + nome + ":";
		for (Campeonato camp : campeonatos) {
			exibir += camp.leCampeonato();
		}
		return exibir;
	}
}