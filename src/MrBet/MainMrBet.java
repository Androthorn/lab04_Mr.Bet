package MrBet;

import java.util.Scanner;

public class MainMrBet {
	public static void main(String[] args) {
		MrBet mrBet = new MrBet();

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, mrBet, scanner);
		}
	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + "(M)Minha inclusão de times\n" + "(R)Recuperar time\n" + "(.)Adicionar campeonato\n"
						+ "(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n"
						+ "(E)Exibir campeonatos que o time participa\n" + "(T)Tentar a sorte e status\n"
						+ "(!)Já pode fechar o programa!\n" + "Opção> ");
		return scanner.nextLine().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, MrBet mrBet, Scanner scanner) {
		if (opcao.isBlank() || opcao == null) {
			throw new IllegalArgumentException("Comando inválido, insira uma das opções anteriores");
		}
		if (opcao.equals("M")) {
			System.out.print("Código: ");
			String codigo = scanner.nextLine().toUpperCase();
			System.out.print("Nome: ");
			String nome = scanner.nextLine();
			System.out.print("Mascote: ");
			String mascote = scanner.nextLine();
			System.out.println("Código: " + codigo + "\nNome: " + nome + "\nMascote: " + mascote);
			System.out.println(mrBet.incluirTime(codigo, nome, mascote));
		}
		if (opcao.equals("R")) {
			System.out.print("Código: ");
			String codigo = scanner.nextLine().toUpperCase();
			System.out.println(mrBet.resgatarTime(codigo));
		}
		if (opcao.equals(".")) {
			System.out.print("Campeonato: ");
			String nomeCampeonato = scanner.nextLine().toUpperCase();
			System.out.print("Participantes: ");
			int numeroParticipantes = scanner.nextInt();
			scanner.nextLine();
			System.out.println(mrBet.adicionarCampeonato(nomeCampeonato, numeroParticipantes));
		}
		if (opcao.equals("B")) {
			System.out.print("(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato?");
			String escolha = scanner.nextLine().toUpperCase();
			if (escolha.equals("I")) {
				System.out.print("Código: ");
				String codigo = scanner.nextLine().toUpperCase();
				System.out.print("Campeonato: ");
				String nomeCampeonato = scanner.nextLine().toUpperCase();
				System.out.println("Código: " + codigo);
				System.out.println("Campeonato: " + nomeCampeonato);
				System.out.println(mrBet.incluirTimeCampeonato(nomeCampeonato, codigo));
			}
			if (escolha.equals("V")) {
				System.out.print("Código: ");
				String codigo = scanner.nextLine().toUpperCase();
				System.out.print("Campeonato: ");
				String nomeCampeonato = scanner.nextLine().toUpperCase();
				System.out.println("Código: " + codigo);
				System.out.println("Campeonato: " + nomeCampeonato);
				System.out.println(mrBet.verificarTimeCampeonato(nomeCampeonato, codigo));
			}
		}
		if (opcao.equals("E")) {
			System.out.print("Time: ");
			String time = scanner.nextLine().toUpperCase();
			System.out.println(mrBet.exibirCampeonatos(time));
		}
		if (opcao.equals("T")) {
			System.out.print("(A)Apostar ou (S)Status das Apostas?");
			String escolha = scanner.nextLine().toUpperCase();
			if (escolha.equals("A")) {
				System.out.print("Código: ");
				String codigo = scanner.nextLine().toUpperCase();
				System.out.print("Campeonato: ");
				String nomeCampeonato = scanner.nextLine().toUpperCase();
				System.out.print("Colocação: ");
				int colocacao = scanner.nextInt();
				System.out.print("Valor da Aposta: ");
				double valorAposta = scanner.nextDouble();
				System.out.println(mrBet.apostar(codigo, nomeCampeonato, colocacao, valorAposta));
			}
//			if (escolha.equals("S")) {
//				
//			}
		}
		if (opcao.equals("!"))
			sai();
	}

	private static void sai() {
		System.out.println("\nPor hoje é só pessoal!");
		System.exit(0);
	}
}
