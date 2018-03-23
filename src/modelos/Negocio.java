package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelos.ventas.Venta;

public class Negocio {
	private List<Venta> ventas = new ArrayList<Venta>();
	
	public Double gananciasDe(LocalDate unDia) {
		return ventas.stream().filter(venta -> venta.esDeFecha(unDia)).mapToDouble(venta -> venta.importe()).sum();
	}
	
	public void addVenta(Venta venta) {
		ventas.add(venta);
	}
}
