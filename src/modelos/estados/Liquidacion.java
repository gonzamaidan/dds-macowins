package modelos.estados;

public class Liquidacion implements Estado {

	@Override
	public Double precioFinal(Double precioOriginal) {
		return precioOriginal * 0.5;
	}

}
