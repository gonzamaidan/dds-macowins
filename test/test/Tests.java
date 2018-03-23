package test;

import java.time.LocalDate;

import modelos.Item;
import modelos.Negocio;
import modelos.Prenda;
import modelos.estados.Estado;
import modelos.estados.Liquidacion;
import modelos.estados.Nueva;
import modelos.estados.Promocion;
import modelos.ventas.Venta;
import modelos.ventas.VentaConTarjeta;

public class Tests {

	public static void main(String[] args) {
		Negocio negocio = new Negocio();
		LocalDate fecha1 = LocalDate.of(2018, 1, 1);
		assertEquals(0.0, negocio.gananciasDe(fecha1), "Deberia iniciar sin ganancias.");
		
		Venta venta = new Venta(fecha1);
		Estado estado = new Nueva();
		Prenda prendaNueva = new Prenda(10.0, estado);
		Prenda prendaPromocion = new Prenda(10.0, new Promocion(2.0));
		Prenda prendaLiquidacion = new Prenda(10.0, new Liquidacion());
		Item itemNueva = new Item(prendaNueva , 1);
		Item itemPromo = new Item(prendaPromocion , 1);
		Item itemLiq = new Item(prendaLiquidacion , 1);
		
		assertEquals(0.0, negocio.gananciasDe(fecha1), "No se cargo ningun item a la venta");
		negocio.addVenta(venta);
		
		venta.addItem(itemNueva);
		assertEquals(10.0, negocio.gananciasDe(fecha1), "Deberia tener 10 de primera prenda");
		
		venta.addItem(itemPromo);
		assertEquals(18.0, negocio.gananciasDe(fecha1), "Deberia tener 18 con 2 prendas");

		venta.addItem(itemLiq);
		assertEquals(23.0, negocio.gananciasDe(fecha1), "Deberia tener 23 con 3 prendas");
		
		LocalDate fecha2 = LocalDate.of(2018, 1, 2);
		VentaConTarjeta ventaConTarjeta = new VentaConTarjeta(fecha2 , 10, 10.0);
		
		
		assertEquals(0.0, negocio.gananciasDe(fecha2), "No deberia tener ganancias para la fecha 2");
		ventaConTarjeta.addItem(itemNueva);
		negocio.addVenta(ventaConTarjeta);
		assertEquals(10.0 + 0.01 * 10 + 100, negocio.gananciasDe(fecha2), "Calculo tarjeta");
		
		System.out.println("Fin correcto de test");
		
	}
	
	public static void assertEquals(Double expected, Double actual, String message) {
		if(expected.doubleValue() != actual.doubleValue()) {
			throw new RuntimeException(message + " expected: " + expected + " actual: " + actual);
		}
	}
}