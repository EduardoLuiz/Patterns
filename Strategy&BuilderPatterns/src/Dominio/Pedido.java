package Dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class Pedido {
	private int numero;
	private Calendar dataDaRealizacao;
	private Collection<ItemDoPedido> itensDoPedido;
	private Cliente cliente;
	private double valorDoFrete;

	public Pedido(int numero, Cliente cliente, Produto produto,
			double quantidade, double valorDoFrete) {
		this.numero = numero;
		this.dataDaRealizacao = Calendar.getInstance();
		this.itensDoPedido = new ArrayList<ItemDoPedido>();
		this.cliente = cliente;
		this.valorDoFrete = valorDoFrete;
		this.itensDoPedido.add(new ItemDoPedido(produto, quantidade));
	}

	public void incluiItem(Produto produto, double quantidade) {
		this.itensDoPedido.add(new ItemDoPedido(produto, quantidade));
	}

	public double calculaTotal() {
		double total = 0.0;
		for (ItemDoPedido itemDoPedido : itensDoPedido) {
			total += itemDoPedido.calculaTotal();
		}
		return total;
	}

	public int getNumero() {
		return numero;
	}

	public double getValorDoFrete() {
		return valorDoFrete;
	}

	public String getCgcDoCliente(){
		return cliente.getCgc();
	}
	
	public String getNomeDoCliente(){
		return cliente.getNome();
	}
	@Override
	public String toString() {
		return String.format("Pedido %03d# data=%2$te/%2$tm/%2$tY",
				this.numero, this.dataDaRealizacao);
	}
}
