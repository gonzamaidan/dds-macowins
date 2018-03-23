package modelos.estados;

public class Nueva implements Estado {

	@Override
	public Double precioFinal(Double precioOriginal) {
		return precioOriginal;
	}

}
