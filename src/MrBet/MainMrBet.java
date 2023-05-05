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
		if (opcao.isBlank() || opcao == null) throw new IllegalArgumentException("Comando inválido, insira uma das opções anteriores");
		if (opcao.equals("!")) sai();
	}
	private static void sai() {
		System.out.println("\nObrigado por usar o Mr.Bet!");
		System.exit(0);
	}
}
