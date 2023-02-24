package ar.com.gonzacostaweb.ejercicio_combis;

import static org.junit.Assert.*;

import org.junit.Test;

public class AgenciaTest {

	// Tests
	
	@Test
	public void queSePuedaCrearUnaAgencia() {
		
		Agencia agencia1 = dadoQueExisteUnaAgencia(1, "Nueva Agencia 2023");
		
		entoncesSuIdEs(agencia1, 1);
		
	}
	
	@Test
	public void queAlCrearUnaAgenciaPoseaSus5PlazasDeCombisDisponibles() {
		
		Agencia agencia1 = dadoQueExisteUnaAgencia(1, "Nueva Agencia 2023");
		
		entoncesDebePoseerPlazasLibres(5, agencia1);
		
	}
	
	@Test
	public void queSePuedaAsociarUnaCombiAUnaAgencia() {
		
		Agencia agencia1 = dadoQueExisteUnaAgencia(1, "Nueva Agencia 2023");
		
		Integer idCombi = 1000;
		
		cuandoAgregoUnaCombi(idCombi, agencia1);
		
		entoncesDebePoseerPlazasLibres(4, agencia1);
		
	}
	
	@Test
	public void queNoSePuedaAsociarUnaCombiSiNoHayPlazasDisponibles() {
		
		Agencia agencia1 = dadoQueExisteUnaAgencia(1, "Nueva Agencia 2023");
		
		Integer idCombi1 = 1000;
		Integer idCombi2 = 1001;
		Integer idCombi3 = 1002;
		Integer idCombi4 = 1003;
		Integer idCombi5 = 1004;
		Integer idCombi6 = 1005;
		
		cuandoAgregoUnaCombi(idCombi1, agencia1);
		cuandoAgregoUnaCombi(idCombi2, agencia1);
		cuandoAgregoUnaCombi(idCombi3, agencia1);
		cuandoAgregoUnaCombi(idCombi4, agencia1);
		cuandoAgregoUnaCombi(idCombi5, agencia1);
		
		entoncesNoPuedoAgregarOtraCombi(idCombi6, agencia1);
			
	}
	
	@Test
	public void queNoSePuedaAsociarUnaCombiNula() {
		
		Agencia agencia1 = dadoQueExisteUnaAgencia(1, "Nueva Agencia 2023");
		
		Combi combiNula = null;
		
		Boolean flagCombiAgregada = cuandoAgregoUnaCombi(combiNula, agencia1);
		
		entoncesNoSePudoAgregarLaCombi(flagCombiAgregada);	
		
	}
	
	@Test
	public void queNoSePuedaAsociarUnaCombiCuyoIdYaExisteEnLaAgencia() {
		
		Agencia agencia1 = dadoQueExisteUnaAgencia(1, "Nueva Agencia 2023");
		
		Integer idCombi1 = 1000;
		Integer idCombi2 = 1000;
		
		cuandoAgregoUnaCombi(idCombi1, agencia1);
		
		Boolean flagCombiAgregada = cuandoAgregoUnaCombi(idCombi2, agencia1);
				
		entoncesNoSePudoAgregarLaCombi(flagCombiAgregada); 
						
	}
	
	@Test
	public void queNoSePuedaAsociarUnaCombiConIdNull() {
		
		Agencia agencia1 = dadoQueExisteUnaAgencia(1, "Nueva Agencia 2023");
		
		Integer idCombi1 = null;
	
		Boolean flagCombiAgregada = cuandoAgregoUnaCombi(idCombi1, agencia1);
	
		entoncesNoSePudoAgregarLaCombi(flagCombiAgregada);
		
	}
	
	@Test
	public void queSePuedaDesasociarUnaCombi() {
		
		Agencia agencia1 = dadoQueExisteUnaAgencia(1, "Nueva Agencia 2023");
		
		Integer idCombi1 = 1000;
		Integer idCombi2 = 1001;
		
		cuandoAgregoUnaCombi(idCombi1, agencia1);
		cuandoAgregoUnaCombi(idCombi2, agencia1);
		
		cuandoQuitoUnaCombi(idCombi2, agencia1);
		
		entoncesDebePoseerPlazasLibres(4, agencia1);
				
	}
	
	@Test
	public void queNoSePuedaDesasociarUnaCombiSiNoExisteEsaCombiEnLaAgencia() {
		
		Agencia agencia1 = dadoQueExisteUnaAgencia(1, "Nueva Agencia 2023");
		
		Integer idCombi1 = 1000;
		Integer idCombi2 = 1001;
		Integer idCombi3 = 5000;
		
		cuandoAgregoUnaCombi(idCombi1, agencia1);
			
		cuandoAgregoUnaCombi(idCombi2, agencia1);
		
		entoncesNoPuedoQuitarUnaCombiQueNoFueAgregada(idCombi3, agencia1);
		
	}
	
	@Test
	public void queSePuedaObtenerLaCantidadDeCombisQuePoseeLaAgencia() {
		
		// Testea el requirimiento 1 de la consigna
		
		Agencia agencia1 = dadoQueExisteUnaAgencia(1, "Nueva Agencia 2023");
		
		Integer idCombi1 = 1000;
		Integer idCombi2 = 1001;
		Integer idCombi3 = 1002;
		Integer idCombi4 = 1003;
		
		cuandoAgregoUnaCombi(idCombi1, agencia1);
		cuandoAgregoUnaCombi(idCombi2, agencia1);
		cuandoAgregoUnaCombi(idCombi3, agencia1);
		cuandoAgregoUnaCombi(idCombi4, agencia1);
		
		entoncesLaAgenciaPoseeCombis(4, agencia1);
			
	}
	
	@Test
	public void queSePuedaPonerUnaCombiEnViaje() { 
		
		Agencia agencia1 = dadoQueExisteUnaAgencia(1, "Nueva Agencia 2023");
		
		Integer idCombi1 = 1000;
		
		dadoQueExisteUnaCombiEnLaAgencia(idCombi1, agencia1);
		
		cuandoSePoneUnaCombiEnViaje(idCombi1, agencia1);
		
		entoncesElEstadoEnViajeDeLaCombiEs(true, idCombi1, agencia1);		
		
	}
	
	@Test
	public void queNoSePuedaPonerUnaCombiEnViajeSiYaEstaEnViaje() { 
		
		Agencia agencia1 = dadoQueExisteUnaAgencia(1, "Nueva Agencia 2023");
		
		Integer idCombi1 = 1000;
		
		dadoQueExisteUnaCombiEnLaAgencia(idCombi1, agencia1);
		
		cuandoSePoneUnaCombiEnViaje(idCombi1, agencia1);
		
		Boolean flagViajeIniciado = cuandoSePoneUnaCombiEnViaje(idCombi1, agencia1);
		
		entoncesNoSePudoVolverAIniciarElViaje(flagViajeIniciado);		
		
	}
	
	@Test
	public void queSePuedaFinalizarElViajeDeUnaCombi() {
		
		Agencia agencia1 = dadoQueExisteUnaAgencia(1, "Nueva Agencia 2023");
		
		Integer idCombi1 = 1000;
		
		dadoQueExisteUnaCombiEnLaAgencia(idCombi1, agencia1);
		
		cuandoSePoneUnaCombiEnViaje(idCombi1, agencia1);
		
		cuandoSeFinalizaElViajeDeUnaCombi(idCombi1, agencia1);
		
		entoncesElEstadoEnViajeDeLaCombiEs(false, idCombi1, agencia1);	
		
	}
	
	@Test
	public void queNoSePuedaFinalizarElViajeDeUnaCombiSiNoEstaEnViaje() {
		
		Agencia agencia1 = dadoQueExisteUnaAgencia(1, "Nueva Agencia 2023");
		
		Integer idCombi1 = 1000;
		
		dadoQueExisteUnaCombiEnLaAgencia(idCombi1, agencia1);
				
		Boolean flagViajeFinalizado = cuandoSeFinalizaElViajeDeUnaCombi(idCombi1, agencia1);
		
		entoncesNoSePudoFinalizarElViaje(flagViajeFinalizado);
		
	}
	
	@Test
	public void queSePuedaSaberSiUnaCombiSeEncuentraONoEnViaje() {
		
		// Testea el requerimiento 2 de la consigna
		
		Agencia agencia1 = dadoQueExisteUnaAgencia(1, "Nueva Agencia 2023");
		
		Integer idCombi1 = 1000;
		
		Integer idCombi2 = 4000;
		
		dadoQueExisteUnaCombiEnLaAgencia(idCombi1, agencia1);
		
		// Devolución de estado de combi en viaje
		
		cuandoSePoneUnaCombiEnViaje(idCombi1, agencia1);
		
		entoncesElEstadoEnViajeDeLaCombiEs(true, idCombi1, agencia1);
		
		// Devolución de estado de combi que no está en viaje
		
		cuandoSeFinalizaElViajeDeUnaCombi(idCombi1, agencia1);
		
		entoncesElEstadoEnViajeDeLaCombiEs(false, idCombi1, agencia1);
		
		// Devolución de estado de combi que no existe en la agencia
		
		cuandoSePoneUnaCombiEnViaje(idCombi2, agencia1);
		
		entoncesElEstadoEnViajeDeLaCombiEs(null, idCombi2, agencia1);
					
	}
	
	@Test
	public void queSePuedaObtenerLaCantidadDeCombisDeLaAgenciaQueSeEncuentranEnViaje() {
		
		// Testea el requerimiento 3 de la consigna
		
		Agencia agencia1 = dadoQueExisteUnaAgencia(1, "Nueva Agencia 2023");
		
		Integer idCombi1 = 1000;
		Integer idCombi2 = 1001;
		Integer idCombi3 = 1002;
		Integer idCombi4 = 1003;
		
		dadoQueExisteUnaCombiEnLaAgencia(idCombi1, agencia1);
		dadoQueExisteUnaCombiEnLaAgencia(idCombi2, agencia1);
		dadoQueExisteUnaCombiEnLaAgencia(idCombi3, agencia1);
		dadoQueExisteUnaCombiEnLaAgencia(idCombi4, agencia1);

		cuandoSePoneUnaCombiEnViaje(idCombi1, agencia1);
		cuandoSePoneUnaCombiEnViaje(idCombi2, agencia1);
		
		entoncesLaCantidadDeCombisEnViajeDeLaAgenciaEs(2, agencia1);
		
	}
	
	@Test
	public void queSePuedaObtenerLaCantidadDeCombisDeLaAgenciaQueNoSeEncuentranEnViaje() {
		
		// Testea el requerimiento 3 de la consigna
		
		Agencia agencia1 = dadoQueExisteUnaAgencia(1, "Nueva Agencia 2023");
		
		Integer idCombi1 = 1000;
		Integer idCombi2 = 1001;
		Integer idCombi3 = 1002;
		Integer idCombi4 = 1003;
		
		dadoQueExisteUnaCombiEnLaAgencia(idCombi1, agencia1);
		dadoQueExisteUnaCombiEnLaAgencia(idCombi2, agencia1);
		dadoQueExisteUnaCombiEnLaAgencia(idCombi3, agencia1);
		dadoQueExisteUnaCombiEnLaAgencia(idCombi4, agencia1);

		cuandoSePoneUnaCombiEnViaje(idCombi1, agencia1);
		cuandoSePoneUnaCombiEnViaje(idCombi2, agencia1);
		cuandoSePoneUnaCombiEnViaje(idCombi3, agencia1);
		
		entoncesLaCantidadDeCombisFueraDeViajeEs(1, agencia1);
		
	}
	
	@Test
	public void queAlFinalizarUnViajeSeContabiliceALaAgencia() {
		
		Agencia agencia1 = dadoQueExisteUnaAgencia(1, "Nueva Agencia 2023");
		
		Integer idCombi1 = 1000;
		
		dadoQueExisteUnaCombiEnLaAgencia(idCombi1, agencia1);
		
		// 1er viaje
				
		cuandoSePoneUnaCombiEnViaje(idCombi1, agencia1);
		
		cuandoSeFinalizaElViajeDeUnaCombi(idCombi1, agencia1);
		
		// 2do viaje
		
		cuandoSePoneUnaCombiEnViaje(idCombi1, agencia1);
		
		cuandoSeFinalizaElViajeDeUnaCombi(idCombi1, agencia1);
		
		// Testea el requerimiento 4 de la consigna
		
		entoncesLaAgenciaRegistroLosViajesFinalizados(2, agencia1);
		
	}
	
					
	// Métodos para los tests
	
	private Agencia dadoQueExisteUnaAgencia(Integer id, String nombre) {
		
		return new Agencia(id, nombre);
		
	}
	
	private Boolean dadoQueExisteUnaCombiEnLaAgencia(Integer idCombi, Agencia agencia) {
		
		Combi combi = new Combi(idCombi);
		
		return agencia.agregarCombi(combi);
		
	}
	
	private void entoncesSuIdEs(Agencia agencia, Integer id) {
		
		Integer VE = id;
				
		Integer VO = agencia.getId();
		
		assertEquals(VE, VO);
		
	}

	private void entoncesDebePoseerPlazasLibres(Integer nPlazas, Agencia agencia) {
		
		Integer VE = nPlazas;
		
		Integer VO = agencia.getPlazasLibres();
		
		assertEquals(VE, VO);
		
	}
	
	private Boolean cuandoAgregoUnaCombi(Integer idCombi, Agencia agencia) {
		
		Combi combi = new Combi(idCombi);
		
		return agencia.agregarCombi(combi);
		
	}
	
	private Boolean cuandoAgregoUnaCombi(Combi combi, Agencia agencia) {
		
		return agencia.agregarCombi(combi);
		
	}
	
	private void entoncesNoPuedoAgregarOtraCombi(Integer idCombi, Agencia agencia) {
		
		Combi combi = new Combi(idCombi);
		
		Boolean VO = agencia.agregarCombi(combi);
		
		assertFalse(VO);
		
	}
	
	private void entoncesNoSePudoAgregarLaCombi(Boolean flagCombiAgregada) {
		
		assertFalse(flagCombiAgregada);
		
	}
	
	private void cuandoQuitoUnaCombi(Integer idCombi, Agencia agencia) {
		
		agencia.quitarCombi(idCombi);
		
	}
	
	private void entoncesNoPuedoQuitarUnaCombiQueNoFueAgregada(Integer idCombi, Agencia agencia) {
		
		Boolean VO = agencia.quitarCombi(idCombi);
		
		assertFalse(VO);
		
	}
	
	private void entoncesLaAgenciaPoseeCombis(Integer cantCombis, Agencia agencia) {
		
		Integer VE = cantCombis;
		
		Integer VO = agencia.getCantidadCombis();
		
		assertEquals(VE, VO);
		
	}
	
	private Boolean cuandoSePoneUnaCombiEnViaje(Integer idCombi, Agencia agencia) {
		
		return agencia.iniciarViaje(idCombi);	
		
	}
	
	private void entoncesElEstadoEnViajeDeLaCombiEs(Boolean estadoEnViajeCombi, Integer idCombi, Agencia agencia) {
		
		Boolean VE = estadoEnViajeCombi;
		
		Boolean VO = agencia.consultarEstadoEnViaje(idCombi);
		
		assertEquals(VE, VO);
		
	}
	
	private void entoncesNoSePudoVolverAIniciarElViaje(Boolean flagViajeIniciado) {
		
		assertFalse(flagViajeIniciado);
		
	}
	
	private Boolean cuandoSeFinalizaElViajeDeUnaCombi(Integer idCombi, Agencia agencia) {
		
		return agencia.finalizarViaje(idCombi);
		
	}
	
	private void entoncesNoSePudoFinalizarElViaje(Boolean flagViajeFinalizado) {
	
		assertFalse(flagViajeFinalizado);
		
	}
	
	private void entoncesLaAgenciaRegistroLosViajesFinalizados(Integer viajesFinalizados, Agencia agencia) {
		
		Integer VE = viajesFinalizados;
		
		Integer VO = agencia.getViajesFinalizados();
		
		assertEquals(VE, VO);
		
	}
	
	private void entoncesLaCantidadDeCombisEnViajeDeLaAgenciaEs(Integer combisEnViaje, Agencia agencia) {
		
		Integer VE = combisEnViaje;
		
		Integer VO = agencia.getCantidadCombisEnViaje();
		
		assertEquals(VE, VO);
		
	}
	
	private void entoncesLaCantidadDeCombisFueraDeViajeEs(Integer combisFueraDeViaje, Agencia agencia) {
		
		Integer VE = combisFueraDeViaje;
		
		Integer VO = agencia.getCantidadCombisFueraDeViaje();
		
		assertEquals(VE, VO);
		
	}

}
