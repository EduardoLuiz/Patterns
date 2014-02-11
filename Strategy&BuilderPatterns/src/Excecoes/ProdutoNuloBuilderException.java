package Excecoes;

@SuppressWarnings("serial")
public class ProdutoNuloBuilderException extends NullPointerException {
	public ProdutoNuloBuilderException(){}
	public ProdutoNuloBuilderException(String mensagem){
		super(mensagem);
	}
}
