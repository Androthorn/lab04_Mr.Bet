package MrBet;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author André Cunha Cria a classe MrBet
 */
public class MrBet {
	/**
	 * Cria o HashMap de times, aceitando um código em String como chave e um objeto
	 * Time.
	 */
	private HashMap<String, Time> times;
	/**
	 * Cria o HashMap de campeonatos, aceitando um nome de campeonato em String como
	 * chave e um objeto Campeonato.
	 */
	private HashMap<String, Campeonato> campeonatos;
	/**
	 * Um ArrayList para armazenar os objetos Aposta.
	 */
	private ArrayList<Aposta> apostas;

	/**
	 * Construtor da classe MrBet, inicializa os HashMaps de times e campeonatos,
	 * bem como a lista de apostas.
	 */
	public MrBet() {
		this.times = new HashMap<>();
		this.campeonatos = new HashMap<>();
		this.apostas = new ArrayList<>();
	}

	/**
	 * Inclui um time no sistema MrBet
	 * 
	 * @param codigo  o codigo identificador do time
	 * @param nome    o nome do time
	 * @param mascote o mascote do time
	 * @return Retorna "TIME JÃ EXISTE!" caso o código informado já esteja no
	 *         HashMap ou "INCLUSÃO REALIZADA" em caso contrário. Lança uma exceção
	 *         caso o usuario insira um codigo em branco ou null.
	 */
	public String incluirTime(String codigo, String nome, String mascote) {
		codigo = codigo.toUpperCase();
		if (codigo.isBlank() || codigo == null) {
			throw new IllegalArgumentException("Comando inválido, insira uma das opções anteriores");
		}
		if (times.containsKey(codigo))
			return "TIME JÁ EXISTE!";
		Time novoTime = new Time(codigo, nome, mascote);
		times.put(codigo, novoTime);
		return "INCLUSÃO REALIZADA!";
	}

	/**
	 * Exibe o time correspondente ao código digitado
	 * 
	 * @param codigo o codigo do time
	 * @return Uma String com o nome do time e o seu mascote ou "TIME NÃO EXISTE!"
	 *         em caso contrário. Lança uma exceção caso o usuario insira um codigo
	 *         em branco ou null.
	 */
	public String resgatarTime(String codigo) {
		if (codigo.isBlank() || codigo == null) {
			throw new IllegalArgumentException("Comando inválido, insira uma das opções anteriores");
		}

		codigo = codigo.toUpperCase();

		if (times.get(codigo) != null) {
			return times.get(codigo).toString();
		}
		return "TIME NÃO EXISTE!";
	}

	/**
	 * Adiciona um campeonato ao sistema MrBet
	 * 
	 * @param nomeCampeonato      o nome do campeonato, também é a chave para o
	 *                            HashMap campeonatos.
	 * @param numeroParticipantes o numero de participantes do campeonato.
	 * @return retorna "CAMPEONATO JÁ EXISTE!" se o usuario escolher um nome de um
	 *         campeonato já existente ou "CAMPEONATO ADICIONADO" em caso contrario.
	 *         Lança uma exceção caso o usuario insira um nome de campeonato em
	 *         branco ou null.
	 */
	public String adicionarCampeonato(String nomeCampeonato, int numeroParticipantes) {
		if (nomeCampeonato.isBlank() || nomeCampeonato == null) {
			throw new IllegalArgumentException("Comando inválido, insira uma das opções anteriores");
		}
		nomeCampeonato = nomeCampeonato.toUpperCase();
		if (campeonatos.containsKey(nomeCampeonato)) {
			return "CAMPEONATO JÁ EXISTE!";
		}
		Campeonato novoCampeonato = new Campeonato(numeroParticipantes, nomeCampeonato);
		campeonatos.put(nomeCampeonato, novoCampeonato);
		return "CAMPEONATO ADICIONADO!";
	}

	/**
	 * Inclui um time em um campeonato.
	 * 
	 * @param nomeCampeonato o nome do campeonato que receberá um time.
	 * @param codigo         o codigo do time a ser inserido no campeonato
	 * @return uma String diferente para cada um dos 4 casos: 1- quando o campeonato
	 *         inserido não existe. 2-quando o time a ser inserido nao existe.
	 *         3-Quando a inserção ocorre regularmente. 4- quando a inserção não
	 *         funciona devido ao número de participantes já estar completo. Lança
	 *         uma exceção caso o usuario insira um nome de campeonato ou código de
	 *         time em branco ou null.
	 * 
	 */
	public String incluirTimeCampeonato(String nomeCampeonato, String codigo) {
		if (nomeCampeonato.isBlank() || nomeCampeonato == null) {
			throw new IllegalArgumentException("Comando inválido, insira uma das opções anteriores");
		}
		if (codigo.isBlank() || codigo == null) {
			throw new IllegalArgumentException("Comando inválido, insira uma das opções anteriores");
		}
		nomeCampeonato = nomeCampeonato.toUpperCase();
		codigo = codigo.toUpperCase();

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

	/**
	 * Verifica se o campeonato inserido contém um time.
	 * 
	 * @param nomeCampeonato o nome do campeonato a ser analisado
	 * @param codigo         o codigo do time a ser buscado
	 * @return uma String para cada situacao, 1- quando o campeonato nao existe. 2-
	 *         quando o time nao existe. 3- quando o time está no campeonato. 4-
	 *         quando o time não está no campeonato.Lança uma exceção caso o usuario
	 *         insira um nome de campeonato ou um codigo de time em branco ou null.
	 */
	public String verificarTimeCampeonato(String nomeCampeonato, String codigo) {
		if (nomeCampeonato.isBlank() || nomeCampeonato == null) {
			throw new IllegalArgumentException("Comando inválido, insira uma das opções anteriores");
		}
		if (codigo.isBlank() || codigo == null) {
			throw new IllegalArgumentException("Comando inválido, insira uma das opções anteriores");
		}
		nomeCampeonato = nomeCampeonato.toUpperCase();
		codigo = codigo.toUpperCase();

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

	/**
	 * Exibe todos os campeonatos nos quais um time está inscrito.
	 * 
	 * @param codigo o codigo do time
	 * @return "O TIME NÃO EXISTE!" caso o time nao esteja registrado em MrBet ou
	 *         uma String com os campeonatos em que o time está inserido. Lança uma
	 *         exceçao em caso de codigo em branco ou null.
	 */
	public String exibirCampeonatos(String codigo) {
		if (codigo.isBlank() || codigo == null) {
			throw new IllegalArgumentException("Comando inválido, insira uma das opções anteriores");
		}
		codigo = codigo.toUpperCase();
		Time time = times.get(codigo);
		if (time == null)
			return "O TIME NÃO EXISTE!";

		return time.leCampeonatos(codigo);
	}

	/**
	 * Cria um método através do qual o usuário pode apostar em qual posicao o time
	 * selecionado ira finalizar o campeonato.
	 * 
	 * @param codigo         o codigo do time.
	 * @param nomeCampeonato o nome do campeonato.
	 * @param colocacao      a colocação do time no campeonato.
	 * @param valorAposta    o Valor da aposta do usuario.
	 * @return retorna uma String em caso: 1- de campeonato não existente. 2- de
	 *         time não existente. 3- de aposta nao registrada por exceder numero de
	 *         participantes. 4-de aposta devidamente registrada. Lança uma exceção
	 *         em caso de codigo ou nome de campeonato em branco ou null.
	 */
	public String apostar(String codigo, String nomeCampeonato, int colocacao, double valorAposta) {
		if (nomeCampeonato.isBlank() || nomeCampeonato == null) {
			throw new IllegalArgumentException("Comando inválido, insira uma das opções anteriores");
		}
		if (codigo.isBlank() || codigo == null) {
			throw new IllegalArgumentException("Comando inválido, insira uma das opções anteriores");
		}

		codigo = codigo.toUpperCase();
		nomeCampeonato = nomeCampeonato.toUpperCase();

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

	/**
	 * método responsável por exibir todas as apostas existentes no sistema.
	 * 
	 * @return retorna uma String que exibe todas as apostas cadastradas, na ordem
	 *         em que foram inseridas no sistema.
	 */
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

	public HashMap<String, Campeonato> getCampeonatos() {
		return campeonatos;
	}

	public HashMap<String, Time> getTimes() {
		return times;
	}

}