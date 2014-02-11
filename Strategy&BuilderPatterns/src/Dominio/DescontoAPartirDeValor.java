package Dominio;

public class DescontoAPartirDeValor implements Desconto {

	@Override
	public double calcula(Pedido pedido) {
		if(pedido.calculaTotal() > 1000 )
			return 10.0;
		else if(pedido.calculaTotal() < 1000 && pedido.calculaTotal() >= 500)
			return 5.0;
		
		return 2.0;
	}
}
