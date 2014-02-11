package Dominio;

public class CalculadorDeImpostos {
	public double calcula(Pedido pedido, Imposto imposto) {
		return imposto.calcula(pedido);
	}
}
