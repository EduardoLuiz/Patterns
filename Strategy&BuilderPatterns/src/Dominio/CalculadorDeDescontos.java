package Dominio;

public class CalculadorDeDescontos {
	public double calcula(Pedido pedido, Desconto desconto) {
		return desconto.calcula(pedido);
	}
}
