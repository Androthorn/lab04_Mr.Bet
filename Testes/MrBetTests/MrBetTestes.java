package MrBetTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import MrBet.MrBet;

class MrBetTestes {
	MrBet mrBet = new MrBet();

	public MrBetTestes() {
		this.mrBet.adicionarCampeonato("Campeonato Brasileiro", 20);
		this.mrBet.incluirTime("122-b", "Palmeiras", "Porco");
		this.mrBet.incluirTimeEmCampeonato("Campeonato Brasileiro", "122-b");
	}

	@Test
	void testIncluirTimeBemSucedido() {
		assertEquals("INCLUSÃO REALIZADA!", mrBet.incluirTime("1889-D", "CRICIUMA", "TOURO"));
	}

	@Test
	void testIncluirTimeCodigoJaExistente() {
		assertEquals("TIME JÁ EXISTE!", mrBet.incluirTime("122-b", "Flamengo", "Urubu"));
	}

	@Test
	void testResgatarTimeExistente() {
		assertEquals("Palmeiras / Porco", mrBet.resgatarTime("122-b"));
	}

	@Test
	void testResgatarTimeNaoExistente() {
		assertEquals("TIME NÃO EXISTE!", mrBet.resgatarTime("1899-C"));
	}

	@Test
	void testAdicionarCampeonatoBemSucedido() {
		assertEquals("CAMPEONATO ADICIONADO!", mrBet.adicionarCampeonato("Campeonato Paraibano", 10));
	}

	@Test
	void testAdicionarCampeonatoJaExistente() {
		assertEquals("CAMPEONATO JÁ EXISTE!", mrBet.adicionarCampeonato("Campeonato Brasileiro", 33));
	}

	@Test
	void testQuantidadeCampeonatos() {
		assertEquals(1, mrBet.getCampeonatos().size());
	}

	@Test
	void testCampeonatoExiste() {
		assertTrue(mrBet.getCampeonatos().containsKey("Campeonato Brasileiro"));
	}

	@Test
	void testCampeonatoNaoExiste() {
		assertFalse(mrBet.getCampeonatos().containsKey("Campeonato Xexelento"));
	}

	@Test
	void testIncluirTimeEmCampeonato() {
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mrBet.incluirTimeEmCampeonato("Campeonato Brasileiro", "122-b"));
	}

	@Test
	void testIncluirTimeEmCampeonatoInexistente() {
		assertEquals("CAMPEONATO NÃO EXISTE!", mrBet.incluirTimeEmCampeonato("Campeonato Xexelento", "122-b"));
	}

	@Test
	void testIncluirTimeEmCampeonatoTimeInexistente() {
		assertEquals("TIME NÃO EXISTE!", mrBet.incluirTimeEmCampeonato("Campeonato Brasileiro", "000-A"));
	}

	@Test
	void testIncluirTimeEmCampeonatoUltimaVaga() {
		this.mrBet.adicionarCampeonato("Campeonato Paraibano", 1);
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mrBet.incluirTimeEmCampeonato("Campeonato Paraibano", "122-b"));
	}

	@Test
	void testIncluirTimeEmCampeonatoSemVagas() {
		this.mrBet.adicionarCampeonato("Campeonato Paraibano", 0);
		assertEquals("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!",
				mrBet.incluirTimeEmCampeonato("Campeonato Paraibano", "122-b"));
	}

	@Test
	void testVerificarTimeCampeonato() {
		assertEquals("O TIME ESTÁ NO CAMPEONATO!", mrBet.verificarTimeCampeonato("Campeonato Brasileiro", "122-b"));
	}

	@Test
	void testVerificarTimeCampeonatoTimeNaoExiste() {
		assertEquals("O TIME NÃO EXISTE!", mrBet.verificarTimeCampeonato("Campeonato Brasileiro", "000-b"));
	}

	@Test
	void testVerificarTimeCampeonatoCampeonatoNaoExiste() {
		assertEquals("O CAMPEONATO NÃO EXISTE!", mrBet.verificarTimeCampeonato("Campeonato Xexelento", "122-b"));
	}

	@Test
	void testExibirCampeonatos() {
		this.mrBet.adicionarCampeonato("Campeonato dos melhores do mundo", 30);
		this.mrBet.incluirTimeEmCampeonato("Campeonato dos melhores do mundo", "122-b");
		assertEquals(
				"Campeonatos do Palmeiras:\n* Campeonato Brasileiro - 1/20\n* Campeonato dos melhores do mundo - 1/30",
				mrBet.exibirCampeonatos("122-b"));
	}

	@Test
	void testApostaValida() {
		assertEquals(
				"Código: 122-b\nCampeonato: Campeonato Brasileiro\nColocação: 1\nValor da Aposta: R$30.0\nAPOSTA REGISTRADA!",
				mrBet.apostar("122-b", "Campeonato Brasileiro", 1, 30));
	}

	@Test
	void testApostaInvalida() {
		assertEquals(
				"Código: 122-b\nCampeonato: Campeonato Brasileiro\nColocação: 2929\nValor da Aposta: R$30.0\nAPOSTA NÃO REGISTRADA!",
				mrBet.apostar("122-b", "Campeonato Brasileiro", 2929, 30));
	}

	@Test
	void testExibirApostas() {
		mrBet.apostar("122-b", "Campeonato Brasileiro", 1, 30);
		mrBet.apostar("122-b", "Campeonato Brasileiro", 20, 100);
		assertEquals(
				"Apostas:\n1. [122-b] Palmeiras / Porco\nCampeonato Brasileiro\n1/20\nR$ 30.0\n\n2. [122-b] Palmeiras / Porco\nCampeonato Brasileiro\n20/20\nR$ 100.0\n\n",
				mrBet.exibeApostas());
	}
}
