package Testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Dominio.CalculadorDeImpostos;
import Dominio.Cliente;
import Dominio.ICMS;
import Dominio.IPI;
import Dominio.ISS;
import Dominio.Pedido;
import Dominio.PedidoComRegrasBasicasBuilder;
import Dominio.Produto;

public class TestaOCalculoDoImposto {
	private static CalculadorDeImpostos calculador;
	private static Produto caneta;
	private static Produto lapis;

	private Pedido pedido;

	@BeforeClass
	public static void configuraTodosOsTestes() {
		caneta = new Produto(1, "Caneta", 1.00);
		lapis = new Produto(1, "Lápis", 2.00);
		calculador = new CalculadorDeImpostos();
	}

	@Before
	public void configuraUmTeste() {
		PedidoComRegrasBasicasBuilder builder = new PedidoComRegrasBasicasBuilder();
		builder.comNumero(1);
		builder.comUmItem(caneta, 100);
		builder.doCliente(new Cliente("157634678/0001-1", "Pedro da Silva"));
		builder.comFrete(0.50);

		pedido = builder.constroi();
	}

	@Test
	public void oCalculoDoImpostoDeveraRetornarOICMSparaUmPedido() {
		assertEquals(pedido.calculaTotal() * 0.18,
				calculador.calcula(pedido, new ICMS()), 0.01);
	}

	@Test
	public void oCalculoDoImpostoDeveraRetornarOISSparaUmPedido() {
		assertEquals(pedido.calculaTotal() * 0.06 + 2.00,
				calculador.calcula(pedido, new ISS()), 0.01);
	}

	@Test
	public void oCalculoDoImpostoDeveraRetornarOIPIparaUmPedidoComValorMenorDoQue1000() {
		assertEquals(pedido.calculaTotal() * 0.07,
				calculador.calcula(pedido, new IPI()), 0.01);
	}

	@Test
	public void oCalculoDoImpostoDeveraRetornarOIPIparaUmPedidoComValorMenorOuIgualA3000() {
		pedido.incluiItem(lapis, 1000);
		assertEquals(pedido.calculaTotal() * 0.08,
				calculador.calcula(pedido, new IPI()), 0.01);
	}
	
	@Test
	public void oCalculoDoImpostoDeveraRetornarOIPIparaUmPedidoComValorMaiorDoQue3000() {
		pedido.incluiItem(lapis, 3000);
		assertEquals(pedido.calculaTotal() * 0.09,
				calculador.calcula(pedido, new IPI()), 0.01);
	}
}
