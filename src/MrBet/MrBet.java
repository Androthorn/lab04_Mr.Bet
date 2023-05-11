package MrBet;

import java.util.ArrayList;
import java.util.HashMap;

public class MrBet {
	private HashMap<String, Time> times;
	private HashMap<String, Campeonato> campeonatos;
	private ArrayList<Aposta> apostas;

	public MrBet() {
		this.times = new HashMap<>();
		this.campeonatos = new HashMap<>();
		this.apostas = new ArrayList<>();
	}

	public String incluirTime(String codigo, String nome, String mascote) {
		if (times.containsKey(codigo))
			return "TIME JÁ EXISTE!";
		Time novoTime = new Time(codigo, nome, mascote);
		times.put(codigo, novoTime);
		return "INCLUSÃO REALIZADA!";
	}

	public String resgatarTime(String codigo) {
		if (times.get(codigo) != null) {
			return times.get(codigo).toString();
		}
		return "TIME NÃO EXISTE!";
	}

	public String adicionarCampeonato(String nomeCampeonato, int numeroParticipantes) {
		if (campeonatos.containsKey(nomeCampeonato)) {
			return "CAMPEONATO JÁ EXISTE!";
		}
		Campeonato novoCampeonato = new Campeonato(numeroParticipantes, nomeCampeonato);
		campeonatos.put(nomeCampeonato, novoCampeonato);
		return "CAMPEONATO ADICIONADO!";
	}

	public HashMap<String, Campeonato> getCampeonatos() {
		return campeonatos;
	}

	public String incluirTimeCampeonato(String nomeCampeonato, String codigo) {
		Campeonato campeonato = campeonatos.get(nomeCampeonato);
		if (campeonato == null)
			return "CAMPEONATO NÃO EXISTE!";

		Time time = times.get(codigo);
		if (time == null)
			return "TIME NÃO EXISTE!";

		if (campeonato.incluirTime(time)) {
			time.presenteEmCampeonato(campeonato);
			return "TIME INCLUÍDO NO CAMPEONATO!";
		}
		return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
	}

	public String verificarTimeCampeonato(String nomeCampeonato, String codigo) {
		Campeonato campeonato = campeonatos.get(nomeCampeonato);
		if (campeonato == null)
			return "O CAMPEONATO NÃO EXISTE!";

		Time time = times.get(codigo);
		if (time == null)
			return "O TIME NÃO EXISTE!";

		if (campeonato.contemTime(time))
			return "O TIME ESTÁ NO CAMPEONATO!";

		return "O TIME NÃO ESTÁ NO CAMPEONATO!";
	}

	public String exibirCampeonatos(String codigo) {
		Time time = times.get(codigo);
		if (time == null)
			return "O TIME NÃO EXISTE!";

		return time.leCampeonatos(codigo);
	}

	public String apostar(String codigo, String nomeCampeonato, int colocacao, double valorAposta) {
		Campeonato campeonato = campeonatos.get(nomeCampeonato);
		if (campeonato == null)
			return "CAMPEONATO NÃO EXISTE!";

		Time time = times.get(codigo);
		if (time == null)
			return "O TIME NÃO EXISTE!";

		Aposta novaAposta = new Aposta(codigo, nomeCampeonato, colocacao, valorAposta);
		if (colocacao > campeonato.getNumeroParticipantes())
			return novaAposta.apostaString() + "\nAPOSTA NÃO REGISTRADA!";

		apostas.add(novaAposta);
		return novaAposta.apostaString() + "\nAPOSTA REGISTRADA!";
	}

	public String exibeApostas() {
		String exibir = "Apostas:";
		int i = 1;
		for (Aposta aposta : apostas) {
			Time time = times.get(aposta.getCodigo());
			Campeonato campeonato = campeonatos.get(aposta.getNomeCampeonato());
			exibir += "\n" + i + ". " + aposta.exibirApostaCompleta(time, campeonato);
			i += 1;
		}
		return exibir;
	}


	public HashMap<String, Time> getTimes() {
		return times;
	}

	public void setTimes(HashMap<String, Time> times) {
		this.times = times;
	}

	public void setCampeonatos(HashMap<String, Campeonato> campeonatos) {
		this.campeonatos = campeonatos;
	}

}