package Dominio;

public abstract class PedidoBuilder {

	protected int numero;
	protected Cliente cliente;
	protected Produto produto;
	protected int quantidade;
	protected double valorDoFrete;

	public void comFrete(double valorDoFrete) {
		this.valorDoFrete = valorDoFrete;
	}

	public void comNumero(int numero) {
		this.numero = numero;
	}

	public void comUmItem(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public abstract Pedido constroi();

	public void doCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
