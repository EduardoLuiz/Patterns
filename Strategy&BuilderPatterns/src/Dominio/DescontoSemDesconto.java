package Dominio;

public class DescontoSemDesconto implements Desconto {

	@Override
	public double calcula(Pedido pedido) {
		return 0;
	}

}
