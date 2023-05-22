package MrBetTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import MrBet.Aposta;
class ApostaTestes {

	Aposta aposta = new Aposta("122-B", "Campeonato Brasileiro", 1, 30);
	
	@Test
	void testApostaString() {
		assertEquals("Código: 122-B\nCampeonato: Campeonato Brasileiro\nColocação: 1\nValor da Aposta: R$30.0", aposta.apostaString());
	}

	// O método ExibirApostaCompleta já foi testado nos testes MrBetTestes.
}
