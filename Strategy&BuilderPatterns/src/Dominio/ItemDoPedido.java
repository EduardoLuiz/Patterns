package Dominio;

public class ItemDoPedido {
	private Produto produto;
	private double quantidade;

	public ItemDoPedido(Produto produto, double quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public double calculaTotal() {
		return this.produto.obtemPreco() * this.quantidade;
	}

	@Override
	public String toString() {
		return String.format("ItemDoPedido : produto=%s, quantidade=%.2f",
				this.produto, this.quantidade);
	}
}
