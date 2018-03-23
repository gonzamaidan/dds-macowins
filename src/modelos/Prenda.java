package modelos;

import modelos.estados.Estado;

public class Prenda {

	private Double precioBase;
	private Estado estado;
	
	public Prenda(Double precioBase, Estado estado) {
		super();
		this.precioBase = precioBase;
		this.estado = estado;
	}
	
	public Double precio() {
		return estado.precioFinal(precioBase);
	}
	
}
