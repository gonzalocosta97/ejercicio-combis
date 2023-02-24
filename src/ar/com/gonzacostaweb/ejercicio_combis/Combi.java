package ar.com.gonzacostaweb.ejercicio_combis;

public class Combi {
	
	// Atributos
	
	private Integer id;
	
	private Boolean enViaje;
	
	// Constructor/es
	
	public Combi(Integer id) {
		
		this.id = id;
		
		this.enViaje = false;
		
	}
	
	// Getters
	
	public Integer getId() {
		
		return id;
		
	}
	
	public Boolean getEnViaje() {
		
		return enViaje;
		
	}
	
	// Setters 
	
	public void setEnViaje(Boolean estadoViaje) {
		
		this.enViaje = estadoViaje;
		
	}
	
}
