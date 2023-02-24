package ar.com.gonzacostaweb.ejercicio_combis;

public class Agencia {
	
	// Atributos
	
	private Integer id;
	
	private String nombre;
	
	private Combi[] combisAsociadas;
	
	private Integer viajesFinalizados;
	
	// Constructor/es
	
	public Agencia(Integer id, String nombre) {
		
		this.id = id;
		
		this.nombre = nombre;
		
		this.combisAsociadas = new Combi[5];
		
		this.viajesFinalizados = 0;
		
	}
	
	// Getters

	public Integer getId() {
		
		return id;
		
	}

	public String getNombre() {
		
		return nombre;
		
	}

	public Combi[] getCombisAsociadas() {
		
		return combisAsociadas;
		
	}

	public Integer getViajesFinalizados() {
		
		return viajesFinalizados;
		
	}
	
	public Integer getPlazasLibres() {
		
		Integer plazasLibres = 0;
		
		for(int i = 0; i < combisAsociadas.length; i++) {
			
			if(combisAsociadas[i] == null) {
				
				plazasLibres++;
				
			}
			
		}
		
		return plazasLibres;
		
	}
	
	public Integer getCantidadCombis() {
		
		Integer plazasLibres = getPlazasLibres();
		
		Integer cantidadCombis = combisAsociadas.length - plazasLibres;
		
		return cantidadCombis;
		
	}
	
	public Integer getCantidadCombisEnViaje() {
		
		Integer combisEnViaje = 0;
		
		for(int i = 0; i < combisAsociadas.length; i++) {
			
			if(combisAsociadas[i] != null) {
				
				if(combisAsociadas[i].getEnViaje() == true) {
					
					combisEnViaje++;
					
				}
				
			}
					
		}
		
		return combisEnViaje;
		
	}
	
	public Integer getCantidadCombisFueraDeViaje() {
		
		Integer combisFueraDeViaje = 0;
		
		for(int i = 0; i < combisAsociadas.length; i++) {
			
			if(combisAsociadas[i] != null) {
			
				if(combisAsociadas[i].getEnViaje() == false) {
					
					combisFueraDeViaje++;
					
				}
			
			}
			
		}
		
		return combisFueraDeViaje;
		
	}
	
	// Setters 

	public void setNombre(String nombre) {
		
		this.nombre = nombre;
		
	}
	
	// Métodos
	
	public Boolean agregarCombi(Combi combi) {
			
		if(combi != null && combi.getId() != null) {
					
			Combi combiExistente = validaCombi(combi.getId());
			
			if(combiExistente == null) {
				
				for(int i = 0; i < combisAsociadas.length; i++) {
					
					if(combisAsociadas[i] == null) {
						
						combisAsociadas[i] = combi;
						
						return true;
						
					}
					
				}
			
			}
			
		}
		
		return false;
		
	}
	
	private Combi validaCombi(Integer idCombi) {
		
		for(int i = 0; i < combisAsociadas.length; i++) {
			
			if(combisAsociadas[i] != null) {
				
				if(combisAsociadas[i].getId().equals(idCombi)) {
					
					return combisAsociadas[i];
					
				}
				
			}
			
		}
		
		return null;
		
	}
	
	public Boolean quitarCombi(Integer idCombi) {
		
		for(int i = 0; i < combisAsociadas.length; i++) {
			
			if(combisAsociadas[i] != null) {
				
				if(combisAsociadas[i].getId().equals(idCombi)) {
				
					combisAsociadas[i] = null;
				
					return true;
					
				}
				
			}
						
		}
		
		return false;
		
	}
	
	public Boolean iniciarViaje(Integer idCombi) {
		
		Combi combiExistente = validaCombi(idCombi);
		
		if(combiExistente != null && combiExistente.getEnViaje() == false) {
			
			combiExistente.setEnViaje(true);
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public Boolean finalizarViaje(Integer idCombi) {
		
		Combi combiExistente = validaCombi(idCombi);
		
		if(combiExistente != null && combiExistente.getEnViaje() == true) {
			
			combiExistente.setEnViaje(false);
			
			this.viajesFinalizados++;
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public Boolean consultarEstadoEnViaje(Integer idCombi) {
		
		Combi combiExistente = validaCombi(idCombi);
		
		if(combiExistente != null) {
			
			return combiExistente.getEnViaje();
			
		} else {
			
			return null;
			
		}
		
	}

}
