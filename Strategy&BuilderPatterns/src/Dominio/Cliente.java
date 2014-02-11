package Dominio;

public class Cliente {
	private String cgc;
	private String nome;
	
	public Cliente(String cgc, String nome) {
		this.cgc = cgc;
		this.nome = nome;
	}

	public String getCgc() {
		return cgc;
	}

	public String getNome() {
		return nome;
	}
	
	
}
