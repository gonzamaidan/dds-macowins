package modelos.ventas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelos.Item;

public class Venta {
	private LocalDate fecha;
	private List<Item> items = new ArrayList<>();
	
	public Venta(LocalDate fecha) {
		super();
		this.fecha = fecha;
	}
	
	public Boolean esDeFecha(LocalDate unaFecha) {
		return fecha.isEqual(unaFecha);
	}
	public void addItem(Item item) {
		items.add(item);
	}
	
	public Double importe() {
		return items.stream().mapToDouble(item -> item.importe()).sum();
	}
	
	
}