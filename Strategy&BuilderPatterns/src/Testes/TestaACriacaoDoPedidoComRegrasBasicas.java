package Testes;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Dominio.Cliente;
import Dominio.Pedido;
import Dominio.PedidoBuilder;
import Dominio.PedidoComRegrasBasicasBuilder;
import Dominio.Produto;

public class TestaACriacaoDoPedidoComRegrasBasicas {

	@Test
	public void oPedidoComFreteDeveraSerCriadoComSucesso() {
		PedidoBuilder builder = new PedidoComRegrasBasicasBuilder();
		builder.comNumero(2);
		builder.doCliente(new Cliente("27300045900013", "ACME"));
		builder.comUmItem(new Produto(1, "Lápis", 1.50), 1);
		builder.comFrete(0.50);
		
		Pedido pedido = builder.constroi();
		
		assertEquals(2, pedido.getNumero());
		assertEquals("27300045900013", pedido.getCgcDoCliente());
		assertEquals("ACME", pedido.getNomeDoCliente());	
		assertEquals(1.50, pedido.calculaTotal(), 0.01);
		assertEquals(0.50, pedido.getValorDoFrete(), 0.01);		
		
	}

}
