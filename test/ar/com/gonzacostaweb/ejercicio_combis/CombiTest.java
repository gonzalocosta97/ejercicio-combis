package ar.com.gonzacostaweb.ejercicio_combis;

import static org.junit.Assert.*;

import org.junit.Test;

public class CombiTest {
	
	// Tests

	@Test
	public void queSePuedaCrearUnaCombi() {
	
		Combi combi1 = dadoQueExisteUnaCombi(1000);
		
		entoncesSuIdEs(combi1, 1000);
		
	}
	
	@Test
	public void queAlCrearUnaCombiSuEstadoEnViajeSeaFalse() {
		
		Combi combi1 = dadoQueExisteUnaCombi(1000);
		
		entoncesSuEstadoEnViajeEs(combi1, false);
		
	}
	
	// Métodos para los tests
	
	private Combi dadoQueExisteUnaCombi(Integer id) {
		
		return new Combi(id);
		
	}
	
	private void entoncesSuIdEs(Combi combi, Integer id) {
		
		Integer VE = id;
		
		Integer VO = combi.getId();
		
		assertEquals(VE, VO);
		
	}
		
	private void entoncesSuEstadoEnViajeEs(Combi combi, Boolean estadoEnViaje) {
		
		Boolean VE = estadoEnViaje;
		
		Boolean VO = combi.getEnViaje();
		
		assertEquals(VE, VO);
		
	}

}
