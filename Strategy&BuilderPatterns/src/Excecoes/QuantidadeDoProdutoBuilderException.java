package Excecoes;

@SuppressWarnings("serial")
public class QuantidadeDoProdutoBuilderException extends
		IllegalArgumentException {
	
	public QuantidadeDoProdutoBuilderException(){}
	public QuantidadeDoProdutoBuilderException(String mensagem){
		super(mensagem);
	}
}
