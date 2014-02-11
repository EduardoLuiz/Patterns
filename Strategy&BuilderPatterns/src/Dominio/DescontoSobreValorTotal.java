package Dominio;

public class DescontoSobreValorTotal implements Desconto {

	@Override
	public double calcula(Pedido pedido) {
		return pedido.calculaTotal() * 0.15;
	}

}
