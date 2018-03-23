package modelos.ventas;

import java.time.LocalDate;

public class VentaConTarjeta extends Venta {

	private Integer cantidadCuotas;
	private Double coeficienteTarjeta;
	
	public VentaConTarjeta(LocalDate fecha, Integer cantidadCuotas, Double coeficienteTarjeta) {
		super(fecha);
		this.cantidadCuotas = cantidadCuotas;
		this.coeficienteTarjeta = coeficienteTarjeta;
	}

	@Override
	public Double importe() {
		Double importeBase = super.importe();
		return recargoTarjeta(importeBase) + importeBase;
	}

	private double recargoTarjeta(Double importeBase) {
		return 0.01 * importeBase + coeficienteTarjeta * cantidadCuotas;
	}
}

