package Testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dominio.CalculadorDeDescontos;
import Dominio.Cliente;
import Dominio.DescontoAPartirDeValor;
import Dominio.DescontoSemDesconto;
import Dominio.DescontoSobreValorTotal;
import Dominio.Pedido;
import Dominio.PedidoComRegrasBasicasBuilder;
import Dominio.Produto;

public class TestaOCalculoDoDesconto {
	private static CalculadorDeDescontos calculador;
	private static Produto caneta;

	private Pedido pedido;

	@BeforeClass
	public static void configuraTodosOsTestes() {
		caneta = new Produto(1, "Caneta", 1.00);
		calculador = new CalculadorDeDescontos();
	}

	@Before
	public void configuraUmTeste() {
		PedidoComRegrasBasicasBuilder builder = new PedidoComRegrasBasicasBuilder();
		builder.comNumero(1);
		builder.comUmItem(caneta, 100);
		builder.doCliente(new Cliente("157634678/0001-1", "Pedro da Silva"));

		pedido = builder.constroi();
	}

	@Test
	public void oCalculoDoDescontoDeveraRetornarDescontoParaValorAcimaDe1000() {
		PedidoComRegrasBasicasBuilder builder = new PedidoComRegrasBasicasBuilder();
		builder.comNumero(1);
		builder.comUmItem(caneta, 1001);
		builder.doCliente(new Cliente("157634678/0001-1", "Pedro da Silva"));

		pedido = builder.constroi();
		assertEquals(10,
				calculador.calcula(pedido, new DescontoAPartirDeValor()), 0.01);
	}
	
	@Test
	public void oCalculoDoDescontoDeveraRetornarDescontoParaValorEntre1000e500() {
		PedidoComRegrasBasicasBuilder builder = new PedidoComRegrasBasicasBuilder();
		builder.comNumero(1);
		builder.comUmItem(caneta, 750);
		builder.doCliente(new Cliente("157634678/0001-1", "Pedro da Silva"));

		pedido = builder.constroi();
		assertEquals(5,
				calculador.calcula(pedido, new DescontoAPartirDeValor()), 0.01);
	}
	
	@Test
	public void oCalculoDoDescontoDeveraRetornarDescontoParaValorAbaixoDe500() {
		PedidoComRegrasBasicasBuilder builder = new PedidoComRegrasBasicasBuilder();
		builder.comNumero(1);
		builder.comUmItem(caneta, 350);
		builder.doCliente(new Cliente("157634678/0001-1", "Pedro da Silva"));

		pedido = builder.constroi();
		assertEquals(2,
				calculador.calcula(pedido, new DescontoAPartirDeValor()), 0.01);
	}

	@Test
	public void oCalculoDoDescontoDeveraRetornarAPartirDeValorTotal() {
		assertEquals(pedido.calculaTotal() * 0.15,
				calculador.calcula(pedido, new DescontoSobreValorTotal()), 0.01);
	}

	@Test
	public void oCalculoDoDescontoDeveraRetornarZeroDeDesconto() {
		assertEquals(0,
				calculador.calcula(pedido, new DescontoSemDesconto()), 0.01);
	}
}
