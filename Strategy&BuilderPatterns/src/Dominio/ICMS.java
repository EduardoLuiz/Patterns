package Dominio;

public class ICMS implements Imposto {
	@Override
	public double calcula(Pedido pedido) {
		return pedido.calculaTotal() * 0.18;
	}
}
