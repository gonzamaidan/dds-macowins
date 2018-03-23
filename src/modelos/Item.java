package modelos;

public class Item {

	private Prenda prenda;
	private Integer cantidad;
	
	public Item(Prenda prenda, Integer cantidad) {
		super();
		this.prenda = prenda;
		this.cantidad = cantidad;
	}
	
	public Double importe() {
		return prenda.precio() * cantidad;
	}
	
}
