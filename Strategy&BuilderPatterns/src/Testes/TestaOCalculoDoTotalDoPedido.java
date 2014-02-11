package Testes;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Dominio.Cliente;
import Dominio.Pedido;
import Dominio.Produto;

public class TestaOCalculoDoTotalDoPedido {
	
	private static Produto livro;
	private static Produto lapis;
	private Pedido pedido;
	private Cliente cliente;

	@BeforeClass
	public static void configuraClasseDeTeste() {
		livro = new Produto(1, "UML e Padrões", 136.00, 0);
		lapis = new Produto(2, "Lápis Preto", 1.50, 0);
	}
	@Before 
	public void configura(){
		cliente = new Cliente("2705678900013", "ACME LTDA");
		pedido = new Pedido(1, cliente, livro, 1, 0);
	}
	

	@Test
	public void oTotalDoPedidoDeveraRetornarUmValorParaUmPedidoComUmItem() {
		assertEquals(136.00, pedido.calculaTotal(), 0.01);
	}

	@Test
	public void oTotalDoPedidoDeveraRetornarUmValorParaUmPedidoComDoisItens() {
		pedido.incluiItem(lapis, 1);
		assertEquals(137.50, pedido.calculaTotal(), 0.01);
	}
	@After
	public void desconfigura(){
		pedido = null;
		cliente = null;
	}
	
	@AfterClass
	public static void desconfiguraClasseDeTeste() {
		livro = null;
		lapis = null;
	}
}
