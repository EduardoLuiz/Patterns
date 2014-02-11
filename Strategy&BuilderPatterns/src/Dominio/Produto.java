package Dominio;

public class Produto {

	private int codigo;
	private String nome;
	private double preco;
	private double peso;

	public Produto(int codigo, String nome, double preco) {
		this(codigo, nome, preco, 0);
	}

	public Produto(int codigo, String nome, double preco, double peso) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.peso  = peso;
	}

	public int obtemCodigo() {
		return this.codigo;
	}

	public String obtemNome() {
		return this.nome;
	}

	public double obtemPreco() {
		return this.preco;
	}

	public double obtemPeso() {
		return peso;
	}

	@Override
	public String toString() {
		return String.format("Produto %03d# nome=%s, preco=%.2f", this.codigo,
				this.nome, this.preco);
	}


}
