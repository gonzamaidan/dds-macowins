package modelos.estados;

public class Promocion implements Estado {

	private Double descuento;

	public Promocion(Double descuento) {
		this.descuento = descuento;
	}

	@Override
	public Double precioFinal(Double precioOriginal) {
		return precioOriginal - descuento;
	}

	
	
}
