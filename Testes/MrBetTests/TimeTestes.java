package MrBetTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import MrBet.MrBet;
import MrBet.Time;

class TimeTestes {
	MrBet mrBet = new MrBet();
	
	@BeforeEach
	void timeTestes() {
		this.mrBet.adicionarCampeonato("Campeonato Brasileiro", 20);
		this.mrBet.incluirTime("122-b", "Palmeiras", "Porco");
		this.mrBet.incluirTime("990", "Campinense", "Raposa");
		this.mrBet.incluirTimeCampeonato("Campeonato Brasileiro", "122-b");
		this.mrBet.incluirTimeCampeonato("Campeonato Paraibano", "122-b");
		
	}

	@Test
	void testPresenteEmCampeonato() {
		Time novoTime = new Time("1020", "Treze", "Galo");
		assertTrue(novoTime.presenteEmCampeonato(mrBet.getCampeonatos().get("Campeonato Brasileiro")));
	}

	@Test
	void testLeCampeonatos() {
		assertEquals("Campeonatos do Palmeiras:\n* CAMPEONATO BRASILEIRO - 1/20", mrBet.getTimes().get("122-B").leCampeonatos("122-b"));
	}
	
	@Test
	void testLeCampeonatosNenhumCampeonato() {
		assertEquals("Campeonatos do Campinense:", mrBet.getTimes().get("990").leCampeonatos("990"));
	}

}
