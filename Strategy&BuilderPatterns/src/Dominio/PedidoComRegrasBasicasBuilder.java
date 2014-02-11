package Dominio;

import Excecoes.ClienteNuloBuilderException;
import Excecoes.NumeroDoPedidoInvalidoBuilderException;
import Excecoes.ProdutoNuloBuilderException;
import Excecoes.QuantidadeDoProdutoBuilderException;

public class PedidoComRegrasBasicasBuilder extends PedidoBuilder {

	@Override
	public Pedido constroi() {
		if (this.numero <= 0) {
			throw new NumeroDoPedidoInvalidoBuilderException(
					"O numero do pedido dever ser maior do que zero.");
		}
		if (this.cliente == null) {
			throw new ClienteNuloBuilderException(
					"O pedido devera estar associado a um cliente.");
		}
		if (this.produto == null) {
			throw new ProdutoNuloBuilderException(
					"O pedido devera estar associado a um produto.");
		}
		if (this.quantidade <= 0) {
			throw new QuantidadeDoProdutoBuilderException(
					"O pedido dever estar associado a um produto com quantidade maior do que zero.");
		}
		return new Pedido(this.numero, this.cliente, this.produto,
				this.quantidade, this.valorDoFrete);
	}
}
