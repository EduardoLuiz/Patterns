package Testes;

import Dominio.CalculadorDeImpostos;
import Dominio.Cliente;
import Dominio.ICMS;
import Dominio.IPI;
import Dominio.ISS;
import Dominio.Pedido;
import Dominio.PedidoComRegrasBasicasBuilder;
import Dominio.Produto;

public class TestaCalculadorDeImpostos {
	public static void main(String[] args) {
		PedidoComRegrasBasicasBuilder builder = new PedidoComRegrasBasicasBuilder();
		builder.comNumero(1);
		builder.comUmItem(new Produto(1, "Caneta", 1.10), 1);
		builder.doCliente(new Cliente("157634678/0001-1", "Pedro da Silva"));
		builder.comFrete(0.50);
		try {
			Pedido pedido = builder.constroi();
			CalculadorDeImpostos calculadorDeImposto = new CalculadorDeImpostos();
			System.out.println("ICMS para o pedido " + pedido.getNumero()
					+ " e R$ "
					+ calculadorDeImposto.calcula(pedido, new ICMS()));
			System.out
					.println("ISS para o pedido " + pedido.getNumero()
							+ " e R$ "
							+ calculadorDeImposto.calcula(pedido, new ISS()));
			System.out
					.println("IPI para o pedido " + pedido.getNumero()
							+ " e R$ "
							+ calculadorDeImposto.calcula(pedido, new IPI()));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
