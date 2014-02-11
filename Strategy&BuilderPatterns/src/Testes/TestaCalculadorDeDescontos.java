package Testes;

import Dominio.CalculadorDeDescontos;
import Dominio.Cliente;
import Dominio.DescontoAPartirDeValor;
import Dominio.DescontoSemDesconto;
import Dominio.DescontoSobreValorTotal;
import Dominio.Pedido;
import Dominio.PedidoComRegrasBasicasBuilder;
import Dominio.Produto;

public class TestaCalculadorDeDescontos {

	public static void main(String[] args) {
		PedidoComRegrasBasicasBuilder builder = new PedidoComRegrasBasicasBuilder();
		builder.comNumero(1);
		builder.comUmItem(new Produto(5, "Caneta", 100.10), 1);
		builder.doCliente(new Cliente("157634678/0001-1", "Pedro da Silva"));
		builder.comFrete(0.50);
		try {
			Pedido pedido = builder.constroi();
			CalculadorDeDescontos calculadorDeDescontos = new CalculadorDeDescontos();
			System.out.println("DescontoAPartirDeValor " + pedido.getNumero()
					+ " e R$ "
					+ calculadorDeDescontos.calcula(pedido, new DescontoAPartirDeValor()));
			System.out
					.println("DescontoSobreValorTotal " + pedido.getNumero()
							+ " e R$ "
							+ calculadorDeDescontos.calcula(pedido, new DescontoSobreValorTotal()));
			System.out
					.println("DescontoSemDesconto " + pedido.getNumero()
							+ " e R$ "
							+ calculadorDeDescontos.calcula(pedido, new DescontoSemDesconto()));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
