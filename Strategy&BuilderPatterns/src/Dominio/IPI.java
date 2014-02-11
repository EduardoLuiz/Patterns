package Dominio;


public class IPI implements Imposto {
	@Override
	public double calcula(Pedido pedido) {
		double resultado;
		double valor = pedido.calculaTotal();

		if (valor < 1000) {
			resultado = valor * 0.07;
		} else if ((valor <= 3000)) {
			resultado = valor * 0.08;
		} else {
			resultado = valor * 0.09;
		}
		return resultado;
	}
}
