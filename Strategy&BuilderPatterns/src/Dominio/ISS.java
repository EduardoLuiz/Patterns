package Dominio;

public class ISS implements Imposto {
	@Override
	public double calcula(Pedido pedido) {
		return pedido.calculaTotal() * 0.06 + 2.00;
	}
}
