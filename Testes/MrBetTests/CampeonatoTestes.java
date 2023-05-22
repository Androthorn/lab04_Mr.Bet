package MrBetTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import MrBet.Campeonato;
import MrBet.Time;

class CampeonatoTestes {

	
	@Test
	void testIncluirTime() {
		Time Flamengo = new Time("990", "Flamengo", "Urubu");
		Campeonato novoCamp = new Campeonato(30, "Campeonato Teste");
		assertTrue(novoCamp.incluirTime(Flamengo));
	}
	

	@Test
	void testContemTime() {
		Time Flamengo = new Time("990", "Flamengo", "Urubu");
		Campeonato novoCamp = new Campeonato(30, "Campeonato Teste");
		novoCamp.getTimes().add(Flamengo);
		assertTrue(novoCamp.contemTime(Flamengo));
	}
	
	@Test
	void testContemTimeSemTime() {
		Time Criciúma = new Time("990", "Criciúma", "preguiça");
		Campeonato novoCamp = new Campeonato(30, "Campeonato Teste");
		// Perceba que, comparado ao outro teste o time não foi adicionado ao campeonato.
		assertFalse(novoCamp.contemTime(Criciúma));
	}

	@Test
	void testTemVaga() {
		Campeonato novoCamp = new Campeonato(30, "Campeonato Teste");
		assertTrue(novoCamp.temVaga());
	}

	@Test
	void testNaoTemVaga() {
		Campeonato novoCamp = new Campeonato(0, "Campeonato Teste");
		assertFalse(novoCamp.temVaga());
	}
}
